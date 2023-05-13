package com.devtiro.Demo.App.entity;

import lombok.Data; // Cria os getters e setters automaticamente 

import lombok.Builder;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data // cria os getters e setters 
@AllArgsConstructor // criar construtor com as propriedades que criarmos de vendas 
@Builder // para ajudar na criacao de objetos Vendas  
@NoArgsConstructor // para criar um construtor vazio 

@Entity //  para informar que é uma entidade de banco de dados 
public class Vendedor implements Serializable{
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // geracao automatica de ID 
	private Integer idVendedor; 
	
	@Column(name = "nomeVendedor", nullable = false)
	private String nomeVendedor; 
	
	@Column(name = "qtdVendas")
	private int qtdVendas; 
	
	@Column(name = "mediaVendas")
	private float mediaVendas;	
	

}









