package com.customer.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private String customerEmail;

	@OneToOne(targetEntity = Billingaddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_address_id")
	private Billingaddress customerBillingAddress;

	@OneToOne(targetEntity = ShippingAddress.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id")
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

	public Customer(Long customerId, String customerName, String customerEmail, Billingaddress customerBillingAddress,
			ShippingAddress customerShippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBillingAddress = customerBillingAddress;
		this.customerShippingAddress = customerShippingAddress;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
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
