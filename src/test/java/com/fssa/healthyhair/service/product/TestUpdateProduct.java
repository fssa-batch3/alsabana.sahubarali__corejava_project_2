package com.fssa.healthyhair.service.product;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.ProductService;

class TestUpdateProduct {
	@Test

	void updateProductSuccess() {
		ProductDAO productDAO = new ProductDAO();
		String productName = "Ayurvedic conditioner";

		int cost = 3200;

		String imageURL = "https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283";

		String detail = "A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.";

		String category = "samples";

		Product product1 = new Product(72, productName, cost, imageURL, detail, category);

		try {
			assertTrue(productDAO.update(product1));
		} catch (DAOException e) {

			fail();
			e.printStackTrace();
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
