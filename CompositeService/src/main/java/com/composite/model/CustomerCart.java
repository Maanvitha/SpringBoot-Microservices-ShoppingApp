package com.composite.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_cart")
public class CustomerCart {
	
	@Id
	int customerId;
	int cartId;
	public CustomerCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int long1) {
		this.customerId = long1;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	

}
