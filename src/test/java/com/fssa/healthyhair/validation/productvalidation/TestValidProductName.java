package com.fssa.healthyhair.validation.productvalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductName {
	@Test
	void testValidProductName() {
		try {

			assertTrue(ProductValidator.validateProductName("Ayuvedic shampoo"));
			
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
			fail();
		} 
	} 

	@Test
	void testInvalidProductNameStartingWithSpecialCharacter() {
		try {

			assertFalse(ProductValidator.validateProductName("@!Hair colour %^shampoo"));
			System.err.println("Product name shouldn't contains special character");
		} catch (InvalidProductInputException e) {

			System.err.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameTooShort() {
		try {

			assertFalse(ProductValidator.validateProductName("pro"));
			System.err.println("Product name shouldn't be too small ");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameTooLong() {
		try {
			assertFalse(ProductValidator.validateProductName(
					"Sabannnnnnnnnnnnnnnnnnnnnnnnnna.................................................................................................................................."));
			System.err.println("Product name should not be too long ");
		} catch (InvalidProductInputException e) {
			System.err.println(e.getMessage());
		}
	}
}
