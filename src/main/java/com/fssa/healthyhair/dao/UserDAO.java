package com.fssa.healthyhair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;
import com.fssa.healthyhair.service.UserService;
import com.fssa.healthyhair.service.exception.ServiceException;
import com.fssa.healthyhair.util.ConnectionUtil;

public class UserDAO {

	/**
	 * Registers a new user in the database.
	 *
	 * @param user The user object containing user information to be registered.
	 * @return true if the user registration is successful, false otherwise.
	 * @throws DAOException If there's an error during the registration process.
	 */
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

	/**
	 * Checks if an email address is already registered in the database.
	 *
	 * @param email The email address to check for registration.
	 * @return true if the email is already registered, false otherwise.
	 * @throws DAOException If there's an error while checking email existence.
	 */
	public boolean isEmailAlreadyRegistered(String email) throws DAOException {
		final String SELECTQUERY = "SELECT email FROM user WHERE email = ?";

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	/**
	 * Finds a user by their email address in the database.
	 *
	 * @param email The email address of the user to retrieve.
	 * @return The User object if found, or an empty User object if not found.
	 * @throws DAOException If there's an error while querying the database.
	 */
	public User findUserByEmail(String email) throws DAOException {
		final String SELECTQUERY = "SELECT * FROM user WHERE email = ?";

		User user = new User();

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {

					user.setEmail(rs.getString("email"));
					user.setUserId(rs.getInt("user_id"));
					user.setPassword(rs.getString("password"));
					user.setUsername(rs.getString("name"));
					user.setNumber(rs.getString("phonenumber"));
					user.setType(rs.getString("type"));

				}
			}

		} catch (SQLException e) {
			throw new DAOException("Finding user failed", e);
		}
		return user;

	}

	/**
	 * Updates user information in the database.
	 *
	 * @param user The User object containing updated user information.
	 * @return true if the update is successful, false otherwise.
	 * @throws DAOException If there's an error during the update process.
	 */
	public boolean update(User user) throws DAOException {
		final String SELECTQUERY = "UPDATE user SET  name=?,phonenumber=?,email=?,address=?,profile_img=?,company_name=?,company_address=?,company_license=? WHERE user_id=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {

			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getNumber());
			stmt.setString(3, user.getEmail());
			stmt.setString(4,user.getAddress());
			stmt.setString(5, user.getProfileUrl());
			stmt.setString(6,user.getCompanyName());
			stmt.setString(7, user.getCompanyAddress());
			stmt.setString(8, user.getCompanylicense());
			stmt.setInt(9, user.getUserId());
			

			int row = stmt.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			throw new DAOException("Error in to update User", e);
		}
	}

	/**
	 * Retrieves a list of all users from the database.
	 *
	 * @return A list of User objects representing all users in the database.
	 * @throws DAOException If there's an error while retrieving the user list.
	 */
	public List<User> allUser() throws DAOException {
		// Create an empty list to store user list
		List<User> user1 = new ArrayList<>();
		final String SELECTQUERY = "SELECT * FROM user";
		// Start a try block with a prepared statement for selecting all users
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY);
				ResultSet rs = stmt.executeQuery()) {
			// Iterate through the result set and extract user information
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String number = rs.getString("phonenumber");
				String type = rs.getString("type");
				String password = rs.getString("password");

				user1.add(new User(email, name, password, type, number, userId));

			}
			// Return the list of user
			return user1;

		} catch (SQLException e) {
			throw new DAOException("Error in List user", e);
		}
	}

	/**
	 * Deletes a user from the database based on their user ID.
	 *
	 * @param userId The ID of the user to be deleted.
	 * @return true if the user is successfully deleted, false otherwise.
	 * @throws DAOException If there's an error during the deletion process.
	 */

	public static boolean deleteUser(int userId) throws DAOException {
		final String SELECTQUERY = "DELETE from user WHERE user_id=?";
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement(SELECTQUERY)) {

			stmt.setInt(1, userId);

			int rows = stmt.executeUpdate();

			return rows > 0;

		} catch (SQLException e) {
			throw new DAOException("Deletion account failed", e);
		}

	}

}