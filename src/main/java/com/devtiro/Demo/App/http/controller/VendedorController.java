package com.devtiro.Demo.App.http.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.entity.Vendedor;
import com.devtiro.Demo.App.service.VendasService;
import com.devtiro.Demo.App.service.VendedorService;

// definicao de rotas e controller 

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	// na PostMapping, automaticamente o @RequestBody esta pegando os dados e atributos da classe Vendedor
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // resposta 201 
	public Vendedor salvar(@RequestBody Vendedor vendedor) {
		System.out.println("Entrou no post ------- ");
		return vendedorService.cadastrarVendedor(vendedor);
	}
	
	@PostMapping("/vendendo/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Vendas  criarVenda(@PathVariable("id")Integer id , @RequestBody Vendas vendas) {
		return vendedorService.criarVenda(id, vendas);
	}
	
	
	
	@GetMapping 
	@ResponseStatus(HttpStatus.OK)  // 200 
	public List<Vendedor> listVendedor() {
		return vendedorService.listaVendedor();
	}

	//Consultar vendedor por id 
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vendedor buscarVendedorPorId(@PathVariable("id")Integer id) {
		return vendedorService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException (HttpStatus.NOT_FOUND, "Vendedor nao encontrado"));
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerVendedor(@PathVariable("id") Integer id) {
		vendedorService.buscarPorId(id).map(vendedor -> {
			System.out.println("Vendedor a ser excluido : " + vendedor);
			vendedorService.removerPorId(id);
			return Void.TYPE;
		});
	}
	


		
	
	@PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable("id") Integer id, @RequestBody Vendedor vendedor){
    	vendedorService.atualizaVendedor(id, vendedor);
    }
	
	// --- ok ok ok 
	@PostMapping("/mediaVendedor/{id}") 
	@ResponseStatus(HttpStatus.OK)
	public void  calculaMediaVendedor(
			@PathVariable ("id") Integer id,
			@RequestParam(value = "periodoInicial", defaultValue = "14/05/2023") String periodoInicial,
			@RequestParam(value = "periodoFinal", defaultValue = "18/05/2023") String periodoFinal
			) {
		vendedorService.calcularMediaPeriodica(id, periodoInicial, periodoFinal);
	 }
	
	
	
}
/*
 * @PathVariable ("periodoInicial") String periodoInicial,
			@PathVariable ("periodoFinal") String periodoFinal
 * 
 */



