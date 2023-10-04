package com.fssa.healthyhair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Cart;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.util.ConnectionUtil;

public class CartDAO {

	public static boolean create(Cart cart) throws DAOException {

		final String QUERY = "INSERT INTO cart (product_id, user_id) VALUES (?,?)";

		try (Connection connection = ConnectionUtil.getConnection();

				PreparedStatement pmt = connection.prepareStatement(QUERY)) {

			pmt.setInt(1, cart.getCartProduct().getProductId());
			pmt.setInt(2, cart.getAddedUser().getUserId());

			// Execute the update and get the number of rows affected
			int rowsAffected = pmt.executeUpdate();
			// Return a boolean indicating whether the insertion was successful
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public static boolean remove(int cartId) throws DAOException {
		final String QUERY = "DELETE from cart WHERE cart_id=?";
		// Start a try block with a prepared statement for deleting a product
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(QUERY)) {

			stmt.setInt(1, cartId);// Set the cart ID in the prepared statement for deletion

			int rows = stmt.executeUpdate();

			return rows > 0;// Return a boolean indicating whether the deletion was successful

		} catch (SQLException e) {
			throw new DAOException("Error in cancelling ", e);
		}
	}

	public static List<Cart> findCartItembyUserId(int userId) throws DAOException {
		List<Cart> cartList = new ArrayList<>();
		final String QUERY = "SELECT user.user_id, "
				+ "product.product_name, product.cost, product.product_image, product.product_detail, product.category, product.product_id, "
				+ "cart.cart_id, cart.quantity " + "FROM user " + "INNER JOIN cart ON user.user_id = cart.user_id "
				+ "INNER JOIN product ON cart.product_id = product.product_id " + "WHERE user.user_id = ?"; // Add a
																											// WHERE
																											// clause to
																											// filter by
																											// user_id

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pst = connection.prepareStatement(QUERY)) {
			pst.setInt(1, userId); // Set the user ID as a parameter

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					int cartId = rs.getInt("cart_id");
					String productname = rs.getString("product_name");
					int productcost = rs.getInt("cost");
					String productImageURL = rs.getString("product_image");
					String category = rs.getString("category");
					String productDetail = rs.getString("product_detail");
					int productId = rs.getInt("product_id");
					int quantity = rs.getInt("quantity");
					int userId1 = rs.getInt("user_id");

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
					user.setUserId(userId1);

					// Create Cart object and add to the list
					Cart cart1 = new Cart();
					cart1.setCart_id(cartId);
					cart1.setQuantity(quantity);

					// Set the User and Product objects in the Cart object
					cart1.setAddedUser(user);
					cart1.setCartProduct(product);

					// Add the Cart object to the list
					cartList.add(cart1);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return cartList;
	}
	
	
	
	
}
