package com.fssa.healthyhair.validation.uservalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.UserValidator;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

class TestValidateUsername {
	@Test
	void testValidUsername() {
		try {

			assertTrue(UserValidator.validateName("sabana"));
			System.out.println("username is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}  

	@Test
	void testInvalidUsernameStartingWithNumber() {
		try {

			assertFalse(UserValidator.validateName("1Sabana"));
			System.out.println("username should not start with number");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidUsernameStartingWithSpecialCharacter() {
		try {

			assertFalse(UserValidator.validateName("@sabana"));
			System.out.println("username should not contains special character");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidUsernameWithSpaces() {
		try {

			assertFalse(UserValidator.validateName("mow sabin"));
			System.out.println("username should not contains spaces ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidUsernameTooShort() {
		try {

			assertFalse(UserValidator.validateName("SA"));
			System.out.println("username should not be too small ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidUsernameTooLong() {
		try {

			assertFalse(UserValidator.validateName("Sabannnnnnnnnnnnnnnnnnnnnnnnnna"));
			System.out.println("username should not be too long ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}