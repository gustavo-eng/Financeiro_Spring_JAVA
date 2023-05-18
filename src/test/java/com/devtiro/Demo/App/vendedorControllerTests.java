package com.devtiro.Demo.App;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

//import java.util.Arrays;
//import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.http.controller.VendedorController;
//import com.devtiro.Demo.App.service.VendedorService;



@SpringBootTest
public class vendedorControllerTests {

	@Autowired
	private VendedorController controller; 
	
	

//	@Autowired
//	private VendedorService vendedorService;
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
	
	@DisplayName("Teste dos getters e setters da classe Vendedor")
    @Test
    public void testGettersAndSetters() {
        Vendedor vendedor = new Vendedor();

        // Define os valores de teste
        Integer idVendedor = 1;
        String nomeVendedor = "Gustavo";
        Integer qtdVendas = 10;
        Float mediaVendas = 50.0f;

        // Configura os valores usando os setters
        vendedor.setIdVendedor(idVendedor);
        vendedor.setNomeVendedor(nomeVendedor);
        vendedor.setQtdVendas(qtdVendas);
        vendedor.setMediaVendas(mediaVendas);

        // Verifica se os valores estão corretos usando os getters
        assertThat(vendedor.getIdVendedor()).isEqualTo(idVendedor);
        assertThat(vendedor.getNomeVendedor()).isEqualTo(nomeVendedor);
        assertThat(vendedor.getQtdVendas()).isEqualTo(qtdVendas);
        assertThat(vendedor.getMediaVendas()).isEqualTo(mediaVendas);
    }
	
	

	
	
}
