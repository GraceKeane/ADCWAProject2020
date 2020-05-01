package com.sales.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.ProductService;

//Controller for customer
@ Controller
public class CustomerController {
	
	@Autowired
	CustomerService cs;
		
	// Method for finding all customers in the database & 
	// displaying them in "/getCustomers.html" 
	@RequestMapping(value = "/getCustomers.html")
	  public String getCustomers(Model model) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		System.out.println("Customer Size = " + customers.size());
		model.addAttribute("customers", customers);
	    return "showCustomers";
	 }
		
	// Adding a customer to the getCustomers.html page & database
	@RequestMapping(value = "/addCustomer.html", method=RequestMethod.GET)
	public String addCustomerGET(Model model) {
		// Getting customer from the database	
		ArrayList<Customer> customers = cs.getAllCustomers();
		// Create a getCustomer map	
		Map<String, Long> getCustomers =
		new LinkedHashMap<String, Long>();
		// Adding customer name and number to the map	
		for (Customer c : customers) {
		getCustomers.put(c.getCustomername(), c.getNumber());
		}
		// Add to map
		model.addAttribute("getCustomers", customers);
		// Creating a new customer
		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "addCustomer";
	}
		
	// When data is submitted a post request is sent to the browser
	@RequestMapping(value = "/addCustomer.html", method=RequestMethod.POST)
		// @Valid & BindingResult -> checks whether there is errors or not in submission form
		public String addCustomerPOST(@Valid @ModelAttribute("customer") Customer c, BindingResult result) {
		
			// If entered data has errors user will be directed to the original addCustomer page
			if (result.hasErrors()) {
				return "addCustomer";
			}
			
			// Else -> customer is saved and info is displayed in the "getCustomers.html page" 
			cs.saveCustomer(c);	
		return "redirect:getCustomers.html";
			
		}
	}
