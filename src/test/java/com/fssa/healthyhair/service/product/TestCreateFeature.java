package com.fssa.healthyhair.service.product;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.ProductService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestCreateFeature {
	/*
	 * Define a test method for creating a product successfully
	 */
	@Test
	void testCreateProductSuccess() {
		// Create an instance of ProductService to test
		ProductService productservice = new ProductService();
		// Create a Product object for testing

		String productName = "Ayurvedic shampoo";

		int cost = 3200;

		String imageURL = "https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283";

		String detail = "A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.";

		String category = "ayurvedic range";

		User user = new User();
		user.setUserId(87);

		Product product1 = new Product(productName, cost, imageURL, detail, category, user);

		try {
			// Use an assertion to check if the product creation is successful
			assertTrue(productservice.createProduct(product1));

		} catch (ServiceException e) {
			// Catch and print any ServiceException that occurs
			e.printStackTrace();
			fail();
		}

	}

	/*
	 * Define a test method for failing to create a product
	 */

	@Test

	void testCreateProductFail() {
		// Create an instance of ProductService for testing
		ProductService productservice = new ProductService();
		// Create a Product object that you expect will fail the validation
		Product product2 = new Product("  shampoo", 300, "",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"");
		try {
			// Use an assertion to check if the product creation fails as expected
			assertFalse(productservice.createProduct(product2));
			fail();
			System.out.println("Creating product failed");
		} catch (ServiceException e) {
			// Catch and print any ServiceException that occurs
			System.out.println(e.getMessage());
		}

	}

}
