package com.fssa.healthyhair.dao.order;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.OrderDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.OrderService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestGetAllOrders {
	@Test
	void testOrderSuccess() {
	    try {
	        User user = new User();
	        user.setUserId(3);

	        Product product1 = new Product(64, "Ayurvedashampoo", 3700,
	                "https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
	                "A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
	                        + "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
	                "ayurvedic");

	        Order order = new Order(); 
	        order.setOrderedUser(user);
	        order.setQuantity(2);
	        order.setAddress("Chennai");
	        order.setOrderedProduct(product1);

	        assertTrue(OrderService.createOrder(order));
	        System.out.println("Successfully your order created");
	    } catch (ServiceException e) {
	        fail();
	    }
	}
	
	
	@Test 
	void ValidGetOrderSuccess() {
		OrderDAO orderDAO = new OrderDAO();
		OrderService service = new OrderService();
		try {
			assertTrue(OrderService.createOrder(new Order()));
			List<Order> orderlist = orderDAO.view();
			assertNotNull(orderlist);
 
			for (Order p : orderlist) {
				System.out.println(p.toString());
			} 

			System.out.println("Successfully Viewed");

		} catch (DAOException | ServiceException e) {
			fail();
		}

	}

	@Test
	void testGetOrderFail() {
		OrderService service = new OrderService();
		try {
			List<Order> list =service.getAllOrder(null);
			assertNotNull(list);

		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
} 
