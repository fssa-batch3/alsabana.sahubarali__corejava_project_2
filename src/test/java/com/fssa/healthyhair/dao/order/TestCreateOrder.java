package com.fssa.healthyhair.dao.order;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.OrderService;

class TestCreateOrder {
	private final Order order = new Order();

	@Test

	void validOrderSuccess() {
		User user = new User();
		user.setUserId(1);

		order.setUser(user);

		Product product1 = new Product("Ayurvedashampoo", 3700,
				"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");

		order.setQuantity(2);
		order.setUser(user);
		order.setProduct(product1);

		OrderService orderService = new OrderService();
		try {
			assertTrue(orderService.createOrder(order));
			System.out.println("Successfully your order created");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}
}
