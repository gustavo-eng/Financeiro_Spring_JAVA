package com.devtiro.Demo.App.entity;

import lombok.Data; // Cria os getters e setters automaticamente 

import lombok.Builder;

import java.io.Serializable;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data // cria os getters e setters 
@AllArgsConstructor // criar construtor com as propriedades que criarmos de vendas 
@Builder // para ajudar na criacao de objetos Vendas  
@Entity //  para informar que é uma entidade de banco de dados 
@NoArgsConstructor // para criar um construtor vazio 

public class Vendedor implements Serializable{
	/* 
	  id
	  nome 
	  lista de vendas  (vai estar no banco ??)
	  total de vendas 
	  media de vendas diaria 
	 */
	
	private int idVendedor; 
	private String nomeVendedor; 
	private int qtdVendas; 
	private float mediaVenda;
	
	

}









