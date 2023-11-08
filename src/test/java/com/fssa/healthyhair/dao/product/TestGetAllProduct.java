package com.fssa.healthyhair.dao.product;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.ProductService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestGetAllProduct {

	@Test
	void ValidGetSuccess() {

		try {

			List<Product> list = ProductService.getAllProduct();
			assertNotNull(list);

			for (Product p : list) {
				System.err.println(p.toString());
			}

		} catch (ServiceException e) {
			fail();
		}
 
	} 

}
