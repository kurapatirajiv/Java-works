/**
 * Author: Team B.     
 * Version:1.0      
 * Class name:LoginModel
 * Creation Date:05-01-2012
 * History: This class is used to get the username and password from database  
 *          to authenticate the user login details.
 */

package com.tcs.ilp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.tcs.ilp.utility.DBConnection;

public class LoginModel {
	// for logger class
	static final Logger logger = Logger.getLogger(LoginModel.class);

	/**
	 * This function is used to get username and password database to
	 * authenticate. Parameters used: userName(String): used to store username.
	 * password(String): used to store password. Return type:String Exception:
	 * SQL Exception Since:Version 1.0
	 * 
	 */
	public String checkin(String userName, String password) {
		// for returning String type
		String Query = null;
		try {
			Connection connection = DBConnection.getConnection();

			Statement statement = connection.createStatement();
			String sqlQuery = "select * from users where username='" + userName
					+ "' and password='" + password + "'";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			if (resultSet.next()) {
				Query = "success";
			} else {
				Query = "fail";
			}
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return Query;

	}

}
