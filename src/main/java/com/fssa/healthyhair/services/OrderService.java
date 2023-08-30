package com.fssa.healthyhair.services;

import java.util.List;

import com.fssa.healthyhair.dao.OrderDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.OrderValidator;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

public class OrderService {
	public static boolean createOrder(Order order) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();

		try {
			OrderValidator.validateOrder(order);
			if (orderDAO.create(order)) {
			
				return true;
			} else {
				System.err.println("Creating failed");
				return false;
			}

		}catch (InvalidProductInputException|InvalidOrderException | DAOException e) {

			throw new ServiceException(e);
		}

	}

	/*
	 * Define the method to retrieve all orders and handle exceptions
	 */
	public List<Order> getAllOrder(Order order) throws ServiceException {

		OrderDAO orderDAO = new OrderDAO();// Create an instance of OrderDAO
		try {
			OrderValidator.validateOrder(order);// Validate the order using ProductValidator

			return orderDAO.view(); // Retrieve all orders from the DAO and return the order list

		} catch (DAOException | InvalidOrderException | InvalidProductInputException e) {
			throw new ServiceException(e);
		}

	}
	
	/*
	 * Define the method to delete a order by ID and handle exceptions
	 */
	public boolean deleteOrder(int orderId) throws ServiceException {
		try {
			// Check if the order deletion in the DAO was successful and provide feedback
			if (OrderDAO.delete(orderId)) {
				
				return true;
			} else {
				System.err.println("deleting failed");
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}

	

}
