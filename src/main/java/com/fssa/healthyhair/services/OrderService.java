package com.fssa.healthyhair.services;

import com.fssa.healthyhair.dao.OrderDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.OrderValidator;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

public class OrderService {
	public boolean createOrder(Order order) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		
		try {
			OrderValidator.validateOrder(order);
			if (orderDAO.create(order)) {
				System.out.println("Your order successfully created");
				return true;
			} else {
				System.out.println("Creating failed");
				return false;
			}

		} catch (InvalidProductInputException e) {

			System.out.println(e.getMessage());
		}

		catch (InvalidOrderException | DAOException e) {

			throw new ServiceException(e);
		}
		return false;
 
	}


}
