package com.tcs.ilp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.ilp.bean.NsepAccountBean;
import com.tcs.ilp.bean.StudentAccountBean;
import com.tcs.ilp.utility.DBConnection;
import com.tcs.ilp.utility.Constants;

/**
 * NsepAccountModel has functions for creating,viewing, updating, deleting and
 * viewallusers of NsepAccount.
 * 
 * @author : A.S.L.Prasuna Devi (539389), K.Soumya Devi (539316)
 * @version :3.5.2
 * @Class name : NsepAccountModel
 * @Creation Date: 07/01/2012 @ History:
 **/
public class NsepAccountModel {
	static final Logger logger = Logger.getLogger(NsepAccountModel.class);

	// Declarations
	// To establish the connection with database
	Connection connection = DBConnection.getConnection();
	// To create Prepared statement.
	PreparedStatement preparedStatement = null;
	// To create result set
	ResultSet resultSet = null;
	//To create statement
	Statement statement = null;
	

	/**
	 * verifyStudentAccount() method is used for verifying whether the
	 * studentaccount number is present.
	 * 
	 * @param---------studentAccountNumber is passed as a parameter.
	 * @return----------StudentAccountBean
	 * @exception-------SQLException
	 * @since-----------3.5.2
	 * @see <reference to any other function called >
	 */
	public StudentAccountBean verifyStudentAccount(String studentAccountNumber) {
		// To create the Instance of StudentAccountBean
		StudentAccountBean studentAccountBean = new StudentAccountBean();
		studentAccountBean.setStudentId(0);
		try {
			// To create the Prepared Statement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY1);

			preparedStatement.setString(1, studentAccountNumber);
			logger.info("This is Model" );
			// Assigning the return values to resultSet
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				studentAccountBean.setStudentId(-1);
			} else {
				// To create the Prepared Statement
				preparedStatement = connection
						.prepareStatement(Constants.NSEP_QUERY2);
				preparedStatement.setString(1, studentAccountNumber);
				// Assigning the return values to resultSet
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					// setting the studentAccountBean object variables
					studentAccountBean.setStudentId(resultSet
							.getInt("studentid"));
					studentAccountBean.setYearOfGraduation(resultSet
							.getString("yearofgraduation"));
					studentAccountBean.setStudentAccountNumber(resultSet
							.getString("studentaccountnumber"));

				}
			}

		} catch (SQLException e) {
			 logger.error(e.getMessage());

		} finally {
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return studentAccountBean;
	}

	public StudentAccountBean verifyStudentAccount(int studentId) {
		// To create the Instance of Studentaccountbean

		StudentAccountBean studentAccountBean = new StudentAccountBean();
		studentAccountBean.setStudentId(0);
		try {
			// To create the Prepared Statement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY11);

			preparedStatement.setInt(1, studentId);

			logger.info("This is verifyStudentAccount");
			// Assigning the return values to resultSet
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				studentAccountBean.setStudentId(-1);
			} else {
				// To create the Prepared Statement
				preparedStatement = connection
						.prepareStatement(Constants.NSEP_QUERY12);
				preparedStatement.setInt(1, studentId);
				// Assigning the return values to resultSet
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					// setting the studentAccountBean object variables
					studentAccountBean.setStudentId(resultSet
							.getInt("studentid"));
					System.out.println(resultSet.getInt("studentid"));
					studentAccountBean.setStudentAccountNumber(resultSet
							.getString("studentaccountnumber"));
					studentAccountBean.setYearOfGraduation(resultSet
							.getString("yearofgraduation"));

				}
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {
			logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return studentAccountBean;
	}

	/**
	 * createNsepAccount() method is used for creating the NsepAccount.
	 * 
	 * @param---------Student ID is passed as a parameter.
	 * @return----------ArrayList
	 * @exception-------SQLException
	 * @since-----------3.5.2
	 * @see <reference to any other function called >
	 */
	public String createNsepAccount(NsepAccountBean nsepAccountBean) {
		// To store the result after execution of the query
		int flag = 0;
		// To store the NsepAccountNumber
		String nsepaccountnumber = null;
		try {
			// To create the Prepared Statement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY3);
			// setting the respected parameters
			preparedStatement.setInt(1, nsepAccountBean.getStudentId());
			preparedStatement.setString(2, nsepAccountBean
					.getStudentAccountNumber());

			preparedStatement.setString(3, nsepAccountBean
					.getStudentAccountNumber().substring(0, 7)
					+ 1234
					+ nsepAccountBean.getStudentAccountNumber().substring(11,
							14));

			preparedStatement.setInt(4, nsepAccountBean.getCommittedAmount());
			preparedStatement.setString(5, nsepAccountBean.getCreationDate());
			preparedStatement.setString(6, nsepAccountBean.getEndDate());
			preparedStatement.setFloat(7, nsepAccountBean.getTopup());
			preparedStatement.setFloat(8, nsepAccountBean.getQuarterlyBonus());
			preparedStatement.setFloat(9, nsepAccountBean.getAnnualBonus());
			preparedStatement.setFloat(10, nsepAccountBean.getAccountBalance());
			preparedStatement.setString(11, "Open");
			preparedStatement.setString(12, "Nondefaulter");
			// Assigning the result of query execution to flag
			flag = preparedStatement.executeUpdate();
			if (flag > 0)
				nsepaccountnumber = nsepAccountBean.getStudentAccountNumber()
						.substring(0, 7)
						+ 1234
						+ nsepAccountBean.getStudentAccountNumber().substring(
								11, 14);

		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return nsepaccountnumber;

	}

	/**
	 * viewNsepAccountDetails() method is used for getting the details of a
	 * particular NsepAccount.
	 * 
	 * @param---------Student ID is passed as a parameter.
	 * @return----------NsepAccountBean
	 * @exception-------SQLException
	 * @since-----------3.5.2
	 * @see <reference to any other function called >
	 */
	public NsepAccountBean viewNsepAccountDetails(int studentId) {
		// Instance of NsepAcountBean Class
		NsepAccountBean nsepAccountBean = new NsepAccountBean();
		try {
			// To create the PreparedStatement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY4);
			// setting the parameter
			preparedStatement.setInt(1, studentId);
			// Assigning the return values to resultSet
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// setting the values to the nsepAccountBean
				nsepAccountBean.setStudentId(resultSet.getInt("studentid"));
				nsepAccountBean.setStudentAccountNumber(resultSet
						.getString("studentacctnum"));
				nsepAccountBean.setNsepAccountNumber(resultSet
						.getString("nsepacctnum"));
				nsepAccountBean.setCommittedAmount(resultSet
						.getInt("committedamt"));
				nsepAccountBean.setCreationDate(resultSet
						.getString("creationdate"));
				nsepAccountBean.setEndDate(resultSet.getString("enddate"));
				nsepAccountBean.setTopup(resultSet.getFloat("topup"));
				nsepAccountBean.setQuarterlyBonus(resultSet
						.getFloat("quarterlybonus"));
				nsepAccountBean.setAnnualBonus(resultSet
						.getFloat("annualbonus"));
				nsepAccountBean.setAccountBalance(resultSet
						.getFloat("accountbalance"));
			}
		} catch (SQLException e) {
			 logger.error(e.getMessage());
		} finally { 
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return nsepAccountBean;
	}
	
	public NsepAccountBean viewNsepAccountDetails(String nsepAccountNumber) {
		// Instance of NsepAcountBean Class
		NsepAccountBean nsepAccountBean = new NsepAccountBean();
		try {
			// To create the PreparedStatement
			preparedStatement = connection
					.prepareStatement("select * from nsepAccount where nsepacctnum=?");
			// setting the parameter
			preparedStatement.setString(1, nsepAccountNumber);
			// Assigning the return values to resultSet
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// setting the values to the nsepAccountBean
				nsepAccountBean.setStudentId(resultSet.getInt("studentid"));
				nsepAccountBean.setStudentAccountNumber(resultSet
						.getString("studentacctnum"));
				nsepAccountBean.setNsepAccountNumber(resultSet
						.getString("nsepacctnum"));
				nsepAccountBean.setCommittedAmount(resultSet
						.getInt("committedamt"));
				nsepAccountBean.setCreationDate(resultSet
						.getString("creationdate"));
				nsepAccountBean.setEndDate(resultSet.getString("enddate"));
				nsepAccountBean.setTopup(resultSet.getFloat("topup"));
				nsepAccountBean.setQuarterlyBonus(resultSet
						.getFloat("quarterlybonus"));
				nsepAccountBean.setAnnualBonus(resultSet
						.getFloat("annualbonus"));
				nsepAccountBean.setAccountBalance(resultSet
						.getFloat("accountbalance"));
			}
		} catch (SQLException e) {
			 logger.error(e.getMessage());
		} finally { // close the resources
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return nsepAccountBean;
	}

	/**
	 * deleteViewNsep() method is used for getting the details of NSepAccount
	 * that wants to be deleted.
	 * 
	 * @param---------nsepaccountnumber is passed as a parameter.
	 * @return----------NsepAccountBean
	 * @exception-------SQLException
	 * @since-----------1.5
	 * @see <reference to any other function called >
	 */
	public NsepAccountBean deleteViewNsep(String nsepAccountNumber) {
		// Instance of NsepAccountBean Class
		NsepAccountBean nsepAccountBean = new NsepAccountBean();
		try {
			// To create the PreparedStatement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY5);
			// setting the parameter
			preparedStatement.setString(1, nsepAccountNumber);
			// Assigning the return values to resultSet
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// setting the values to nsepAccountBean
				nsepAccountBean.setStudentId(resultSet.getInt("studentid"));
				nsepAccountBean.setNsepAccountNumber(resultSet
						.getString("nsepacctnum"));
				nsepAccountBean.setCommittedAmount(resultSet
						.getInt("committedamt"));
				nsepAccountBean.setTopup(resultSet.getFloat("topup"));
				nsepAccountBean.setQuarterlyBonus(resultSet
						.getFloat("quarterlybonus"));
				nsepAccountBean.setAnnualBonus(resultSet
						.getFloat("annualbonus"));
				nsepAccountBean.setAccountBalance(resultSet
						.getFloat("accountbalance"));

			}
		} catch (SQLException e) {
			 logger.error(e.getMessage());
		} finally {// Close the resources
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return nsepAccountBean;
	}
	
	public NsepAccountBean deleteViewNsep(int studentId) {
		// Instance of NsepAccountBean Class
		NsepAccountBean nsepAccountBean = new NsepAccountBean();
		try {
			// To create the PreparedStatement
			preparedStatement = connection
					.prepareStatement("select * from nsepaccount where studentid=?");
			// setting the parameter
			preparedStatement.setInt(1, studentId);
			// Assigning the return values to resultSet
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// setting the values to nsepAccountBean
				nsepAccountBean.setStudentId(resultSet.getInt("studentid"));
				nsepAccountBean.setNsepAccountNumber(resultSet
						.getString("nsepacctnum"));
				nsepAccountBean.setCommittedAmount(resultSet
						.getInt("committedamt"));
				nsepAccountBean.setTopup(resultSet.getFloat("topup"));
				nsepAccountBean.setQuarterlyBonus(resultSet
						.getFloat("quarterlybonus"));
				nsepAccountBean.setAnnualBonus(resultSet
						.getFloat("annualbonus"));
				nsepAccountBean.setAccountBalance(resultSet
						.getFloat("accountbalance"));

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {// Close the resources
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return nsepAccountBean;
	}


	/**
	 * deleteNsepAccount() method is used for deleting the Nsep Account details
	 * and the deleted accounts are kept in NsepArchive.
	 * 
	 * @param---------Student ID is passed as a parameter.
	 * @return----------int
	 * @exception-------SQLException
	 * @since-----------1.5
	 * @see <reference to any other function called >
	 */
	public int deleteNsepAccount(int studentId) {
		int flag = 0;
		// To store the NsepAccountNumber
		String nsepacctno = null;
		try {
			// To create the PreparedStatement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY6);
			// setting the parameter
			preparedStatement.setInt(1, studentId);
			// Assigning the return values to resultSet
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				if (resultSet.getString("status").equalsIgnoreCase("close")) {
					flag = 1;
					nsepacctno = resultSet.getString("nsepacctnum");

				} else
					flag = 2;
			}
			if (flag == 1) {
				// To create the PreparedStatement
				preparedStatement = connection
						.prepareStatement(Constants.NSEP_QUERY7);
				// setting the parameter
				preparedStatement.setInt(1, studentId);
				int x = preparedStatement.executeUpdate();
				if (x > 0) {
					flag = 1;
					// To create the PreparedStatement
					PreparedStatement pst2 = connection
							.prepareStatement(Constants.NSEP_QUERY8);
					// Setting the parameters
					pst2.setInt(1, studentId);
					pst2.setString(2, nsepacctno);
					// executing the query
					pst2.executeUpdate();

				} else
					flag = 3;

			}
		} catch (SQLException e) {
			 logger.error(e.getMessage());
		} finally {
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return flag;
	}

	/**
	 * viewAllNsepUsers() method is used for getting the details of
	 * NsepAccounts.
	 * 
	 * @param---------No parameter.
	 * @return----------ArrayList<NsepAccountBean>
	 * @exception-------SQLException
	 * @since-----------1.5
	 * @see <reference to any other function called >
	 */
	public ArrayList<NsepAccountBean> viewAllNsepUsers() {
		// Creating the Arraylist of generic type NsepAccountBean
		ArrayList<NsepAccountBean> nsepAccountList = new ArrayList<NsepAccountBean>();

		try {
			// To create the PreparedStatement
			statement = connection.createStatement();
			String sql="select sd.studentname,na.studentid,na.nsepacctnum," +
					"na.committedamt,na.topup,na.quarterlybonus,na.annualbonus," +
					"na.accountbalance from nsepaccount na join studentdetails " +
					"sd on na.studentid=sd.studentid ";
			// Assigning the return values to resultSet
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				// Instance of NsepAccountBean class
				NsepAccountBean nsepAccountBean = new NsepAccountBean();
				// Setting the values of nsepAccountBean
				nsepAccountBean.setStudentName(resultSet.getString("studentname"));
				nsepAccountBean.setStudentId(resultSet.getInt("studentid"));
				nsepAccountBean.setNsepAccountNumber(resultSet
						.getString("nsepacctnum"));
				nsepAccountBean.setAccountBalance(resultSet
						.getFloat("accountbalance"));
				nsepAccountBean.setCommittedAmount(resultSet
						.getInt("committedamt"));
				nsepAccountBean.setTopup(resultSet
						.getFloat("topup"));
				nsepAccountBean.setQuarterlyBonus(resultSet
						.getFloat("quarterlybonus"));
				nsepAccountBean.setAnnualBonus(resultSet
						.getFloat("annualbonus"));
				nsepAccountList.add(nsepAccountBean);
			}
		} catch (SQLException e) {

			logger.error(e.getMessage());
		} finally {// Closing the resources
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
				statement);
		}
		return nsepAccountList;
	}

	/**
	 * updateNsepAccount() method is used for updating the remarks like
	 * defaulter or non-defaulter for a student with help of his Student Id.
	 * 
	 * @param---------Student ID and remarks are passed as parameters.
	 * @return----------integer
	 * @exception-------SQLException
	 * @since-----------3.5.2
	 * @see <reference to any other function called >
	 */
	public int updateNsepAccount(int studentId, String remarks) {
		// To store the result of query execution
		int flag = 0;
		try {
			// To create the PreparedStatement
			preparedStatement = connection
					.prepareStatement(Constants.NSEP_QUERY10);
			// setting the parameters
			preparedStatement.setString(1, remarks);
			preparedStatement.setInt(2, studentId);
			// Assigning the result of execution of the query
			flag = preparedStatement.executeUpdate();
			// if (x > 0)
			// flag = 1;
		}

		catch (SQLException e) {

			logger.error(e.getMessage());
		} finally {// Closing the resources
			 logger.info("Closing Resources");
			 DBConnection.closeResources(connection, resultSet,
					preparedStatement);
		}
		return flag;
	}

}
