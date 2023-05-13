package com.devtiro.Demo.App.entity;


import lombok.Data;
import lombok.Builder;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data // cria os getters e setters 
@AllArgsConstructor // criar construtor com as propriedades que criarmos de vendas 
@Builder // para ajudar na criacao de objetos Vendas  
@Entity //  para informar que é uma entidade de banco de dados 
@NoArgsConstructor // para criar um construtor vazio 

public class Vendas {
	
	private int idVenda; 
	private int idVendedor; 
	private String nomeVendedor; 
	private Data dataVenda;
	
	/*  
	 ID venda 
	 ID vendedor
	 Nome vendedor 
	 Data 
	 Valor  
	 */

}
