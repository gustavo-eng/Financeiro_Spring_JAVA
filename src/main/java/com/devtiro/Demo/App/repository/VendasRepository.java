package com.devtiro.Demo.App.repository;

import com.devtiro.Demo.App.entity.Vendas;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

//acesso aos dados 

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Integer> {
	
//	Vendas findByIdVendedor(Integer idVendedor);
	
}
