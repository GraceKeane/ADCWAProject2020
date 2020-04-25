package com.sales.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="number")
	private Long number;
	
	// NotNul - Does not allow a null value, which is what Spring MVC generates if the entry is empty.
	@NotNull
	@Column(name="productname")
	@NotBlank
	private String productname;
	
	@NotNull
	@Column(name="stocknumber")
	// Min - Does not allow the stock number to be less than 0.
	//@PositiveOrZero(message = "You cannot have negative numbers of children.") 
	@Min (value = 0, message = "Stock number can not be below 0")
	private int stocknumber;
	
	//@OneToMany(mappedBy="prod")
	//private List<Product> ordersForProduct = new ArrayList<Product>();*/

	//private List<Order> ordersForProduct = new ArrayList<Order>();

	// Getters & setters
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getStocknumber() {
		return stocknumber;
	}

	public void setStocknumber(int stocknumber) {
		this.stocknumber = stocknumber;
	}

/*	public List<Order> getOrdersForProduct() {
		return ordersForProduct;
	}

	public void setOrdersForProduct(List<Order> ordersForProduct) {
		this.ordersForProduct = ordersForProduct;
	}*/
	
	/*public List<Product> getOrdersForProduct() {
		return ordersForProduct;
	}

	public void setOrdersForProduct(List<Product> ordersForProduct) {
		this.ordersForProduct = ordersForProduct;
	}*/
	
	

}
