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
import com.sales.models.Order;
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
	
		// Adding an order - customer name
	
		// Drop down list got person name
		@RequestMapping(value = "/addOrder.html", method=RequestMethod.GET)
		public String addOrder(Model model) {	
			
			ArrayList<Customer> customers = cs.getAllCustomers();
			
			Map<Long, String> customerList =
					new LinkedHashMap<Long, String>();
					
			for (Customer c : customers) {
				customerList.put(c.getNumber(), c.getCustomername());
			
			}
			
			
			
			
			model.addAttribute("customerList", customerList);
			Order o = new Order();
			model.addAttribute("order", o);
			return "addOrder";			
		}
		
		@RequestMapping(value="/addOrder.html", method=RequestMethod.POST)
		public String addOrderPOST(@ModelAttribute("order")Order o) {
			os.saveOrder(o);
			return "redirect:getOrders.html";
		}
}
	

