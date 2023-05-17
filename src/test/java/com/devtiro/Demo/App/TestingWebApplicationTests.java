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


@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		System.out.println("Teste MockMvc");
		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
	
	 
	@Test 
	public void testGetVendedorById_success_returnStudent() throws Exception {
		this.mockMvc
			.perform(get ("http://localhost:8080/vendedor"))
			.andExpectAll(status ().isOk());
	}

	

}
