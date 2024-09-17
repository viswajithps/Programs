package com.iiht.securityinmemory.service;

import java.util.List;

import com.iiht.securityinmemory.model.Product;


 
public interface ProductService {
	
	List<Product> findAll();
	List<Product> findByCategory(String Category);
	Product findById(int id);

}
