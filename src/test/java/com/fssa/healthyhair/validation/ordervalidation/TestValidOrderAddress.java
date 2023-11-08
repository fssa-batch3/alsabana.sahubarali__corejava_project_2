package com.fssa.healthyhair.validation.ordervalidation;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.OrderValidator;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;

class TestValidOrderAddress {

	@Test
	void testValidCompleteAddress() {
		String address = "123 Main Street, Cityville, Stateland, 12345";
		try {
			Assert.assertTrue(OrderValidator.validateAddress(address));
		} catch (InvalidOrderException e) {
			System.err.println(e.getMessage());

		}
	}
 
	@Test
	void testMissingStreetAddress() {
		String address = "";
		try {
			Assert.assertFalse(OrderValidator.validateAddress(address));
		} catch (InvalidOrderException e) {
			System.err.println(e.getMessage());
		}
	}

}
