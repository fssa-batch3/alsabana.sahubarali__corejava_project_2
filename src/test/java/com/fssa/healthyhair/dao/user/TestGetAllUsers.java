package com.fssa.healthyhair.dao.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.dao.UserDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.services.UserService;

 class TestGetAllUsers {
	@Test 
	void ValidGetSuccess() {
		UserDAO userDAO = new UserDAO();
	     UserService service = new UserService();
		try {
			service.registerUser(new User("mambumigu@gmail.com", "gopikanan", "passWord@786", "buyer", "8018059760"));
			List<User> list = userDAO.allUser();
			assertNotNull(list);
 
			

		} catch (DAOException | ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

}