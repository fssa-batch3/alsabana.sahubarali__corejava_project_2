package com.fssa.healthyhair.validation.productvalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductCost {

	@Test

	void validProductNameCost() {
		try {
			assertTrue(ProductValidator.validateProductCost(480));
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
			fail();
		}
	}
 
	@Test

	void validProductNameCostTooLong() {
		try {
			assertFalse(ProductValidator.validateProductCost(480097));
			System.err.println("Product cost isn't valid It is too costly");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test

	void validProductNameCostContainsLetter() {
		try {
			assertFalse(ProductValidator.validateProductCost(0000));
			System.err.println("Product cost should not be zero");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test

	void validProductNameCostTooSmall() {
		try {
			assertFalse(ProductValidator.validateProductCost(22));
			System.err.println("Product cost should not be two digit");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test

	void validProductNameCostToooSmall() {
		try {
			assertFalse(ProductValidator.validateProductCost(9));
			System.err.println("Product cost should not be one digit");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

}
