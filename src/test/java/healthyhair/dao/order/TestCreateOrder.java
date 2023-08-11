package healthyhair.dao.order;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import healthyhair.model.Order;
import healthyhair.model.Product;
import healthyhair.model.User;
import healthyhair.service.exception.ServiceException;
import healthyhair.services.OrderService;

class TestCreateOrder {

	@Test

	void validOrderSuccess() {

		OrderService orderService = new OrderService();
		User user = new User("sabana31@gmail.com", "mowsabin", "sabin786", "buyer", "801559760",2);
		Product product = new Product("Ayurvedashampoo", 3700,
				"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
				"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
						+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
				"ayurvedic");
		Order order1 = new Order(3, product, 1, user);

		try {

			assertTrue(orderService.createOrder(order1));
			System.out.println("Your Order successfully created");
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}

	}
}
