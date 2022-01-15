package com.composite.model;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerEmail;

	private Billingaddress customerBillingAddress;

	private ShippingAddress customerShippingAddress;

	public Billingaddress getCustomerBillingAddress() {
		return customerBillingAddress;
	}

	public void setCustomerBillingAddress(Billingaddress customerBillingAddress) {
		this.customerBillingAddress = customerBillingAddress;
	}

	public ShippingAddress getCustomerShippingAddress() {
		return customerShippingAddress;
	}

	public void setCustomerShippingAddress(ShippingAddress customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}

	public Customer(int customerId, String customerName, String customerEmail, Billingaddress customerBillingAddress,
			ShippingAddress customerShippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Customer() {
		super();
	}


}
