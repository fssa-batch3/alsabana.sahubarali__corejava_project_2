package healthyhair.validation.productvalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductName {
	@Test
	void testValidProductName() {
		try {

			assertTrue(ProductValidator.validateProductName("Ayuvedic shampoo"));
			System.out.println("Product name is valid");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidProductNameStartingWithSpecialCharacter() {
		try {

			assertFalse(ProductValidator.validateProductName("@!Hair colour %^shampoo"));
			System.out.println("Product name shouldn't contains special character");
		} catch (InvalidProductInputException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameTooShort() {
		try {

			assertFalse(ProductValidator.validateProductName("pro"));
			System.out.println("Product name shouldn't be too small ");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidProductNameTooLong() {
		try {
			assertFalse(ProductValidator.validateProductName(
					"Sabannnnnnnnnnnnnnnnnnnnnnnnnna.................................................................................................................................."));
			System.out.println("Product name should not be too long ");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}
}
