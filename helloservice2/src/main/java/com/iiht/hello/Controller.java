package com.iiht.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service2")
public class Controller {

	@GetMapping("/fetch")
	public String message() {
		return "HELLO from Service 2";
	}
}
