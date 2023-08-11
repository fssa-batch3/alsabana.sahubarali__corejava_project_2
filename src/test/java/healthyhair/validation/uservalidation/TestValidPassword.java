package healthyhair.validation.uservalidation;

import static org.junit.Assert.fail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import healthyhair.validation.UserValidator;
import healthyhair.validation.exception.InvalidUserException;

class TestValidPassword {

	@Test
	void testValidPassword() {

		try {

			assertTrue(UserValidator.validatePassword("Password@123"));
			System.out.println("Your password is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacter() {

		try {

			assertFalse(UserValidator.validatePassword("Password123"));
			System.out.println("Your password is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordWithoutNumbers() {

		try {

			assertFalse(UserValidator.validatePassword("Password@"));
			System.out.println("Your password is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordWithoutCapitalLetter() {

		try {

			assertFalse(UserValidator.validatePassword("password@123"));
			System.out.println("Your password is not valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordWithoutSmallLetter() {

		try {

			assertFalse(UserValidator.validatePassword("PASSWORD@123"));
			System.out.println("Your password is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidPasswordShorterLength() {

		try {

			assertFalse(UserValidator.validatePassword("Pa"));
			System.out.println("Your password is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());

		}
	}

}
