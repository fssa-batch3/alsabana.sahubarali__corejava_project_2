package com.fssa.healthyhair.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.validation.exception.InvalidProductException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;

public class ProductValidator {

	public static boolean validateProduct(Product product) throws InvalidProductException {

		if (product == null) {
			throw new InvalidProductException("Product details are not valid");
		}

		try {

			return validateProductName(product.getProduct_name()) && validateProductCost(product.getCost())
					&& validateProductImageURL(product.getProduct_img())
					&& validateProductDetail(product.getProduct_detail())
					&& validateProductCategory(product.getCategory());

		} catch (InvalidProductInputException e) {
			throw new InvalidProductException("details are not valid");
		}

	}

	public static boolean validateProductName(String productName) throws InvalidProductInputException {
		boolean match = false;

		String regex = "^[A-Za-z0-9\\s]{10,50}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(productName);
		match = m.matches();
		if (match) {
			System.out.println("The product name is valid.");
		} else {
			throw new InvalidProductInputException("The product name is not valid");
		}
		return match;
	}

	public static boolean validateProductCost(int cost) throws InvalidProductInputException {
		boolean match = false;

		String regex = "^\\d{3,4}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(Integer.toString(cost));
		match = m.matches();
		if (match) {
			System.out.println("The product cost is valid.");
		} else {
			throw new InvalidProductInputException("The product cost should be a 4-digit number.");
		}

		return match;
	}

	public static boolean validateProductImageURL(String imageUrl) throws InvalidProductInputException {
		boolean match = false;

		String regex = "^(https?|ftp)://.*$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(imageUrl);
		match = m.matches();
		if (match) {
			System.out.println("The product image URL is valid.");
		} else {
			throw new InvalidProductInputException("The product image URL is not valid.");
		}

		return match;
	}

	public static boolean validateProductDetail(String productDetail) throws InvalidProductInputException {
		boolean match = false;

		int lengthOfWords = 100;

		if (productDetail != null && productDetail.trim().length() >= lengthOfWords
				&& productDetail.trim().length() <= 400) {
			match = true;
			System.out.println("The product detail is valid.");
		} else {
			throw new InvalidProductInputException("The product detail is not valid.");
		}

		return match;
	}

	public static boolean validateProductCategory(String category) throws InvalidProductInputException {
		if (category != null && !category.isEmpty())
			return true;
		else
			return false;

	}

	public static boolean validateProductId(int productId) throws InvalidProductInputException {
		if (productId > 0)
			return true;
		else
			return false;

	}

}
