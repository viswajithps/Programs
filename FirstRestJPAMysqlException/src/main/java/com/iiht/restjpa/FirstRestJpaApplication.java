package com.iiht.restjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FirstRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestJpaApplication.class, args);
	}

}
