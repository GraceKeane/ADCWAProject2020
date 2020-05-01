package com.sales.controllers;

import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.sales.models.Product;
import com.sales.services.ProductService;

// Controller for product
@ Controller
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	// Method for finding all products in the database & 
	// displaying them in "/getProducts.html" 
	@RequestMapping(value = "/getProducts.html")
	  public String getProducts(Model model) {
		ArrayList<Product> products = ps.getAllProducts();
		System.out.println("Size = " + products.size());
		model.addAttribute("products", products);
	    return "showProducts";
	  }
	
	
	// Adding a product to the getProducts.html page & database
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model model) {
		// Getting product from the database
		ArrayList<Product> products = ps.getAllProducts();
		// Create a getProducts map
		Map<String, Integer> getProducts =
		new LinkedHashMap<String, Integer>();
		// Adding product name and stocknumber to the map
		for (Product p : products) {
			getProducts.put(p.getProductname(), p.getStocknumber());
		}
		// Add to map
		model.addAttribute("getProducts", products);
		// Creating a new product
		Product p = new Product();
		model.addAttribute("product", p);
		return "addProduct";
	}
	
	// When data is submitted a post request is sent to the browser
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.POST)
	// @Valid & BindingResult -> checks whether there is errors or not in submission form
	public String addProductPOST(@Valid @ModelAttribute("product") Product p, BindingResult result) {
		// If entered data has errors user will be directed to the original addProduct page
		if (result.hasErrors()) {
			return "addProduct";
		}
		
		// Else -> product is saved and info is displayed in the "getProduct.html page" 
		ps.saveProduct(p);
		return "redirect:getProducts.html";
		
	}
	
}
