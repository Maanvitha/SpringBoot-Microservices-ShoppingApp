package com.composite.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



public class Order {

	
	
	int orderId;
	
	List<OrderItems> items=new ArrayList<>();
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(List<OrderItems> items) {
		super();
		this.items = items;
	}
	public Order(Order o) {
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<OrderItems> getItems() {
		return items;
	}
	public void setItems(List<OrderItems> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + "]";
	}
	
	
}
