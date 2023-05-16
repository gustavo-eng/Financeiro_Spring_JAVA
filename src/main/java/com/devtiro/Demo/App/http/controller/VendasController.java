package com.devtiro.Demo.App.http.controller;

import java.util.List;
//import java.util.Optional;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

import com.devtiro.Demo.App.entity.Vendas;
import com.devtiro.Demo.App.service.VendasService;
//import com.devtiro.Demo.App.entity.Vendedor;
//import com.devtiro.Demo.App.repository.VendedorRepository;
//import com.devtiro.Demo.App.service.VendedorService;
@RestController
@RequestMapping("/vendas")
public class VendasController {

	@Autowired
	private VendasService vendasService;
	
	
	@GetMapping("/escreve")
	public String escreve(@RequestParam(value = "name", defaultValue = "escreve") String name) {
	      return String.format("Ola vendas %s!", name);
	}
	
	@GetMapping("/listagem")
	@ResponseStatus(HttpStatus.OK)
	public List<Vendas> listaVendas() {
		return vendasService.listaVendas();
	}
	
	
	@GetMapping("/vendedor/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Vendas> buscaVendasPorVendedor(@PathVariable("id")Integer id) {
		return vendasService.vendasPorVendedor(id);
		
	}
	
	
}


