	/**
	 * The descriptive text that explaining the purpose and use of the class.
	 * 
	 * @author - B.Navya, P.Maha Lakshmi, K.Rajiv.
	 * @version -3.5.2
	 * @Class name-TransactionController
	 * @Creation Date-09/01/2012
	 *  @ History-To direct from controller to model based on id readcsv or
	 *  			 readtable and to redirect the page to JSP pages based 
	 *  				on value returned.
	 */


package com.tcs.ilp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.ilp.bean.Transaction_EntityBean;
import com.tcs.ilp.model.Readcsvfile;
import com.tcs.ilp.model.TransactionModel;
import com.tcs.ilp.utility.Constants;


public class TransactionController extends HttpServlet {
	static final Logger logger =Logger.getLogger(TransactionController.class); 
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher=null;
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
			{
try
{
if (request.getParameter(Constants.ID) != null) 
{
	ArrayList<Object> arrayList=new ArrayList<Object>();
	String action = request.getParameter(Constants.ID);
	if(action.equalsIgnoreCase(Constants.READCSV)){
		
		Readcsvfile readcsvFile=new Readcsvfile();
		arrayList=  readcsvFile.uploadCSV(request,response);
      if(arrayList.size()!=0)
      {
        request.setAttribute("arrayList", arrayList);
        requestDispatcher = request.getRequestDispatcher(Constants.REPORTS);
      }
      else
      {
    	  requestDispatcher = request.getRequestDispatcher(Constants.REPORTSERROR);
      }
      requestDispatcher.forward(request, response);
	}
	if (action.equalsIgnoreCase(Constants.READTABLE)) 
	{
		if(request.getParameter(Constants.HIDDEN)!=null)
		{
		String criteria = request.getParameter(Constants.HIDDEN);
		if (criteria.equals(Constants.DATE)) 
		{			
			String month =null;//To get month details.
			String year=null;//To get year details.
			if(request.getParameter(Constants.MONTH)!=null)
			{
				month=request.getParameter(Constants.MONTH);
			}
			if(request.getParameter(Constants.YEAR)!=null)
			{
				year = request.getParameter(Constants.YEAR);
			}
			TransactionModel transactionModel = new TransactionModel();
			ArrayList<Transaction_EntityBean> transactionList=null;
			//create a arraylist of type transaction_EntityBean.
			transactionList=new ArrayList<Transaction_EntityBean>();
			//call getTransactionDetails(String,String)in transactionModel
			//with return type as arraylist.
			try{
			transactionList = transactionModel.
									getTransactionDetails(month,year);
			if (transactionList.size()!=0) 
			{
				request.setAttribute("transactionList", transactionList);				
				requestDispatcher = request.getRequestDispatcher
									(Constants.VIEW_RECORDS);
							
			}
			else{
				requestDispatcher= request.getRequestDispatcher
									(Constants.VIEW_RECORDS_ERROR);
				
			}	
			requestDispatcher.forward(request, response);
			transactionModel=null;
			}
			catch(NullPointerException npe)
			{
				logger.error(npe.getMessage());
			}
			

		}

		if (criteria.equals(Constants.AMOUNT)) 
		{
			int amount = 0;//To get amount details.
			if(request.getParameter(Constants.AMOUNT)!=null)
			{
				amount=Integer.parseInt(request.getParameter(Constants.AMOUNT));
			}
			TransactionModel transactionModel = new TransactionModel();
			ArrayList<Transaction_EntityBean> transactionList=null;
			//create a arraylist of type transaction_EntityBean.
			transactionList=new ArrayList<Transaction_EntityBean>();
			//call getTransactionDetails(int)in transactionModel
			//with return type as arraylist.
			try
			{
			transactionList = transactionModel.getTransactionDetails(amount);
			
			if (transactionList.size()!=0) 
			{
				request.setAttribute("transactionList", transactionList);				
				requestDispatcher= request.getRequestDispatcher
											(Constants.VIEW_RECORDS);
				
			}
			else{
				requestDispatcher= request.getRequestDispatcher
										(Constants.VIEW_RECORDS_ERROR);
				
			}
			requestDispatcher.forward(request, response);
			transactionModel=null;
			}
			catch(NullPointerException npe)
			{
				logger.error(npe.getMessage());
			}
		}
		if (criteria.equals(Constants.STUDENTID)) 
		{			
			int studentid = 0;//To get details based on studentid.
			if(request.getParameter(Constants.STUDENTID)!=null)
			{
				studentid=Integer.parseInt(request.getParameter
									(Constants.STUDENTID));	
			}
		
			TransactionModel transactionModel = new TransactionModel();
			ArrayList<Transaction_EntityBean> transactionList=null;
			//create a arraylist of type transaction_EntityBean.
			transactionList=new ArrayList<Transaction_EntityBean>();
			//call getTransactionByStudentId(int)in transactionModel
			//with return type as arraylist.
			try
			{
			transactionList = transactionModel.getTransactionByStudentId
														(studentid);
			
			if (transactionList.size()!=0) 
			{
				request.setAttribute("transactionList", transactionList);				
				requestDispatcher= request.getRequestDispatcher
								(Constants.VIEW_RECORDS);
				
			}
			else{
				requestDispatcher= request.getRequestDispatcher
									(Constants.VIEW_RECORDS_ERROR);
				
			}
			requestDispatcher.forward(request, response);
			transactionModel=null;
			}
			catch(NullPointerException nullPointerException)
			{
				logger.error(nullPointerException.getMessage());
			}

		}
		}

	}
}
			}
	catch(NullPointerException nullPointerException)
	{
		logger.error(nullPointerException.getMessage());
	}
			}

}
