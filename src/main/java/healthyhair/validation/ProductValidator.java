package healthyhair.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import healthyhair.model.Product;
import healthyhair.validation.exception.InvalidProductException;

public class ProductValidator {

	public static boolean validateProduct(Product product) throws InvalidProductException {
		if (product != null && validateProductName(product.getProduct_name()) && validateProductCost(product.getCost())
				&& validateProductImageURL(product.getProduct_img())
				&& validateProductDetail(product.getProduct_detail())) {
			System.out.println("All details are valid");
			return true;
		} else {
			throw new InvalidProductException("Product details are not valid");
		}
	}

	public static boolean validateProductName(String productName) throws InvalidProductException {
		boolean match = false;
		try {
			String regex = "^[A-Za-z0-9\\s]{10,50}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(productName);
			match = m.matches();
			if (match) {
				System.out.println("The product name is valid.");
			} else {
				throw new InvalidProductException("The product name is not valid");
			}
		} catch (Exception e) {
			System.out.println("Product name is not valid");
		}
		return match;
	}

	public static boolean validateProductCost(int cost) throws InvalidProductException {
		boolean match = false;
		try {
			String regex = "^\\d{3,4}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(Integer.toString(cost));
			match = m.matches();
			if (match) {
				System.out.println("The product cost is valid.");
			} else {
				throw new InvalidProductException("The product cost should be a 4-digit number.");
			}
		} catch (Exception e) {
			System.out.println("Product cost is not valid");
		}
		return match;
	}

	public static boolean validateProductImageURL(String imageUrl) throws InvalidProductException {
		boolean match = false;
		try {
			String regex = "^(https?|ftp)://.*$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(imageUrl);
			match = m.matches();
			if (match) {
				System.out.println("The product image URL is valid.");
			} else {
				throw new InvalidProductException("The product image URL is not valid.");
			}
		} catch (Exception e) {
			System.out.println("Product image URL is not valid.");
		}
		return match;
	}

	public static boolean validateProductDetail(String productDetail) throws InvalidProductException {
		boolean match = false;
		try {

			int lengthOfWords = 100;

			if (productDetail != null && productDetail.trim().length() >= lengthOfWords
					&& productDetail.trim().length() <= 400) {
				match = true;
				System.out.println("The product detail is valid.");
			} else {
				throw new InvalidProductException("The product detail is not valid.");
			}
		} catch (Exception e) {
			System.out.println("Product detail is not valid.");
		}
		return match;
	}

}
