package com.fssa.healthyhair.validation.productvalidation;

import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductCategory {

	@Test

	 void validCategorySuccess() {
		try {
			assertTrue(ProductValidator.validateProductCategory("ayurvedic range"));
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
			fail();
		}
  
	}

	@Test

	void validCategoryFail() {
		try {
			assertFalse(ProductValidator.validateProductCategory(""));
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

}
