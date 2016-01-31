/*
 * 
 * 
 * 
 File for calculating topUp, Annual,QuarterlyBonus and Updating them to their Respective Nsep accounts;
 
 Author : K.RAJIV,MahaLakshmi
 
 Batch  :H80
 
 Module: Transaction Management
 
 Creation Date: Jan 16 2012
  
  
 * 
 * 
 */

package com.tcs.ilp.model;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.ilp.utility.DBConnection;
import com.tcs.ilp.utility.Constants;

/*
 * 
 Read CSV file for Inserting data from the csv file to the data base

 return type: void

 Exceptions: SQLException

 functions called :setTopUp returns void


 */

public class Readcsvfile implements Constants {
	static final Logger logger = Logger.getLogger(Readcsvfile.class);
	Connection connection = DBConnection.getConnection();
	PreparedStatement preparedstatement;

	static int startyear = 0, transactionyear = 0;
	/*
	 * Startyear,startday,startmonth: represent the starting date of the student
	 * account
	 * 
	 * transactionyear,transactionday,transactionmonth:represent the Transaction
	 * date of the student where the student deposited the money
	 */
	static int startmonth = 0, transactionmonth = 0;
	static int startday = 0, transactionday = 0;

	static float topup = 0;
	static float quarterlybonus = 0;
	static float annualbonus = 0;
	static int studentidnumber = 0;
	static int flag = 0;
	// studentidnumber number for student identification

	static int depositedamount = 0;
	// amount deposited by the student for the particular month

	/*
	 * 
	 * topup: represent the topup calcualated to the student present month
	 * Quarterlybonus: represents the Quaterly bonus calcualated to the student
	 * Annualbonus: represent theAnnual bonus calcualated to the student topup:
	 * represent the topup calcualated to the student present month
	 */

	String filename = null;
	String name = null;
	// for storing the filename of the file uploaded

	float balance = 0;

	// For storing current balance of the student present in the bank account

	public ArrayList<Object> uploadCSV(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException

	{

		String contentType = request.getContentType();
		// To Store the content type of the form
		String saveFile = null;
		// Temporary to store name of the file along with MIME type
		ArrayList<Object> returnlist = new ArrayList<Object>();
		// Arraylist to store values for returning in the reports page
		// such as number of records and filename,path

		// Temporary to store name of the file
		int lineNumber = 0;
		// To Number of lines the controller read in the csv file
		/*
		 * Here we are checking the content type is not equal to Null and as
		 * well as the passed data from multi-part/form-data is greater than or
		 * equal to 0
		 */
		if ((contentType != null)
				&& (contentType.indexOf("multipart/form-data") >= 0)) {

			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			// this loop converting the uploaded file into byte code
			while (totalBytesRead < formDataLength) {
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
				totalBytesRead += byteRead;
			}
			String file = new String(dataBytes);
			// for saving the file name
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			// for getting the name of the file
			name = saveFile.substring(0, saveFile.indexOf("\n"));
			name = name.substring(name.lastIndexOf("\\") + 1, name
					.indexOf("\""));
			filename = name;

			int t = saveFile.indexOf("\n") - 2; // for getting the path of the
			// file

			saveFile = saveFile.substring(0, t);

		}// end of if

		try {
			String csvname = filename;
			// temporary variable for storing the filename
			String query = "select studentid from dontmodify d where d.filename=?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, csvname);
			ResultSet resultset1 = preparedstatement.executeQuery();
			if (!resultset1.next()) {

				BufferedReader br = new BufferedReader(new FileReader(saveFile));
				String strLine = "";
				StringTokenizer stringtokenizer = null;
				strLine = br.readLine(); // for omitting the header of the file
				while ((strLine = br.readLine()) != null) {
					lineNumber++;
					// break comma separated line using ","
					stringtokenizer = new StringTokenizer(strLine, ",");
					// Populating CSV file data into database table
					while (stringtokenizer.hasMoreTokens()) {
						logger.info("insert csv file data into table");
						String sqlQuery = "insert into dontmodify "
								+ "values(?,?,?,?,?,?,?)";
						preparedstatement = connection
								.prepareStatement(sqlQuery);

						preparedstatement.setInt(1, Integer
								.parseInt(stringtokenizer.nextToken()));
						preparedstatement.setInt(2, Integer
								.parseInt(stringtokenizer.nextToken()));
						preparedstatement.setInt(3, Integer
								.parseInt(stringtokenizer.nextToken()));
						preparedstatement.setInt(4, Integer
								.parseInt(stringtokenizer.nextToken()));
						preparedstatement.setString(5, stringtokenizer
								.nextToken());
						preparedstatement.setString(6, stringtokenizer
								.nextToken());
						preparedstatement.setString(7, name);

						preparedstatement.executeUpdate();

					}

				}
				// End of main while

				returnlist.add(lineNumber);
				returnlist.add(saveFile);
				returnlist.add(name);

				setTopUp();
			}

		}// End of try block

		catch (SQLException e) {
			e.printStackTrace();
		}

		return returnlist;

	}// function upload

	/*
	 * 
	 * SetTopup calculates the topup and bonuses of the every student present in
	 * the transaction table
	 * 
	 * return type: void
	 * 
	 * Exceptions: SQLException
	 * 
	 * functions called :UpdateAccount returns void
	 */
	public void setTopUp() {

		/*
		 * for calculating topup,bonuses
		 */
		logger.info("Top up, bonus calculation started");
		try {
			Calendar cal = new GregorianCalendar(); // CREATING CALENDER OBJECT

			int presentday = cal.get(Calendar.DAY_OF_MONTH);
			int presentmonth = cal.get(Calendar.MONTH) + 1;
			int presentyear = cal.get(Calendar.YEAR);

			int temp = 0;

			// for calculating bonuses
			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select t.studentid,t.amount,"
							+ "t.sdate,t.tdate,t.filename,n.committedamt,n.enddate,b.balance from "
							+ "dontmodify t,studentaccountdetails b,nsepaccount n"
							+ " where t.studentid=b.studentid and"
							+ " t.studentid=n.studentid and t.filename like '"
							+ name + "'");
			while (resultset.next()) {

				studentidnumber = resultset.getInt("studentid");

				depositedamount = resultset.getInt("amount");
				balance = resultset.getFloat("balance");

				String stempdate = resultset.getString("sdate");
				int camount = resultset.getInt("committedamt");

				startday = Integer.parseInt(stempdate.substring(0, 2));
				startmonth = Integer.parseInt(stempdate.substring(3, 5));
				startyear = Integer.parseInt(stempdate.substring(6, stempdate
						.length()));

				String enddate = resultset.getString("enddate");
				int endday = 0;
				int endmonth = 0;
				int endyear = 0;

				endday = Integer.parseInt(enddate.substring(0, 2));
				endmonth = Integer.parseInt(enddate.substring(3, 5));
				endyear = Integer.parseInt(enddate.substring(6, stempdate
						.length()));

				String transactiondate = resultset.getString("tdate");

				transactionday = Integer.parseInt(transactiondate.substring(0,
						2));
				transactionmonth = Integer.parseInt(transactiondate.substring(
						3, 5));
				transactionyear = Integer.parseInt(transactiondate.substring(6,
						transactiondate.length()));

				if ((presentyear != endyear) && (presentmonth != endmonth)
						&& (presentday != endday)) {

					if ((startyear == presentyear - 1)
							&& (presentmonth == startmonth)
							&& (presentday == startday)) {
						logger.info("into bonus condition");
						annualbonus = (balance >= 12 * (camount)) ? (float) (12 * camount * ANNUALBONUSINTEREST)

								: 0;

					}

					if (presentyear == startyear) {
						temp = presentmonth - startmonth;
						if (temp % 3 == 0) {
							quarterlybonus = (balance >= 3 * (camount)) ? (float) (3 * camount * QUARTERLYBONUSINTEREST)
									: 0;

						}
					}

					if (presentyear > startyear) {

						if (startyear == (presentyear - 1)) {
							temp = 12 - startmonth;
							temp = presentmonth + temp;

							if (temp % 3 == 0) {

								quarterlybonus = (balance >= 3 * (depositedamount)) ? (float) (3 * camount * QUARTERLYBONUSINTEREST)
										: 0;

							}
						}
						// if the admin wants calculate all the quaterly bonuses
						// at a
						// time
						if (startyear == (presentyear - 2)) {
							temp = 12 - startmonth;
							temp = presentmonth + temp + 12;

							if (temp % 3 == 0) {
								quarterlybonus = (balance >= 3 * (depositedamount)) ? (float) (3 * camount * QUARTERLYBONUSINTEREST)
										: 0;

							}
						}

					}

					// for calculating top-up
					if (transactionyear == presentyear
							|| transactionyear == presentyear - 1) {

						if (transactionmonth == presentmonth) {

							if (transactionday <= 20) {

								topup = (depositedamount >= camount) ? (float) (camount * TOPUPINTEREST)
										: 0;

							}

						}
						if (transactionmonth == presentmonth - 1) {

							if (transactionday > 21) {

								topup = (depositedamount >= camount) ? (float) (camount * TOPUPINTEREST)
										: 0;

							}

						}
					}

					UpdateAccount();

				}// end if
				else {
					Statement statusstatement = connection.createStatement();
					String UpdateStatus = "update nsepaccount set status='close'  where studentid='"
							+ studentidnumber + "'";
					statusstatement.executeUpdate(UpdateStatus);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Top up, bonus calculation completed");
	}

	/*
	 * 
	 * SetTopup calculates the topup and bonuses of the every student present in
	 * the transaction table
	 * 
	 * return type: void
	 * 
	 * Exceptions: SQLException
	 * 
	 * functions called :None
	 */

	public void UpdateAccount() {

		/*
		 * Function to Update topups,bonuses to the respective Students
		 */
		try {
			Statement st = connection.createStatement();
			String UpdateQuery = "select topup,quarterlybonus,annualbonus from "
					+ "nsepaccount where studentid='" + studentidnumber + "'";
			ResultSet resultset1 = st.executeQuery(UpdateQuery);
			if (resultset1.next()) {
				topup += resultset1.getInt("topup");
				quarterlybonus += resultset1.getInt("quarterlybonus");
				annualbonus += resultset1.getInt("annualbonus");

			}

			String Query = "update nsepaccount set topup='" + topup
					+ "',quarterlybonus='" + quarterlybonus + "',annualbonus='"
					+ annualbonus + "' where studentid='" + studentidnumber
					+ "'";
			st.executeUpdate(Query);

			String getBalance = "select balance from studentaccountdetails where studentid='"
					+ studentidnumber + "'";

			ResultSet resultset2 = st.executeQuery(getBalance);
			if (resultset2.next()) {
				depositedamount += resultset2.getFloat("balance");

			}
			// update balance in studentbank account
			String Updatebalance = "update studentaccountdetails set balance='"
					+ depositedamount + "'  where studentid='"
					+ studentidnumber + "'";
			st.executeUpdate(Updatebalance);

			float nsepbalance = 0;
			nsepbalance = topup + quarterlybonus + annualbonus;

			String Updatensepbalance = "update nsepaccount set accountbalance='"
					+ nsepbalance
					+ "'  where studentid='"
					+ studentidnumber
					+ "'";
			st.executeUpdate(Updatensepbalance);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Balance updated");
	}

} // end of class

