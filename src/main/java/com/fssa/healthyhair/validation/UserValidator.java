package com.fssa.healthyhair.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.healthyhair.dao.UserDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {
		return user != null && validateName(user.getUsername()) && validateEmail(user.getEmail())
				&& validatePassword(user.getPassword()) && validateMobileNo(user.getNumber())
				&& validateType(user.getType());

	}

	public static boolean validateUserId(int id) throws InvalidUserException {
		if (id > 0)
			return true;
		else
			throw new InvalidUserException("Invalid User Id");
	}
	public static void validateGetAllUser(List<User> user) throws InvalidUserException {

		if (user == null || user.isEmpty())
			throw new InvalidUserException("There is no product");

	}
	public static boolean validateName(String name) throws InvalidUserException {
		boolean match = false;

		String regex = "^[A-Za-z]\\w{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Username");
		}

	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		boolean match = false;

		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(patternString, password);
		if (match) {
			return true;
		} else {

			throw new InvalidUserException("Invalid password.");
		}

	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		boolean isMatch = false;
		
		if (email == null) {
			return false;
		}
		String regex = "^[^@]+@[^.]+\\..+$";
		isMatch = Pattern.matches(regex, email);
		if (!isMatch) {
			throw new InvalidUserException("Invalid Email");
		}
		
		try {
			UserDAO userDAO = new UserDAO();
			@SuppressWarnings("unused")
			User user = userDAO.findUserByEmail(email);
		} catch (DAOException e) {
			
			throw new InvalidUserException("Email is not registered");
		}
		
		return true;

	}

	public static boolean validateMobileNo(String mobileno) throws InvalidUserException {
		boolean isMatch = false;
		if (mobileno == null)
			return false;

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, mobileno);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The mobile number is Invalid");

		}

	}

	public static boolean validateType(String type) throws InvalidUserException {
		if (!type.isBlank())
			return true;
		else
			throw new InvalidUserException("Invalid category");

	}
	
	public static boolean validateCompanyName(String companyName) throws InvalidUserException {
	    boolean match = false;

	    // Define your regex pattern for validating company names
	    String regex = "^[A-Za-z]\\w{3,29}$";
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(companyName);
	    match = m.matches();
	    
	    if (match) {
	        return true;
	    } else {
	        throw new InvalidUserException("Invalid Company Name");
	    }
	}

	public static boolean validateCompanyAddress(String companyAddress) throws InvalidUserException {
	    boolean match = false;

	    // Define your regex pattern for validating company addresses
	    String regex = "^[A-Za-z]\\w{3,100}$"; 
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(companyAddress);
	    match = m.matches();
	    
	    if (match) {
	        return true;
	    } else {
	        throw new InvalidUserException("Invalid Company Address");
	    }
	}
	
	public static boolean validateLicenseImageURL(String imageUrl) throws InvalidUserException {
		String regex = "^(https?|ftp)://.*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(imageUrl);
		boolean match = m.matches();

		if (match) {
			return true;
		} else {
			// Throw exception with a descriptive error message
			throw new InvalidUserException(
					"Invalid product image URL format. Please provide a valid URL starting with 'http' or 'https'.");
		}
	}
	
	

}
