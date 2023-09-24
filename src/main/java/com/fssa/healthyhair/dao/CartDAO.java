package com.fssa.healthyhair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Cart;
import com.fssa.healthyhair.util.ConnectionUtil;

public class CartDAO {

	public static boolean  create(Cart cart) throws DAOException {

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
			throw new DAOException( e);
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
	
}
