package com.fssa.healthyhair.validation;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class OrderValidator {

	public static boolean validateOrder(Order order) throws InvalidOrderException, InvalidProductInputException {
		try {
			if (validateQuantity(order.getQuantity()) && validateAddress(order.getAddress())
					&& UserValidator.validateUserId(order.getOrderedUser1().getUserId())
					&& ProductValidator.validateProductId(order.getProduct().getProductId())) {
				return true;
			}
		} catch (InvalidOrderException | InvalidUserException e) {

			throw new InvalidOrderException("Order Details are not valid");
		}
		return false;
	} 

	public static boolean validateQuantity(int quantity) throws InvalidOrderException {
		if (quantity >= 0)
			return true;

		throw new InvalidOrderException("Quantity is not not valid");
	}

	public static boolean validateAddress(String address) throws InvalidOrderException {
		if (!address.isEmpty())
			return true;
		else
			throw new InvalidOrderException("Address should not be null");

	}

}
