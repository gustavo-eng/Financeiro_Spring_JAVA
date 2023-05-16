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
	
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // geracao automatica de ID 
	public Integer idVendedor; 
	
	@Column(name = "nomeVendedor", nullable = false)
	public String nomeVendedor; 
	
	@Column(name = "qtdVendas")
	public int qtdVendas; 
	
	@Column(name = "mediaVendas")
	public float mediaVendas;	
	

}









