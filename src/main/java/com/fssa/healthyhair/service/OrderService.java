package com.fssa.healthyhair.service;

import java.util.List;

import com.fssa.healthyhair.dao.OrderDAO;
import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.OrderValidator;
import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

public class OrderService {
	public static boolean createOrder(Order order) throws ServiceException {

		try {

			OrderValidator.validateOrder(order);
			return OrderDAO.create(order);
		} catch (InvalidProductInputException | InvalidOrderException | DAOException e) {
			throw new ServiceException(e);
		}

	}

	/*
	 * Define the method to retrieve all orders and handle exceptions
	 */
	public List<Order> getAllOrder() throws ServiceException {

		OrderDAO orderDAO = new OrderDAO();// Create an instance of OrderDAO
		try {

			return orderDAO.view(); // Retrieve all orders from the DAO and return the order list

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	/*
	 * Define the method to delete a order by ID and handle exceptions
	 */
	public boolean deleteOrder(int orderId) throws ServiceException {
		try {
			// Check if the order deletion in the DAO was successful and provide feedback
			OrderValidator.validateOrderId(orderId);
			return OrderDAO.delete(orderId);

		} catch (DAOException | InvalidOrderException e) {
			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}

	public List<Order> findOrdersByUserId(int userId) throws ServiceException {
		try {
			return OrderDAO.findOrdersByUserId(userId); // Retrieve orders by userId from the DAO and return the order
														// list
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public static boolean doesOrderExistForProduct(int productId) throws ServiceException {
		try {
			return OrderDAO.findOrderByProductId(productId);
		} catch (DAOException e) {
			throw new ServiceException(
					"Error while checking for the existence of an order for product ID: " + productId, e);
		}
	}

	public static boolean update(String status, int orderId) throws ServiceException {

		try {
			OrderValidator.validateOrderId(orderId);
			// Check if the order update in the DAO was successful and provide feedback

			return OrderDAO.update(status,orderId);

			// Catch exceptions related to invalid products or DAO issues and throw a
			// ServiceException
		} catch (DAOException | InvalidOrderException e) {

			throw new ServiceException(e);
		}
	}
	
	
}
