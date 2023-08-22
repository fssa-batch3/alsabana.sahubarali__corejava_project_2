package com.fssa.healthyhair.services;

import java.util.List;

import com.fssa.healthyhair.dao.*;
import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.validation.ProductValidator;
import com.fssa.healthyhair.validation.exception.InvalidProductException;

public class ProductService {

	public boolean createProduct(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.create(product)) {
				System.out.println(product.getProduct_name() + "  Succesfully product created");
				return true;
			} else {
				System.out.println("Creating failed");
				return false;
			}

		} catch (InvalidProductException | DAOException e) {

			throw new ServiceException(e);
		}

	}

	public List<Product> getAllProduct(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			return productDAO.getAllProduct();
		} catch (DAOException | InvalidProductException e) {
			throw new ServiceException(e);
		}

	}

	public boolean updateProduct(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.update(product)) {
				System.out.println(product.getProduct_name() + " Successfully updated");
				return true;
			} else {
				System.out.println("Update failed");
				return false;
			}
		} catch (InvalidProductException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteProduct(int productId) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {

			if (productDAO.delete(productId)) {
				System.out.println("Product with ID " + productId + " successfully deleted.");
				return true;
			} else {
				System.out.println("Deletion failed for product with ID " + productId + ".");
				return false;
			}

		} catch (DAOException e) {

			throw new ServiceException(e.getMessage(), e);
		}
	}

}
