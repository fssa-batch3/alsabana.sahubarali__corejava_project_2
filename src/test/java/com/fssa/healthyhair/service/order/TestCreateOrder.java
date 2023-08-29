package com.fssa.healthyhair.service.order;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.OrderService;

class TestCreateOrder {
 
@Test
void testOrderSuccess() {
   

    try {
        User user = new User();
        user.setUserId(3);

        Product product1 = new Product(1, "Ayurvedashampoo", 3700,
                "https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
                "A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
                        + "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
                "ayurvedic");

        Order order = new Order();  // Initialize the Order object
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
	void testOrderFail() {
	   
	    // Create an invalid order (missing required fields)
	    Order invalidOrder = new Order();
	    
	    try {
	        assertFalse(OrderService.createOrder(invalidOrder));
	        System.err.println("Order creation should have failed due to invalid input");
	    } catch (ServiceException e) {
	        // The creation attempt should result in a ServiceException due to invalid input
	        System.err.println("Order creation failed" + e.getMessage());
	    }
	}

}
