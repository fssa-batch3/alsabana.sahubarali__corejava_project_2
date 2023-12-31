package com.fssa.healthyhair.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.Product;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.util.ConnectionUtil;

public class ProductDAO {
	/**
	 * Creates a new product and inserts it into the database.
	 *
	 * @param product The Product object containing product information to be
	 *                created
	 * @return true if the product creation is successful, false otherwise.
	 * @throws DAOException If there's an error during the product creation process.
	 */
	public boolean create(Product product) throws DAOException {
		// the SQL query for inserting a new product
		final String QUERY = "INSERT INTO product (product_name, cost, product_image, product_detail, category,user_id) VALUES (?, ?, ?, ?, ?,?)";

		// Start a try block with a prepared statement for the insert query
		try (Connection connection = ConnectionUtil.getConnection();

				PreparedStatement pmt = connection.prepareStatement(QUERY)) {

			// Set the product attributes in the prepared statement

			pmt.setString(1, product.getProductName());
			pmt.setInt(2, product.getCost());
			pmt.setString(3, product.getProductImg());
			pmt.setString(4, product.getProductDetail());
			pmt.setString(5, product.getCategory());
			pmt.setInt(6, product.getCreatedUser().getUserId());
			// Execute the update and get the number of rows affected
			int rowsAffected = pmt.executeUpdate();
			// Return a boolean indicating whether the insertion was successful
			return rowsAffected > 0;
		} catch (SQLException e) {
			throw new DAOException("Error in Creating a Product", e);
		}
	}

	/**
	 * Retrieves a list of all products from the database.
	 *
	 * @return A list of Product objects representing all products in the database.
	 * @throws DAOException If there's an error while retrieving the product list.
	 */
	public List<Product> getAllProducts() throws DAOException {
		// Create an empty list to store products
		List<Product> product1 = new ArrayList<>();

		final String QUERY = "SELECT product_id, product_name,cost, product_image,product_detail,category,user_id FROM product";
		// Start a try block with a prepared statement for selecting all products
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(QUERY);
				ResultSet rs = pmt.executeQuery()) {
			// Iterate through the result set and extract product information
			while (rs.next()) {
				int productId = rs.getInt("product_id");
				String productName = rs.getString("product_name");
				int cost = rs.getInt("cost");
				String productImage = rs.getString("product_image");
				String productDetail = rs.getString("product_detail");
				String category = rs.getString("category");

				int userId = rs.getInt("user_id");
				User user = new User();
				user.setUserId(userId);

				product1.add(new Product(productName, cost, productImage, productDetail, category, productId, user));

			}
			// Return the list of products
			return product1;

		} catch (SQLException e) {
			throw new DAOException("Error in getting All Product", e);
		}

	}

	/**
	 * Finds a product by its ID in the database.
	 *
	 * @param productId The ID of the product to retrieve.
	 * @return The Product object if found, or an empty Product object if not found.
	 * @throws DAOException If there's an error while querying the database.
	 */
	public static Product findProductById(int productId) throws DAOException {
		final String SELECTQUERY = "SELECT * FROM product WHERE product_id = ?";

		Product product = new Product();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(SELECTQUERY)) {

			pmt.setInt(1, productId);

			try (ResultSet rs = pmt.executeQuery()) {
				if (rs.next()) {
					product.setProductId(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setCost(rs.getInt("cost"));
					product.setProductImg(rs.getString("product_image"));
					product.setProductDetail(rs.getString("product_detail"));
					product.setCategory(rs.getString("category"));
					int userId = rs.getInt("user_id"); // Assuming the column name in the database is "created_user_id"
					User user = new User();
					user.setUserId(userId);
					product.setCreatedUser(user);

				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return product;
	}

	/**
	 * Updates product information in the database.
	 *
	 * @param product The Product object containing updated product information.
	 * @return true if the update is successful, false otherwise.
	 * @throws DAOException If there's an error during the product update process.
	 */

	public boolean update(Product product) throws DAOException {
		final String SELECTQUERY = "UPDATE product SET  product_name=?,cost=?,product_image=?,product_detail=?,category=? WHERE product_id=?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {
			// Set the updated product attributes in the prepared statement
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getCost());
			stmt.setString(3, product.getProductImg());
			stmt.setString(4, product.getProductDetail());
			stmt.setString(5, product.getCategory());

			stmt.setInt(6, product.getProductId());
			// Execute the update and get the number of rows affected
			int rows = stmt.executeUpdate();

			return rows > 0;// Return a boolean indicating whether the update was successful
		} catch (SQLException e) {
			throw new DAOException("Error while updating Product");
		}
	}

	/**
	 * Deletes a product from the database based on its ID.
	 *
	 * @param productId The ID of the product to be deleted.
	 * @return true if the product is successfully deleted, false otherwise.
	 * @throws DAOException If there's an error during the product deletion process.
	 */
	public boolean delete(int productId) throws DAOException {
		final String SELECTQUERY = "DELETE from product WHERE product_id=?";
		// Start a try block with a prepared statement for deleting a product
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {

			stmt.setInt(1, productId);// Set the product ID in the prepared statement for deletion

			int rows = stmt.executeUpdate();

			return rows > 0;// Return a boolean indicating whether the deletion was successful

		} catch (SQLException e) {
			throw new DAOException("Error in delete product method", e);
		}

	}

	
}
