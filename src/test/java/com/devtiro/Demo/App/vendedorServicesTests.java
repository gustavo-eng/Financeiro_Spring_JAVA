package com.devtiro.Demo.App;

import static org.assertj.core.api.Assertions.assertThat;




import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.http.controller.VendedorController;
import com.devtiro.Demo.App.service.VendedorService;




@SpringBootTest
public class vendedorServicesTests {

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
	
	
	
	
	@DisplayName("Teste do método isDateInRange")
    @Test
    public void testIsDateInRange() {
        VendedorService service = new VendedorService();

        // Teste para data dentro do intervalo
        boolean result1 = service.isDateInRange("01/01/2023", "31/12/2023", "15/06/2023");
        assertThat(result1).isTrue();

        // Teste para data antes do intervalo
        boolean result2 = service.isDateInRange("01/01/2023", "31/12/2023", "15/12/2022");
        assertThat(result2).isFalse();

        // Teste para data após do intervalo
        boolean result3 = service.isDateInRange("01/01/2023", "31/12/2023", "15/01/2024");
        assertThat(result3).isFalse();
    }
	
	
	
	
}



