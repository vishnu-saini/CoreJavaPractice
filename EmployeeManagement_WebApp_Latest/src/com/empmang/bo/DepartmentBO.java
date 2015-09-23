package com.empmang.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.empmang.dao.Department;
import com.empmang.dao.DepartmentDao;
import com.empmang.exceptions.ApplicationException;
import com.empmang.exceptions.BusinessException;
import com.empmang.exceptions.DatabaseOperationException;
import com.empmang.model.DepartmentTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentBO.
 */
public class DepartmentBO {
	
	/** The depart. */
	Department depart = new DepartmentDao();
	
	/** The Constant LOG. */
	public static final Logger LOG = Logger.getLogger("EmployeeBO");
	
	/**
	 * Adds the depart.
	 *
	 * @param departNm the depart nm
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws BusinessException the business exception
	 */
	public void addDepart(String departNm) throws DatabaseOperationException, ApplicationException, BusinessException {
			depart.addDepart(departNm);
		
	}
	
	/**
	 * Gets the all depart.
	 *
	 * @return the all depart
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<DepartmentTO> getAllDepart() throws DatabaseOperationException, ApplicationException {
		return depart.getAllDepart();
	}
	
	/**
	 * Gets the all depart details which will be paginated.
	 *
	 * @return the all depart
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public List<DepartmentTO> getAllDepartByPagination(String maxPage, String ofset) throws DatabaseOperationException, ApplicationException {
		return depart.getAllDepartByPagination(maxPage, ofset);
	}
	
	/**
	 * Gets the depart count.
	 *
	 * @return the all depart
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 */
	public int getAllDepartCount() throws DatabaseOperationException, ApplicationException {
		return depart.getAllDepartCount();
	}
	
	/**
	 * Adds the depart.
	 *
	 * @param departId the depart id
	 * @return true, if successful
	 * @throws DatabaseOperationException the database operation exception
	 * @throws ApplicationException the application exception
	 * @throws BusinessException the business exception
	 */
	public boolean deleteDepart(int departId) throws DatabaseOperationException, ApplicationException, BusinessException {
			return depart.deleteDepart(departId);
		
	}
}
