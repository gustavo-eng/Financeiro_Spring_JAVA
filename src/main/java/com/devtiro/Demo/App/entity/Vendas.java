package com.devtiro.Demo.App.entity;



import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



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
	private Integer idVendedor; 

	
	@Column(name = "nomeVendedor", nullable = false)
	private String nomeVendedor; 
	
	
	@Column(name = "dataVenda")
	private String dataVenda;
	
	@Column(name = "valorVenda")
	private float valorVenda;

	
	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	} 
	
	
}



