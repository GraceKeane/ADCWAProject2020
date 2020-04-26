package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.repositories.CustomerRepo;
import com.sales.repositories.ProductRepo;

//Service for customer
@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo cr;
	
	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) cr.findAll();
		
	}
	
	public void saveCustomer(Customer c) {
		cr.save(c);
		
		System.out.printf("Product saved");
    		
  	}

}
