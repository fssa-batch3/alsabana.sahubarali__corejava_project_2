package com.fssa.healthyhair.services;

import java.util.List;


import com.fssa.healthyhair.dao.OrderDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
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
	public boolean deleteOrder(int OrderId) throws ServiceException {
		try {
			// Check if the order deletion in the DAO was successful and provide feedback
			if (OrderDAO.delete(OrderId)) {
				
				return true;
			} else {
				System.err.println("Deletion failed for order with ID " + OrderId + ".");
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}

	public static void main(String[] args) {
	    try {
	        // Create an example Order object
	    	Product product = new Product(4,"Ayurvedashampoo", 3700,
					"https://www.gkhair.co.in/cdn/shop/files/Balancing-banner_023150bb-42a3-4452-bbe8-aa23828dfdd1_1600x.png?v=1673589283",
					"A power-packed, leave in scalp serum strengthens hair roots and promotes fast and healthy hair growth.\r\n"
							+ "A vital scalp treatment that helps remove dead skin cells, product build up and give roots the chance to thrive, control hyper production of scalp serum, tackle itchiness and flakiness.",
					"ayurvedic");
	    	User user = new User();
	    	user.setUserId(3);
	        Order order = new Order(product,2,user,"chennai");

	        // Call the createOrder method
	        boolean isSuccess = createOrder(order);

	        if (isSuccess) {
	           
	        } else {
	            System.out.println("Main: Order creation failed");
	        }

	    } catch (ServiceException e) {
	        System.err.println("Main: ServiceException - " + e.getMessage());
	        e.printStackTrace();
	    }
	}

}
