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
import com.sales.models.Product;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController{
	
	@Autowired
	OrderService os;
	
	@RequestMapping(value = "/getOrders.html")
	  public String getOrders(Model model) {
		ArrayList<Order> orders = os.getAllOrders();
		System.out.println("Order Size = " + orders.size());
		model.addAttribute("orders", orders);
	    return "showOrders";

	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	
		// Adding an order
	
		// Drop down list got person name
		@RequestMapping(value = "/addOrder.html")
		public String addOrder(Model model) {	
			
			Map<Integer, String> orders =
					new LinkedHashMap<Integer, String>();
					
					orders.put(1,"John");
					orders.put(2,"Tom");
					orders.put(3,"Fred");	
					model.addAttribute("orderList", orders);
			
			Order o = new Order();
			model.addAttribute("order", o);
			return "addOrder";
		}
}
	

