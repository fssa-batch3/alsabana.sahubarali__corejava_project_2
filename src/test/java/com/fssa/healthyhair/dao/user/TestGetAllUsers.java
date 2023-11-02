package com.fssa.healthyhair.dao.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.UserService;
import com.fssa.healthyhair.service.exception.ServiceException;

class TestGetAllUsers {
	@Test
	void ValidGetSuccess() {

		try {

			List<User> list = UserService.getAllUser();
			assertNotNull(list);

			System.err.println(list.toString());

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

}