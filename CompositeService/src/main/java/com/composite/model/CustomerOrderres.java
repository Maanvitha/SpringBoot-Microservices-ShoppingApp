package com.composite.model;

import java.util.List;

public class CustomerOrderres {
	Customer customer;
	List<Order> ods;
	public CustomerOrderres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Order> getOds() {
		return ods;
	}
	public void setOds(List<Order> ods) {
		this.ods = ods;
	}
	
	
}
