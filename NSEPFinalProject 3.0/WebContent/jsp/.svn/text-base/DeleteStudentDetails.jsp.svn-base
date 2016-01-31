<jsp:include page="Header.jsp"></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tcs.ilp.bean.StudentAccountBean"%>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>


<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Deletion</p></strong></center>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%> <%
 	ArrayList list = (ArrayList) request.getAttribute("arrayList");
 	String studentName = "";
 	int studentId = 0;
 	int bankId = 0;
 	String bankName = "";
 	String accountNumber = "";
 	String date="";
 	float balance=0;

 	Iterator itr = list.iterator();
 	
 	while (itr.hasNext()) {
 		StudentAccountBean ab = (StudentAccountBean) (itr.next());
 		bankId = ab.getBankId();
 		bankName = ab.getBankName();
 		studentName = ab.getStudentName();
 		studentId = ab.getStudentId();
 		accountNumber = ab.getStudentAccountNumber();
 		date=ab.getDateOfCreation();
 		balance=ab.getBalance();

 	}
 %>

<center><h4 style="font-size:17px;color: #f0a108;letter-spacing: -1px;">Student Details</h4></center>
<center>
<form method="post" action="<%=request.getContextPath()%>/StudentAccountController?pageid=3">
<table border=0 cellpadding="20" cellspacing="10" align="center">



	<tr>
		<th align="left">Student Id:</th>
		<td align="left"><%=studentId%></td>
	</tr>

	<tr>
		<th align="left">Student Name:</th>
		<td align="left"><%=studentName%></td>
	</tr>
	<tr>
		<th align="left">Bank Name:</th>
		<td align="left"><%=bankName%></td>
	</tr>

	<tr>
		<th align="left">Student Account Number:</th>
		<td align="left"><%=accountNumber%></td>
	</tr>
	
	<tr>
		<th align="left">Date Of Creation:</th>
		<td align="left"><%=date%></td>
	</tr>
	
	<tr>
		<th align="left">Balance:</th>
		<td align="left"><%=balance%></td>
	</tr>

</table>
<input type="hidden" name="studentid" value="<%=studentId%>" /> <br></br>
<center><input type="submit" value="Delete" />&nbsp;&nbsp;
<input type="button" value="Cancel" onClick="javascript:window.location='jsp/DeleteStudentAccount.jsp';">
</center>
</form>
</div>
<!-- END DESCRIPTION --> <!-- SHORT NEWS FROM TWITTER -->

<!-- END SHORT NEWS FROM TWITTER -->
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<jsp:include page="Footer.jsp"></jsp:include>