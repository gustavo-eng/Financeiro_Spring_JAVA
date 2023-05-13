package com.devtiro.Demo.App.repository;

//Entidade
import com.devtiro.Demo.App.entity.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

// implementa operações CRUD 


@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	
	
	
}
