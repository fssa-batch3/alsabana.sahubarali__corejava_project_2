package healthyhair.validation.ProductValidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductException;

class TestValidProductCategory {

	@Test

	void validCategorySuccess() {
		try {
			assertTrue(ProductValidator.validateProductCategory("ayurvedic range"));
			System.out.println("Category is valid");
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test

	void validCategoryFail() {
		try {
			assertFalse(ProductValidator.validateProductCategory(""));
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}
	}

}
