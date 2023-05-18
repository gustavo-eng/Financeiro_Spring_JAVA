package com.devtiro.Demo.App;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.http.controller.VendedorController;
import com.devtiro.Demo.App.repository.VendedorRepository;
import com.devtiro.Demo.App.service.VendedorService;

import org.springframework.beans.factory.annotation.Value;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// --------------- teste import --------------- 


//--------------- teste import ---------------

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HttpRequestTests {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@MockBean
	private VendedorService vendedorService; 
	
	
	@Mock 
	VendedorRepository vendedorRepository;
	
	
	@Autowired
	private MockMvc mockMvc;
	

	@Autowired
	private VendedorController controller; 

	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/test",
				String.class)).contains("Hello, World");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageForListOfSeller() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendedor",
				String.class)).contains("[]");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageForSellerInitial() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendedor/1",
				String.class)).isNotEqualTo("[]");
	}
		
	@Test
	public void greetingShouldReturnDefaultMessageForSells() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendas/listagem",
				String.class)).contains("[]");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageForSellsPerSeller() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendas/vendedor/1",
				String.class)).contains("[]");
	}

	@Test 
	public void testNewVendedor_success_returnSellerSaved() throws Exception {
		 Vendedor vendedor = new Vendedor();
	     vendedor.setNomeVendedor("xBrain");
	     controller.salvar(vendedor);
	     
	     when(vendedorService.cadastrarVendedor(any(Vendedor.class))).thenReturn(vendedor);
	     
	     mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + port + "/vendedor")
	             .contentType("application/json")
	             .content("{\"nomeVendedor\": \"xBrain\"}"))  // Corrigir a construção do JSON aqui
	             .andDo(print())
	             .andExpect(status().isCreated())
	             .andExpect(content().json("{\"nomeVendedor\": \"xBrain\"}"));

	     
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

	        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:" + port + "/vendedor/vendendo/1")
	                .contentType("application/json")
	                .content("{\"valorVenda\": 100.0}"))
	                .andDo(print())
	                .andExpect(status().isCreated())
	                .andExpect(content().json("{\"valorVenda\": 100.0}"));
			
	}
	

	

}






















