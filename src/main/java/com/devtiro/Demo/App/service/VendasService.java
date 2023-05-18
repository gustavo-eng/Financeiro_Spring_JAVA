package com.devtiro.Demo.App.service;

//import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Vendas> vendasPorVendedor(Integer id) {
	    List<Vendas> vendasDoVendedor = vendasRepository.findAll();
	    
	    return vendasDoVendedor.stream()
	        .filter(v -> v.getIdVendedor().equals(id))
	        .collect(Collectors.toList());
	}

	
}



