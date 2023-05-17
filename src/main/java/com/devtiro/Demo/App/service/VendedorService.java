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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

@Service
public class VendedorService {
	
	@Autowired
	public VendasRepository vendasRepository;
	
	@Autowired
	public VendedorRepository vendedorRepository; 
	

	public Optional<Vendas> searchPorId(Integer id) {
		return vendasRepository.findById(id);	
	}

	public Vendas criarVenda(Integer id, Vendas sells) {
	    try {
	        Optional<Vendedor> vendedorResponsavel = vendedorRepository.findById(id);
	        Vendas vendas = new Vendas();
	        if (vendedorResponsavel.isPresent()) {
	            Vendedor vendedorIdentificado = vendedorResponsavel.get();

	          
	            Date dataAtual = new Date();
	            SimpleDateFormat formatoBrasil = new SimpleDateFormat("dd/MM/yyyy");
	            String dataFormatada = formatoBrasil.format(dataAtual);
	         

	            vendas.setIdVendedor(id);
	            vendas.setNomeVendedor(vendedorIdentificado.getNomeVendedor());
	            vendas.setValorVenda(sells.getValorVenda());
	            vendas.setDataVenda(dataFormatada);

	            vendedorIdentificado.setQtdVendas(1);
	        }

	        return vendasRepository.save(vendas);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
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
			
			vendedor.setNomeVendedor(vendedorAtualizado.getNomeVendedor());
			vendedor.setMediaVendas(vendedorAtualizado.getMediaVendas());
			vendedor.setQtdVendas(vendedorAtualizado.getQtdVendas());
			
			return vendedorRepository.save(vendedor);
		} else {
			throw new RuntimeException("Vendedor não encontrado");
		}
	}
		

	public void  calcularMediaPeriodica(Integer id, String periodoInicial, String periodoFinal) {
		List<Vendas> vendasDoVendedor =  vendasRepository.findAll(); 
		List<Vendas> vendaFiltrada = new ArrayList<>();
		List<Integer> qtdVendasPorDataValidada = new ArrayList<>();

		Optional<Vendedor> vendedorResponsavel = vendedorRepository.findById(id);
		

		for(Vendas v : vendasDoVendedor) { 
			if(v.getIdVendedor().equals(id)) { // unico vendedor a ser analisado 
				vendaFiltrada.add(v);
				
				boolean vendaNoPeriodo = isDateInRange(periodoInicial, periodoFinal, v.getDataVenda()); 
				if(vendaNoPeriodo) { 
				   qtdVendasPorDataValidada.add(contarVendasMesmaData(vendaFiltrada, v.getDataVenda()));
				}
			}
		}
		long diferencaDias = calcularDiferencaEmDias(periodoInicial, periodoFinal);
		
		if(vendedorResponsavel.isPresent()) {
			Vendedor vendedor = vendedorResponsavel.get();
			vendedor.setMediaVendas((int) qtdVendasPorDataValidada.size()/ (float) diferencaDias);

			vendedorRepository.save(vendedor);
		}	
		
	}
	
	// Utils ... 
	public  int contarVendasMesmaData(List<Vendas> vendas, String dataVenda) {
	    int quantidade = 0;
	    for (Vendas venda : vendas) {
	        if (venda.getDataVenda().equals(dataVenda)) {
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
	
	
	public long calcularDiferencaEmDias(String dataInicio, String dataFim) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date inicio = dateFormat.parse(dataInicio);
            Date fim = dateFormat.parse(dataFim);

            long diferencaEmMilissegundos = fim.getTime() - inicio.getTime();
            long diferencaEmDias = TimeUnit.DAYS.convert(diferencaEmMilissegundos, TimeUnit.MILLISECONDS);
       
            return diferencaEmDias;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
	
}









