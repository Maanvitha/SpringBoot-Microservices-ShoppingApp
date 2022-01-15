package com.composite.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_order")
public class CustomerOrders {

	@Id
	int customerId;
	int orderId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public CustomerOrders(int customerId, int orderId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
	}
	public CustomerOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
