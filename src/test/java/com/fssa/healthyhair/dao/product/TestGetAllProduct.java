package com.fssa.healthyhair.dao.product;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.ProductService;

class TestGetAllProduct {
	final ProductDAO productDAO = new ProductDAO();

	@Test
	void ValidGetSuccess() {

		ProductService service = new ProductService();
		try {
			assertTrue(service.createProduct(new Product("Ayurvedic shampoo", 300,
					"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
					"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
							+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
					"ayurvedic")));
			List<Product> list = productDAO.getAllProduct();
			assertNotNull(list);

			for (Product p : list) {
				System.out.println(p.toString());
			}

			System.out.println("Successfully Viewed");

		} catch (DAOException | ServiceException e) {
			fail();
		}

	}

	@Test
	void testGetFail() {
		ProductService service = new ProductService();

		try {

			List<Product> list = service.getAllProduct(null);
			assertNotNull(list);
            fail();
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
