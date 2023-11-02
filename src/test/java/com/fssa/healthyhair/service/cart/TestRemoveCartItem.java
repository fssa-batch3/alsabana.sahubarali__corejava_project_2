package com.fssa.healthyhair.service.cart;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.service.CartService;
import com.fssa.healthyhair.service.exception.ServiceException;

 class TestRemoveCartItem {
     
	@Test
	 void removeItemSuccess(){
			try {
			assertTrue(CartService.remove(33));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	} 
	@Test
	 void removeItemFail(){
		try {
			assertFalse(CartService.remove(0));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
