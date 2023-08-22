package com.fssa.healthyhair.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;

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

}
