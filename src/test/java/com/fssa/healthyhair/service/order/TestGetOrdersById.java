package com.fssa.healthyhair.service.order;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

public class TestGetOrdersById {
	
	    public void testFindOrdersByUserId() {
	        int userId = 76; // Replace with the actual user ID you want to test

	        OrderService orderService = new OrderService(); // Create an instance of your OrderService

	        try {
	            List<Order> orderList = orderService.findOrdersByUserId(userId);
	            assertTrue("No orders found for User ID: " + userId, !orderList.isEmpty());
	        } catch (ServiceException e) {
	            fail("ServiceException should not be thrown: " + e.getMessage());
	        }
	    }
	}



