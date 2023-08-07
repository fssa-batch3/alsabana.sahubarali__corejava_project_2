package healthyhair.services;

import healthyhair.DAO.exception.DAOException;
import healthyhair.model.Product;

import java.util.List;

import healthyhair.DAO.ProductDAO;
import healthyhair.service.exception.ServiceException;
import healthyhair.validation.ProductValidator;
import healthyhair.validation.exception.InvalidProductException;

public class ProductService {

	public boolean createProduct(Product product) throws ServiceException {
		ProductDAO productDAO = new ProductDAO();
		try {
			ProductValidator.validateProduct(product);
			if (productDAO.create(product)) {
				System.out.println(product.getProduct_name()+ "  Succesfully product created");
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



}
