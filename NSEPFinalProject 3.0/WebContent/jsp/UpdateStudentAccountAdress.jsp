<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/Validatestudentaddress.js">

</script>
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
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Updation</p></strong></center>
				

	<%ArrayList<StudentAccountBean> list1= new ArrayList<StudentAccountBean>(); %>
<%StudentAccountBean s=new StudentAccountBean(); %>
<%list1=(ArrayList<StudentAccountBean>)request.getAttribute("student");%>
<%Iterator iterator1 = list1.iterator(); 
if(iterator1.hasNext())
{
	s=(StudentAccountBean)iterator1.next();
	
}%>
<br></br>
<center><h4 style="font-size:17px;color: #f0a108;letter-spacing: -1px;">Student Details</h4></center>
<center>
	<form  name="nsep" action="<%=request.getContextPath()%>/StudentAccountController?pageid=8" onsubmit="return validate()" method="post" >
		<table border="0" cellspacing="10">
				 
				<tr><td align="right"><strong>Student Name:</strong></td> <td align="left"><%=s.getStudentName()%> </td> </tr> 
				<tr><td align="right"><strong>Student ID:</strong></td> <td align="left"><%=s.getStudentId()%></td></tr>
				<tr><td align="right"><strong>Address:</strong> </td><td align="left"><%=s.getAddress() %></td></tr> 
				
				<tr><td><strong align="right">New Address:</strong></td> <td align="left"><textarea name="address" rows="6" cols="30"></textarea>  </td> </tr> 
				<tr><td><input name="studentid" type="hidden" value=<%=s.getStudentId()%>></input></td></tr>
		</table>
		</center>
		<CENTER>
   <input  type="submit" value="Submit"></input> &nbsp;&nbsp;
<input type="reset" value="Reset"></input>
</CENTER>
	</form>
</div>
<!-- END DESCRIPTION --> 
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> <br>

<jsp:include page="Footer.jsp"></jsp:include>


