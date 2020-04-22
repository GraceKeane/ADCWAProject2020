package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.ProductService;

//Controller for customer
@ Controller
public class CustomerController {
	
	@Autowired
	CustomerService cs;
		
	@RequestMapping(value = "/getCustomers.html")
	  public String getCustomers(Model model) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		System.out.println("Customer Size = " + customers.size());
		model.addAttribute("customers", customers);
	    return "showCustomers";
	  }
}
