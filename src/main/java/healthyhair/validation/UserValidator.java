package healthyhair.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import healthyhair.model.User;
import healthyhair.validation.exception.InvalidUserException;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {
		// User is valid if username is valid and email is valid and password is valid

		if (user != null && validateName(user.getUsername()) && validateEmail(user.getEmail())
				&& validatePassword(user.getPassword()) && ValidateMobileNo(user.getNumber())
				&& validateType(user.getType())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	public static boolean validateUserId(int id) throws InvalidUserException {

		if (id > 0) {
			System.out.println("The id is valid");
		} else {

			throw new InvalidUserException("print some valid id.");
		}

		return id > 0;
	}

	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;
		try {
			String regex = "^[A-Za-z]\\w{3,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The user name is valid.");
			} else {

				throw new InvalidUserException("The user name is not valid");
			}
		} catch (Exception e) {
			System.out.println("user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;
		try {
			String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);
			if (match) {
				System.out.println("Valid password.");
			} else {

				throw new InvalidUserException("Invalid password.");
			}
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}

		return match;
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		if (email == null) {
			return false;
		}
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is Valid");
			} else {

				throw new InvalidUserException("The email address is not valid");
			}
			return isMatch;
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return isMatch;
	}

	public static boolean ValidateMobileNo(String mobileno) throws InvalidUserException {
		boolean isMatch = false;
		if (mobileno == null)
			return false;

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			System.out.println("The mobile number is: Valid");
		} else {
			throw new InvalidUserException("The mobile number is: Invalid");

		}
		return isMatch;

	}

	public static boolean validateType(String type) throws InvalidUserException {

		if (type != null && !type.isBlank())
			return true;
		else
			return false;
	}
}
