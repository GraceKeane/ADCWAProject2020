package com.sales.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="number")
	private Long number;

	@Column(name="customername")
	@NotBlank
	private String customername;
	
	/*@OneToMany(mappedBy="cust")
	private List<Order> orders = new ArrayList<Order>();
*/
	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	/*public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}*/	
}