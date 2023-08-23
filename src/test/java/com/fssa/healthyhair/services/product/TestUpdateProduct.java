package com.fssa.healthyhair.services.product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.services.ProductService;

class TestUpdateProduct {
	@Test

	void updateProductSuccess() {
		ProductDAO productDAO = new ProductDAO();
		ProductService productService = new ProductService();
		Product product1 = new Product(8, "Ayurvedicoil", 40,
				"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");
 
		try {
			assertTrue(productDAO.update(product1));
			System.out.println("Successfully updated");
		} catch (DAOException e) {
			fail();
		}

	}

	@Test

	void updateProductFail() {
		ProductDAO productDAO = new ProductDAO();
		ProductService productService = new ProductService();
		Product product1 = new Product(0, null, 0, null, null, null);

		try {
			assertFalse(productDAO.update(product1));
			System.out.println("Successfully updated");
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		}

	}
}
