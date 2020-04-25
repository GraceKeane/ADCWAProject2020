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
	
	// Getting all products from the database
	@RequestMapping(value = "/getProducts.html")
	  public String getProducts(Model model) {
		ArrayList<Product> products = ps.getAllProducts();
		System.out.println("Size = " + products.size());
		model.addAttribute("products", products);
	    return "showProducts";
	  }
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Adding a product
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model model) {
		
		ArrayList<Product> products = ps.getAllProducts();
		
		
		
		
		Map<String, Integer> getProducts =
				new LinkedHashMap<String, Integer>();
		
		for (Product p : products) {
			getProducts.put(p.getProductname(), p.getStocknumber());
		}
		
		model.addAttribute("getProducts", products);
		
		Product p = new Product();
		model.addAttribute("product", p);
		return "addProduct";
	}
	
	@RequestMapping(value = "/addProduct.html", method=RequestMethod.POST)
	public String addProductPOST(@ModelAttribute("product") Product p) {
		ps.saveProduct(p);
		return "redirect:getProducts.html";
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	// Security
	// Security - checking if the product stock number is greater or equal to 0
	
	/*@GetMapping("/")
	public String showForm(Product product) {
		return "form";
	}
	
	@PostMapping("/")
	public String checkProductInfo(@Valid Product product, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		return "redirect:/getProducts";
	}*/
	
}
