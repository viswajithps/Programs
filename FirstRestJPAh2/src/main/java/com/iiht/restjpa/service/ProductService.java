package com.iiht.restjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.restjpa.entity.Product;
import com.iiht.restjpa.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAll() {
		return productRepository.findAll();
		}

	public Optional<Product> getId(Long productid) {
		
		Optional<Product> optional=productRepository.findById(productid);
		if (optional.isPresent()) {
			return optional;
		}else {
			return null;
		}
		
	}
	
	public Product update(Long id,Product product){
		Optional<Product> optional=productRepository.findById(id);
		if(optional.isPresent()) {
			return productRepository.save(product);
		}
		else {
			return null;
		}
	}
	
	public String delete(Long id){
		Optional<Product> optional=productRepository.findById(id);
		if(optional.isPresent()) {
			productRepository.deleteById(id);
			return "Deleted Successfully";
		}
		else {
			return "Not Found";
		}
	}
}
