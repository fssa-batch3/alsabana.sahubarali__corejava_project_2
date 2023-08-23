package com.fssa.healthyhair.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;

public class OrderDAO {

	public boolean create(Order order) throws DAOException {
		final String QUERY = "INSERT INTO orders (order_id, product_id, quantity, user_id ,address) VALUES (?, ?, ?, ?,?)";

		try (PreparedStatement pmt = UserDAO.getConnection().prepareStatement(QUERY)) {
			pmt.setInt(1, order.getOrder_id());
			pmt.setInt(2, order.getProduct().getProduct_id());
			pmt.setInt(3, order.getQuantity());
			pmt.setInt(4, order.getUser().getUserId());
			pmt.setString(5, order.getAddress());

			int rows = pmt.executeUpdate();
			return rows > 0;
		} catch (SQLException e) { 
			throw new DAOException(e);
		}
	}

	public List<Order> view() throws DAOException {
		List<Order> orders = new ArrayList<>();

		final String query = "SELECT user.name, user.email, user.phonenumber, "
				+ "product.product_name, product.cost, product.product_image, product.product_detail,product.category "
				+ "orders.quantity, orders.address, orders.order_id " + "FROM user "
				+ "INNER JOIN orders ON user.user_id = orders.user_id "
				+ "INNER JOIN product ON orders.product_id = product.product_id";

		try (PreparedStatement pst = UserDAO.getConnection().prepareStatement(query);
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
//				Product product = new Product();
//				product.setProduct_name(productname);
//				product.setCost(productcost);
//				product.setProduct_img(productImageURL);
//				product.setProduct_detail(productDetail);
//				product.setCategory(category);

				// Create User object with retrieved data
				User user = new User();
				user.setUsername(username);
				user.setEmail(useremail);
				user.setNumber(usernumber);

				// Create Order object and add to the list
				Order order = new Order();
				order.setUser(user);
			//	order.setProduct(product);
				order.setQuantity(quantity);
				order.setAddress(address);
				order.setOrder_id(orderId);

				orders.add(order);
			}
		} catch (SQLException e) {
			throw new DAOException("Error while listing orders", e);
		}

		return orders;
	}

}
