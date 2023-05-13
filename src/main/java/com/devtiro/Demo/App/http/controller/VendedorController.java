package com.devtiro.Demo.App.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devtiro.Demo.App.service.VendedorService;

// definicao de rotas e controller 

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService; 
	
	
	
	
}
