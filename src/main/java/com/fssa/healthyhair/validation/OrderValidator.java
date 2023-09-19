package com.fssa.healthyhair.validation;

import java.util.regex.Pattern;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class OrderValidator {

	public static boolean validateOrder(Order order) throws InvalidOrderException, InvalidProductInputException {
		try {
			if (validateQuantity(order.getQuantity()) && validateAddress(order.getAddress())
					&& UserValidator.validateUserId(order.getOrderedUser().getUserId())
					&& ProductValidator.validateProductId(order.getOrderedProduct().getProductId())
					&& validateMobileNo(order.getNumber())) {
				return true;
			}
		} catch (InvalidOrderException | InvalidUserException e) {

			throw new InvalidOrderException(e.getMessage());
		}
		return false;
	}

	public static boolean validateQuantity(int quantity) throws InvalidOrderException {
		boolean check = false;
		try {
			if (quantity > 0)
				check = true;

		} catch (Exception e) {
			throw new InvalidOrderException("Quantity is not not valid");
		}
		return check;

	}

	public static boolean validateAddress(String address) throws InvalidOrderException {
		if (!address.isEmpty())
			return true;
		else
			throw new InvalidOrderException("Address is not valid");

	}

	public static boolean validateOrderId(int id) throws InvalidOrderException {
		if (id > 0) {
			return true;
		} else {
			throw new InvalidOrderException("Order Id is invalid");
		}

	}

	public static boolean validateMobileNo(String number) throws InvalidUserException {
		boolean isMatch = false;
		if (number == null)
			return false;

		String regex = "^[6789]\\d{9}$";
		isMatch = Pattern.matches(regex, number);
		if (isMatch) {
			return true;
		} else {
			throw new InvalidUserException("The mobile number is Invalid");

		}

	}

	public static boolean validateCityName(String cityName) throws InvalidUserException {

		if (cityName != null) {
			return true;
		} else {
			throw new InvalidUserException("The city name is invalid");
		}
	}

}
