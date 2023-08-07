package healthyhair.DAO;

import java.sql.*;

import healthyhair.DAO.exception.DAOException;
import healthyhair.model.User;

public class UserDAO {

	// connect to database
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/healthyhair", "root", "123456");
	}

	public boolean register(User user) throws DAOException {

		String query = "INSERT INTO USER (EMAIL ,NAME,PASSWORD,TYPE,phonenumber) VALUES (?,?,?,?,?)";

		try (Connection connection = getConnection(); PreparedStatement pmt = connection.prepareStatement(query)) {

			pmt.setString(1, user.getEmail());
			pmt.setString(2, user.getUsername());
			pmt.setString(3, user.getPassword());
			pmt.setString(4, user.getType());
			pmt.setString(5, user.getNumber());

			int rows = pmt.executeUpdate();

			// Return successful or not
			return rows == 1;

		} catch (SQLException e) {
			throw new DAOException("Error while registering the user");
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
			throw new DAOException("Error in getting the email exist");
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
			throw new DAOException("Error in loggin in");
		}

	}

	public void updateUser(User user) throws DAOException {
		UserDAO userDAO = new UserDAO();
		try (Connection connection = userDAO.getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("UPDATE user SET  password=?,name=?,phonenumber=? WHERE email=?")) {

			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getNumber());
			stmt.setString(4, user.getEmail());

			int rows = stmt.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} catch (SQLException e) {
			throw new DAOException("Error in updateUser method");
		}
	}

	public void deleteUser(String email) throws DAOException {
		UserDAO userDAO = new UserDAO();
		try (Connection connection = userDAO.getConnection();
				PreparedStatement stmt = connection.prepareStatement("DELETE from user WHERE email=?")) {

			stmt.setString(1, email);

			int rows = stmt.executeUpdate();
			System.out.println("No of rows inserted :" + rows);

		} catch (SQLException e) {
			throw new DAOException("Error in deleteTask method");
		}

	}

}