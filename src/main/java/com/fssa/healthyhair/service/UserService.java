package com.fssa.healthyhair.service;

import java.security.NoSuchAlgorithmException;

import java.util.List;

import com.fssa.healthyhair.dao.UserDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.util.PasswordUtil;
import com.fssa.healthyhair.validation.UserValidator;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);
			
			 byte[] salt = PasswordUtil.getSalt();
			 String saltedString = PasswordUtil.byteArrayToHexString(salt);
		     user.setSalt(saltedString);
		     String hashedPassword = PasswordUtil.getSecurePassword(user.getPassword(), salt);
		     user.setPassword(hashedPassword);
			if (userDAO.isEmailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("Email already exists");
			}

			if (userDAO.register(user)) {
				return true;
			} else {
				System.err.println("Registered failed");
				return false;
			}

		} catch (DAOException | InvalidUserException | NoSuchAlgorithmException e) {

			throw new ServiceException(e.getMessage());
		}

	}

	public int loginWithEmail(String email, String password) throws ServiceException {
		int id = 0;
		try {
			UserDAO dao = new UserDAO();
			if (UserValidator.validateEmail(email) && UserValidator.validatePassword(password)) {
				UserValidator.isUserExist(email);
				User user = dao.findUserByEmail(email);
				 byte[] salt = PasswordUtil.hexStringToByteArray(user.getSalt());
				 String saltedPassword = PasswordUtil.getSecurePassword(password, salt);
				if (saltedPassword.equals(user.getPassword())) {
					id = user.getUserId();
				} else {
					throw new ServiceException("Invalid Password");
				}
			}

		} catch (InvalidUserException | DAOException e) {

			System.err.println(e.getMessage());
			throw new ServiceException(e.getMessage());
		}
		return id;
	}

	public static boolean updateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateName(user.getUsername());
			UserValidator.validateMobileNo(user.getNumber());
			UserValidator.validateAddress(user.getCompanyAddress());
			UserValidator.validateEmail(user.getEmail());
      		UserValidator.validateCompanyName(user.getCompanyName());
			UserValidator.validateLicenseImageURL(user.getCompanylicense());
			

			// Validate the user using UserValidator
			// Check if the user update in the DAO was successful and provide feedback
			return userDAO.update(user);

			// Catch exceptions related to invalid user or DAO issues and throw a
			// ServiceException
		} catch (InvalidUserException | DAOException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	public static boolean updateBuyer(User user) throws ServiceException {

		try {
			UserValidator.validateName(user.getUsername());
			UserValidator.validateMobileNo(user.getNumber());
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validateLicenseImageURL(user.getProfileUrl());
			// Validate the user using UserValidator
			// Check if the user update in the DAO was successful and provide feedback
			return UserDAO.updateBuyer(user);

			// Catch exceptions related to invalid user or DAO issues and throw a
			// ServiceException
		} catch (InvalidUserException | DAOException e) {

			throw new ServiceException(e.getMessage());
		}
	}

	/*
	 * Define the method to delete a user by ID and handle exceptions
	 */
	public boolean deleteUser(int userId) throws ServiceException {

		try {
			// Check if the user deletion in the DAO was successful and provide feedback
			return UserDAO.deleteUser(userId);

		} catch (DAOException e) {

			throw new ServiceException(e);

			// Catch exceptions related to DAO issues and throw a
			// ServiceException
		}

	}

	public static User findingUserByEmail(String email) throws ServiceException {
		try {
			// Call the DAO method to retrieve the user by email

			User user = new UserDAO().findUserByEmail(email);

			if (user == null)
				throw new ServiceException("user object is null");

			return user;
		} catch (DAOException e) {
			// You can handle or throw the exception as needed
			throw new ServiceException(e.getMessage());
		}
	}

	public static List<User> getAllUser() throws ServiceException {

		UserDAO userDAO = new UserDAO();// Create an instance of ProductDAO
		try {

			List<User> user = userDAO.allUser();
			UserValidator.validateGetAllUser(user);

			return user;

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}

	}

}
