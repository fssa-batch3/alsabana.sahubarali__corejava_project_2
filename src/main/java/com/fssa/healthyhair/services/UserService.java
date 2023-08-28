package com.fssa.healthyhair.services;

import com.fssa.healthyhair.dao.UserDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.UserValidator;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);

			if (userDAO.isEmailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("Email already exists");
			}

			if (userDAO.register(user)) {
				return true;
			} else {
				System.err.println("Registered failed");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e);
		}

	}

	public int loginWithEmail(String email, String password) throws ServiceException {
		int id = 0;
		try {
			if (UserValidator.validateEmail(email) && UserValidator.validatePassword(password)) {
				UserDAO userDAO = new UserDAO();
				User user = userDAO.findUserByEmail(email);
				if (user.getPassword().equals(password)) {
					id = user.getUserId();
				} else {
					throw new ServiceException("invalid Password");
				}
			}

		} catch (InvalidUserException | DAOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new ServiceException(e);
		}
		return id;
	}

	public boolean login(String email, String password) throws ServiceException, InvalidUserException {
		boolean status = false;

		if (!UserValidator.validateEmail(email) && !UserValidator.validatePassword(password)) {
			throw new InvalidUserException("Invalid User Credentials");
		}

		try {
			
			UserDAO userDAO = new UserDAO();
			status = userDAO.userExists(email, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
		return status;

	}

}
