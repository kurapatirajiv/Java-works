/**

 * Author:V.Kali,B.HimaSudha,P.Madhuri.     
 * Version:1.0      
 * Class name:StudentAccountController
 * Creation Date:06-01-2012
 * History:To navigate the control from user interface to back end functions this controller is needed.
 */

package com.tcs.ilp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.tcs.ilp.bean.StudentAccountBean;

import com.tcs.ilp.model.StudentAccountModel;
import com.tcs.ilp.utility.Constants;

public class StudentAccountController extends HttpServlet
{
	static final Logger logger =Logger.
							getLogger(StudentAccountController.class);
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher requestDispatcher;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			int pageId = Integer.parseInt(request
					.getParameter(Constants.PAGE_ID));
			if (pageId == 6) {
				StudentAccountModel studentAccountModel = new StudentAccountModel();

				ArrayList<StudentAccountBean> studentAccountList = new ArrayList<StudentAccountBean>();
				studentAccountList = studentAccountModel.viewAllAccounts();
				logger.debug("ArrayList");
				if (studentAccountList.size() > 0) {
					request.setAttribute("studentAccountList", studentAccountList);
					requestDispatcher = request
							.getRequestDispatcher(Constants.VIEW_ALL_ACCOUNTS);
				}

			}
		} catch (NullPointerException nullPointerException) {
			logger.error(nullPointerException.getMessage());
		}
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		/*Stores page id.*/
		int pid = Integer.parseInt(request.getParameter(Constants.PAGE_ID));

		if (pid == 1)
		{
			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();
			
			studentAccountBean.setStudentId(studentId);

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();
			
			try 
			{
				/*Array list which holds the object of StudentAccountBean*/
				ArrayList<StudentAccountBean> arrayList = studentAccountModel
						.getStudentDetails(studentAccountBean);

				if (arrayList.size() > 0) 
				{
					request.setAttribute("arrayList", arrayList);
					
					requestDispatcher = request.getRequestDispatcher
													(Constants.STUDENT_SEARCH_ID);

				}

				else 
				{
					requestDispatcher = request.getRequestDispatcher
												(Constants.STUDENT_NOT_PRESENT);

				}
				
				requestDispatcher.forward(request, response);
			} 
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

		
		}

		if (pid == 2)
		{
			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();
			
			studentAccountBean.setStudentId(studentId);

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountDAO = new StudentAccountModel();
			
			try
			{
				ArrayList<StudentAccountBean> arrayList = studentAccountDAO
						.getStudentAccountDetails(studentAccountBean);
				
				if (arrayList.size() > 0)
				{
					request.setAttribute("arrayList", arrayList);
					
					requestDispatcher = request.getRequestDispatcher
											(Constants.STUDENT_DELETE_SEARCH);
				}

				else
				{
					requestDispatcher = request.getRequestDispatcher
											(Constants.STUDENT_DELETE_SEARCH_FAIL);
				}
				
				requestDispatcher.forward(request, response);
			}
			
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

		}

		if (pid == 3)
		{
			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));
			
			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();
			
			studentAccountBean.setStudentId(studentId);

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountDAO = new StudentAccountModel();
			
			try 
			{
				studentAccountBean =  studentAccountDAO
						.deleteStudentAccount(studentAccountBean);
				
				String accountStatus = studentAccountBean.getAccountStatus();

				if (accountStatus.equals(Constants.STATUS_CLOSED))
				{
					requestDispatcher = request.getRequestDispatcher
											(Constants.STUDENT_DELETE_SUCESS);
				}

				else
				{
					request.setAttribute("studentAccountBean2",
							studentAccountBean);
					
					requestDispatcher = request.getRequestDispatcher
											(Constants.STUDENT_DELETE_FAILURE);
				}
				
				requestDispatcher.forward(request, response);
			}
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}


		}

		if (pid == 4)
		{

			/*Stores bank name*/
			String bankName = request.getParameter(Constants.BANK);
			
			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));
			
			/*Stores student name*/
			String studentName = request.getParameter(Constants.STUDENT_NAME);
			
			/*Stores balance of bank account*/
			float balance = 0;
			
			/*Stores status of the bank account*/
			String status = Constants.STATUS_OPEN;
			
			/*Stores student account number*/
			String studentAccountNumber;

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();

			studentAccountBean.setBankName(bankName);

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();
			
			try 
			{

				studentAccountModel.getBankId(studentAccountBean);

				/*Stores bank id*/
				int bankId = studentAccountBean.getBankId();

				studentAccountNumber = studentAccountModel
						.generateAcccountNumber(studentId);
				
				Calendar calender = new GregorianCalendar(); // CREATING CALENDER OBJECT
				
				String month1=null;
				
				int day = calender.get(Calendar.DAY_OF_MONTH);
				
				int month = calender.get(Calendar.MONTH) + 1;
				
				if(month<9)
				{
				 month1=(String)("0" + month);
				}
				
				int year = calender.get(Calendar.YEAR);
				
				String dateOfCreation = day + "-" + month1 + "-" + year;

				/*Stores number of rows effected in database*/
				int numberOfRowsEffected = studentAccountModel.
							    updateStudentAccountNumber(studentAccountNumber,
								studentId, studentName, bankId, bankName,
								balance, status,dateOfCreation);

				/*Array list which stores elements of string type*/
				ArrayList<String> arrayList = new ArrayList<String>();

				arrayList.add(studentName);
				
				arrayList.add(Integer.toString(studentId));
				
				arrayList.add(bankName);
				
				arrayList.add(studentAccountNumber);
				
				arrayList.add(Float.toString(balance));
				
				arrayList.add(status);
				
				arrayList.add(dateOfCreation);
				
				

				if (numberOfRowsEffected != 0)
				{
					request.setAttribute("arrayList", arrayList);
					
					requestDispatcher = request.getRequestDispatcher
										(Constants.STUDENT_ACCOUNT_DETAILS);
				}

				else 
				{

					requestDispatcher = request.getRequestDispatcher
									(Constants.STUDENT_ACCOUNT_DETAILS_FAIL);
				}
				
				requestDispatcher.forward(request, response);
			} 
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

		}
		
		if (pid == 5)
		{
			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));

			/*Stores error message*/
			String errorMessage = Constants.MESSAGE_ERROR;

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();

			studentAccountBean.setStudentId(studentId);
			
			/*Array list which holds object of StudentAccountBean*/
			ArrayList<StudentAccountBean> arrayList =
											new ArrayList<StudentAccountBean>();

			try 
			{
				arrayList = studentAccountModel.view(studentAccountBean);
			} 
			catch (NullPointerException nullPointerException) 
			{
				nullPointerException.printStackTrace();
			}
			if (arrayList.isEmpty())
			{
				request.setAttribute("report", errorMessage);
				
				requestDispatcher = request
						.getRequestDispatcher(Constants.FAILURE_VIEW);

			}

			else
			{
				request.setAttribute("student", arrayList);
				
				requestDispatcher = request
						.getRequestDispatcher(Constants.STUDENT_VIEW);
			}
			
			requestDispatcher.forward(request, response);
			
	
		}
		
		if (pid == 6)
		{
			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));
			
			/*Stores error message*/
			String errorMessage = Constants.MESSAGE_ERROR;

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();
			
			/*Array list which holds object of StudentAccountBean*/
			ArrayList<StudentAccountBean>
							arrayList = new ArrayList<StudentAccountBean>();

			studentAccountBean.setStudentId(studentId);

			try
			{
				arrayList = studentAccountModel.view(studentAccountBean);
			} 
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

			if (arrayList.isEmpty())

			{
				request.setAttribute("report", errorMessage);
				
				requestDispatcher = request
					.getRequestDispatcher(Constants.FAILURE_UPDTAE);
			}
			
			else
			{
				request.setAttribute("student", arrayList);
				
				requestDispatcher = request
						.getRequestDispatcher(Constants.STUDENT_UPDATE);
			}
			
			requestDispatcher.forward(request, response);
			
		
		}

		if (pid == 7)
		{

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();

			/*Stores student id*/
			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));

			studentAccountBean.setStudentId(studentId);

			/*Array list which holds object of StudentAccountBean*/
			ArrayList<StudentAccountBean> arrayList =
										new ArrayList<StudentAccountBean>();

			try 
			{
				arrayList = studentAccountModel.view(studentAccountBean);

			} 
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}
			request.setAttribute("student", arrayList);
			
			requestDispatcher = request
					.getRequestDispatcher(Constants.STUDENT_UPDATE_ADRESS);
			
			requestDispatcher.forward(request, response);
			


		}

		if (pid == 8)
		{

			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();

			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();

			/*Stores the address of student*/
			String address = request.getParameter(Constants.ADDRESS);

			/*Stores error message*/
			String message = Constants.MESSAGE;

			ArrayList<StudentAccountBean> arrayList = 
											new ArrayList<StudentAccountBean>();

			int studentId = Integer.parseInt(request
					.getParameter(Constants.STUDENT_ID));

			studentAccountBean.setStudentId(studentId);

			try 
			{
				studentAccountModel.updateStudentAccount
									(address,studentId);
			} 
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

			try
			{
				arrayList = studentAccountModel.view(studentAccountBean);
			}
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

			request.setAttribute("student", arrayList);
			
			request.setAttribute("message", message);
			
			requestDispatcher = request
					.getRequestDispatcher(Constants.STUDENT_UPDATE_SUCESS);
			
			requestDispatcher.forward(request, response);
			


		}

		if (pid == 9)
		{
			/*Object of StudentAccountBean */
			StudentAccountBean studentAccountBean = new StudentAccountBean();
			
			String name = request.getParameter("name");
			
			/*Object of StudentAccountModel*/
			StudentAccountModel studentAccountModel = new StudentAccountModel();

			/*Stores date of birth of student*/
			String dob = request.getParameter("dob");
					

			/*Stores error message*/
			String message = "Sorry! Record does not exist.";
			
			

			studentAccountBean.setStudentName(name);

			studentAccountBean.setDob(dob);
			
			/*Array list which holds object of StudentAccountBean*/
			ArrayList<StudentAccountBean> arrayList = new ArrayList<StudentAccountBean>();

			try
			{
				arrayList = studentAccountModel.view(studentAccountBean);

			} 
			catch (NullPointerException nullPointerException)
			{
				nullPointerException.printStackTrace();
			}

			try {

				if (arrayList.isEmpty())
				{
					request.setAttribute("report", message);
					
					requestDispatcher = request
							.getRequestDispatcher(Constants.FAILURE_VIEW);

				} 
				else if(arrayList.size()>1)
				{
										
					request.setAttribute("report", Constants.MULTIPLE_RECORDS);
					request.setAttribute("student", arrayList);
					requestDispatcher = request
							.getRequestDispatcher(Constants.MORE_RECORDS);

				}
				else
				{
				
					request.setAttribute("student", arrayList);
					
					requestDispatcher = request
							.getRequestDispatcher(Constants.STUDENT_VIEW);
				}
				
				requestDispatcher.forward(request, response);
			} 
			catch (NullPointerException nullPointerException) 
			{
				nullPointerException.printStackTrace();
			}
			
		

		}
	}

}
