package healthyhair.services;

import healthyhair.model.User;

import healthyhair.validation.UserValidator;
import healthyhair.validation.exception.InvalidUserException;
import com.google.protobuf.ServiceException;

import healthyhair.DAO.exception.DAOException;
import healthyhair.DAO.*;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);
			if (userDAO.isEmailAlreadyRegistered(user.getEmail())) {
				throw new DAOException("Email already exists");
			}
			if (userDAO.register(user)) {
				System.out.println(user.getUsername() + "  Succesfully registered");
				return true;
			} else {
				System.out.println("Registration failed");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {

			throw new ServiceException(e.getMessage());
		}

	}

	public boolean loginUser(User user) throws ServiceException {

		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.isLogin(user) && (userDAO.getUserPasswordFromDb().equals(user.getPassword()))) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
		}

	}

}
