package com.fssa.healthyhair.model;

public class Order {
	private int orderId;
	private Product orderedProduct;
	private int quantity;
	private String address;
	private User orderedUser;

	

	public Order(int orderId, Product orderedProduct, int quantity) {
		this.orderId = orderId;
		this.orderedProduct = orderedProduct;
		this.quantity = quantity;

	}

	public Order(int orderId, Product orderedProduct, User orderedUser, int quantity, String address) {
		this.orderId = orderId;
		this.orderedProduct = orderedProduct;
		this.quantity = quantity;
		this.orderedUser = orderedUser;
		this.address = address;
	}

	public Order(Product orderedProduct, int quantity, User orderedUser, String address) {
		this.orderedProduct = orderedProduct;
		this.quantity = quantity;
		this.address = address;
		this.orderedUser = orderedUser;
	}

	public Order() {

	}

	public Product getOrderedProduct() {
		return orderedProduct;
	}

	public void setOrderedProduct(Product orderedProduct) {
		this.orderedProduct = orderedProduct;
	}

	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public User getOrderedUser() {
		return orderedUser;
	}

	public void setOrderedUser(User orderedUser) {
		this.orderedUser = orderedUser;
	}
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedProduct=" + orderedProduct + ", quantity=" + quantity
				+ ", address=" + address + ", orderedUser=" + orderedUser.getUsername() + "]";
	}
}
