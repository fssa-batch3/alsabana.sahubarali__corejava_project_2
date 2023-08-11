package healthyhair.services;

import healthyhair.DAO.OrderDAO;
import healthyhair.DAO.exception.DAOException;
import healthyhair.model.Order;
import healthyhair.service.exception.ServiceException;
import healthyhair.validation.OrderValidator;
import healthyhair.validation.exception.InvalidOrderException;
import healthyhair.validation.exception.InvalidProductInputException;

public class OrderService {
	public boolean createOrder(Order order) throws ServiceException {
		OrderDAO orderDAO = new OrderDAO();
		try {
			OrderValidator.validateOrder(order);
			if (orderDAO.create(order)) {
				System.out.println(order.getUser().getUsername() + "  Your order successfully created");
				return true;
			} else {
				System.out.println("Creating failed");
				return false;
			}

		} catch (InvalidProductInputException e) {

			System.out.println(e.getMessage());
		}

		catch (InvalidOrderException | DAOException e) {

			throw new ServiceException(e);
		}
		return false;

	}
}
