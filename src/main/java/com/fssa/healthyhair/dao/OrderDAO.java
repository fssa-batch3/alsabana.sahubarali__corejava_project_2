package com.fssa.healthyhair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.util.ConnectionUtil;

public class OrderDAO {

	public boolean create(Order order) throws DAOException {
		final String QUERY = "INSERT INTO orders (order_id, product_id, quantity, user_id ,address) VALUES (?, ?, ?, ?,?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY)) {
			pmt.setInt(1, order.getOrderId());
			pmt.setInt(2, order.getOrderedProduct().getProductId());
			pmt.setInt(3, order.getQuantity());
			pmt.setInt(4, order.getOrderedUser().getUserId());
			pmt.setString(5, order.getAddress());

			int rows = pmt.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Order> view() throws DAOException {
		List<Order> orders = new ArrayList<>();

		final String QUERY = "SELECT user.name, user.email, user.phonenumber, "
				+ "product.product_name, product.cost, product.product_image, product.product_detail,product.category "
				+ "orders.quantity, orders.address, orders.order_id " + "FROM user "
				+ "INNER JOIN orders ON user.user_id = orders.user_id "
				+ "INNER JOIN product ON orders.product_id = product.product_id";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(QUERY);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				String username = rs.getString("name");
				String useremail = rs.getString("email");
				String usernumber = rs.getString("phonenumber");
				String productname = rs.getString("product_name");
				int productcost = rs.getInt("cost");
				String productImageURL = rs.getString("product_image");
				String productDetail = rs.getString("product_detail");
				String category = rs.getString("category");
				int quantity = rs.getInt("quantity");
				String address = rs.getString("address");
				int orderId = rs.getInt("order_id");

				// Create Product object with retrieved data
				Product product = new Product();
				product.setProductName(productname);
				product.setCost(productcost);
				product.setProductImg(productImageURL);
				product.setProductDetail(productDetail);
				product.setCategory(category);

				// Create User object with retrieved data
				User user = new User();
				user.setUsername(username);
				user.setEmail(useremail);
				user.setNumber(usernumber);

				// Create Order object and add to the list
				Order order = new Order(orderId, product, quantity, user, address);
				orders.add(order);
			}
		} catch (SQLException e) {
			throw new DAOException("Error while listing orders", e);
		}

		return orders;
	}

	public static boolean delete(int orderId) throws DAOException {
		final String QUERY = "DELETE from orders WHERE order_id=?";
		// Start a try block with a prepared statement for deleting a product
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(QUERY)) {

			stmt.setInt(1, orderId);// Set the product ID in the prepared statement for deletion

			int rows = stmt.executeUpdate();

			return rows > 0;// Return a boolean indicating whether the deletion was successful

		} catch (SQLException e) {
			throw new DAOException("Error in cancelling order", e);
		}
	}
}
