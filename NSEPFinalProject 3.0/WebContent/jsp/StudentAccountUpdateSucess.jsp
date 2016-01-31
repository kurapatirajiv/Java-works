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
<br></br>

<%ArrayList<StudentAccountBean> list1= new ArrayList<StudentAccountBean>(); %>
<%StudentAccountBean s=new StudentAccountBean(); %>
<%list1=(ArrayList<StudentAccountBean>)request.getAttribute("student");%>
<%Iterator iterator1 = list1.iterator(); 
if(iterator1.hasNext())
{
	s=(StudentAccountBean)iterator1.next();
	
}%>

<%String m=(String)request.getAttribute("message"); %>

<center><h4 style="font-size:17px;color: #f0a108;letter-spacing: -1px;">Updated Successfully</h4></center>

<table border="0" bordercolor="black"  cellpadding="5" cellspacing="10" align="center">
		 
		 <tr><td><strong>Student Name:</strong></td> <td><%=s.getStudentName()%> </td> </tr> 
		 <tr><td><strong>Student ID:</strong></td> <td><%=s.getStudentId()%></td></tr>
		 <tr><td><strong>Address: </strong></td><td><%=s.getAddress() %></td></tr> 
		 <tr><td><strong>Bank Name:</strong></td><td><%=s.getBankName() %></td></tr>
		 <tr><td><strong>Bank ID:</strong></td><td><%=s.getBankId() %></td></tr>
		 <tr><td><strong>Account Number:</strong></td><td><%=s.getStudentAccountNumber() %></td></tr>
		 <tr><td><strong>Balance:</strong></td><td><%=s.getBalance() %></td></tr>
		 
		   
</table>
<form>
<center><input type="button" name="print" value="Print" onclick="window.print()" class="button" /></center>
</form>
</div>

<!-- END DESCRIPTION --> 

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> <br>
<jsp:include page="Footer.jsp"></jsp:include>

