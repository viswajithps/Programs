package com.iiht.resl4jclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class resl4jClientController {
	
	@Autowired
	RestTemplate restTemplate;
	public final static String CLIENT_SERVICE="clientService";
	
	
	@GetMapping("/client")
	@CircuitBreaker(name=CLIENT_SERVICE,
	fallbackMethod="callOnFail")
	public String message() {
		String url="http://localhost:8071/hello";
		String output=restTemplate.getForObject(url, String.class);
		return output;
	}
	
	public String callOnFail(Exception e) {
		return "message from callOnFail()....";
	}

}
