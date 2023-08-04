package healthyhair.validation.ProductValidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductException;

public class TestValidProductImage {

	@Test

	void ValidProductImage() {
		try {
			assertTrue(ProductValidator.validateProductImageURL(
					"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			System.out.println("Image URL is Valid");
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test

	void InValidProductImage() {
		try {
			assertFalse(ProductValidator.validateProductImageURL(
					"lll://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			System.out.println("Image URL isn't Valid");
		} catch (InvalidProductException e) {
			System.out.println(e.getMessage());
		}

	}

}
