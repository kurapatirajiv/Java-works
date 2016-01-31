package com.tcs.ilp.utility;

public interface Constants {
	String PAGE_ID = "pageid";
	String STUDENT_ID = "studentid";
	String STATUS_CLOSED = "closed";
	String STATUS_OPEN = "open";;
	String BANK = "bank";
	String ADDRESS = "address";
	String MESSAGE_ERROR = "Sorry! Record does not exist.";
	String MULTIPLE_RECORDS="Multiple records exist.";
	String STUDENT_NAME = "studentName";
	String MESSAGE = "Updated successfully!";
	String STUDENT_SEARCH_ID = "/jsp/StudentDetailsSucess.jsp";
	String STUDENT_NOT_PRESENT = "/jsp/StudentDetailsFailure.jsp";
	String STUDENT_DELETE_SEARCH = "/jsp/DeleteStudentDetails.jsp";
	String STUDENT_DELETE_SEARCH_FAIL = "jsp/StudentNotPresent.jsp";
	String STUDENT_DELETE_SUCESS = "/jsp/StudentAccountDeleteSuccess.jsp";
	String STUDENT_DELETE_FAILURE = "/jsp/StudentAccountDeleteFailure.jsp";
	String STUDENT_ACCOUNT_DETAILS = "/jsp/StudentAccountDetailsSucess.jsp";
	String STUDENT_ACCOUNT_DETAILS_FAIL = "/jsp/StudentAccountDetailsFailure.jsp";
	String STUDENT_VIEW = "/jsp/ViewStudentDetailsSucess.jsp";
	String FAILURE_VIEW = "/jsp/Failure_viewStudent.jsp";
	String FAILURE_UPDTAE = "/jsp/Failure_UpdateStudent.jsp";
	String STUDENT_UPDATE = "/jsp/StudentAccountUpdateDetails.jsp";
	String STUDENT_UPDATE_ADRESS = "/jsp/UpdateStudentAccountAdress.jsp";
	String STUDENT_UPDATE_SUCESS = "/jsp/StudentAccountUpdateSucess.jsp";
	String MORE_RECORDS="/jsp/StudentViewMultipleRecords.jsp";
	String VIEW_ALL_ACCOUNTS="/jsp/ViewAllStudentAccounts.jsp";
	// NSEP Constants
	String STUDENT_ACCOUNT_NUMBER = "studentAccountNumber";
	String NSEP_STUDENTID = "studentId";
	String NSEP_ACCOUNT_NUMBER = "nsepAccountNumber";
	String NSEP_ACCOUNT_CREATE = "/jsp/NsepCreatePg2.jsp";
	String NSEP_CREATE_NOTFOUND = "/jsp/NsepCreatepg1NotFound.jsp";
	String NSEP_EXISTS = "/jsp/NsepCreatepg1Exists.jsp";
	String NSEP_CREATE_SUCCESS = "/jsp/NsepCreateSuccess.jsp";
	String NSEP_CREATE_ERROR = "/jsp/NsepCreateFailed.jsp";
	String NSEP_VIEW_NOTFOUND = "/jsp/ViewNsepNotFound.jsp";
	String NSEP_VIEW_DETAILS = "/jsp/ViewNsepDetails.jsp";
	String NSEP_VIEW_USERS = "/jsp/ViewNsepUsers.jsp";
	String NSEP_UPDATE_SUCCESS = "/jsp/NsepUpdateSuccess.jsp";
	String NSEP_UPDATE_FAILURE = "/jsp/NsepUpdateFailure.jsp";
	String NSEP_DELETE_VIEW = "/jsp/DeleteNsepDetails.jsp";
	String NSEP_DELETE_ERROR = "/jsp/NsepDeleteFailed.jsp";
	String NSEP_DELETE_SUCCESS = "/jsp/NsepDeleteSuccess.jsp";
	String NSEP_DELETE_NOTFOUND = "/jsp/NsepDeleteNotFound.jsp";
	String NSEP_DELETE_IMPOSSIBLE = "/jsp/NsepDeleteNotPossible.jsp";
	String NSEP_QUERY1 = "select studentacctnum from nsepaccount where studentacctnum=?";
	String NSEP_QUERY11 = "select studentid from nsepaccount where studentid=?";
	String NSEP_QUERY12 = "select sa.studentid,sa.studentaccountnumber," +
			"sd.yearofgraduation from studentaccountdetails sa join " +
			"studentdetails sd on sa.studentid=sd.studentid where sa.studentid=?";
	String NSEP_QUERY2 = "select studacct.studentid,studacct.studentaccountnumber,studdetails.yearofgraduation from "
			+ "studentaccountdetails studacct join studentdetails studdetails on"
			+ " studacct.studentid=studdetails.studentid where studentaccountnumber=?";
	String NSEP_QUERY3 = "insert into nsepaccount values(?,?,?,?,?,?,?,?,?,?,?,?) ";
	String NSEP_QUERY4 = "select * from nsepAccount where studentid=?";
	String NSEP_QUERY5 = "select * from nsepaccount where nsepacctnum=?";
	String NSEP_QUERY6 = "select status,studentid,nsepacctnum from nsepaccount where studentid=?";
	String NSEP_QUERY7 = "delete from nsepaccount where studentid=?";
	String NSEP_QUERY8 = "insert into nseparchive values(?,?)";
	String NSEP_QUERY9 = "select studentid,nsepacctnum,accountbalance,committedamt from nsepaccount";
	String NSEP_QUERY10 = "update nsepAccount set remarks=? where studentid=?";

	String VIEW_RECORDS = "/jsp/viewRecordDetails.jsp";
	String VIEW_RECORDS1 = "/jsp/viewRecordDetails1.jsp";
	String VIEW_RECORDS_ERROR = "/jsp/TransactionError.jsp";
	String ID = "id";
	String READTABLE = "readtable";
	String HIDDEN = "hidden_crit";
	String DATE = "date";
	String MONTH = "month";
	String YEAR = "year";
	String AMOUNT = "amount";
	String STUDENTID = "stuid";
	String REPORTS = "/jsp/Reports.jsp";
	String READCSV = "readcsv";
	String REPORTSERROR = "/jsp/ReportsError.jsp";
	double ANNUALBONUSINTEREST = 0.10;
	double QUARTERLYBONUSINTEREST = 0.10;
	double TOPUPINTEREST = 0.25;
	String TRANSACTION_QUERY = "select d.studentid,na.topup,na.quarterlybonus,"
			+ "na.annualbonus,sa.balance,sa.status from dontmodify d join"
			+ " nsepaccount na on na.studentid=d.studentid join "
			+ "studentaccountdetails sa on sa.studentid=d.studentid where "
			+ "d.amount=?";
	String TRANSACTION_QUERY1 = "select d.studentid,na.topup,na.quarterlybonus,"
			+ "na.annualbonus,sa.balance,sa.status from dontmodify d join"
			+ " nsepaccount na on na.studentid=d.studentid join "
			+ "studentaccountdetails sa on sa.studentid=na.studentid where"
			+ " d.tdate like '%?'";
	String TRANSACTION_QUERY2 = "select d.studentid,na.topup,na.quarterlybonus,"
			+ "na.annualbonus,sa.balance,sa.status from dontmodify "
			+ "d join nsepaccount na on na.studentid=d.studentid join "
			+ "studentaccountdetails sa on sa.studentid=na.studentid where"
			+ " d.studentid=?";
	String TRANSACTION_JOIN = "select t.studentid,t.amount,b.balance"
			+ "t.sdate,t.tdate,n.committedamt,n.enddate from "
			+ "dontmodify t,studentaccountdetails b,nsepaccount n"
			+ " where t.studentid=b.studentid and" + " t.studentid=n.studentid";
	String TRANSACTION_INSERT = "insert into dontmodify "
			+ "values(?,?,?,?,?,?,?)";

}
