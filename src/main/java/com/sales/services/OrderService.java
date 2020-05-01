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
	
	// get current date 
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
		
	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) or.findAll();
		
	}
	
	public void save(Order o) {
		o.setOrderDate(dateFormat.format(date));
		or.save(o);
		
		System.out.printf("Order saved");
    		
  	}
}
