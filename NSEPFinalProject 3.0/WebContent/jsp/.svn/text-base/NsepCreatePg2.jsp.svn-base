<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%@ page import="com.tcs.ilp.bean.StudentAccountBean"%>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>

<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Create NSEP Account</p></strong></center>
<br>
<form name="form1" action="NsepAccountController?pageid=2" method="post">
<table align="center" cellspacing="20">

	<%--HttpSession hs=request.getSession();--%>
	<%
		StudentAccountBean studentAccountBean1 = (StudentAccountBean) request
				.getAttribute("studentAccountBean");
	%>

	<tr>
		<td><strong>Student Id</strong></td>
		<td><input type="hidden" name="studentId" value="<%=studentAccountBean1.getStudentId()%>"/><%=studentAccountBean1.getStudentId()%></td>
	</tr>
	<tr>
		<td><strong>Student Account Number:</strong></td>
		<td><input type="hidden" name="studentAccountNumber1" value="<%=studentAccountBean1.getStudentAccountNumber()%>"/><%=studentAccountBean1.getStudentAccountNumber()%></td>
	</tr>

	<tr>
		<td><strong>Year of Graduation:</strong></td>
		<td><input type="hidden" name="yearOfGraduation" value="<%=studentAccountBean1.getYearOfGraduation()%>"/><%=studentAccountBean1.getYearOfGraduation()%></td>
	</tr>

	<tr>
		<td><strong>Committed Amount</strong> <font color="red"> * </font></td>
		<td><select id="committedamt" name="committedAmount">
			<option value="1000">1000</option>
			<option value="2000">2000</option>
			<option value="3000">3000</option>
			<option value="4000">4000</option>
			<option value="5000">5000</option>
		</select></td>
	</tr>
	

</table>
<center><input type="submit" value="Submit" />&nbsp;&nbsp;&nbsp;
<input type="reset" value="Reset" /></center>
</form>


<br>


</div>
<!-- END DESCRIPTION -->







<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>




<jsp:include page="Footer.jsp"></jsp:include>

