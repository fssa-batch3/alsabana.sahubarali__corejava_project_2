package healthyhair.validation.productvalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductInputException;

class TestValidProductCost {

	@Test

	void validProductNameCost() {
		try {
			assertTrue(ProductValidator.validateProductCost(480));
			System.out.println("Product cost is valid");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test

	void validProductNameCostTooLong() {
		try {
			assertFalse(ProductValidator.validateProductCost(480097));
			System.out.println("Product cost isn't valid It is too costly");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test

	void validProductNameCostContainsLetter() {
		try {
			assertFalse(ProductValidator.validateProductCost(0000));
			System.out.println("Product cost should not be zero");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test

	void validProductNameCostTooSmall() {
		try {
			assertFalse(ProductValidator.validateProductCost(22));
			System.out.println("Product cost should not be two digit");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test

	void validProductNameCostToooSmall() {
		try {
			assertFalse(ProductValidator.validateProductCost(9));
			System.out.println("Product cost should not be one digit");
		} catch (InvalidProductInputException e) {
			System.out.println(e.getMessage());
		}
	}

}