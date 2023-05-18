package com.devtiro.Demo.App;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.http.controller.VendasController;
import com.devtiro.Demo.App.service.VendasService;



@SpringBootTest
public class vendasServiceTests {

	@Autowired
	private VendasController vendasController; 
	
	@Autowired
	VendasService vendasService; 
	
	@Test 
	public void contextLoads() throws Exception { 
		assertThat(vendasController).isNotNull();
	}
	
	
	@DisplayName("Todas as vendas listadas sem vendedor cadastrado")
	@Test 
	public void testFindSeller_successfull_returnSells()  {
		List<Vendas> vendasList = vendasService.vendasRepository.findAll();
		assertThat(vendasList).isEmpty();
	}

	@DisplayName("Teste dos getters e setters da classe Vendas")
    @Test
    public void testGettersAndSetters() {
        Vendas vendas = new Vendas();

        // Define os valores de teste
        Integer idVenda = 1;
        Integer idVendedor = 2;
        String nomeVendedor = "xBrain";
        String dataVenda = "17/05/2023";
        float valorVenda = 100.0f;

        // Configura os valores usando os setters
        vendas.setIdVenda(idVenda);
        vendas.setIdVendedor(idVendedor);
        vendas.setNomeVendedor(nomeVendedor);
        vendas.setDataVenda(dataVenda);
        vendas.setValorVenda(valorVenda);

        // Verifica se os valores estão corretos usando os getters
        assertThat(vendas.getIdVenda()).isEqualTo(idVenda);
        assertThat(vendas.getIdVendedor()).isEqualTo(idVendedor);
        assertThat(vendas.getNomeVendedor()).isEqualTo(nomeVendedor);
        assertThat(vendas.getDataVenda()).isEqualTo(dataVenda);
        assertThat(vendas.getValorVenda()).isEqualTo(valorVenda);
    }
	
	
	
	
}






