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
public class vendasControllerTests {

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
	
}
