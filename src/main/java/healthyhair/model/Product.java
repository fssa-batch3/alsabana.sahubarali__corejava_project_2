package healthyhair.model;

public class Product {
	private String product_name;
	private int cost;
	private String product_img;
	private String product_detail;
	private String category;
	private int product_id;

	public Product(String product_name, int cost, String product_img, String product_detail, String category) {
		this.product_name = product_name;
		this.cost = cost;
		this.product_img = product_img;
		this.product_detail = product_detail;
		this.category = category;
	}

	public Product(int product_id, String product_name, int cost, String product_img, String product_detail,
			String category) {
		this.product_name = product_name;
		this.setProduct_id(product_id);
		this.cost = cost;
		this.product_img = product_img;
		this.product_detail = product_detail;
		this.category = category;
	}

	public Product() {

	}

	public String getProduct_name(String string) {
		return product_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "Product [product_name = " + product_name + ", cost = " + cost + ", product_img=" + product_img
				+ ", product_detail = " + product_detail + ", category=" + category + ", product_id=" + product_id
				+ "]";
	}

	public void getProduct_id(int i) {

	}

}
