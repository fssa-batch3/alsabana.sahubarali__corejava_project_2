package com.fssa.healthyhair.dao.product;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.ProductService;
import com.fssa.healthyhair.service.exception.ServiceException;


class TestGetAllProduct {
	

	@Test
	void ValidGetSuccess() {

		ProductService service = new ProductService();
		try {
			assertTrue(service.createProduct(new Product("Ayurvedic shampoo", 300,
					"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
					"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
							+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
					"ayurvedic")));
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
