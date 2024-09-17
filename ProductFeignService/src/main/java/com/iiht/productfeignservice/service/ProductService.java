package com.iiht.productfeignservice.service;

import java.util.List;

import com.iiht.productfeignservice.model.Product;
 
public interface ProductService {
	
	List<Product> findAll();
	List<Product> findByCategory(String Category);
	Product findById(int id);

}
