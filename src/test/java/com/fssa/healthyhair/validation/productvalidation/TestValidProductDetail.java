package com.fssa.healthyhair.validation.productvalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductDetail {

	@Test

	void validProductDetail() {
		try {
			assertTrue(ProductValidator.validateProductDetail(
					"Hair Care products are those that help to control the properties and behavior of the hair so that it can be maintained in a controlled and desirable manner."));
			
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
			fail();
		}
	}
  
	@Test

	void InvalidProductDetailNull() {
		try {
			assertFalse(ProductValidator.validateProductDetail(""));
			System.err.println("Product Detail isn't valid");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test

	void InvalidProductDetailTooSmall() {
		try {
			assertFalse(ProductValidator.validateProductDetail("prod"));
			System.err.println("Product Detail isn't valid Detail is too small");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

}
