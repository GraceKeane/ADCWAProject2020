package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderRepo;

//Service for order

@Service
public class OrderService {
	
	@Autowired
	OrderRepo or;
		
	// Get the current date & correct format as seen in order spec
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
		
	public ArrayList<Order> getAllOrders() {
		// Find all orders in the database
		return (ArrayList<Order>) or.findAll();
		
	}
	
	// Saving an order to the database & screen 
	public void save(Order o) {
		// Setting the date & format
		o.setOrderDate(dateFormat.format(date));
		// Saving the order
		or.save(o);
		// Print out to console one order has been saved
		System.out.printf("Order saved");
    		
  	}
}
