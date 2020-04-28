package com.sales.services;

import java.util.ArrayList;

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
	
	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) or.findAll();
		
	}
	
	public void saveOrder(Order o) {
		or.save(o);
		
		System.out.printf("Order saved");
    		
  	}
}
