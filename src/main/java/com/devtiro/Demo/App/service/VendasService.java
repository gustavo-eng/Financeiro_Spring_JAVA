package com.devtiro.Demo.App.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.repository.VendasRepository;

// --- vendedor -- 

import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.repository.VendedorRepository;
@Service
public class VendasService {

	@Autowired
	public VendasRepository vendasRepository; 
	
	// gerar venda fica no vendedor 
	
	public List<Vendas> listaVendas() {
		return vendasRepository.findAll();
	}
	
	
	
	// pre requisito ( estudar manipulacao de time em java)
	//calcular media 
	
	// A fazer 
	
	public Optional<Vendas> calcularMediaPeriodica(Date data){
		return null;
	}
	
	
	
	
}
