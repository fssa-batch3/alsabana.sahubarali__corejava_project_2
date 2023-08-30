package com.fssa.healthyhair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.util.ConnectionUtil;

public class UserDAO {

	public boolean register(User user) throws DAOException {

		String query = "INSERT INTO user (email,name,password,phonenumber,type) VALUES (?,?,?,?,?)";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pmt = connection.prepareStatement(query)) {

			pmt.setString(1, user.getEmail());
			pmt.setString(2, user.getUsername());
			pmt.setString(3, user.getPassword());
			pmt.setString(4, user.getNumber());
			pmt.setString(5, user.getType());

			int rows = pmt.executeUpdate();

			return rows > 0;

		} catch (SQLException e) {
			throw new DAOException("Error while registering the user", e);
		}
	}

	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String SELECTQUERY = "SELECT email FROM user WHERE email = ?";

		try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	public User findUserByEmail(String email) throws DAOException {
		final String SELECTQUERY = "SELECT * FROM user WHERE email = ?";
		User user = new User();
		try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {

					user.setEmail(rs.getString("email"));
					user.setUserId(rs.getInt("user_id"));
					user.setPassword(rs.getString("password"));
					user.setUsername(rs.getString("name"));
					user.setType(rs.getString("type"));

				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;

	}

	public void updateUser(User user) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(
						"UPDATE user SET  password=?,name=?,phonenumber=?,email=?,address=? WHERE user_id=?")) {

			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getNumber());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getAddress());
			stmt.setInt(6, user.getUserId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error in to update User", e);
		}
	}

	public List<User> allUser() throws DAOException {
		// Create an empty list to store user list
		List<User> user1 = new ArrayList<>();
		// //Start a try block with a prepared statement for selecting all users
		try (PreparedStatement stmt = ConnectionUtil.getConnection()
				.prepareStatement("SELECT user_id, name,email, phonenumber,address,type,password FROM user");
				ResultSet rs = stmt.executeQuery()) {
			// Iterate through the result set and extract user information
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String number = rs.getString("phonenumber");
				String address = rs.getString("address");
				String type = rs.getString("type");
				String password = rs.getString("password");

				user1.add(new User(email, name, password, type, number, userId, address));

			}
			// Return the list of user
			return user1;

		} catch (SQLException e) {
			throw new DAOException("Error in List user", e);
		}
	}

	public void deleteUser(String email) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE from user WHERE user_id=?")) {

			stmt.setString(1, email);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error in to delete user", e);
		}

	}

	

}