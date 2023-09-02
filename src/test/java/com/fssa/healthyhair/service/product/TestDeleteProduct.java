package com.fssa.healthyhair.service.product;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.*;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestDeleteProduct {

	@Test

	void deleteProductSuccess() {
		ProductService productService = new ProductService();
		try {
			assertTrue(productService.deleteProduct(46));
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			fail();
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
