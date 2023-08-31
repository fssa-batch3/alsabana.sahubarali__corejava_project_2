package com.fssa.healthyhair.service;


import java.util.List;

import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductException;

public class ProductService {
	/*
	 * Declare the method to create a new product and handle exceptions
	 */
/**
 * 
 * @param product
 * @return
 * @throws ServiceException
 */
	public boolean createProduct(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();// Create an instance of ProductDAO
		try {
			ProductValidator.validateProduct(product);// Validate the product using ProductValidator
			// Check if the product creation in the DAO was successful
			if (productDAO.create(product)) {
				return true;
			} else {
				System.err.println("Creating failed");
				return false; 
			}
			// Catch exceptions related to invalid products or DAO issues and throw a
			// ServiceException

		} catch (InvalidProductException | DAOException e) {

			throw new ServiceException(e);
		}

	}

	
	/*
	 * Define the method to retrieve all products and handle exceptions
	 */
	public List<Product> getAllProduct(Product product) throws ServiceException {

		ProductDAO productDAO = new ProductDAO();// Create an instance of ProductDAO
		try {
			ProductValidator.validateProduct(product);// Validate the product using ProductValidator

			return productDAO.getAllProduct(); // Retrieve all products from the DAO and return the list

		} catch (DAOException | InvalidProductException e) {

			throw new ServiceException(e);
		}

	}
	public boolean updateProduct(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);// Validate the product using ProductValidator
			// Check if the product update in the DAO was successful and provide feedback
			if (productDAO.update(product)) {
				
				return true;
			} else {
				System.err.println("Update failed");
				return false;
			}

			// Catch exceptions related to invalid products or DAO issues and throw a
			// ServiceException
		} catch (InvalidProductException | DAOException e) {

			throw new ServiceException(e);
		}
	}

	/*
	 * Define the method to delete a product by ID and handle exceptions
	 */
	public boolean deleteProduct(int productId) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			// Check if the product deletion in the DAO was successful and provide feedback
			if (productDAO.delete(productId)) {
				return true;
			} else {
				System.err.println("Deletion failed for product with ID " + productId + ".");
				return false;
			}

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}

}
