package com.fssa.healthyhair.service.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestCreateOrder {

	@Test
	void testCreateOrderSuccess() {
		Order order = new Order();
		order.setOrderId(4);

		Product product = new Product();
		product.setProductId(64);

		User orderedUser = new User();
		orderedUser.setUserId(27);

		User createdUser = new User();
		createdUser.setUserId(28);

		order.setOrderedProduct(product);
		order.setQuantity(2);
		order.setAddress("Chennai");
		order.setOrderedUser(orderedUser);
		product.setCreatedUser(createdUser);

		try {
			assertTrue(OrderService.createOrder(order));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	void testCreateOrderFailure() {
	    // Create an Order instance with missing or invalid properties
	    Order order = new Order();
	    // Not setting order ID intentionally to cause a failure

	    Product product = new Product();
	    product.setProductId(600);

	    User orderedUser = new User();
	    orderedUser.setUserId(27);

	    User createdUser = new User();
	    createdUser.setUserId(28);

	    order.setOrderedProduct(product);
	    order.setQuantity(2);
	    order.setAddress("Chennai");
	    order.setOrderedUser(orderedUser);
	    product.setCreatedUser(createdUser);

	    try {
	       
	        assertFalse(OrderService.createOrder(order));
	    } catch (ServiceException e) {
	       
	        e.printStackTrace();
	    }
	}
}
