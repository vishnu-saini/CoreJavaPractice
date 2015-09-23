package com.empmang.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.empmang.constants.QueryConstants;
import com.empmang.exceptions.ApplicationException;
import com.empmang.exceptions.DatabaseOperationException;
import com.empmang.model.DepartmentTO;
import com.empmang.util.DbUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentDao.
 */
public class DepartmentDao implements Department {

	/** The connection. */
	private Connection connection;

	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("DepartmentDao");

	/**
	 * **************************************************************** This
	 * method is used to store the department details in DB.
	 * 
	 * @param departNm
	 *            -Department Name
	 * @throws DatabaseOperationException
	 *             when any SQLException occurs in the system
	 * @throws ApplicationException
	 *             *************************************************************
	 *             ****
	 */
	public void addDepart(String departNm) throws DatabaseOperationException,
			ApplicationException {
		PreparedStatement preparedStatement = null;
		try {
			LOG.info("Inside - method addDepart in DepartmentDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.CREATE_DEPARTMENT);
			preparedStatement.setString(1, departNm);
			preparedStatement.executeUpdate();
			LOG.info("Exit - method addDepart in DepartmentDao class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} finally {

			try {
				preparedStatement.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}
	}

	/**
	 * **************************************************************** This
	 * method is used to get all the department details.
	 * 
	 * @return the all depart
	 * @throws DatabaseOperationException
	 *             when any SQLException occurs in the system
	 * @throws ApplicationException
	 *             *************************************************************
	 *             ****
	 */
	public List<DepartmentTO> getAllDepart() throws DatabaseOperationException,
			ApplicationException {
		LOG.info("Inside - method getAllDepart in DepartmentDao class");
		List<DepartmentTO> departlist = new ArrayList<DepartmentTO>();
		ResultSet rs = null;
		Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(QueryConstants.SELECT_DEPT);
			while (rs.next()) {
				DepartmentTO depart = new DepartmentTO();
				depart.setDepartId(rs.getInt("department_id"));
				depart.setDepartName(rs.getString("department_nm"));
				departlist.add(depart);
			}
			LOG.info("Exit - method getAllDepart in DepartmentDao class");
		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				statement.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}
		return departlist;
	}

	/**
	 * **************************************************************** This
	 * method is used to get all the department details which will be paginated
	 * in the view.
	 * 
	 * @return the all depart
	 * @throws DatabaseOperationException
	 *             when any SQLException occurs in the system
	 * @throws ApplicationException
	 *             *************************************************************
	 *             ****
	 */
	public List<DepartmentTO> getAllDepartByPagination(String maxPage, String ofset)
			throws DatabaseOperationException, ApplicationException {
		LOG.info("Inside - method getAllDepartByPagination in DepartmentDao class");
		List<DepartmentTO> departlist = new ArrayList<DepartmentTO>();
		ResultSet rs = null;
		PreparedStatement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection
			.prepareStatement(QueryConstants.SELECT_PAGINATION_DEPT);
			
			statement.setString(1, maxPage);
			statement.setString(2, ofset);
			rs = statement.executeQuery();
			while (rs.next()) {
				DepartmentTO depart = new DepartmentTO();
				depart.setDepartId(rs.getInt("department_id"));
				depart.setDepartName(rs.getString("department_nm"));
				departlist.add(depart);
			}
			LOG.info("Exit - method getAllDepartByPagination in DepartmentDao class");
		} catch (SQLException sqlException) {sqlException.printStackTrace();
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				statement.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}
		return departlist;
	}

	/**
	 * **************************************************************** This
	 * method is used to retrieve the department count.
	 * 
	 * @return the depart count
	 * @throws DatabaseOperationException
	 *             when any SQLException occurs in the system
	 * @throws ApplicationException
	 *             *************************************************************
	 *             ****
	 */
	public int getAllDepartCount() throws DatabaseOperationException,
			ApplicationException {
		LOG.info("Inside - method getAllDepartCount in DepartmentDao class");
		int deptCnt = -1;
		ResultSet rs = null;
		Statement statement = null;
		try {
			connection = DbUtil.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(QueryConstants.SELECT_DEPT_COUNT);
			while (rs.next()) {
				deptCnt = rs.getInt(1);
			}
			LOG.info("Exit - method getAllDepartCount in DepartmentDao class");
		} catch (SQLException sqlException) {sqlException.printStackTrace();
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				statement.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}
		return deptCnt;
	}

	/**
	 * **************************************************************** This
	 * method is used to store the department details in DB.
	 * 
	 * @param departId
	 *            -Department Id
	 * @throws DatabaseOperationException
	 *             when any SQLException occurs in the system
	 * @throws ApplicationException
	 *             *************************************************************
	 *             ****
	 */
	public boolean deleteDepart(int departId)
			throws DatabaseOperationException, ApplicationException {
		ResultSet rs = null;
		int empCount = 0;
		PreparedStatement preparedStatement = null;
		try {
			LOG.info("Inside - method deleteDepart in DepartmentDao class");
			connection = DbUtil.getConnection();
			preparedStatement = connection
					.prepareStatement(QueryConstants.DELETE_DEPT);
			preparedStatement.setInt(1, departId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				empCount = rs.getInt("count");
			}
			preparedStatement.close();
			if (empCount == 0) {
				preparedStatement = connection
						.prepareStatement("delete from department where department_id=?");
				preparedStatement.setInt(1, departId);
				preparedStatement.executeUpdate();
				return true;
			} else {
				return false;
			}

		} catch (SQLException sqlException) {
			throw new DatabaseOperationException(sqlException);

		} catch (ClassNotFoundException e) {
			throw new ApplicationException(e);
		} catch (IOException e) {
			throw new ApplicationException(e);
		} finally {

			try {
				preparedStatement.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlException) {
				new DatabaseOperationException(sqlException);
			}
		}
	}
}
