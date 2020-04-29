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
import com.sales.models.Order;
import com.sales.models.Product;
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
	
	@RequestMapping(value = "/getOrders.html")
	  public String getOrders(Model model) {
		ArrayList<Order> orders = os.getAllOrders();
		System.out.println("Order Size = " + orders.size());
		model.addAttribute("orders", orders);
	    return "showOrders";

	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
		// Adding an order
		@RequestMapping(value = "/addOrder.html", method=RequestMethod.GET)
		public String addOrder(Model model) {	
			
			// Drop down list for person name
			ArrayList<Customer> customers = cs.getAllCustomers();
			Map<Long, String> customerList = new LinkedHashMap<Long, String>();	
			for (Customer c : customers) {
				customerList.put(c.getNumber(), c.getCustomername());
			}
			model.addAttribute("customerList", customerList);
			Customer c = new Customer();
		
			
			// Drop down list for product name 
			ArrayList<Product> products = ps.getAllProducts();
			Map<Long, String> productList = new LinkedHashMap<Long, String>();
			for (Product p : products) {
				productList.put(p.getNumber(), p.getProductname());
			}
			model.addAttribute("productList", productList);
			Product p = new Product();
			
			// Qty input
			ArrayList<Order> orders = os.getAllOrders();
			Map<Long, Integer> getOrders = new LinkedHashMap<Long, Integer>();
			for (Order o : orders) {
			getOrders.put(o.getoId(), o.getQty());
			}
			model.addAttribute("getOrders", orders);			
					
			Order o = new Order();
			model.addAttribute("order", o);
			
			return "addOrder";
			
		}
		

		
		@RequestMapping(value="/addOrder.html", method=RequestMethod.POST)
		public String addOrderPOST(@Valid @ModelAttribute("order")Order o,  BindingResult result) {
			if (result.hasErrors()) {
				return "addOrder";
			}
			os.saveOrder(o);
				
			return "redirect:getOrders.html";
		}
		
		
}
	

