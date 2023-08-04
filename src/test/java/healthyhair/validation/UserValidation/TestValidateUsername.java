package healthyhair.validation.UserValidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import healthyhair.validation.UserValidator;
import healthyhair.validation.exception.InvalidUserException;

public class TestValidateUsername {
	@Test
	public void testValidUsername() {
		try {

			assertTrue(UserValidator.validateName("sabana"));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println("username is not valid");
		}
	}

	@Test
	public void testInvalidUsernameStartingWithNumber() {
		try {

			assertFalse(UserValidator.validateName("1Sabana"));
			System.out.println("username should not start with number");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameStartingWithSpecialCharacter() {
		try {

			assertFalse(UserValidator.validateName("@sabana"));
			System.out.println("username should not contains special character");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameWithSpaces() {
		try {

			assertFalse(UserValidator.validateName("mow sabin"));
			System.out.println("username should not contains spaces ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameTooShort() {
		try {

			assertFalse(UserValidator.validateName("SA"));
			System.out.println("username should not be too small ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testInvalidUsernameTooLong() {
		try {

			assertFalse(UserValidator.validateName("Sabannnnnnnnnnnnnnnnnnnnnnnnnna"));
			System.out.println("username should not be too long ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}