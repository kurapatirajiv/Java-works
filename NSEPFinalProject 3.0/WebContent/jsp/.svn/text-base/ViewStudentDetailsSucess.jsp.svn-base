<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>


    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.Iterator" %>
   <%@page import="com.tcs.ilp.bean.StudentAccountBean" %>

<!-- START CONTAINER ABOUT -->
			<div id="containerAbout">
			<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
            </div>

				<!-- DESCRIPTION -->
				<div class="rightAbout">
				<br></br>
               <center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account View</p></strong></center>		
				
				
<%ArrayList<StudentAccountBean> list1= new ArrayList<StudentAccountBean>(); %>
<%StudentAccountBean s=new StudentAccountBean(); %>
<%list1=(ArrayList<StudentAccountBean>)request.getAttribute("student");%>
<%Iterator iterator1 = list1.iterator(); 
if(iterator1.hasNext())
{
	s=(StudentAccountBean)iterator1.next();
	
}

%>
<pre>
<center><h4 style="font-size:17px;color: #f0a108;letter-spacing: -1px;">Student Details</h4></center></pre>

<%if(s.getBankName()==null)
	{%>
	<center><br></br>
<table border="0" cellpadding="5" cellspacing="10">
	
		 <tr><td align="left"><STRONG>Student Name:</STRONG></td> <td align="left" ><%=s.getStudentName()%> </td> </tr> 
		 <tr><td align="left"><STRONG>Student ID:</STRONG></td> <td align="left"><%=s.getStudentId()%></td></tr>
		 <tr><td align="left"><STRONG>Address: </STRONG></td><td align="left"><%=s.getAddress() %></td></tr> 
		 <tr><td align="left"><strong>College:</strong></td><td align="left"><%=s.getCollege() %></td></tr>
		 <caption align="bottom">STUDENT DOES NOT HAVE A BANK ACCOUNT</caption>			
		  
</table>
<a  href="jsp/CreateStudentAccount.jsp">Click here to create bank account</a>  
</center>
<%}
else
{
%>
<center>
<table border="0" bordercolor="black"  cellpadding="5" cellspacing="10" >
	
		 <tr><td align="left"><STRONG>Student Name:</STRONG></td> <td align="left"><%=s.getStudentName()%> </td> </tr> 
		 <tr><td align="left"><STRONG>Student ID:</STRONG></td> <td align="left"><%=s.getStudentId()%></td></tr>
		 <tr><td align="left"><STRONG>Address: </STRONG></td><td align="left"><%=s.getAddress() %></td></tr> 
		 <tr><td align="left"><STRONG>Bank Name:</STRONG></td><td align="left"><%=s.getBankName() %></td></tr>
		 <tr><td align="left"><STRONG>Bank ID:</STRONG></td><td align="left"><%=s.getBankId() %></td></tr>
		 <tr><td align="left"><STRONG>Account Number:</STRONG></td><td align="left"><%=s.getStudentAccountNumber() %></td></tr>
		  <tr><td align="left"><STRONG>Account Status:</STRONG></td><td align="left"><%=s.getAccountStatus() %></td></tr>
		 <tr><td align="left"><STRONG>Date Of Creation:</STRONG></td><td align="left"><%=s.getDateOfCreation() %></td></tr>
		 <tr><td align="left"><STRONG>Balance:</STRONG></td><td align="left"><%=s.getBalance() %></td></tr>
		 
		   
</table></center>
<form>
<center><input type="button" name="print" value="Print" onclick="window.print()" class="button" /></center>
</form>
<%} %>

</div>
<!-- END DESCRIPTION --> 
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> <br>
<jsp:include page="Footer.jsp"></jsp:include>


