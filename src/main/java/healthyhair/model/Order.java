package healthyhair.model;

public class Order {
	private int order_id;
	private Product orderedProduct;
	private int quantity;
	private User orderedUser;

	public Order(int order_id, Product orderedProduct, int quantity, User orderedUser) {

		this.order_id = order_id;
		this.orderedProduct = orderedProduct;
		this.quantity = quantity;
		this.orderedUser = orderedUser;
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
