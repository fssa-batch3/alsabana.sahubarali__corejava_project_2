package healthyhair.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import healthyhair.DAO.exception.DAOException;
import healthyhair.model.Product;
import healthyhair.model.User;

public class ProductDAO {

	public Connection getConnection() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/healthyhair", "root", "123456");
	}

	public boolean create(Product product) throws DAOException {
		final String QUERY = "INSERT INTO product (product_name, cost, product_image, product_detail, category) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(QUERY)) {
			pmt.setString(1, product.getProduct_name());
			pmt.setInt(2, product.getCost());
			pmt.setString(3, product.getProduct_img());
			pmt.setString(4, product.getProduct_detail());
			pmt.setString(5, product.getCategory());

			int rowsAffected = pmt.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {

			throw new DAOException(e);
		}
	}

	public List<Product> getAllProduct() throws DAOException {
		List<Product> product1 = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement stmt = connection.prepareStatement(
						"SELECT product_id, product_name,cost, product_image,product_detail,category FROM product");
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				int cost = rs.getInt("cost");
				String productImage = rs.getString("product_image");
				String productDetail = rs.getString("product_detail");
				String category = rs.getString("category");
				product1.add(new Product(productId, productName, cost, productImage, productDetail, category));

			}

			return product1;

		} catch (SQLException e) {
			throw new DAOException("Error in getAllPproduct", e);
		}

	}

	public boolean update(Product product) throws DAOException {
		ProductDAO productDAO = new ProductDAO();
		try (Connection connection = productDAO.getConnection();
				PreparedStatement stmt = connection.prepareStatement(
						"UPDATE product SET  product_name=?,cost=?,product_image=?,product_detail=?,category=? WHERE product_id=?")) {

			stmt.setString(1, product.getProduct_name());
			stmt.setInt(2, product.getCost());
			stmt.setString(3, product.getProduct_img());
			stmt.setString(4, product.getProduct_detail());
			stmt.setString(5, product.getCategory());
			stmt.setInt(6, product.getProduct_id());

			int rows = stmt.executeUpdate();
			return rows > 0;
		} catch (SQLException e) {
			throw new DAOException("Error in update Product");
		}
	}

	public boolean delete(int productId) throws DAOException {
		ProductDAO productDAO = new ProductDAO();
		try (Connection connection = productDAO.getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE from product WHERE product_id=?")) {

			stmt.setInt(1, productId);

			int rows = stmt.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in delete product method",e);
		}

	}

}
