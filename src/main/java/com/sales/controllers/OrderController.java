package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderRepo;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController{
	
	@Autowired
	OrderService os;
	
	@Autowired 
	ProductService ps;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	OrderRepo or;
	
	// Method for finding all orders in the database & 
	// displaying them in "/getOrders.html" 
	@RequestMapping(value = "/getOrders.html", method=RequestMethod.GET)
	  public String getOrdersGET(Model model) {
		ArrayList<Order> orders = os.getAllOrders();
		System.out.println("Order Size = " + orders.size());
		model.addAttribute("orders", orders);
	    return "showOrders";

	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Adding an order to the getOrders.html page & database

		@RequestMapping(value = "/addOrder.html", method=RequestMethod.GET)
		public String addOrderGET(Model model) {	
			
			// Drop down list for person name, extracting all names
			// from the database 
			
			// Getting customers from the database	
			ArrayList<Customer> customers = cs.getAllCustomers();
			// Create a list1 map 	
			Map<Long, String> list1 = new HashMap<Long, String>();	
			// Adding customer number and name to the map	
			for (Customer c : customers) {
			list1.put(c.getNumber(), c.getCustomername());
			}
			// Add to map
			model.addAttribute("list1", list1);
			
			
			// Drop down list for product description, extracts all product
			// descriptions from the database
			
			// Getting products from the database	
			ArrayList<Product> products = ps.getAllProducts();
			// Create a list2 map 	
			Map<Long, String> list2 = new HashMap<Long, String>();
			// Adding product number and name to the map	
			for (Product p : products) {
				list2.put(p.getNumber(), p.getProductname());
			}
			// Add to map
			model.addAttribute("list2", list2);	
			
			// Creating a new order
			Order o = new Order();
			model.addAttribute("order", o);
			
			// Returning the addOrder page 
			return "addOrder";	
		}
		
	
		// When data is submitted a post request is sent to the browser
		@RequestMapping(value="/addOrder.html", method=RequestMethod.POST)
		// @Valid & BindingResult -> checks whether there is errors or not in submission form
		public String addOrderPOST(@Valid @ModelAttribute("order")Order o,  BindingResult result) {						
			
			// If entered data has errors user will be directed to the original addOrder page
			if (result.hasFieldErrors()) {
				return "addOrder";
			}
			else {
				
				// Else -> order is saved and info is displayed in the "getOrders.html page" 
				os.save(o);
				return "redirect:getOrders.html";
			}	
		}
	}
		

	

