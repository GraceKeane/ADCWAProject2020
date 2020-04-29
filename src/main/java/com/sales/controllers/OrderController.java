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
		public String addOrderGET(Model model) {	
			
			/// Drop down list for person name
			ArrayList<Customer> customers = cs.getAllCustomers();
			Map<Long, String> list1 = new HashMap<Long, String>();	
			for (Customer c : customers) {
				list1.put(c.getNumber(), c.getCustomername());
			}
			
			model.addAttribute("list1", list1);
			
			
			
			/// Drop down list for product description 
			ArrayList<Product> products = ps.getAllProducts();
			Map<Long, String> list2 = new HashMap<Long, String>();
			for (Product p : products) {
				list2.put(p.getNumber(), p.getProductname());
			}
			model.addAttribute("list2", list2);			
			
		
			Order o = new Order();
			model.addAttribute("orders", o);
				
			return "addOrder";
			
		}
		

		
		@RequestMapping(value="/addOrder.html", method=RequestMethod.POST)
		public String addOrderPOST(@Valid @ModelAttribute("orders")Order orders,  BindingResult result) {
			if (result.hasErrors()) {
				return "addOrder";
			}
	
			//os.saveOrder(order);
		
			return "redirect:getOrders.html";
		}	
}
	

