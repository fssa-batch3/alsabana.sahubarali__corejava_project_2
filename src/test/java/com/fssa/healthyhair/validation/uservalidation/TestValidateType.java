package com.fssa.healthyhair.validation.uservalidation;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.validation.UserValidator;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

class TestValidateType {
	@Test

	void validTypeSuccess() {
		try {
			assertTrue(UserValidator.validateType("seller"));
			System.out.println("Type is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
 
	}

	@Test

	void validTypeFail() {
		try {
			assertFalse(UserValidator.validateType(""));

		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

}
