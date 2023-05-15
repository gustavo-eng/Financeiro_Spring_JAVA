package com.devtiro.Demo.App.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.repository.VendasRepository;

// --- vendedor -- 

import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.repository.VendedorRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.devtiro.Demo.App.repository.VendedorRepository;
@Service
public class VendasService {

	@Autowired
	public VendasRepository vendasRepository; 
	
	
	public List<Vendas> listaVendas() {
		return vendasRepository.findAll();
	}
	
	// Essa funcao buscar retornar apenas todas as vendas de um vendedor
	public List<Vendas> vendasPorVendedor(Integer id){
		List<Vendas> vendasDoVendedor =  vendasRepository.findAll(); 
		List<Vendas> vendaFiltrada = new ArrayList<>();
		System.out.println("---- vendas por vendedor --- ");
		for(Vendas v : vendasDoVendedor) { 
			if(v.idVendedor.equals(id)) {
			   vendaFiltrada.add(v);
			   
			}
		}
		
		return vendaFiltrada; // [{}, {}]
//		return Optional.ofNullable(vendaFiltrada.isEmpty() ? null : vendaFiltrada.get(0));
	}
	
	//a fazer  linkar com a entidade vendedor 
	public float calcularMediaPeriodica(Integer id, String periodoInicial, String periodoFinal) {
		List<Vendas> vendasDoVendedor =  vendasRepository.findAll(); 
		List<Vendas> vendaFiltrada = new ArrayList<>();
		List<Integer> qtdVendasPorDataValidada = new ArrayList<>();
		System.out.println("---- vendas por vendedor --- ");
		for(Vendas v : vendasDoVendedor) { 
			if(v.idVendedor.equals(id)) { // unico vendedor a ser analisado 
			   vendaFiltrada.add(v);
			   boolean vendaNoPeriodo = isDateInRange(periodoFinal, periodoInicial, v.dataVenda); 
			   if(vendaNoPeriodo) { 
				  qtdVendasPorDataValidada.add(contarVendasMesmaData(vendaFiltrada, v.dataVenda));
			   }
			}
		}
		int soma = 0; 
		for (int quantidade : qtdVendasPorDataValidada) {
			soma += quantidade;
		}
		System.out.println("-- CHEGOU NA ULTIMA LINHA  --");	
		return (float)soma/qtdVendasPorDataValidada.size(); 
	}
	
	// Utils ... 
	public static int contarVendasMesmaData(List<Vendas> vendas, String dataVenda) {
	    int quantidade = 0;

	    for (Vendas venda : vendas) {
	        if (venda.dataVenda.equals(dataVenda)) {
	            quantidade++;
	        }
	    }
	    return quantidade;
	}
	
	public static boolean isDateInRange(String dataInicio, String dataFim, String dataAvaliada) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date inicio = dateFormat.parse(dataInicio);
            Date fim = dateFormat.parse(dataFim);
            Date avaliada = dateFormat.parse(dataAvaliada);

            return avaliada.compareTo(inicio) >= 0 && avaliada.compareTo(fim) <= 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
	
}



