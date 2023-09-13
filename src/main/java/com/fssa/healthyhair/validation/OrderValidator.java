package com.fssa.healthyhair.validation;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class OrderValidator {

	public static boolean validateOrder(Order order) throws InvalidOrderException, InvalidProductInputException {
		try {
			if (validateQuantity(order.getQuantity()) && validateAddress(order.getAddress())
					&& UserValidator.validateUserId(order.getOrderedUser().getUserId())
					&& ProductValidator.validateProductId(order.getOrderedProduct().getProductId())) {
				return true;
			}
		} catch (InvalidOrderException | InvalidUserException e) {

			throw new InvalidOrderException("Order Details are not valid");
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
		try {
			if (!address.isEmpty())
				return true;
		}catch(Exception e) {
			throw new InvalidOrderException("Address should not be null");
		}
		return false;
	
			

	}
	
	public static boolean validateOrderId(int id) throws InvalidOrderException{
		if(id>0) {
			return true;
		}else {
			throw new InvalidOrderException("Order Id is invalid");
		}
		
	}

}
