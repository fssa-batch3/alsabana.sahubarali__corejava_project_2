package healthyhair.validation.UserValidation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import healthyhair.service.exception.ServiceException;
import healthyhair.validation.UserValidator;
import healthyhair.validation.exception.InvalidUserException;

public class TestValidPassword {

	@Test
	void testValidPassword() {
		UserValidator userValidator = new UserValidator();
		try {

			assertTrue(UserValidator.validatePassword("Password@123"));
			System.out.println("Your password is valid");
		} catch (InvalidUserException e) {

			System.out.println("Your password is not valid");
		}
	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacter() {
		UserValidator userValidator = new UserValidator();
		try {

			assertFalse(UserValidator.validatePassword("Password123"));
			System.out.println("Your password is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordWithoutNumbers() {
		UserValidator userValidator = new UserValidator();
		try {

			assertFalse(UserValidator.validatePassword("Password@"));
			System.out.println("Your password is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordWithoutCapitalLetter() {
		UserValidator userValidator = new UserValidator();
		try {

			assertFalse(UserValidator.validatePassword("password@123"));
			System.out.println("Your password is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordWithoutSmallLetter() {
		UserValidator userValidator = new UserValidator();
		try {

			assertFalse(UserValidator.validatePassword("PASSWORD@123"));
			System.out.println("Your password is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordShorterLength() {
		UserValidator userValidator = new UserValidator();
		try {

			assertFalse(UserValidator.validatePassword("Pa"));
			System.out.println("Your password is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());

		}
	}

}
