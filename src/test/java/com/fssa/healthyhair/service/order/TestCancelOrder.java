package com.fssa.healthyhair.service.order;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

 class TestCancelOrder {
	
	@Test
	 void deleteOrderSuccess(){
		OrderService orderService = new OrderService();
		try {
			assertTrue(orderService.deleteOrder(4));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	 
	@Test
	 void deleteOrderFail(){
		OrderService orderService = new OrderService();
		try {
			assertFalse(orderService.deleteOrder(00));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
