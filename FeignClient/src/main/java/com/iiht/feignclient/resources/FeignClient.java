package com.iiht.feignclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.feignclient.ifaces.FeignInterface;
import com.iiht.feignclient.model.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class FeignClient {
	
	
	 @Autowired

	 private FeignInterface feignclient;

	 @Autowired
	 Environment environment;
	 

	 																																									//http://localhost:7082/client/allProducts
     @CircuitBreaker(name="client-cb",fallbackMethod="generateResponse")
	 @GetMapping("/allProducts")

	 public List<Product> getAll() {

		 

		  return feignclient.getProducts();

	 }
     
     @GetMapping()
     public String Welcome()
     {
    	 String port=environment.getProperty("server.port");
    	 return port;
     }
	 																																												//http://localhost:7082/client/products-by-id/2

	 @GetMapping("/products-by-id/{id}")

		public Product getProductById(@PathVariable ("id") int id) {

		   System.out.println(id);
		   

		   return feignclient.getProductsById(id);

	 }

	 																																											// http://localhost:7082/client/products-by-category/Mobile

	 @GetMapping("/products-by-category/{category}")

		public List<Product> getProductsByCategory(@PathVariable("category") String category){

		 

		           return feignclient.getProductsByCategory(category);

	 }
	 
	 public String generateResponse(Throwable throwable) {
		  
		  return "The Server is Unavailable Temporary,Pls Try After Some time";
	 }

}
