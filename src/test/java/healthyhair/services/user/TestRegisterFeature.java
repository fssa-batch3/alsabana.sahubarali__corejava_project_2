package healthyhair.services.user;

import static org.junit.Assert.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import healthyhair.DAO.exception.DAOException;
import healthyhair.DAO.*;
import healthyhair.model.User;
import healthyhair.services.*;

class TestRegisterFeature {

	@Test
	void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("sabin@gmail.com", "sabin", "passWord@786", "buyer", "8015059760");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.printf("  Registered failed", e);

		}

	}

	@Test
	 void testRegistrationFail() {
		UserService userService = new UserService();

		User invalidUser = new User("", "JohnDoe", "Password@123", "buyer", "");

		try {

			assertFalse(userService.registerUser(invalidUser));
			System.out.println("please fill your input");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testUserNull() {
		UserService userservice = new UserService();
		User user1 = null;
		try {
			assertFalse(userservice.registerUser(user1));
			System.out.println("Can not be null");
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}

	}

	@AfterAll
	static void deleteByEmail() {
		UserDAO dao = new UserDAO();

		try {
			dao.deleteUser("sabin321@gmail.com");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}