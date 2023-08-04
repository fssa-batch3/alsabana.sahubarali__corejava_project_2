package healthyhair.services.product;

import org.junit.jupiter.api.Test;


import healthyhair.DAO.exception.DAOException;
import healthyhair.model.Product;

import healthyhair.DAO.*;

 class TestUpdateProduct {
	@Test

	 void updateTask() {
		ProductDAO productDAO = new ProductDAO();
		Product product1 = new Product("Ayurvedic shampoo", 300,
				"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");

		try {
			product1.getProduct_id(10);
			productDAO.update(product1);
			System.out.println("Successfully updated");
		} catch (DAOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
