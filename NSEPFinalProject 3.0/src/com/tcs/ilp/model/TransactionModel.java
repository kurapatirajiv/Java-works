/**
 * 
 * @author - B.Navya    
 * @version  -3.5.2    
 * @Class name-TransactionModel
 * @Creation Date-07/01/2012
 * @ History- To retrieve the details from transaction table, 
 * 				Nsep account table and student account table 
 * 				by using deposited amount / by deposited month
 * 				 / by student id
 */
package com.tcs.ilp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.ilp.bean.Transaction_EntityBean;
import com.tcs.ilp.utility.DBConnection;

public class TransactionModel {
	static final Logger logger =Logger.getLogger(TransactionModel.class); 

	Connection connection = DBConnection.getConnection();
	//To establish connection by using DBConnection.
	ResultSet resultSet = null;
	//To create result set.
	PreparedStatement prepareStatement = null;
	//To create Prepared statement.
	Statement statement = null;
	//To create statement.

	/**
	 * getTransactionDetails() method is used for getting the details like 
	 * 	studentid, topup, bonuses, account balance and status based 
	 * deposited amount.
	 * 
	 * @param---------deposited amount is passed as a parameter. 
	 * 					This amount is obtained from csv file.
	 * @return----------ArrayList
	 * @exception-------SQLException
	 * @since-----------1.5
	 * @see <reference to any other function called >
	 */
	public ArrayList<Transaction_EntityBean> getTransactionDetails(int amount) 
	{
		logger.info("Reports based on month");
		int depositedAmount =0;
		//Assign the value obtained from the parameter. 
		depositedAmount= amount;
		ArrayList<Transaction_EntityBean> list = null;
		// create an arraylist of generic type as Transaction_EntityBean.
		list=new ArrayList<Transaction_EntityBean>();		
			String query = null;
			Transaction_EntityBean transactionBean =null;
					
			//To retieve data from datadase based on the amount passed in parameter .
			query = "select d.studentid,d.tdate,na.topup,na.quarterlybonus,"
				+ "na.annualbonus,sa.balance,sa.status from dontmodify d join"
				+ " nsepaccount na on na.studentid=d.studentid join "
				+ "studentaccountdetails sa on sa.studentid=d.studentid where "
				+ "d.amount='" + depositedAmount + "'";
			
		try {
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				transactionBean = new Transaction_EntityBean();
				transactionBean.setStudent_id(resultSet.getInt(1));
				transactionBean.setTransaction_date(resultSet.getString(2));
				transactionBean.setMonthly_topup(resultSet.getInt(3));
				transactionBean.setQuartely_bonus(resultSet.getInt(4));
				transactionBean.setAnnual_bonus(resultSet.getInt(5));
				transactionBean.setBalance(resultSet.getInt(6));
				transactionBean.setStatus(resultSet.getString(7));
				list.add(transactionBean);

			}
			//transactionBean=null;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		finally {
			logger.info("close resources");
			DBConnection.closeResources(connection, resultSet, statement);
		}
		return list;
	}

	/**
	 * getTransactionDetails() method is used for getting the details like 
	 * 	studentid, topup, bonuses, account balance and status based 
	 * deposited amount.
	 * 
	 * @param---------deposited month and year are passed as parameters. 
	 * 					This date is obtained from csv file.
	 * @return----------ArrayList
	 * @exception-------SQLException
	 * @since-----------1.5
	 * @see <reference to any other function called >
	 */
	public ArrayList<Transaction_EntityBean> getTransactionDetails(String month,
			String year) {
logger.info("reports based on month and year");
		String depositedMonth =null;
		//Assign the value obtained from the parameter.
		depositedMonth=month;
		String depositedYear =null;
		//Assign the value obtained from the parameter.
		depositedYear=year;
		String date =null;
		//create the variable in the form of date based on data from parameters.
		date="-" + depositedMonth + "-" + depositedYear;
		
		ArrayList<Transaction_EntityBean> list =null; 
		// create an arraylist of generic type as Transaction_EntityBean.
		list=new ArrayList<Transaction_EntityBean>();
		String query =null;
		
		//To retieve data from datadase based on the month and year passed in parameter .
		query = "select d.studentid,d.tdate,na.topup,na.quarterlybonus,"
				+ "na.annualbonus,sa.balance,sa.status from dontmodify d join"
				+ " nsepaccount na on na.studentid=d.studentid join "
				+ "studentaccountdetails sa on sa.studentid=na.studentid where"
				+ " d.tdate like '%" + date + "%'";

		try {
			
			statement = connection.createStatement();
			resultSet= statement.executeQuery(query);

			
			while (resultSet.next()) {
				Transaction_EntityBean transactionBean = 
					new Transaction_EntityBean();
				transactionBean.setStudent_id(resultSet.getInt(1));
				transactionBean.setTransaction_date(resultSet.getString(2));
				transactionBean.setMonthly_topup(resultSet.getInt(3));
				transactionBean.setQuartely_bonus(resultSet.getInt(4));
				transactionBean.setAnnual_bonus(resultSet.getInt(5));
				transactionBean.setBalance(resultSet.getInt(6));
				transactionBean.setStatus(resultSet.getString(7));
				list.add(transactionBean);

			}
			//transactionBean=null;
		} 		
		catch (SQLException e) {
			logger.error(e.getMessage());
		}
		finally {
			logger.info("close resources");
			DBConnection.closeResources(connection, resultSet, statement);
		}

		return list;
	}

	/**
	 * getTransactionByStudentId() method is used for getting the details like 
	 * 	studentid, topup, bonuses, account balance and status based 
	 * deposited amount.
	 * 
	 * @param---------Student ID is passed as a parameter. 	 		
	 * @return----------ArrayList
	 * @exception-------SQLException
	 * @since-----------1.5
	 * @see <reference to any other function called >
	 */
	public ArrayList<Transaction_EntityBean> getTransactionByStudentId(int id)
	{
logger.info("Reports based on studentId");
		int studentid = 0;
		//Assign the value obtained from the parameter.
		studentid = id; 

		ArrayList<Transaction_EntityBean> list =null; 
		// create an arraylist of generic type as Transaction_EntityBean.
			list=new ArrayList<Transaction_EntityBean>();
			String query = null;
			//To retieve data from datadase based on the month and year passed in parameter .
		query = "select d.studentid,d.tdate,na.topup,na.quarterlybonus,"
				+ "na.annualbonus,sa.balance,sa.status from dontmodify "
				+ "d join nsepaccount na on na.studentid=d.studentid join "
				+ "studentaccountdetails sa on sa.studentid=na.studentid where"
				+ " d.studentid='" + studentid + "'";

		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Transaction_EntityBean transactionBean = 
					new Transaction_EntityBean();
				transactionBean.setStudent_id(resultSet.getInt(1));
				transactionBean.setTransaction_date(resultSet.getString(2));
				transactionBean.setMonthly_topup(resultSet.getInt(3));
				transactionBean.setQuartely_bonus(resultSet.getInt(4));
				transactionBean.setAnnual_bonus(resultSet.getInt(5));
				transactionBean.setBalance(resultSet.getInt(6));
				transactionBean.setStatus(resultSet.getString(7));
				list.add(transactionBean);

			}
			//transactionBean=null;
		} catch (SQLException e) {
			logger.error(e.getMessage());
			
		} finally {
			logger.info("close resources");
			DBConnection.closeResources(connection, resultSet, statement);
		}

		return list;
	}

}
