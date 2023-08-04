package healthyhair.services;

import healthyhair.model.User;

import healthyhair.validation.UserValidator;
import healthyhair.validation.exception.InvalidUserException;

import java.sql.SQLException;

import com.google.protobuf.ServiceException;

import healthyhair.DAO.UserDAO;
import healthyhair.DAO.exception.DAOException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

//		if (user == null) {
//			System.out.println("User cannot be null");
//			return false;
//		}

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
			if (userDAO.login(user)) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getLocalizedMessage());
		}

	}

	public static void main(String[] args) throws ServiceException {
		UserService reg = new UserService();

//		User user1 = new User("sabin@gmail.com","sabin","passWord@786","Buyer");
		User user2 = new User("sabingmail.com", "passWord@786");

//		reg.registerUser(user1);
		reg.loginUser(user2);
	}

}
