package healthyhair.dao.product;

import healthyhair.DAO.exception.DAOException; 

import healthyhair.model.Product;
import healthyhair.services.*;
import healthyhair.DAO.*;
import healthyhair.service.exception.ServiceException;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.Test;



 class TestGetAllProduct {

	@Test
	void ValidGetSuccess() {
		ProductDAO productDAO = new ProductDAO();
		ProductService service = new ProductService();
		try {
			assertTrue(service.createProduct(new Product("Ayurvedic shampoo", 300,
					"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
					"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
							+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
					"ayurvedic")));
			List<Product> list = productDAO.getAllProduct();
			assertNotNull(list);
			  
			for(Product p:list) {
				System.out.println(p.toString());
			}
			
			System.out.println("Successfully Viewed");

		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
		}

	}

}
