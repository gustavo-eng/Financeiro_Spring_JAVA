package com.devtiro.Demo.App.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.repository.VendasRepository;


@Service
public class VendasService {

	@Autowired
	public VendasRepository vendasRepository; 
	
	
	public List<Vendas> listaVendas() {
		return vendasRepository.findAll();
	}
	
	// Essa funcao buscar retornar apenas todas as vendas de um vendedor
	public List<Vendas> vendasPorVendedor(Integer id){
		List<Vendas> vendasDoVendedor =  vendasRepository.findAll(); 
		List<Vendas> vendaFiltrada = new ArrayList<>();
		System.out.println("---- vendas por vendedor --- ");
		for(Vendas v : vendasDoVendedor) { 
			if(v.getIdVendedor().equals(id)) {
			   vendaFiltrada.add(v);
			   
			}
		}
		
		return vendaFiltrada; // [{}, {}]

	}
	
	
	
}



