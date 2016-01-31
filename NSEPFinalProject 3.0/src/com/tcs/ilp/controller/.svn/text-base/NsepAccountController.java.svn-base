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

import com.tcs.ilp.bean.NsepAccountBean;
import com.tcs.ilp.bean.StudentAccountBean;
import com.tcs.ilp.model.NsepAccountModel;
import com.tcs.ilp.utility.Constants;

/**
 * Servlet implementation class NsepAccountController NsepAccountController has
 * functions for creating,viewing, updating, deleting and viewallNsep Accounts
 * of NsepAccount.
 * 
 * @Author - A.S.L.Prasuna Devi(539389), K.Soumya Devi(539316)
 * @version -3.5.2
 * @Class name-NsepAccountController
 * @Creation Date-07/01/2012 @ History-
 * 
 **/
public class NsepAccountController extends HttpServlet {
	static final Logger logger = Logger.getLogger(NsepAccountModel.class);
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			int pageId = Integer.parseInt(request
					.getParameter(Constants.PAGE_ID));
			if (pageId == 6) {
				NsepAccountModel nsepAccountModel = new NsepAccountModel();

				ArrayList<NsepAccountBean> nsepAccountList = new ArrayList<NsepAccountBean>();
				nsepAccountList = nsepAccountModel.viewAllNsepUsers();
				logger.debug("ArrayList");
				if (nsepAccountList.size() > 0) {
					request.setAttribute("nsepAccountList", nsepAccountList);
					requestDispatcher = request
							.getRequestDispatcher(Constants.NSEP_VIEW_USERS);
				}

			}
		} catch (NullPointerException nullPointerException) {
			logger.error(nullPointerException.getMessage());
		}
		requestDispatcher.forward(request, response);
	}

	/**
	 * doPost(--) is the one of the method in the service method. here we are
	 * writing all the logic of the code to perform Nsep Account Creation,view
	 * Nsep Account, Update Nsep Account,Delete Nsep Account and View All Nsep
	 * Accounts fetching,updating and deleting.
	 * 
	 * @param---------dopost() all the logic of code present here for controller
	 * @return----------nothing
	 * @exception-------ServletException, IOException
	 * @since-----------3.5.2
	 * @see <reference to any other function called >
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// To store the pageid parameter
		try {
			int pageId = Integer.parseInt(request
					.getParameter(Constants.PAGE_ID));
			try {

				/**
				 * if pageId equals 1, then this block will be executed. Here
				 * when the student account number is given, it goes to the
				 * model and gets verified. Depending upon the return parameter,
				 * controller forwards to the respective page.
				 * 
				 */
				if (pageId == 1) {

					String criteria = request.getParameter(Constants.HIDDEN);

					if (criteria.equals(Constants.STUDENT_ACCOUNT_NUMBER)) {
						// To store parameter studentAccountNumber
						try {
							String studentAccountNumber = request
									.getParameter(Constants.STUDENT_ACCOUNT_NUMBER);

							// Instance of NsepAccountModel
							NsepAccountModel nsepAccountModel = new NsepAccountModel();
							// Instance of StudentAccountBean
							StudentAccountBean studentAccountBean = new StudentAccountBean();
							// Assigning the return value of the function
							studentAccountBean = nsepAccountModel
									.verifyStudentAccount(studentAccountNumber);

							if (studentAccountBean.getStudentId() != 0
									&& studentAccountBean.getStudentId() != -1) {
								request.setAttribute("studentAccountBean",
										studentAccountBean);
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_ACCOUNT_CREATE);

							} else if (studentAccountBean.getStudentId() == -1) {

								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_EXISTS);

							}

							else {
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_CREATE_NOTFOUND);
							}

							requestDispatcher.forward(request, response);
						} catch (NullPointerException nullPointerException) {
							logger.error(nullPointerException.getMessage());
						}

					}

					if (criteria.equals(Constants.NSEP_STUDENTID)) {
						try {
							int studentId = Integer.parseInt(request
									.getParameter(Constants.NSEP_STUDENTID));

							// Instance of NsepAccountModel
							NsepAccountModel nsepAccountModel = new NsepAccountModel();
							// Instance of StudentAccountBean
							StudentAccountBean studentAccountBean = new StudentAccountBean();
							// Assigning the return value of the function
						
							studentAccountBean = nsepAccountModel
									.verifyStudentAccount(studentId);
							if (studentAccountBean.getStudentId() != 0
									&& studentAccountBean.getStudentId() != -1) {
								request.setAttribute("studentAccountBean",
										studentAccountBean);
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_ACCOUNT_CREATE);

							} else if (studentAccountBean.getStudentId() == -1) {

								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_EXISTS);

							}

							else if (studentAccountBean.getStudentId() == 0) {
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_VIEW_NOTFOUND);
							}

							requestDispatcher.forward(request, response);
						} catch (NullPointerException nullPointerException) {
							logger.error(nullPointerException.getMessage());
						}
					}
				}

				/**
				 * if pageId equals 2, then this block will be executed. Here
				 * all the details from User Interface are taken and set those
				 * values to nsepaccountbean. Then this is sent to the
				 * nsepaccountmodel. Depending upon the return parameter,
				 * controller forwards to the respective page.
				 * 
				 */
				else if (pageId == 2)// create
				{
					Calendar cal = new GregorianCalendar(); // CREATING CALENDER
															// OBJECT
					String month1 = null;
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int month = cal.get(Calendar.MONTH) + 1;
					if (month < 9) {
						month1 = (String) ("0" + month);
					}
					int year = cal.get(Calendar.YEAR);
					String creationDate = day + "-" + month1 + "-" + year;

					// To store date
					String day1 = "01";
					// To store month
					String mon1 = "05";
					// To store year
					int year1 = 0000;
					try {
						// to store studentId parameter
						int studentId = Integer.parseInt(request
								.getParameter("studentId"));
						// to store studentAccountNumber1 parameter
						String studentAccountNum = request
								.getParameter("studentAccountNumber1");
						// to store committedAmount parameter
						int committedAmt = Integer.parseInt(request
								.getParameter("committedAmount"));

						// to store yearOfGraduation parameter

						String yearofstudy = request
								.getParameter("yearOfGraduation");

						if (yearofstudy.equalsIgnoreCase("First")) {
							year1 = year + 3;

						} else if (yearofstudy.equalsIgnoreCase("Second")) {
							year1 = year + 2;
						} else if (yearofstudy.equalsIgnoreCase("Third")) {
							mon1="11";
							year1 = year + 1;
						}

						// setting the enddate
						String endDate = day1 + "-" + mon1 + "-" + year1;
						// Instance of NsepAccountBean
						NsepAccountBean nsepAccountBean = new NsepAccountBean();
						// Instance of NsepAccountModel
						NsepAccountModel nsepAccountModel = new NsepAccountModel();
						// Setting the nsepAccountBean Object
						nsepAccountBean.setAccountBalance(0);
						nsepAccountBean.setTopup(0);
						nsepAccountBean.setQuarterlyBonus(0);
						nsepAccountBean.setAnnualBonus(0);
						nsepAccountBean.setStudentId(studentId);
						nsepAccountBean
								.setStudentAccountNumber(studentAccountNum);
						nsepAccountBean.setCommittedAmount(committedAmt);
						nsepAccountBean.setCreationDate(creationDate);
						nsepAccountBean.setEndDate(endDate);
						// To store the return value
						String nsepAccountNumber = nsepAccountModel
								.createNsepAccount(nsepAccountBean);
						if (nsepAccountNumber != null) {
							// setting the attribute nsepAccountNumber
							request.setAttribute("nsepAccountNumber",
									nsepAccountNumber);

							requestDispatcher = request
									.getRequestDispatcher(Constants.NSEP_CREATE_SUCCESS);
						} else
							requestDispatcher = request
									.getRequestDispatcher(Constants.NSEP_CREATE_ERROR);
						requestDispatcher.forward(request, response);
					} catch (NullPointerException nullPointerException) {
						logger.error(nullPointerException.getMessage());
					}
				}
				/**
				 * if pageId equals 3, then this block will be executed. Here
				 * when the student Id is given, it goes to the model and gets
				 * verified. Depending upon the return parameter, controller
				 * forwards to the respective page.
				 * 
				 */
				else if (pageId == 3)// view
				{
					String criteria = request.getParameter(Constants.HIDDEN);

					if (criteria.equals(Constants.NSEP_ACCOUNT_NUMBER)) {
						try {
							// To store the student id
							String nsepAccountNumber = request
									.getParameter("nsepAccountNumber");

							if (nsepAccountNumber != null) {
								// Instance for NsepAccountBean
								NsepAccountBean nsepAccountBean = new NsepAccountBean();
								// Instance for NsepAccountModel
								NsepAccountModel nsepAccountModel = new NsepAccountModel();
								// Returning object is stored in nsepAccountBean
								nsepAccountBean = nsepAccountModel
										.viewNsepAccountDetails(nsepAccountNumber);
								// To store the student id obtained from
								// nsepAccountBean
								int studentid1 = nsepAccountBean.getStudentId();
								if (studentid1 != 0) {
									// Setting the attribute nsepAccountBean
									request.setAttribute("nsepAccountBean",
											nsepAccountBean);
									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_VIEW_DETAILS);

								} else
									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_DELETE_NOTFOUND);
							}
							requestDispatcher.forward(request, response);
						} catch (NullPointerException nullPointerException) {
							logger.error(nullPointerException.getMessage());
						}
					}
					if (criteria.equals(Constants.NSEP_STUDENTID)) {
						try {
							// To store the student id
							int studentId = Integer.parseInt(request
									.getParameter("studentId"));

							if (studentId != 0) {
								// Instance for NsepAccountBean
								NsepAccountBean nsepAccountBean = new NsepAccountBean();
								// Instance for NsepAccountModel
								NsepAccountModel nsepAccountModel = new NsepAccountModel();
								// Returning object is stored in nsepAccountBean
								nsepAccountBean = nsepAccountModel
										.viewNsepAccountDetails(studentId);
								// To store the student id obtained from
								// nsepAccountBean
								int studentid1 = nsepAccountBean.getStudentId();
								if (studentid1 != 0) {
									// Setting the attribute nsepAccountBean
									request.setAttribute("nsepAccountBean",
											nsepAccountBean);
									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_VIEW_DETAILS);

								} else
									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_VIEW_NOTFOUND);
							}
							requestDispatcher.forward(request, response);
						} catch (NullPointerException nullPointerException) {
							logger.error(nullPointerException.getMessage());
						}
					}
				}
				/**
				 * if pageId equals 5, then this block will be executed. Here
				 * when the student Id is given, it goes to the model and gets
				 * verified. Depending upon the return parameter, controller
				 * forwards to the respective page.
				 * 
				 */
				else if (pageId == 5)// delete
				{

					// To perform operations basing upon this value
					int flag = 0;
					try {
						// To store the Student Id
						int studentId = Integer.parseInt(request
								.getParameter("studentId"));

						if (studentId != 0) {
							// Instance for NsepAccountModel
							NsepAccountModel nsepAccountModel = new NsepAccountModel();
							// Return value is stored in flag
							flag = nsepAccountModel
									.deleteNsepAccount(studentId);

							if (flag == 1) {
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_DELETE_SUCCESS);

							} else if (flag == 2)
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_DELETE_IMPOSSIBLE);

							else if (flag == 3)
								requestDispatcher = request
										.getRequestDispatcher(Constants.NSEP_DELETE_ERROR);
						}
						requestDispatcher.forward(request, response);
					}

					catch (NullPointerException nullPointerException) {
						logger.error(nullPointerException.getMessage());
					}
				}

				/**
				 * if pageId equals 4, then this block will be executed. Here
				 * when the Nsep account number is given, it goes to the model
				 * and gets verified. Depending upon the return parameter,
				 * controller forwards to the respective page.
				 * 
				 */

				else if (pageId == 4) { // Delete View
					String criteria = request.getParameter(Constants.HIDDEN);

					if (criteria.equals(Constants.NSEP_ACCOUNT_NUMBER)) {
						try {
							// To store the NsepAccountNumber
							String nsepAccountNumber = request
									.getParameter("nsepAccountNumber");

							if (nsepAccountNumber != null) {
								// Instance for NsepAccountModel
								NsepAccountModel nsepAccountModel = new NsepAccountModel();
								// Instance for NsepAccountBean
								NsepAccountBean nsepAccountBean = new NsepAccountBean();
								// Return value is nsepAccountBean

								nsepAccountBean = nsepAccountModel
										.deleteViewNsep(nsepAccountNumber);
								// To store the student id
								int studentId = nsepAccountBean.getStudentId();
								// if studentId is not equals to zero
								if (studentId != 0) {

									request.setAttribute("nsepAccountBean",
											nsepAccountBean);

									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_DELETE_VIEW);

								} else

									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_DELETE_NOTFOUND);

							}
							requestDispatcher.forward(request, response);
						} catch (NullPointerException nullPointerException) {
							logger.error(nullPointerException.getMessage());
						}
					}
					if (criteria.equals(Constants.NSEP_STUDENTID)) {
						try {
							// To store the NsepAccountNumber
							int studentId = Integer.parseInt(request
									.getParameter("studentId"));

							if (studentId != 0) {
								// Instance for NsepAccountModel
								NsepAccountModel nsepAccountModel = new NsepAccountModel();
								// Instance for NsepAccountBean
								NsepAccountBean nsepAccountBean = new NsepAccountBean();
								// Return value is nsepAccountBean

								nsepAccountBean = nsepAccountModel
										.deleteViewNsep(studentId);
								// To store the student id
								studentId = nsepAccountBean.getStudentId();
								// if studentId is not equals to zero
								if (studentId != 0) {

									request.setAttribute("nsepAccountBean",
											nsepAccountBean);

									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_DELETE_VIEW);

								} else

									requestDispatcher = request
											.getRequestDispatcher(Constants.NSEP_VIEW_NOTFOUND);

							}
							requestDispatcher.forward(request, response);
						} catch (NullPointerException nullPointerException) {
							logger.error(nullPointerException.getMessage());
						}
					}

				}
				/**
				 * if pageId equals 7, then this block will be executed. Here
				 * when the student Id is given, it goes to the model and gets
				 * verified. Depending upon the return parameter, controller
				 * forwards to the respective page.
				 * 
				 */

				else if (pageId == 7) {

					try {
						// To keep the Student Id
						int studentId = Integer.parseInt(request
								.getParameter("studentId"));
						// To Keep the Remarks
						String remarks = request.getParameter("remarks");
						// Instance for NsepAccountModel
						NsepAccountModel nsepAccountModel = new NsepAccountModel();
						// To store the result of the returned value
						int flag = nsepAccountModel.updateNsepAccount(
								studentId, remarks);
						if (flag == 1) {
							requestDispatcher = request
									.getRequestDispatcher(Constants.NSEP_UPDATE_SUCCESS);
						} else
							requestDispatcher = request
									.getRequestDispatcher(Constants.NSEP_UPDATE_FAILURE);

						requestDispatcher.forward(request, response);
					}

					catch (NullPointerException nullPointerException) {
						nullPointerException.printStackTrace();
					}
				}

			} catch (NullPointerException nullPointerException) {
				logger.error(nullPointerException.getMessage());
			}

		} catch (NullPointerException nullPointerException) {
			logger.error(nullPointerException.getMessage());
		}
	}
}
