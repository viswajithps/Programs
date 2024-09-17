package com.iiht.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/client")
public class HelloClient {
	
	@Autowired
	RestTemplate template;

	@GetMapping("/fact")
	public ResponseEntity<String> connect() {
		String url="http://localhost:8071/hello";
		ResponseEntity<String> response=template.getForEntity(url, String.class);
		return response;
	}
	
//	@GetMapping("/even/{number}")
//	public ResponseEntity<String> connect2(@PathVariable int number) {
//		String url="http://localhost:8071/even/{number}";
//		ResponseEntity<String> response=template.getForEntity(url, String.class);
//		return response;
//	}
//	
//	@GetMapping("/square/{number}")
//	public ResponseEntity<String> connect3(@PathVariable int number) {
//		String url="http://localhost:8071/square/{number}";
//		ResponseEntity<String> response=template.getForEntity(url, String.class);
//		return response;
//	}
}
