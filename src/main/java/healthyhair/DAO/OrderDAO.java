package healthyhair.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import healthyhair.DAO.exception.DAOException;
import healthyhair.model.Order;

public class OrderDAO {

	public boolean create(Order order) throws DAOException {
		final String QUERY = "INSERT INTO orders (order_id, product_id,product_name,cost,product_detail,product_image, quantity, user_id , user_name) VALUES (?, ?, ?, ?,?,?,?,?,?)";

		try (PreparedStatement pmt = UserDAO.getConnection().prepareStatement(QUERY)) {
			pmt.setInt(1, order.getOrder_id());
			pmt.setInt(2, order.getProduct().getProduct_id());
			pmt.setString(3, order.getProduct().getProduct_name());
			pmt.setInt(4, order.getProduct().getCost());
			pmt.setString(5, order.getProduct().getProduct_detail());
			pmt.setString(6, order.getProduct().getProduct_img());
			pmt.setInt(7, order.getQuantity());
			pmt.setInt(8, order.getUser().getUserId());
			pmt.setString(9, order.getUser().getUsername());
			int rows = pmt.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
