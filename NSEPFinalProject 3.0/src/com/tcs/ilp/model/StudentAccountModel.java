/**
 * Author: V.Kali,B.HimaSudha,P.Madhuri     
 * Version:1.0      
 * Class name:StudentAccountDAO
 * Creation Date:05-01-2012
 * History: This class is used to get details of student from student details
 * and has functionalities like creation of bank account,view details of bank
 * account,update details of bank account and deletion of bank account.
 */

package com.tcs.ilp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.ilp.bean.StudentAccountBean;
import com.tcs.ilp.utility.DBConnection;

public class StudentAccountModel 
{
	static final Logger logger =Logger.
								getLogger(StudentAccountModel.class);
	
	/*Initializing statement*/
	Statement statement = null;
	
	/*Initializing prepared statement*/
	PreparedStatement preparedStatement = null;

	/*Initializing result set*/
	ResultSet resultSet = null;
	
	/*Initializing connection*/
	Connection connection = DBConnection.getConnection();
	
	

	/**
	 * This function is used to get student details from student details table in database.
	 * Parameters used:
	 * studentid(int): used to store student id.
	 * sqlQuery(String): used to store the SQL query.
	 * arrayList(StudentAccountBean):used to store the object of StudentAccountBean class.
	 * 
	 * Return type:An object of StudentAccountBean 
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public ArrayList<StudentAccountBean> getStudentDetails(
			StudentAccountBean studentAccountBean)
	{
		/*Array list which holds the object of StudentAccountBean*/
		ArrayList<StudentAccountBean> arrayList =
			                           new ArrayList<StudentAccountBean>();

		try 
		{

			/*Stores student id*/
			int studentId = studentAccountBean.getStudentId();
			
			/*Stores SQL query*/
			String sqlQuery = "select * from StudentDetails " +
					                          "where studentid="+studentId;

			
			statement=connection.createStatement();
			
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next())
			{
				
				
				studentAccountBean.setStudentId(resultSet.getInt("studentid"));
				
				studentAccountBean.setStudentName(resultSet
						                          .getString("studentname"));
				
				studentAccountBean.setCollege(resultSet.getString("college"));
				
				studentAccountBean.setYearOfGraduation(resultSet
						                       .getString("yearofgraduation"));
				
				arrayList.add(studentAccountBean);

			}

		}

		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally
		{
			DBConnection.closeResources(connection, resultSet, statement);
		}

		return arrayList;

	}

	/**
	 * This function is used to get student account details from database.
	 * Parameters used:
	 * studentid(int): used to store student id.
	 * sqlQuery(String): used to store the SQL query.
	 * arrayList(StudentAccountBean):used to store the object of StudentAccountBean class.
	 * 
	 * Return type:An object of StudentAccountBean 
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public ArrayList<StudentAccountBean> getStudentAccountDetails(
			StudentAccountBean studentAccountBean)
	{

		/*Array list which holds the object of StudentAccountBean*/
		ArrayList<StudentAccountBean> arrayList = new ArrayList<StudentAccountBean>();

		try 
		{

			/*Stores student id*/
			int studentId = studentAccountBean.getStudentId();
			
			
			/*Stores SQL query*/
			String sqlQuery = "select * from StudentAccountDetails" +
					                            " where studentid="+studentId;
			
			statement=connection.createStatement();
			
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next())
			{
				
				studentAccountBean.setBankId(resultSet.getInt("bankid"));
				
				studentAccountBean
						          .setBankName(resultSet.getString("bankname"));
				
				studentAccountBean.setStudentId(resultSet.getInt("studentid"));
				
				studentAccountBean.setStudentName(resultSet
						                             .getString("studentname"));
				
				studentAccountBean.setStudentAccountNumber(resultSet
						                    .getString("studentaccountnumber"));
				
				studentAccountBean.setDateOfCreation(resultSet
	                    .getString("dateofcreation"));
				
				studentAccountBean.setBalance(resultSet
	                    .getFloat("balance"));

				
				arrayList.add(studentAccountBean);

			}

		}

		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}

		finally 
		{
			DBConnection.closeResources(connection, resultSet,statement);
		}

		return arrayList;

	}

	/**
	 * This function is used to delete student account details and student details from database.
	 * Parameters used:
	 * studentid(int): used to store student id.
	 * sqlQuery(String): used to store the SQL query.
	 * arrayList(StudentAccountBean):used to store the object of StudentAccountBean class.
	 * 
	 * Return type:An object of StudentAccountBean 
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public StudentAccountBean deleteStudentAccount(
			StudentAccountBean studentAccountBean) {

		
		try {

			/*Stores student id*/
			int studentId = studentAccountBean.getStudentId();

			/*Stores SQL query*/
			String sqlQuery = "select * from StudentAccountDetails" +
				              " where studentid="+studentId;

			statement=connection.createStatement();
			
			resultSet = statement.executeQuery(sqlQuery);

			resultSet.next();
			
			/*Stores account status*/
			String accountStatus = resultSet.getString("status");

			if (accountStatus.equals("closed"))
			{
				/*Stores SQL query*/
				String sqlQuery3 = "Delete from StudentAccountDetails" +
						           " where studentid="+studentId;
				
				/*Stores SQL query*/
				String sqlQuery4="Delete from StudentDetails" +
						         " where studentid="+studentId;
				
				statement=connection.createStatement();
				
				statement.executeUpdate(sqlQuery3);
				
				statement.executeUpdate(sqlQuery4);
				
				studentAccountBean.setAccountStatus(accountStatus);
			}

			else 
			{

				studentAccountBean.setAccountStatus(accountStatus);

			}

		}

		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally
		{
			DBConnection.closeResources(connection, resultSet, statement);
		}

		return studentAccountBean;

	}

	/**
	 * This function is used to get bank id from database.
	 * Parameters used:
	 * bankName(String): Used to store bank name.
	 * sqlQuery(String): Used to store the SQL query.
	 * arrayList(StudentAccountBean):used to store the object of StudentAccountBean class.
	 * 
	 * Return type:void
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public void getBankId(StudentAccountBean studentAccountBean)
	{

		try 
		{

			/*Stores bank name*/
			String bankName = studentAccountBean.getBankName();
			
			/*Stores SQL query*/
			String sqlQuery = "select bankid,bankname from bankdetails" +
					          " where bankname='"+bankName+"'";
			
			statement=connection.createStatement();
			
			resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) 
			{
				studentAccountBean.setBankId((resultSet.getInt("bankid")));
				
				studentAccountBean
						.setBankName((resultSet.getString("bankname")));
			}

		}

		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally 
		{
			DBConnection.closeResources(connection, resultSet,statement);
		}

	}

	/**
	 * This function is used to generate account number.
	 * Parameters used:
	 * number(String):To store a number 
	 * accountnumber(String):To store account number.
	 * id(String):To store student id
	 * 
	 * Return type:String
	 * Since:Version 1.6
	 * 
	 */

	public String generateAcccountNumber(int studentId)
	{
		/*Stores a number*/
		String number = "217316001";
		
		String accountNumber;
		
		String id = Integer.toString(studentId);
		
		accountNumber = number + id;
		
		return accountNumber;
	}

	/**
	 * This function is used to update student account details.
	 * Parameters used:
	 * studentAccountNumber(String):stores student account number.
	 * studentId(int):Stores student id.
	 * studentName(String):Stores student name.
	 * bankId(int):Stores bank id.
	 * bankName(String): Used to store student id.
	 * balance(float):Stores balance of student account.
	 * status(String):Stores status of student account. 
	 * sqlQuery(String): used to store the SQL query.
	 * arrayList(StudentAccountBean):used to store the object of StudentAccountBean class.
	 * 
	 * Return type:int
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public int updateStudentAccountNumber(String studentAccountNumber,
											int studentId, String studentName,
											int bankId, String bankName,
											float balance, String status, String dateOfCreation)
	{
		int numberOfRowsEffected = 0;
		
		Connection connection1 = DBConnection.getConnection();
		try
		{
            
			String Query="select studentid from studentaccountdetails where studentid="+studentId;
			
			statement=connection1.createStatement();
			resultSet=statement.executeQuery(Query);
			
			if(!resultSet.next())
			{
			String sqlQuery = "Insert into StudentAccountDetails values(?,?,?,?,?,?,?,?)";
			
			preparedStatement = connection1.prepareStatement(sqlQuery);
			
			preparedStatement.setString(1, studentAccountNumber);
			
			preparedStatement.setInt(2, studentId);
			
			preparedStatement.setString(3, studentName);
			
			preparedStatement.setInt(4, bankId);
			
			preparedStatement.setString(5, bankName);
			
			preparedStatement.setFloat(6, balance);
			
			preparedStatement.setString(7, status);
			
			preparedStatement.setString(8, dateOfCreation);
			
			numberOfRowsEffected = preparedStatement.executeUpdate();
			
			}

		} 
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
			finally 
			{
				DBConnection.closeResources(connection1, resultSet,preparedStatement);
			}
	
			return numberOfRowsEffected;

	}

	/**
	 * This function is used to view student details from database.
	 * Parameters used:
	 * studentId(int): Used to store student id.
	 * studentName(String):Used to store student name.
	 * dob(string):used to store date of birth of student.
	 * sqlQuery(String): used to store the SQL query.
	 * arrayList(StudentAccountBean):used to store the object of StudentAccountBean class.
	 * 
	 * Return type:void
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public ArrayList<StudentAccountBean> view(StudentAccountBean
															studentAccountBean) 
	{

		/*Get connection to database*/
		Connection connection1 = DBConnection.getConnection();
		
		/*Stores student id*/
		int studentId = studentAccountBean.getStudentId();

		/*Stores student name*/
		String studentName = studentAccountBean.getStudentName();

		/*Stores date of birth of student*/
		String dob = studentAccountBean.getDob();

		/*Object of StudentAccountBean*/
		

		/*Array List which holds the object of student account bean*/
		ArrayList<StudentAccountBean> arrayList = new ArrayList<StudentAccountBean>();

		//ArrayList<StudentAccountBean> nullArrayList = new ArrayList<StudentAccountBean>();

		String sqlQuery = null;

		try 
		{

			if (studentId == 0)
			{
				sqlQuery = "select s.studentid,s.studentname,s.address," +
						   "s.college,a.bankid,a.studentaccountnumber,a.dateofcreation," +
						   "a.balance,a.status,b.bankname from studentdetails s"
					     + " left join studentaccountdetails a on " +
					       "s.studentid=a.studentid left join bankdetails b on" +
						   " a.bankid=b.bankid where s.studentname='"+studentName+
						   "' and s.dateofbirth='"+dob+"'";
						
				
			}

			else 
			{
				sqlQuery = "select s.studentid,s.studentname,s.address," +
						   "s.college,a.bankid,a.studentaccountnumber,a.dateofcreation"
						+  ",a.balance,a.status,b.bankname from studentdetails"
					    +  " s left join studentaccountdetails a on" +
					       " s.studentid=a.studentid left join bankdetails b"
						+ " on a.bankid=b.bankid where s.studentid="+studentId;
			

			}

			statement=connection1.createStatement();
			
		    resultSet = statement.executeQuery(sqlQuery);
		    
		    

			while (resultSet.next()) 
			{
				StudentAccountBean studentAccountBean2 = new StudentAccountBean();
				studentAccountBean2.setStudentId(resultSet.getInt("studentid"));
				
				studentAccountBean2.setStudentName(resultSet
						.getString("studentname"));
				
				studentAccountBean2.setAddress(resultSet.getString("address"));
				
				studentAccountBean2.setCollege(resultSet.getString("college"));
				
				studentAccountBean2.setBankId(resultSet.getInt("bankid"));
				
				studentAccountBean2
						.setBankName(resultSet.getString("bankname"));
				
				studentAccountBean2.setAccountStatus(resultSet
						.getString("status"));
				
				studentAccountBean2.setStudentAccountNumber(resultSet
						.getString("studentaccountnumber"));
				
				studentAccountBean2.setBalance(resultSet.getInt("balance"));
				
				studentAccountBean2
				.setDateOfCreation(resultSet.getString("dateofcreation"));
				
				arrayList.add(studentAccountBean2);

			}

				

			
		} 
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally 
		{
			DBConnection.closeResources(connection1, resultSet,statement);
		}
	
		//if(studentAccountBean2.getStudentId()!=0)
		//{
	
			return arrayList;
		//}
		//else
		//{
			//return nullArrayList;
		//}
		
	}

	/**
	 * This function is used to update student account.
	 * Parameters used:
	 * studentAddress(String): Used to store student address.
	 * studentId(int):Used to store student id.
	 * sqlQuery(String): used to store the SQL query.
	 * 
	 * Return type:void
	 * Exception: SQL Exception 
	 * Since:Version 1.6
	 * 
	 */

	public void updateStudentAccount(String studentAddress, int studentId)
	{

		
		
		try
		{
			String sqlQuery = "update StudentDetails set address=" +
					          "'"+studentAddress+"' where studentid="+studentId;
						
			statement=connection.createStatement();
			
			statement.executeUpdate(sqlQuery);
		} 
		
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally 
		{
			DBConnection.closeResources(connection, resultSet,statement);
		}
	}

	
	public ArrayList<StudentAccountBean> viewAllAccounts() {
		
		ArrayList<StudentAccountBean> studentAccountList = new ArrayList<StudentAccountBean>();

		try {
			
			statement = connection.createStatement();
			String sql="select s.studentname,s.studentid,s.address," +
					"a.studentaccountnumber,a.balance " +
					"from studentdetails s join studentaccountdetails a" +
					" on s.studentid=a.studentid";
			
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				
				StudentAccountBean studentAccountBean = new StudentAccountBean();
				
				studentAccountBean.setStudentName(resultSet.getString("studentname"));
				studentAccountBean.setStudentId(resultSet.getInt("studentid"));
				studentAccountBean.setStudentAccountNumber(resultSet
						.getString("studentaccountnumber"));
				studentAccountBean.setBalance(resultSet
						.getFloat("balance"));
				studentAccountBean.setAddress(resultSet.getString("address"));
				
				
				studentAccountList.add(studentAccountBean);
			}
		} catch (SQLException e) {

			logger.error(e.getMessage());
		} finally {// Closing the resources
			 logger.info("Closing Resources");
			DBConnection.closeResources(connection, resultSet,
				statement);
		}
		return studentAccountList;
	}

}