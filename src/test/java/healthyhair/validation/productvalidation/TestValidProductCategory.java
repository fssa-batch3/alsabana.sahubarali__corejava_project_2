package healthyhair.validation.productvalidation;

import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;

import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductCategory {

	@Test

	void validCategorySuccess() {
		try {
			assertTrue(ProductValidator.validateProductCategory("ayurvedic range"));
			System.out.println("Category is valid");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
			fail();
		}

	}

	@Test

	void validCategoryFail() {
		try {
			assertFalse(ProductValidator.validateProductCategory(""));
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}

}
