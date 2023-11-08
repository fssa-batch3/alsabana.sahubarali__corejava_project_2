package com.fssa.healthyhair.service.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestCancelOrder {

	@Test
	void deleteOrderSuccess() {

		try {
			assertTrue(OrderService.update("cancel", 132));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void deleteOrderFail() {

		try {
			assertFalse(OrderService.update("cancel", 0));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
