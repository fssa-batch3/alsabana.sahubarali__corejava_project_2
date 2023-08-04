package healthyhair.validation.UserValidation;

import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;

import healthyhair.validation.UserValidator;
import healthyhair.validation.exception.InvalidUserException;

 class TestValidEmail {

	@Test
	void testValidEmail() {
		UserValidator userValidator = new UserValidator();
		try {

			assertTrue(userValidator.validateEmail("sabana03@gmail.com"));
			System.out.println("Your email is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidEmailWithoutAtSymbol() {
		try {

			assertFalse(UserValidator.validateEmail("soffan2906gmail.com"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidEmailWithoutcom() {
		try {

			assertFalse(UserValidator.validateEmail("soffan2906@"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

}
