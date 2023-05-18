package com.devtiro.Demo.App;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.http.controller.VendedorController;
import com.devtiro.Demo.App.repository.VendedorRepository;
import com.devtiro.Demo.App.service.VendedorService;

@WebMvcTest(VendedorController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;
	
	

	@Autowired
	private VendedorController controller; 
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@MockBean
	private VendedorService vendedorService; 
	
	@Mock 
	VendedorRepository vendedorRepository;
	
	@Test
	public void vendedorShouldReturnMessageFromService() throws Exception {
		when(vendedorService.listaVendedor()).thenReturn(new ArrayList<>());
		this.mockMvc.perform(get("/vendedor")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("[]")));
	}
	
	
	
	@DisplayName("---------------- Testando metodo .criarVenda  ----------------")
	@Test 
	public void testVender() throws Exception {
		 Vendedor vendedor = new Vendedor();
	        vendedor.setIdVendedor(1);
	        vendedor.setNomeVendedor("xBrain");
	        controller.salvar(vendedor);
	        Vendas venda = new Vendas();
	        venda.setValorVenda(100.0f);

	        when(vendedorService.criarVenda(any(Integer.class), any(Vendas.class))).thenReturn(venda);	        

	        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/vendedor/vendendo/1")
	                .contentType("application/json")
	                .content("{\"valorVenda\": 100.0}"))
	                .andDo(print())
	                .andExpect(status().isCreated())
	                .andExpect(content().json("{\"valorVenda\": 100.0}"));
			
	}
	
	
	
	
}
















