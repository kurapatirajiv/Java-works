<jsp:include page="Header.jsp"></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tcs.ilp.bean.StudentAccountBean"%>

<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>

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
	ArrayList arrayList = (ArrayList) request.getAttribute("arrayList");
	String studentName = "";
	String college = "";
	String yearOfGraduation = "";
	int studentId = 0;

	Iterator iterator = arrayList.iterator();

	while (iterator.hasNext()) {
		StudentAccountBean studentAccountBean = (StudentAccountBean) (iterator
				.next());
		studentName = studentAccountBean.getStudentName();
		studentId = studentAccountBean.getStudentId();
		college = studentAccountBean.getCollege();
		yearOfGraduation = studentAccountBean.getYearOfGraduation();
	}
%> <br></br>
<center>
<form method="post"
	action="<%=request.getContextPath()%>/StudentAccountController?pageid=4">
<h4 style="font-size: 17px; color: #f0a108; letter-spacing: -1px;">Student
Details</h4>

<table border=0 cellpadding="5" cellspacing="10">

	<tr>
		<th align="left">Student Id:</th>
		<td align="left">&nbsp; &nbsp;<%=studentId%></td>
	</tr>

	<tr>
		<th align="left">Student Name:</th>
		<td align="left">&nbsp; &nbsp;<%=studentName%></td>
	</tr>
	<tr>
		<th align="left">College Name:</th>
		<td align="left">&nbsp; &nbsp;<%=college%></td>
	</tr>
	<tr>
		<th align="left">Year Of Graduation:</th>
		<td align="left">&nbsp; &nbsp;<%=yearOfGraduation%></td>
	</tr>

	<tr>
		<th align="left">Bank:</th>
		<td align="left">&nbsp;&nbsp;&nbsp;<select name="bank">
			<option>SBI</option>
			<option>ICICI</option>
			<option>CITI</option>
			<option>HDFC</option>
			<option>SBH</option>

		</select></td>
	</tr>
	<tr>
		<td><input type="hidden" name="studentid" value="<%=studentId%>" /></td>
		<td><input type="hidden" name="studentName"
			value="<%=studentName%>" /></td>
	</tr>
	<tr>
		<td align="right"><input type="submit" value="Submit" /></td>
		<td align="left"><input type="button" value="Cancel"
			onClick="javascript: window.location = 'jsp/CreateStudentAccount.jsp'"></td>
	</tr>
</table>
</form>
</center>
</div>
<!-- END DESCRIPTION -->

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>
<jsp:include page="Footer.jsp"></jsp:include>

