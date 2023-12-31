package com.fssa.healthyhair.service;

import java.util.List;


import com.fssa.healthyhair.dao.CartDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Cart;
import com.fssa.healthyhair.service.exception.ServiceException;

public class CartService {

	public static boolean createCart(Cart cart) throws ServiceException {

		try {

			return CartDAO.create(cart);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public static boolean addToCart(int userId, int productId) throws ServiceException {
		try {
			return CartDAO.addToCart(userId, productId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public static boolean remove(int cartId) throws ServiceException {
		try {
			// Check if the order deletion in the DAO was successful and provide feedback

			return CartDAO.remove(cartId);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}

	public static List<Cart> findCartItemsByuserId(int userId) throws ServiceException {
		List<Cart> cartList;
		try {
			// Call the DAO to retrieve the product by ID.
			cartList = CartDAO.findCartItembyUserId(userId);
			return cartList;

		} catch (DAOException e) {
			// Handle any exceptions or rethrow them as ServiceException if necessary.
			throw new ServiceException("Failed to retrieve cart by user ID", e);
		}

	}

}
