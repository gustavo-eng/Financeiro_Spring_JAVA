package com.devtiro.Demo.App.entity;



import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.hibernate.*;

@Data // cria os getters e setters 
@AllArgsConstructor // criar construtor com as propriedades que criarmos de vendas 
@Builder // para ajudar na criacao de objetos Vendas  
@NoArgsConstructor // para criar um construtor vazio 


@Entity //  para informar que é uma entidade de banco de dados
public class Vendas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer idVenda; 

	
//	@ManyToOne
//	@JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor", nullable = false)
//	@ForeignKey(name = "FK_idVendedor")
	
	@Column(name = "idVendedor", nullable = false)
	public Integer idVendedor; 

	
	@Column(name = "nomeVendedor", nullable = false)
	public String nomeVendedor; 
	
	
	@Column(name = "dataVenda")
	public String dataVenda;
	
	@Column(name = "valorVenda")
	public float valorVenda; 
	
	
	
	
	
}



