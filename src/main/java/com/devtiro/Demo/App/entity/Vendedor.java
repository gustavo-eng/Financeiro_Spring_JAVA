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


@Data  
@AllArgsConstructor 
@Builder 
@NoArgsConstructor 

@Entity 
public class Vendedor implements Serializable{
	

	private static final long serialVersionUID = 7699134081231408535L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // geracao automatica de ID 
	private Integer idVendedor; 
	
	@Column(name = "nomeVendedor", nullable = false)
	private String nomeVendedor; 
	
	@Column(name = "qtdVendas")
	private int qtdVendas = 0; 
	
	@Column(name = "mediaVendas")
	private float mediaVendas;

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

	public int getQtdVendas() {
		return qtdVendas;
	}

	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas += qtdVendas;
	}

	public float getMediaVendas() {
		return mediaVendas;
	}

	public void setMediaVendas(float mediaVendas) {
		this.mediaVendas = mediaVendas;
	}	
	
	
}









