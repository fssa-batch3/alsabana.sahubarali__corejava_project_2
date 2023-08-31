package com.fssa.healthyhair.service.product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.ProductService;

class TestUpdateProduct {
	@Test

	void updateProductSuccess() {
		ProductDAO productDAO = new ProductDAO();
		Product product1 = new Product(28, "Hair colour Serum", 299,
				"https://truhairandskin.com/cdn/shop/products/p2_2_be881497-52ff-4fbd-b688-cc89b932deb7.webp?v=1684230007&width=493",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");
 
		try {
			assertTrue(productDAO.update(product1));
		} catch (DAOException e) {
			fail();
		}  

	}

	@Test

	void updateProductFail() {
		ProductDAO productDAO = new ProductDAO();
		Product product1 = new Product(0, null, 0, null, null, null);

		try {
			assertFalse(productDAO.update(product1));
	
		} catch (DAOException e) {
			System.err.println(e.getMessage());
		}

	}
}
