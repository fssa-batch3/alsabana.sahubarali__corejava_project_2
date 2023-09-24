package com.fssa.healthyhair.model;

public class Product {
	private String productName;
	private int cost;
	private String productImg;
	private String productDetail;
	private String category;
	private int productId;
	private User createdUser;

	public Product(String productName, int cost, String productImg, String productDetail, String category) {
		this.productName = productName;
		this.cost = cost;
		this.productImg = productImg;
		this.productDetail = productDetail;
		this.category = category;
	}

	public Product(int productId, String productName, int cost, String productImg, String productDetail,
			String category) {
		this.productName = productName;
		this.productId = productId;
		this.cost = cost;
		this.productImg = productImg;
		this.productDetail = productDetail;
		this.category = category;
	}

	public Product(String productName, int cost, String productImg, String productDetail, String category,
			int productId, User createdUser) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.productImg = productImg;
		this.productDetail = productDetail;
		this.category = category;
		this.productId = productId;
		this.createdUser = createdUser;
	}

	public Product(String productName, int cost, String productImg, String productDetail, String category,
			User createdUser) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.productImg = productImg;
		this.productDetail = productDetail;
		this.category = category;

		this.createdUser = createdUser;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [productName = " + productName + ", cost = " + cost + ", productImg=" + productImg
				+ ", productDetail = " + productDetail + ", category=" + category + ", productId=" + productId + "]";
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

}
