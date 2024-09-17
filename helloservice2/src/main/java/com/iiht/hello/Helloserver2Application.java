package com.iiht.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Helloserver2Application {

	public static void main(String[] args) {
		SpringApplication.run(Helloserver2Application.class, args);
	}

}
