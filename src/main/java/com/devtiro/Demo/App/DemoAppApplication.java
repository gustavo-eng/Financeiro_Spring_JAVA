package com.devtiro.Demo.App;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Entidade Comprador 

@SpringBootApplication
@RestController
public class DemoAppApplication {
	
	// toda vez que aplicacao for executada, a configuracao sera executada 
	// atributos nao informados,nao serao atualizados  no vendador na base de dados  
	@Bean
	public ModelMapper modelMapper(){
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.getConfiguration().setSkipNullEnabled(true);//  configurado para n considerar valores nulos 
		 return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}
	@GetMapping("/venda")
    public String hello(@RequestParam(value = "name", defaultValue = " vendedor Gustavo") String name) {
      return String.format("Hello %s!", name);
    }
	 
	
	
}




