package healthyhair.services.user;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.google.protobuf.ServiceException;

import healthyhair.model.User;
import healthyhair.services.UserService;

public class TestLoginFeature {
	
	@Test
	public void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("sabin@gmail.com", "sabin", "passWord@786", "buyer", "8015059760");

		try {
			assertTrue(userservice.registerUser(user1));
			System.out.println("Successfully registered " + user1.getUsername());
		} catch (ServiceException e) {
			System.out.println("Registered failed");

		}

	}

	@Test

	public void loginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("sabin@gmail.com", "sabin", "passWord@786", "buyer", "8015059760");
		try {

			assertTrue(userService.loginUser(user1));
			System.out.println("Succesfully logged in " + user1.getUsername());
		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test

	public void loginFailed() {
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
