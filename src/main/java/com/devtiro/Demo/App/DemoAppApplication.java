package com.devtiro.Demo.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Entidade Comprador 

@SpringBootApplication
@RestController
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}
	@GetMapping("/venda")
    public String hello(@RequestParam(value = "name", defaultValue = "vendedorGustavo") String name) {
      return String.format("Hello %s!", name);
    }
	
	
	

}




