package com.empmang.dao;

import java.util.List;

import com.empmang.exceptions.ApplicationException;
import com.empmang.exceptions.DatabaseOperationException;
import com.empmang.model.DepartmentTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Department.
 */
public interface Department {

	/**
	 * Adds the depart.
	 * 
	 * @param departNm
	 *            the depart nm
	 * @throws DatabaseOperationException
	 *             the database operation exception
	 * @throws ApplicationException
	 *             the application exception
	 */
	void addDepart(String departNm) throws DatabaseOperationException,
			ApplicationException;

	/**
	 * Gets the all depart.
	 * 
	 * @return the all depart
	 * @throws DatabaseOperationException
	 *             the database operation exception
	 * @throws ApplicationException
	 *             the application exception
	 */
	List<DepartmentTO> getAllDepart() throws DatabaseOperationException,
			ApplicationException;

	/**
	 * Gets the all depart which will be paginated in the view.
	 * 
	 * @return the all depart
	 * @throws DatabaseOperationException
	 *             the database operation exception
	 * @throws ApplicationException
	 *             the application exception
	 */
	List<DepartmentTO> getAllDepartByPagination(String maxPage, String ofset)
			throws DatabaseOperationException, ApplicationException;

	/**
	 * This method is used to retrieve the department count.
	 * 
	 * @return the depart count
	 * @throws DatabaseOperationException
	 *             the database operation exception
	 * @throws ApplicationException
	 *             the application exception
	 */
	int getAllDepartCount() throws DatabaseOperationException,
			ApplicationException;

	/**
	 * Delete depart.
	 * 
	 * @param departId
	 *            the depart id
	 * @throws DatabaseOperationException
	 *             the database operation exception
	 * @throws ApplicationException
	 *             the application exception
	 */
	boolean deleteDepart(int departId) throws DatabaseOperationException,
			ApplicationException;
}
