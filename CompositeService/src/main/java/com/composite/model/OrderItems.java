package com.composite.model;

public class OrderItems {

	int itemId;
	int productId;
	String productName;
	int quantity;
	int price;
	
	
	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItems(int productId, String productName, int quantity, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "LineItems [itemId=" + itemId + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
}
