package com.sales.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
}
