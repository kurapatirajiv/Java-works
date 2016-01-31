/**
 * Author:Team B.     
 * Version:1.0      
 * Class name:LoginController
 * Creation Date:06-01-2012
 * History:LoginController is needed to login into the NSEP application.
 */

package com.tcs.ilp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.model.LoginModel;

public class LoginController extends HttpServlet {
	// for logger class
	static final Logger logger = Logger.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	// to dispatch to particular jsp page
	RequestDispatcher requestDispatcher;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// to store username.
		String userName = request.getParameter("userName");
		// to store password.
		String password = request.getParameter("password");
		// object for LoginModel class.
		LoginModel loginModel = new LoginModel();
		// to store the return value from fuction checkin(userName, password).
		String flag = loginModel.checkin(userName, password);

		logger.debug("DATABASE CONNECTION ESTABLISHED!n\n");

		if (flag.equals("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("Active", 1);
			session.setMaxInactiveInterval(1200);
			requestDispatcher = request
					.getRequestDispatcher("/jsp/HomePage.jsp");
		} else {
			requestDispatcher = request
					.getRequestDispatcher("/jsp/InvalidLogin.jsp");
		}
		requestDispatcher.forward(request, response);
	}

}
