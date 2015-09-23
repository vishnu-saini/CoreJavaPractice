package com.empmang.bo;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;

import com.empmang.constants.ErrorConstants;
import com.empmang.dao.User;
import com.empmang.dao.UserDao;
import com.empmang.exceptions.ApplicationException;
import com.empmang.exceptions.BusinessException;
import com.empmang.exceptions.DatabaseOperationException;
import com.empmang.model.UserTO;
import com.empmang.util.PropertyUtil;

/**
 *  The LoginBO class contains the logic for validating the
 *         user's login
 * @author t-Renjith
 */
public class LoginBO {
	/**
	 * The log object used for logging the error and info
	 */
	User userdao = new UserDao();
	
	public static final Logger LOG = Logger.getLogger("LoginBO");

	/**
	 * @param user
	 *            -The UserVO object which contains the user details
	 * @return true if no exception is thrown
	 * @throws ApplicationException 
	 * @throws LoginBusinessException
	 *             -Thrown when the login fails
	 * @throws LoginException
	 *             -Thrown in case of any fatal exception occurring in the
	 *             system
	 */
	public UserTO validateUser(UserTO userTO)
			throws BusinessException, DatabaseOperationException, ApplicationException {

		String message = null;// Variable used for storing the messages.
		int flag = 0; // Flag variable for holding the value returned from the
		// UserDao which says whether the username or password
		// is incorrect

		LOG.info("Method Validate User Invoked" + userTO);
		userdao.getUserDetails(userTO);
		LOG.debug("Authentication flag" + flag);

		if (userTO.getResult() == 0) {
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDUSERNAME);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		} else if (userTO.getResult() == 1) {
			message = PropertyUtil.getErrorMessage(ErrorConstants.INVALIDPASSWORD);
			LOG.debug("Message" + message);
			throw new BusinessException(message);
		}
		LOG.info("Validate User: Response true");
		return userTO;
	}
}
