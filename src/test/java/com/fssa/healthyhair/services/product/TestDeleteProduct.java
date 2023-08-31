package com.fssa.healthyhair.services.product;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.*;

class TestDeleteProduct {

	@Test

	void deleteProductSuccess() {
		ProductService productService = new ProductService();
		try {
			assertTrue(productService.deleteProduct(30));
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
  
	}

	@Test

	void deleteProductFail() {
		ProductService productService = new ProductService();
		try {
			assertFalse(productService.deleteProduct(524));
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}

	}

}
