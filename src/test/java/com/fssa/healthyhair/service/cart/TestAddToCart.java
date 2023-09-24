package com.fssa.healthyhair.service.cart;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.CartDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Cart;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;

class TestAddToCart {

	@Test
	void testCreateCart() {
		try {
			// Create a Cart object with the necessary information
			Cart cart = new Cart();
			Product product = new Product();
			product.setProductId(2);
			User user = new User();
			user.setUserId(3);
			cart.setCartProduct(product); // Assuming you have a Product class
			cart.setAddedUser(user); // Assuming you have a User class

			// Call the create method
			boolean success = CartDAO.create(cart);

			assertTrue("Cart should be created successfully", success);
		} catch (DAOException e) {
			fail("An exception occurred: " + e.getMessage());
		}
	}

}
