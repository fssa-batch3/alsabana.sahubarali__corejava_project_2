package com.fssa.healthyhair.service.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

 class TestUpdateCancelStatus {
	 
	@Test
	void testStatusSuccess() {
		try {
			assertTrue(OrderService.update("canceled", 113));
		} catch (ServiceException e) {
			fail();
		}
	}
	
	
	@Test
	void testStatusFail() {
		try {
			assertFalse(OrderService.update("canceled", 0));
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
