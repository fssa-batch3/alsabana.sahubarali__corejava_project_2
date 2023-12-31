package com.fssa.healthyhair.validation;

import java.util.List;
import java.util.regex.Pattern;

import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.validation.exception.InvalidProductException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

public class ProductValidator {

	public static boolean validateProduct(Product product) throws InvalidProductException {
		// Check if the product object is null
		if (product == null) {
			throw new InvalidProductException("Product details are not valid");
		}

		try {
			// Validate various product details
			return validateProductName(product.getProductName()) && validateProductCost(product.getCost())
					&& validateProductImageURL(product.getProductImg())
					&& validateProductDetail(product.getProductDetail())
					&& validateProductCategory(product.getCategory());
		} catch (InvalidProductInputException e) {
			throw new InvalidProductException(e.getMessage());
		}
	}

	public static void validateGetAllProducts(List<Product> products) throws InvalidProductException {

		if (products == null || products.isEmpty())
			throw new InvalidProductException("There is no product");

	}

	public static boolean validateProductName(String productName) throws InvalidProductInputException {
		// Regular expression to validate product name format

		String regex = "^[A-Za-z0-9\\s]{10,50}$";
		  if (Pattern.matches(regex, productName)) {
		        return true;
		    } else {
		        throw new InvalidProductInputException(
		                "Invalid product name format. The product name should be alphanumeric and between 10 to 50 characters.");
		    }
	}

	public static boolean validateProductCost(int cost) throws InvalidProductInputException {
//		cost
		 String costString = String.valueOf(cost);

		    if (costString.matches("^\\d{3,4}$")) {
		        return true;
		    } else {
		        throw new InvalidProductInputException(
		                "Invalid product cost format. The product cost should be a 3 or 4-digit number.");
		    }
	}

	public static boolean validateProductImageURL(String imageUrl) throws InvalidProductInputException {
		String regex = "^(https?|ftp)://.*$";

		if (Pattern.matches(regex, imageUrl)) {
			return true;
		} else {
			throw new InvalidProductInputException(
					"Invalid image URL format. Please provide a valid URL starting with 'http' or 'https'.");
		}
	}

	public static boolean validateProductDetail(String productDetail) throws InvalidProductInputException {
		int minLength = 100;// Set the minimum length of product details
		int maxLength = 400;// Set the maximum length of product details

		// Handle the case where product details are empty or null
		if (productDetail != null && !productDetail.isEmpty() && productDetail.trim().length() >= minLength
				&& productDetail.trim().length() <= maxLength) {
			return true;
		} else {
			// Throw exception with a descriptive error message
			throw new InvalidProductInputException(
					"Invalid product detail length. The product detail should be between " + minLength + " to "
							+ maxLength + " characters.");
		}
	}

	public static boolean validateProductCategory(String category) throws InvalidProductInputException {
		if (category != null && !category.isEmpty()) {
			return true;
		} else {
			// Throw exception with a descriptive error message
			throw new InvalidProductInputException("Invalid product category. Please provide a valid category.");
		}
	}

	public static boolean validateProductId(int productId) throws InvalidProductInputException {
		if (productId > 0) {
			return true;
		} else {
			// Throw exception with a descriptive error message
			throw new InvalidProductInputException("Invalid product ID. Product ID should be a positive integer.");
		}
	}
}
