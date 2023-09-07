package com.fssa.healthyhair.service.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.UserService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestRegisterFeature {

	@Test
	void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("sabin0302@gmail.com", "sabin", "passWord@786", "buyer", "8015059760");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}

	}

	@Test
	void testRegistrationFail() {
		UserService userService = new UserService();

		User invalidUser = new User("", "JohnDoe", "Password@123", "buyer", "");

		try {

			assertFalse(userService.registerUser(invalidUser));
			System.err.println("please fill your input");
			fail();
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testUserNull() {
		UserService userservice = new UserService();
		User user1 = null;
		try {
			assertFalse(userservice.registerUser(user1));
			System.err.println("Can not be null");
			fail();
		} catch (ServiceException e) {
			System.err.println(e.getMessage());

		}

	}

}