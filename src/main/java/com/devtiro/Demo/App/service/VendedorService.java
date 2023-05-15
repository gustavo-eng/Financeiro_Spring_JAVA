package com.devtiro.Demo.App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.repository.VendedorRepository;
import com.devtiro.Demo.App.repository.VendasRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
@Service
public class VendedorService {
	
	@Autowired
	public VendasRepository vendasRepository;
	
	@Autowired
	public VendedorRepository vendedorRepository; 
	

//	public Vendedor gerarVenda(Vendedor vendedor) {
//		return vendedorRepository.save(vendedor);
//	}
	
	public Optional<Vendas> searchPorId(Integer id) {
		return vendasRepository.findById(id);	
	}

//  Gera venda e atualiza vendedor
	public Vendas 	criarVenda(Integer id, Vendas sells ) {
		Optional<Vendedor> vendedorResponsavel = vendedorRepository.findById(id);
		Vendedor vendedorIdentificado = vendedorResponsavel.get();
		
		// ---- 
		Date dataAtual = new Date();
		SimpleDateFormat formatoBrasil = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatoBrasil.format(dataAtual);
		// ---- 
		
		Vendas vendas = new Vendas();
		
		vendas.idVendedor = id;  // precisar ser consultado 
		vendas.nomeVendedor = vendedorIdentificado.nomeVendedor;
		vendas.valorVenda = sells.valorVenda;
		vendas.dataVenda =  dataFormatada; 
		// consumir funcao de vendas aqui 
	
		if(vendedorResponsavel.isPresent()) { // colocar como if global no escopo da funcao
			vendedorIdentificado.qtdVendas += 1; 	
		} 
		
		return vendasRepository.save(vendas);
	}
	
	// A fazer depois que conseguir retornar lista de todos 	
	public float mediaVendas(String periodo) { 
		return (float)32.23 ;  
	}
	
	
	public Vendedor cadastrarVendedor(Vendedor vendedor) {
		System.out.println("CADASTRANDO VENDEDOR_");
		return vendedorRepository.save(vendedor);
	}

	
	public List<Vendedor> listaVendedor() {
		return vendedorRepository.findAll();
	}
	
	public Optional<Vendedor> buscarPorId(Integer id) {
		return vendedorRepository.findById(id);	
	}
	
	public void removerPorId(Integer id) {
		vendedorRepository.deleteById(id);
	}
	
	public Vendedor atualizaVendedor(Integer id, Vendedor vendedorAtualizado) { 
		Optional<Vendedor> vendedorAntigo = vendedorRepository.findById(id);
		if(vendedorAntigo.isPresent()) {
			Vendedor vendedor = vendedorAntigo.get();
			vendedor.nomeVendedor  = vendedorAtualizado.nomeVendedor; 
			vendedor.mediaVendas  = vendedorAtualizado.mediaVendas;
			vendedor.qtdVendas = vendedorAtualizado.qtdVendas;
			
			return vendedorRepository.save(vendedor);
		} else {
			throw new RuntimeException("Vendedor não encontrado");
		}
	}
		
	// ------------ OK OK OK 
	public void  calcularMediaPeriodica(Integer id, String periodoInicial, String periodoFinal) {
		System.out.println("___00 PERIODO 00__ (periodoInicial)");
		System.out.println(periodoInicial);
		System.out.println("___00 PERIODO 00__ (periodoFinal)");
		System.out.println(periodoFinal);
		List<Vendas> vendasDoVendedor =  vendasRepository.findAll(); 
		List<Vendas> vendaFiltrada = new ArrayList<>();
		List<Integer> qtdVendasPorDataValidada = new ArrayList<>();
		List<Integer> qtdTeste = new ArrayList<>();
		Optional<Vendedor> vendedorResponsavel = vendedorRepository.findById(id);
		Vendedor vendedorIdentificado = vendedorResponsavel.get();
		
		
		System.out.println("---- vendas por vendedor --- ENTROU em for(Vendas v : vendasDoVendedor) ");
		for(Vendas v : vendasDoVendedor) { 
			if(v.idVendedor.equals(id)) { // unico vendedor a ser analisado 
			    System.out.println("<- v.idVendedor.equals(id) ->");
				vendaFiltrada.add(v);
				System.out.println("Antes de vendaNoPeriodo");
				System.out.println("v.dataVenda ---------> " + v.dataVenda);
				boolean vendaNoPeriodo = isDateInRange(periodoInicial, periodoFinal, v.dataVenda); 
				System.out.println("Depois de vendaNoPeriodo");
				if(vendaNoPeriodo) { 
				   System.out.println("Entrou em  if(vendaNoPeriodo)");
				   System.out.println("Imprimindo v" + v.nomeVendedor);
				   qtdVendasPorDataValidada.add(contarVendasMesmaData(vendaFiltrada, v.dataVenda));
				}
			}
		}
		long teste = calcularDiferencaEmDias(periodoInicial, periodoFinal);
		System.out.println("Teste -> "+ teste);
		if(vendedorResponsavel.isPresent()) {
			Vendedor vendedor = vendedorResponsavel.get();
			vendedor.mediaVendas = (int) qtdVendasPorDataValidada.size()/ (float) teste;
			vendedorRepository.save(vendedor);
		}
		
		
		//sair (exclude)
		float soma = 0; 
		for (int quantidade : qtdVendasPorDataValidada) {
			soma += quantidade;
			System.out.println("Soma ----> 989898 ->  " + soma);
		}
		vendedorIdentificado.mediaVendas = (float)qtdVendasPorDataValidada.size()/(float)soma;
		System.out.println("vendedorIdentificado.mediaVendas ===> " + vendedorIdentificado.mediaVendas);
		System.out.println("_____________| _________");
		
		System.out.println("qtdVendasPorDataValidada.size() -->" + qtdVendasPorDataValidada.size());
//		if (vendedorResponsavel.isPresent()) {
//			Vendedor vendedor = vendedorResponsavel.get();
//			System.out.println("(float)soma/(int) qtdVendasPorDataValidada.size() --> "+ (float) soma/ qtdVendasPorDataValidada.size());
//			vendedor.mediaVendas = (float)soma/(int) qtdVendasPorDataValidada.size();
//			
//			System.out.println("vendedor.mediaVendas == " + vendedor.mediaVendas);
//			vendedorRepository.save(vendedor);
//		}
		
//		vendedorRepository.save(vendedorIdentificado);
//		return (float)soma/qtdVendasPorDataValidada.size(); 
	}
	
	// Utils ... 
	public  int contarVendasMesmaData(List<Vendas> vendas, String dataVenda) {
	    int quantidade = 0;
	    System.out.println("Entrou em contarVendasMesmaData  --> ");
	    for (Vendas venda : vendas) {
	        if (venda.dataVenda.equals(dataVenda)) {
	        	System.out.println("Quantidade *****-> " + quantidade);
	            quantidade++;
	        }
	    }
	    return quantidade;
	}
	
	public boolean isDateInRange(String dataInicio, String dataFim, String dataAvaliada) {
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
	
	
	// MANTER
	public long calcularDiferencaEmDias(String dataInicio, String dataFim) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date inicio = dateFormat.parse(dataInicio);
            Date fim = dateFormat.parse(dataFim);

            long diferencaEmMilissegundos = fim.getTime() - inicio.getTime();
            long diferencaEmDias = TimeUnit.DAYS.convert(diferencaEmMilissegundos, TimeUnit.MILLISECONDS);
            System.out.println("diferenca em dias  7777 --->" + diferencaEmDias);
            return diferencaEmDias;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
	// ------------ OK OK OK 
	
}



















