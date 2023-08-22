package com.fssa.healthyhair.validation;

import com.fssa.healthyhair.model.Order;
import com.fssa.healthyhair.validation.exception.InvalidOrderException;
import com.fssa.healthyhair.validation.exception.InvalidProductInputException;
import com.fssa.healthyhair.validation.exception.InvalidUserException;

public class OrderValidator {

	public static boolean validateOrder(Order order) throws InvalidOrderException, InvalidProductInputException {
		try {
			if (order != null && validateQuantity(order.getQuantity())
					&& UserValidator.validateUserId(order.getUser().getUserId())
					&& ProductValidator.validateProductId(order.getProduct().getProduct_id())) {
				return true;
			}
		} catch (InvalidOrderException | InvalidUserException e) {
			e.printStackTrace();
			throw new InvalidOrderException("Order Details are not valid");
		}
		return false;
	}

	public static boolean validateQuantity(int quantity) throws InvalidOrderException {
		if (quantity > 0)
			return true;
		else
			throw new InvalidOrderException("Quantity is not not valid");
	}

//	public static boolean validateOrderId(int orderId) throws InvalidOrderException {
//		if (orderId > 0)
//			return true;
//		else
//			throw new InvalidOrderException("Order ID is not not valid");
//	}

}
