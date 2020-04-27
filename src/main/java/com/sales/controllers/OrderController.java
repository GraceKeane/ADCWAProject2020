package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Order;
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
}
	

