package com.fssa.healthyhair.validation.uservalidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.UserValidator;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

 class TestValidEmail {

	@Test
	void testValidEmail() {
		
		try {

			assertTrue(UserValidator.validateEmail("sabana03@gmail.com"));
			System.err.println("Your email is valid");
		} catch (InvalidUserException e) {
			System.err.println(e.getMessage());
			fail();
		}
	} 

	@Test
	 void testInvalidEmailWithoutAtSymbol() {
		try {

			assertFalse(UserValidator.validateEmail("soffan2906gmail.com"));
			System.err.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidEmailWithoutcom() {
		try {

			assertFalse(UserValidator.validateEmail("soffan2906@"));
			System.err.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.err.println(e.getMessage());
		}
	}

}
