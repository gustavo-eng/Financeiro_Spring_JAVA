package com.devtiro.Demo.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.repository.VendedorRepository;
import com.devtiro.Demo.App.repository.VendasRepository;


import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class VendedorService {
	
	@Autowired
	public VendasRepository vendasRepository;
	
	@Autowired
	public VendedorRepository vendedorRepository; 
	

//	public Vendedor gerarVenda(Vendedor vendedor) {
//		return vendedorRepository.save(vendedor);
//	}
	
	public Optional<Vendas> searchPorId(Integer id) {
		return vendasRepository.findById(id);	
	}

//  Toda vez que gera uma venda estancia uma venda 
	public Vendas 	criarVenda(Integer id, Vendas sells ) {
		Optional<Vendedor> vendedorResponsavel = vendedorRepository.findById(id);
		Vendedor vendedorIdentificado = vendedorResponsavel.get();
		
		// ---- 
		Date dataAtual = new Date();
		SimpleDateFormat formatoBrasil = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatoBrasil.format(dataAtual);
		// ---- 
		
		Vendas vendas = new Vendas();
		
		vendas.idVendedor = id;  // precisar ser consultado 
		vendas.nomeVendedor = vendedorIdentificado.nomeVendedor;
		vendas.valorVenda = sells.valorVenda;
		vendas.dataVenda =  dataFormatada; 
		
		
		if(vendedorResponsavel.isPresent()) {
			vendedorIdentificado.qtdVendas += 1; 
		}
		
		
		return vendasRepository.save(vendas);
		
	}
			
	
	public Vendedor cadastrarVendedor(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	
	public List<Vendedor> listaVendedor() {
		return vendedorRepository.findAll();
	}
	
	public Optional<Vendedor> buscarPorId(Integer id) {
		return vendedorRepository.findById(id);	
	}
	
	public void removerPorId(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public Vendedor atualizaVendedor(Integer id, Vendedor vendedorAtualizado) { 
		Optional<Vendedor> vendedorAntigo = vendedorRepository.findById(id);
		if(vendedorAntigo.isPresent()) {
			Vendedor vendedor = vendedorAntigo.get();
			vendedor.nomeVendedor  = vendedorAtualizado.nomeVendedor; 
			vendedor.mediaVendas  = vendedorAtualizado.mediaVendas;
			vendedor.qtdVendas = vendedorAtualizado.qtdVendas;
			
			return vendedorRepository.save(vendedor);
		} else {
			throw new RuntimeException("Vendedor não encontrado");
		}
	}
		
}

















