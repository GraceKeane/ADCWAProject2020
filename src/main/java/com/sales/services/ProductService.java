package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepo;

// Service for product
@Service
public class ProductService {
	
	@Autowired
	ProductRepo pr;
	
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) pr.findAll();
		
	}
	
	public void saveProduct(Product p) {
		pr.save(p);
		
		System.out.printf("Product saved");
    		
  	}
}
