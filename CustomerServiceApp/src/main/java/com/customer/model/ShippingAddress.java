package com.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bid;

	private Long doorNo;
	private String streetName;
	private String layout;
	private String city;
	private Long pincode;

	public ShippingAddress(Long bid, Long doorNo, String streetName, String layout, String city, Long pincode) {
		super();
		this.bid = bid;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}

	public ShippingAddress() {
		super();
	}

	public Long getId() {
		return bid;
	}

	public void setId(Long id) {
		this.bid = id;
	}

	public Long getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(Long doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


}
