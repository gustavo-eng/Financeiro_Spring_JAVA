package com.devtiro.Demo.App;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.http.controller.VendedorController;


@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	

	@Autowired
	private VendedorController controller; 
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		System.out.println("Teste MockMvc");
		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
	
	 
	@Test 
	public void testGetVendedor_success_returnSeller() throws Exception {
		Vendedor vendedor = new Vendedor();
		vendedor.setNomeVendedor("xBrain");

		controller.salvar(vendedor);
		//Vendedor novoVendedor = 
		this.mockMvc
			.perform(get ("http://localhost:8080/vendedor/1"))
			.andExpectAll(status ().isOk());
	}

	
}
