package com.empmang.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

import com.empmang.exceptions.ApplicationException;
import com.empmang.exceptions.DatabaseOperationException;
import com.empmang.model.UserTO;
import com.empmang.util.DbUtil;

/**
 * @author The UserDao class which manages the DataBase operations for the user
 */
public class UserDao implements User {
	/** The connection. */
	private Connection connection;
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("UserDao");

	/**
	 * This method gets the user details from the database. returns 0 when the
	 * username is not found in the database returns 1 if the password does not
	 * match for the given username returns 2 if the password matches for the
	 * entered username
	 * 
	 * @param user
	 *            -The UserVO object which holds the details entered by the user
	 * @return an integer response.
	 * @throws ApplicationException
	 * 
	 * @throws LoginException
	 *             when any SQLException occurs in the system
	 * 
	 */
	public UserTO getUserDetails(final UserTO user)
			throws DatabaseOperationException, ApplicationException {
		// The SQL query string for retrieving the user's data from the database
		LOG.info("Inside - method getUserDetails in UserDao class");
		// final String queryString = QueryConstants.QRY_USR_VALIDATE;
		int response = 0;// Variable for storing the response value
		ResultSet result = null;
		PreparedStatement statement = null;
		CallableStatement callableStatement = null;

		try {
			connection = DbUtil.getConnection();
			String password;
			String role;
			int userId;

			// calling the stored proc. getUserDetails_sp with the required
			// parameters
			callableStatement = connection
					.prepareCall("{call getUserDetails_sp(?,?,?)}");
			if (user != null) {
				try {
					userId = Integer.parseInt(user.getUserid());
				} catch (NumberFormatException nfe) {
					userId = 0;
				}
				callableStatement.setInt(1, userId);
			}

			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);

			// execute getUserDetails_sp store procedure
			callableStatement.executeUpdate();

			password = callableStatement.getString(2);
			role = callableStatement.getString(3);
			/*
			 * statement = connection.prepareStatement(queryString); // Creates
			 * the
			 * 
			 * // preparedStatement Object statement.setString(1,
			 * user.getUserid()); result = statement.executeQuery(); // Executes
			 * the Query while (result.next()) { // If result has value means a
			 * user with // username exists password = result.getString(2); role
			 * = result.getString(3);
			 */

			if (role == null && password == null) {
				response = 0;
			} else if (password != null && user.getPassword().equals(password)) {
				/**
				 * Checks if the entered password matches with the one already
				 * stored in the database for that particular user
				 */
				response = 2;
			} else {
				response = 1;
			}
			user.setResult(response);
			user.setRole(role);
			// }
			LOG.info("Exit - method getUserDetails in UserDao class");
		} catch (SQLException e) {
			throw new DatabaseOperationException("SQL Exception happened", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException(e);
		} finally {

			try {
				if (statement != null) {
					statement.close();
				}
				if (callableStatement != null) {
					callableStatement.close();
				}

				if (result != null) {
					result.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new DatabaseOperationException("SQL Exception happened",
						e);
			}

		}
		return user;
	}
	
}
