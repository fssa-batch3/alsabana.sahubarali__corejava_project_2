package com.fssa.healthyhair.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	private String userPasswordFromDb;

	public String getUserPasswordFromDb() {
		return userPasswordFromDb;
	}

	public void setUserPasswordFromDb(String userPasswordFromDb) {
		this.userPasswordFromDb = userPasswordFromDb;
	}

	public boolean isLogin(User user) throws DAOException {

		final String SELECTQUERY = "SELECT email, password FROM user WHERE email = ?";

		try (PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, user.getEmail());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					String passwordfromDb = rs.getString("password");
					setUserPasswordFromDb(passwordfromDb);
					return true;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return false;

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

				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return user;

	}

	public void updateUser(User user) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE user SET  password=?,name=?,phonenumber=? WHERE email=?")) {

			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getNumber());
			stmt.setString(4, user.getEmail());

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error in updateUser method", e);
		}
	}

	public void deleteUser(String email) throws DAOException {

		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE from user WHERE email=?")) {

			stmt.setString(1, email);

			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Error in deleteTask method", e);
		}

	}

	public boolean userExists(String email, String password) throws DAOException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean status = false;

		try {
			String sql = "SELECT email FROM user WHERE email=? AND password=? ";

			conn = ConnectionUtil.getConnection();
			ps = conn.prepareStatement(sql);
			 
			ps.setString(1, email);			
			ps.setString(2, password);
			
			rs = ps.executeQuery();

			if (rs.next()) {
				status = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}

		return status;

	}

}