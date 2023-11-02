package com.fssa.healthyhair.service;

import java.util.List;


import com.fssa.healthyhair.dao.ProductDAO;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductException;

public class ProductService {

	/**
	 * Creates a new product and inserts it into the database, while handling
	 * validation and exceptions.
	 *
	 * @param product The Product object containing product information to be
	 *                created.
	 * @return true if the product creation is successful, false otherwise.
	 * @throws ServiceException If there's an error during the product creation
	 *                          process.
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

	/**
	 * Retrieves a list of all products from the database, handling validation and
	 * exceptions.
	 *
	 * @return A list of Product objects representing all products in the database.
	 * @throws ServiceException If there's an error while retrieving the product
	 *                          list.
	 */
	public static List<Product> getAllProduct() throws ServiceException {

		ProductDAO productDAO = new ProductDAO();// Create an instance of ProductDAO
		try {

			List<Product> products = productDAO.getAllProducts();
			ProductValidator.validateGetAllProducts(products);

			return products;

		} catch (DAOException | InvalidProductException e) {

			throw new ServiceException(e);
		}

	}

	/**
	 * Updates product information in the database, handling validation and
	 * exceptions.
	 *
	 * @param product The Product object containing updated product information.
	 * @return true if the update is successful, false otherwise.
	 * @throws ServiceException If there's an error during the product update
	 *                          process.
	 */
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

	/**
	 * Deletes a product from the database based on its ID, handling exceptions.
	 *
	 * @param productId The ID of the product to be deleted.
	 * @return true if the product is successfully deleted, false otherwise.
	 * @throws ServiceException If there's an error during the product deletion
	 *                          process.
	 */
	public boolean deleteProduct(int productId) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			// Check if the product deletion in the DAO was successful and provide feedback
			return productDAO.delete(productId);

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);// Catch exceptions related to DAO issues and throw a
															// ServiceException
		}
	}

	/**
	 * Retrieves a product by its ID from the database, handling exceptions.
	 *
	 * @param productId The ID of the product to retrieve.
	 * @return The Product object if found, or null if not found.
	 * @throws ServiceException If there's an error during the retrieval process.
	 */
	public static Product findProductById(int productId) throws ServiceException {
		Product products;
		try {
			// Call the DAO to retrieve the product by ID.
			products = ProductDAO.findProductById(productId);

		} catch (DAOException e) {
			// Handle any exceptions or rethrow them as ServiceException if necessary.
			throw new ServiceException("Failed to retrieve product by ID", e);
		}
		return products;
	}

}
