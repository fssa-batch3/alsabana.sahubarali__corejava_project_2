package com.fssa.healthyhair.model;

public class Order { 
    private int orderId;
    private Product orderedProduct;
    private int quantity;
    private User orderedUser;   
    private String address;

    public Order(int orderId, Product orderedProduct, int quantity, User orderedUser) {
        this.orderId = orderId;
        this.orderedProduct = orderedProduct;    
        this.quantity = quantity;
        this.orderedUser = orderedUser;
    }

    public Order(int orderId, Product orderedProduct, int quantity, User orderedUser, String address) {
        this.orderId = orderId;
        this.orderedProduct = orderedProduct;
        this.quantity = quantity;
        this.orderedUser = orderedUser;
        this.address = address;
    }
    public Order( Product orderedProduct, int quantity, User orderedUser, String address) {
        this.orderedProduct = orderedProduct;
        this.quantity = quantity;
        this.orderedUser = orderedUser;
        this.address = address;
    }

    public Order() {
		
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderedUser(User user) {
        this.orderedUser = user;
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

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderedProduct=" + orderedProduct + ", quantity=" + quantity
                + ", orderedUser=" + orderedUser + ", address=" + address + "]";
    }
}
