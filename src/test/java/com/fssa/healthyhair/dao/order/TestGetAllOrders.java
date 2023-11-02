package com.fssa.healthyhair.dao.order;

import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestGetAllOrders {
	final OrderService orderService = new OrderService();
	@Test
	void testGetOrderSuccess() {
		try {
			List<Order> order = orderService.getAllOrder();
			assertNotNull(order);

		} catch (ServiceException e) {

			e.printStackTrace();
		}
	}

	


}
