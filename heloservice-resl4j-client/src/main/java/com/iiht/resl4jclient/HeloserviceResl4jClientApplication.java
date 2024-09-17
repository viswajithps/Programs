package com.iiht.resl4jclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HeloserviceResl4jClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeloserviceResl4jClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate newTemplate() {
		return new RestTemplate();
	}

}
