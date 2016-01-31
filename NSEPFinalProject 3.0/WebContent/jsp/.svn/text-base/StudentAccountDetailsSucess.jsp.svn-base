<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>
<%@page import="java.util.ArrayList"%>



<!-- START CONTAINER ABOUT -->
<div id="containerAbout">
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>
<!-- DESCRIPTION -->
<div class="rightAbout"><br></br>
<center><strong>
<p style="font-size: 25px; letter-spacing: -1px;">Bank Account
Creation</p>
</strong></center>

<%
	ArrayList arrayList = (ArrayList) (request
			.getAttribute("arrayList"));
%>
<center>
<h4
	style="font-size: 17px; color: #f0a108; margin: 20px 0 30px 0; letter-spacing: -1px;">Bank
Account Details</h4>
</center>
<form name="studentdetails" method="post">





<table border=0 cellpadding="20" cellspacing="10" align="center">

	<tr>
		<td><b>Student Name:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(0)%></td>
	</tr>
	<tr>
		<td><b>Student Id:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(1)%></td>
	</tr>
	<tr>
		<td><b>Bank Name:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(2)%></td>
	</tr>
	<tr>
		<td><b> Student Account Number:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(3)%></td>
	</tr>
	<tr>
		<td><b> Balance:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(4)%></td>
	</tr>
	<tr>
		<td><b> Account Status:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(5)%></td>
	</tr>
	<tr>
		<td><b> Date Of Creation:</b></td>
		<td>&nbsp; &nbsp;<%=arrayList.get(6)%></td>
	</tr>

</table>
</form>
</div>
<!-- END DESCRIPTION -->


<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>
<jsp:include page="Footer.jsp"></jsp:include>




