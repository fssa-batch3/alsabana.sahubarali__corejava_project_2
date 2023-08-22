package com.fssa.healthyhair.model;

public class Order {
	private int order_id;
	private Product orderedProduct;
	private int quantity;
	private User orderedUser;
	private String address;

	public Order(int order_id, Product orderedProduct, int quantity, User orderedUser) {

		this.order_id = order_id;
		this.orderedProduct = orderedProduct;
		this.quantity = quantity;
		this.orderedUser = orderedUser;
	}

	public Order(int order_id, Product orderedProduct, int quantity, User orderedUser, String address) {

		this.order_id = order_id;
		this.orderedProduct = orderedProduct;
		this.quantity = quantity;
		this.orderedUser = orderedUser;
		this.address = address;
	}

	public Product getOrderedProduct() {
		return orderedProduct;
	}

	public void setOrderedProduct(Product orderedProduct) {
		this.orderedProduct = orderedProduct;
	}

	public User getOrderedUser() {
		return orderedUser;
	}

	public void setOrderedUser(User orderedUser) {
		this.orderedUser = orderedUser;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order(Product orderedProduct, int quantity, User orderedUser) {

		this.orderedProduct = orderedProduct;
		this.quantity = quantity;
		this.orderedUser = orderedUser;
	}

	public User getUser() {
		return orderedUser;
	}

	public void setUser(User user) {
		this.orderedUser = user;
	}

	public Order() {
		super();
	}

	public Product getProduct() {
		return orderedProduct;
	}

	public void setProduct(Product product) {
		this.orderedProduct = product;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
