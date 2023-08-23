package com.fssa.healthyhair.dao.order;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.OrderService;

class TestCreateOrder {
	private final Order order = new Order();

	@Test

	void testOrderSuccess() {
		User user = new User();
		user.setUserId(1);

		order.setUser(user);

		Product product1 = new Product(7, "Ayurvedashampoo", 3700,
				"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");

		order.setQuantity(2); 
		order.setUser(user);
		order.setAddress("Chennai");
		order.setProduct(product1);

		OrderService orderService = new OrderService();
		try {
			assertTrue(orderService.createOrder(order));
			System.out.println("Successfully your order created");
		} catch (ServiceException e) {
			fail();
		}
	}
	
	
	@Test
	void testOrderFail() {
	    OrderService orderService = new OrderService();
	    
	    // Create an invalid order (missing required fields)
	    Order invalidOrder = new Order();
	    
	    try {
	        assertFalse(orderService.createOrder(invalidOrder));
	        System.out.println("Order creation should have failed due to invalid input");
	    } catch (ServiceException e) {
	        // The creation attempt should result in a ServiceException due to invalid input
	        System.out.println("Order creation failed" + e.getMessage());
	    }
	}

}
