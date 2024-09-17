package com.iiht.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	Integer productd;
	String name;
	String category;
	String brand;
	double price;

}
