package com.fssa.healthyhair.services.product;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.ProductService;

class TestCreateFeature {
	@Test
	void testCreateProductSuccess() {

		ProductService productservice = new ProductService();
		Product product1 = new Product("Ayurvedashampoo", 3700,
				"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");
 
	 	try {

			assertTrue(productservice.createProduct(product1));
			System.out.println("Your product successfully created");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
 
	void testCreateProductFail() {

		ProductService productservice = new ProductService();
		Product product2 = new Product("  shampoo", 300, "",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"");
		try {
			assertFalse(productservice.createProduct(product2));
			System.out.println("Creating product failed");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}

	}

}
