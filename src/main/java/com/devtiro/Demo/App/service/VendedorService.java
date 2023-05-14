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
@Service
public class VendedorService {
	
	@Autowired
	public VendasRepository vendasRepository;
	
	@Autowired
	public VendedorRepository vendedorRepository; 
	
	// ID_VENDA  	DATA_VENDA  	NOME_VENDEDOR  	VALOR_VENDA  	ID_VENDEDOR  
	
	// neste local provavel mente o save sera para a entidade Venda 
	// ou tbm tera outro sabe que vai levar para a tabela vendas la no banco de dados 
	// aqui sera feito a venda 
	//Tera outro parametro chamado ( Vendas vandas) 
	// concatenar atributos de vendedor com a classe vendas para colocar no banco 
//	public Vendedor gerarVenda(Vendedor vendedor) {
//		return vendedorRepository.save(vendedor);
//	}
	
	public Optional<Vendas> searchPorId(Integer id) {
		return vendasRepository.findById(id);	
	}
//	
	public Vendas vender(Integer id,Vendedor vendedor) {
		Vendas vendas = new Vendas();
		vendas.idVendedor = vendedor.idVendedor; 
		vendas.nomeVendedor = vendedor.nomeVendedor;
		vendas.valorVenda = 78;
		vendas.dataVenda =  null; 
		return vendasRepository.save(vendas);
	}
			
	
	public Vendedor gerarVenda(Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}

	//save pode ser utilizado para salvar um vendedor e tbm atualizar um vendedor 
	// se for novo ele vai persistir, caso o contrario sera atualizado 
	
	// lista todos os clientes 
	
	// --------------------------------------------
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

















