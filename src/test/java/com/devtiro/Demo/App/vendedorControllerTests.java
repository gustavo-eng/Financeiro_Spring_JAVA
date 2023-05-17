package com.devtiro.Demo.App;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.http.controller.VendedorController;



@SpringBootTest
public class vendedorControllerTests {

	@Autowired
	private VendedorController controller; 
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void testCriarVendedor() {
		Vendedor vendedor = new Vendedor();
		vendedor.setNomeVendedor("xBrain");

		Vendedor novoVendedor = controller.salvar(vendedor);
		assertThat(novoVendedor.getNomeVendedor()).isEqualTo("xBrain");
		assertThat(novoVendedor.getQtdVendas()).isEqualTo(0);
		assertThat(novoVendedor.getMediaVendas()).isEqualTo(0.0f);
	}
	
	
	
	
}
