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
	
//////////////////////////////////////////////////////////////////////////////////////////////
	
		// Adding a customer
		@RequestMapping(value = "/addCustomer.html", method=RequestMethod.GET)
		public String addCustomerGET(Model model) {
		
		ArrayList<Customer> customers = cs.getAllCustomers();
		
		Map<String, Long> getCustomers =
		new LinkedHashMap<String, Long>();
		
		for (Customer c : customers) {
		getCustomers.put(c.getCustomername(), c.getNumber());
		}
		
		model.addAttribute("getCustomers", customers);
		
		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "addCustomer";
		}
		
		@RequestMapping(value = "/addCustomer.html", method=RequestMethod.POST)
		public String addCustomerPOST(@ModelAttribute("customer") Customer c) {
		cs.saveCustomer(c);
		return "redirect:getCustomers.html";
		
		}

}
