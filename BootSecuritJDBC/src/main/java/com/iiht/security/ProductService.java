package com.iiht.security;

import java.util.List;




 
public interface ProductService {
	
	List<Product> findAll();
	List<Product> findByCategory(String Category);
	Product findById(int id);

}
