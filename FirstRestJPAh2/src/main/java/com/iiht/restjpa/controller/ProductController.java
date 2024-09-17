package com.iiht.restjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.service.ProductService;

@RestController
@RequestMapping("/product/api1.0")
public class ProductController {
	
	
	@Autowired
	ProductService service;
	
	@PostMapping
	@RequestMapping(path="/create",
	         consumes=MediaType.APPLICATION_JSON_VALUE,
	         produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product>createProduct(@RequestBody Product product){
		
		Product pro=service.save(product);
		return new ResponseEntity<Product>(pro,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Product>>GetAllProduct(){
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@GetMapping("/fetch/{productid}")
	public ResponseEntity<?>GetById(@PathVariable Long productid){
		return ResponseEntity.ok().body(service.getId(productid));
	}
	
	
	@PutMapping("/update/{productid}")
	public ResponseEntity<Product>Update(@PathVariable Long productid,@RequestBody Product product){
		return ResponseEntity.ok().body(service.update(productid, product));
	}
	
	@DeleteMapping("/delete/{productid}")
	public ResponseEntity<String>Delete(@PathVariable Long productid){
		
		
		return ResponseEntity.ok().body(service.delete(productid));
	}
	

}


