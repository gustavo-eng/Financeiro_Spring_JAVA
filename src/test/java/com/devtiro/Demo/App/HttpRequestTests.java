package com.devtiro.Demo.App;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;


import org.springframework.beans.factory.annotation.Value;
import static org.assertj.core.api.Assertions.assertThat;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTests {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/test",
				String.class)).contains("Hello, World");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageForListOfSeller() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendedor",
				String.class)).contains("[]");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageForSellerInitial() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendedor/1",
				String.class)).isNotEqualTo("[]");
	}
		
	@Test
	public void greetingShouldReturnDefaultMessageForSells() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendas/listagem",
				String.class)).contains("[]");
	}
	
	@Test
	public void greetingShouldReturnDefaultMessageForSellsPerSeller() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/vendas/vendedor/1",
				String.class)).contains("[]");
	}

	
	
	

}






















