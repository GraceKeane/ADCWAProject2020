package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Product;
import com.sales.services.ProductService;

// Controller for product
@ Controller
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@RequestMapping(value = "/getProducts.html")
	  public String getProducts(Model model) {
		ArrayList<Product> products = ps.getAllProducts();
		System.out.println("Size = " + products.size());
		model.addAttribute("products", products);
	    return "showProducts";
	  }
}
