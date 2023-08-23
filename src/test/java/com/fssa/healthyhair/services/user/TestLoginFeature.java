package com.fssa.healthyhair.services.user;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.services.UserService;
import com.google.protobuf.ServiceException;

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
		User user1 = new User("sabin@gmail.com", "sabin", "passWord@786", "buyer", "8015059760");
		try {

			assertTrue(userService.loginUser(user1));
			System.out.println("Succesfully logged in " + user1.getUsername());
		} catch (ServiceException e) {

			System.err.println(e.getMessage());

		}
	}

	@Test

	void loginFailed() {
		UserService userService = new UserService();
		User user2 = new User("alsa@gmail.com", "Password@796");
		try {

			assertFalse(userService.loginUser(user2));
			System.out.println("please check your details");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

}
