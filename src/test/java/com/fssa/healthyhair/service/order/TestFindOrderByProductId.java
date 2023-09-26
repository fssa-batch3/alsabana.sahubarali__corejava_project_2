package com.fssa.healthyhair.service.order;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

 class TestFindOrderByProductId { 
	
	 @Test
	     void testDoesOrderExistForExistingProduct() {
	        int existingProductId = 79; // Replace with an existing product ID in your test database

	        try {
	            boolean orderExists = OrderService.doesOrderExistForProduct(existingProductId);
	            assertTrue(orderExists);
	        } catch (ServiceException e) {
	            fail("ServiceException should not be thrown for an existing product.");
	        }
	    }

	    @Test
	     void testDoesOrderExistForNonExistingProduct() {
	        int nonExistingProductId = 12345; // Replace with a non-existing product ID in your test database

	        try {
	            boolean orderExists = OrderService.doesOrderExistForProduct(nonExistingProductId);
	            assertFalse(orderExists);
	        } catch (ServiceException e) {
	            fail("ServiceException should not be thrown for a non-existing product.");
	        }
	    }

}
