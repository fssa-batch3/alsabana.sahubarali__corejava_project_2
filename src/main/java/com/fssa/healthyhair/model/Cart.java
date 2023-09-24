package com.fssa.healthyhair.model;

public class Cart {

	private Product cartProduct;
	private User addedUser;
	private int quantity;

	public Cart() {
		super();

	}

	public Product getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(Product cartProduct) {
		this.cartProduct = cartProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getAddedUser() {
		return addedUser;
	}

	public void setAddedUser(User addedUser) {
		this.addedUser = addedUser;
	}

	@Override
	public String toString() {
		return "Cart [cartProduct=" + cartProduct + ", addedUser=" + addedUser + ", quantity=" + quantity + "]";
	}

}
