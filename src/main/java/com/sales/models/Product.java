package com.sales.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="number")
	private Long number;
	
	@Column(name="productname")
	@NotEmpty
	private String productname;
	
	@Column(name="stocknumber")
	@Min(value = 0)
	private int stocknumber;
	
	@OneToMany(mappedBy="prod")
	private List<Order> ordersForProduct = new ArrayList<Order>();
	
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

	/*public List<Order> getOrdersForProduct() {
		return ordersForProduct;
	}

	public void setOrdersForProduct(List<Order> ordersForProduct) {
		this.ordersForProduct = ordersForProduct;
	}*/

	

}
