<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
    <%@page import="java.util.ArrayList" %>
     <%@page import="java.util.Iterator" %>
    <%@page import="com.tcs.ilp.bean.StudentAccountBean" %>
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Updation</p></strong></center>

<%ArrayList<StudentAccountBean> list= new ArrayList<StudentAccountBean>(); %>
<%StudentAccountBean s=new StudentAccountBean(); %>
<%list=(ArrayList<StudentAccountBean>)request.getAttribute("student");%>
<%Iterator iterator = list.iterator(); 
while(iterator.hasNext())
{
	s=(StudentAccountBean)iterator.next();
	
}


%>
<center><h4 style="font-size:17px;color: #f0a108;letter-spacing: -1px;">Student Details</h4></center>
<form  name="nsep" action="<%=request.getContextPath()%>/StudentAccountController?pageid=7" method="post">
<table border="0" bordercolor="black"  cellpadding="5" cellspacing="10" align="center">
		 
		 <tr><td><strong>Student Name:</strong></td> <td ><%=s.getStudentName()%> </td> </tr> 
		 <tr><td><strong>Student ID:</strong></td> <td><%=s.getStudentId()%></td></tr>
		 <tr><td><strong>College:</strong> </td><td><%=s.getCollege() %></td></tr> 
		 <tr><td><strong>Address:</strong> </td><td><%=s.getAddress() %></td></tr> 
		 <tr><td><strong>Bank ID:</strong> </td><td><%=s.getBankId() %></td></tr> 
		 <tr><td><strong>Bank Name: </strong></td><td><%=s.getBankName() %></td></tr>
		  <tr><td><strong>Account Number:</strong></td><td><%=s.getStudentAccountNumber() %></td></tr>
		 <tr><td><strong>Balance:</strong></td><td><%=s.getBalance() %></td></tr>
		 <tr><td><input name="studentid" type="hidden" value=<%=s.getStudentId()%>></input></td></tr>
</table>

<center>
    <input  type="submit" value="Update"></input>&nbsp;&nbsp;
		 <input type="button" value="Cancel" onClick="javascript:window.location='jsp/UpdateStudentBankAccount.jsp';" />
</center>
</form>
</div>

<!-- END DESCRIPTION --> 


<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> <br>
<jsp:include page="Footer.jsp"></jsp:include>

