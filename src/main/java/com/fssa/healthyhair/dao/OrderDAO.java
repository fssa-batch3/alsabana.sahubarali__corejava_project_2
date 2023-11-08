package com.fssa.healthyhair.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.ProductService;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.util.ConnectionUtil;

public class OrderDAO {

	public static boolean create(Order order) throws DAOException {
		final String QUERY = "INSERT INTO orders (order_id,product_id, quantity, buyer_id ,address,city,number,pincode,isonline,seller_id, name,date,delivery_date) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY)) {
			pmt.setInt(1, order.getOrderId());
			pmt.setInt(2, order.getOrderedProduct().getProductId());
			pmt.setInt(3, order.getQuantity());
			pmt.setInt(4, order.getOrderedUser().getUserId());
			pmt.setString(5, order.getAddress());
			pmt.setString(6, order.getCity());
			pmt.setString(7, order.getNumber());
			pmt.setString(8, order.getPincode());
			pmt.setBoolean(9, order.isOnline());
			pmt.setInt(10, order.getOrderedProduct().getCreatedUser().getUserId());
			pmt.setString(11, order.getName());
			Timestamp orderDate = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = dateFormat.format(orderDate);
			pmt.setString(12, formattedDate);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, 7);

			String after7days = dateFormat.format(calendar.getTime());
			pmt.setString(13, after7days);
			int rows = pmt.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Order> view() throws DAOException {
		List<Order> orders = new ArrayList<>();

		final String QUERY = "SELECT user.email,user.user_id"
				+ "product.product_name, product.cost, product.product_image,product.product_detail,product.category,product.product_id,"
				+ "orders.quantity, orders.address, orders.order_id,order.city,order.pincode,order.number,order.name,order.date,order.delivery_date, "
				+ "FROM user " + "INNER JOIN orders ON user.user_id = orders.buyer_id "
				+ "INNER JOIN product ON orders.product_id = product.product_id";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(QUERY);
				ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
				String email = rs.getString("email");
				int userId = rs.getInt("user_id");
				String productname = rs.getString("product_name");
				int productcost = rs.getInt("cost");
				String productImageURL = rs.getString("product_image");
				String category = rs.getString("category");
				String productDetail = rs.getString("product_detail");
				int productId = rs.getInt("product_id");
				int quantity = rs.getInt("quantity");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String pincode = rs.getString("pincode");
				String number = rs.getString("number");
				String name = rs.getString("name");
				String orderDate = rs.getString("date");
				String deliveryDate = rs.getString("delivery_date");
				int orderId = rs.getInt("order_id");

				// Create Product object with retrieved data
				Product product = new Product();
				product.setProductName(productname);
				product.setCost(productcost);
				product.setProductDetail(productDetail);
				product.setProductImg(productImageURL);
				product.setCategory(category);
				product.setProductId(productId);

				// Create User object with retrieved data
				User user = new User();
				user.setUserId(userId);
				user.setEmail(email);

				// Create Order object and add to the list
				Order order = new Order(orderId, product, user, quantity, address);
				order.setAddress(address);
				order.setCity(city);
				order.setPincode(pincode);
				order.setNumber(number);
				order.setName(name);
				order.setDate(orderDate);
				order.setDeliveryDate(deliveryDate);
				orders.add(order);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return orders;
	}

	public static List<Order> findOrdersByUserId(int userId) throws DAOException {
		final String QUERY = "SELECT * FROM orders WHERE buyer_id = ?";
		List<Order> orderList = new ArrayList<>();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY)) {
			pmt.setInt(1, userId);
			User user = new User();
			user.setUserId(userId);

			try (ResultSet rs = pmt.executeQuery()) {
				while (rs.next()) {
					Order order = new Order();
					order.setOrderId(rs.getInt("order_id"));
					order.setQuantity(rs.getInt("quantity"));
					order.setOrderedUser(user);
					order.setAddress(rs.getString("address"));
					order.setName(rs.getString("name"));
					order.setDate(rs.getString("date"));
					order.setDeliveryDate(rs.getString("delivery_date"));
					order.setCity(rs.getString("city"));
					order.setPincode(rs.getString("pincode"));
					order.setNumber(rs.getString("number"));
					int productId = rs.getInt("product_id");

					Product product = ProductService.findProductById(productId);
					order.setOrderedProduct(product);
					orderList.add(order);
				}
			}

		} catch (SQLException | ServiceException e) {
			throw new DAOException(e);
		}

		return orderList; // Return the list of orders for the buyer
	}

	public static boolean findOrderByProductId(int productId) throws DAOException {
		final String QUERY = "SELECT COUNT(*) FROM orders WHERE product_id = ?";
		int count = 0;

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY)) {
			pmt.setInt(1, productId);

			try (ResultSet rs = pmt.executeQuery()) {
				if (rs.next()) {
					count = rs.getInt(1);
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return count > 0;
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
	
	public static boolean update(String status, int orderId)throws DAOException{
		final String SELECTQUERY = "UPDATE orders SET  order_status=? WHERE order_id=?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {
			// Set the updated order attributes in the prepared statement
			stmt.setString(1, status);
			stmt.setInt(2, orderId);
			// Execute the update and get the number of rows affected
			int rows = stmt.executeUpdate();

			return rows > 0;// Return a boolean indicating whether the update was successful
		} catch (SQLException e) {
			throw new DAOException("Error while updating order");
		}
	}
	
 
}
