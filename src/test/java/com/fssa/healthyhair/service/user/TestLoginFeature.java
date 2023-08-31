package com.fssa.healthyhair.service.user;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.UserService;
import com.fssa.healthyhair.service.exception.ServiceException;


class TestLoginFeature {

	@Test
	void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("sabin320@gmail.com", "sabin", "passWord@786", "buyer", "8015059760");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {

			System.err.println(e.getMessage());

		}

	}

	@Test

	void loginSuccess() {
		UserService userService = new UserService();
//		User user1 = new User("sabin320@gmail.com", "passWord@786");
		try {

			assertEquals(2,userService.loginWithEmail("sabin320@gmail.com", "passWord@786"));
			System.out.println("Succesfully logged in ");
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
    
//	@Test
//
//	void loginFailed() {
//		UserService userService = new UserService();
//		User user2 = new User("alsa@gmail.com", "Password@796");
//		try {
//
//			assertFalse(userService.loginUser(user2));
//		
//		} catch (ServiceException e) {
//			System.err.println(e.getMessage());
//		}
//	}

}
