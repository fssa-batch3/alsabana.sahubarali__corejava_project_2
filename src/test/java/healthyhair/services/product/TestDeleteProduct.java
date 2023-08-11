package healthyhair.services.product;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import healthyhair.service.exception.ServiceException;
import healthyhair.services.*;

class TestDeleteProduct {

	@Test

	void deleteSuccess() {
		ProductService productService = new ProductService();
		try {
			assertTrue(productService.deleteProduct(6));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test

	void deleteFail() {
		ProductService productService = new ProductService();
		try {
			assertFalse(productService.deleteProduct(524));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

}
