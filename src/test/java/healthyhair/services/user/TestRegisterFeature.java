package healthyhair.services.user;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import healthyhair.DAO.exception.DAOException;
import healthyhair.model.User;
import healthyhair.services.*;
import healthyhair.DAO.*;

public class TestRegisterFeature {

	@Test
	public void testRegistrationSuccess() {

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
	public void testRegistrationFail() {
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
	public void testUserNull() {
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