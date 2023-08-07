package healthyhair.validation.productvalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductException;

class TestValidProductName {
	@Test
	void testValidProductName() {
		try {

			assertTrue(ProductValidator.validateProductName("Ayuvedic shampoo"));
			System.out.println("Product name is valid");
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameStartingWithSpecialCharacter() {
		try {

			assertFalse(ProductValidator.validateProductName("@!Hair colour %^shampoo"));
			System.out.println("Product name shouldn't contains special character");
		} catch (InvalidProductException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameTooShort() {
		try {

			assertFalse(ProductValidator.validateProductName("pro"));
			System.out.println("Product name shouldn't be too small ");
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameTooLong() {
		try {
			assertFalse(ProductValidator.validateProductName(
					"Sabannnnnnnnnnnnnnnnnnnnnnnnnna.................................................................................................................................."));
			System.out.println("Product name should not be too long ");
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}
	}
}
