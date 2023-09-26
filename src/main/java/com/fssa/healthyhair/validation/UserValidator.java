package com.fssa.healthyhair.validation;

import java.util.List;
import java.util.regex.*;
import com.fssa.healthyhair.dao.UserDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
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
		

		String regex = "^[A-Za-z]\\w{3,29}$";
		 if (Pattern.matches(regex, name)) {
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
		
	
		
		return true;

	}
	public static void isUserExist(String email) throws InvalidUserException {
		try {
			UserDAO userDAO = new UserDAO();
		User use =  userDAO.findUserByEmail(email);
		if(use.getEmail() ==null) throw new InvalidUserException("Email is not registered");
		} catch (DAOException e) {
			throw new InvalidUserException("Email is not registered");
		}
		
		
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
	    // Define your regex pattern for validating company names
	    String regex = "^[A-Za-z0-9 ]{5,30}$";  // Allows letters, numbers, and spaces
        
	    if (Pattern.matches(regex, companyName)) {
	        return true;
	    } else {
	        throw new InvalidUserException("Invalid Company Name");
	    }
	}

	public static boolean validateAddress(String address) throws InvalidUserException {
		if (address == null) {
			throw new InvalidUserException("Address should not be in null");
		}
       String trimAddress = address.trim();
		String regex = "^[a-zA-Z0-9\\s.,/'#\\-]+(\\s[A-Za-z0-9\\-#]+)?$";

		if(trimAddress.isEmpty() || trimAddress.length()<5) {
			throw new InvalidUserException("Invalid address format");
		}
		if (!Pattern.matches(regex, address)  ) {
			throw new InvalidUserException("Invalid address format");
		} else {
			return true;
		}
	}
	
	public static boolean validateLicenseImageURL(String imageUrl) throws InvalidUserException {
	    String regex = "^(https?|ftp)://.*$";

	    if (Pattern.matches(regex, imageUrl)) {
	        return true;
	    } else {
	        throw new InvalidUserException(
	                "Invalid image URL format. Please provide a valid URL starting with 'http' or 'https'.");
	    }
	}
	
	

}
