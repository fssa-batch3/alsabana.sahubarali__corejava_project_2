package com.fssa.healthyhair.dao;

import java.sql.*;

import com.fssa.healthyhair.dao.exception.DAOException;
import com.fssa.healthyhair.model.User;

import io.github.cdimascio.dotenv.Dotenv;

public class UserDAO {

	public static Connection getConnection() throws SQLException {

		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}

		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	public boolean register(User user) throws DAOException {

		String query = "INSERT INTO user (email,name,password,phonenumber,type) VALUES (?,?,?,?,?)";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {

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

		try (PreparedStatement pstmt = getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

	private String userPasswordFromDb;

	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	}

	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}

	public boolean isLogin(User user) throws DAOException {

		final String SELECTQUERY = "SELECT email, password FROM user WHERE email = ?";

		try (PreparedStatement pstmt = getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, user.getEmail());

			try (ResultSet rs = pstmt.executeQuery()) {
				String passwordfromDb = rs.getString("password");
				setUserPasswordFromDb(passwordfromDb);
				return rs.next();
			}

		} catch (SQLException e) {
			throw new DAOException("Error in loggin in", e);
		}

	}

	public void updateUser(User user) throws DAOException {

		try (Connection connection = getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE user SET  password=?,name=?,phonenumber=? WHERE email=?")) {

			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getNumber());
			stmt.setString(4, user.getEmail());

			int rows = stmt.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			throw new DAOException("Error in updateUser method", e);
		}
	}

	public void deleteUser(String email) throws DAOException {

		try (Connection connection = getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE from user WHERE email=?")) {

			stmt.setString(1, email);

			int rows = stmt.executeUpdate();
			System.out.println("No of rows inserted :" + rows);

		} catch (SQLException e) {
			throw new DAOException("Error in deleteTask method", e);
		}

	}

}