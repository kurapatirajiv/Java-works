<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%@ page import="com.tcs.ilp.bean.NsepAccountBean"%>
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
<center>
<br></br>
<strong><p style="font-size:25px;letter-spacing:-1px;">Delete NSEP Account</p></strong>
</center>
<br>
<form name="form1"
	action="<%=request.getContextPath()%>/NsepAccountController?pageid=5"
	method="post">
<%

NsepAccountBean nsepAccountBean1 = (NsepAccountBean) request.getAttribute("nsepAccountBean");
%>
<table align="center" cellspacing="20">

	<tr>
		<td><strong>StudentId</strong></td>
		<td>
		<%out.println(nsepAccountBean1.getStudentId());%>
		</td>
	</tr>
	<tr>
		<td><strong>NsepAccount Number</strong></td>
		<td>
		<%out.println(nsepAccountBean1.getNsepAccountNumber());%>
		</td>
	</tr>
	<tr>
		<td><strong>Committed Amount</strong></td>
		<td>
		<%out.println(nsepAccountBean1.getCommittedAmount());%>
		</td>
	</tr>
	<tr>
		<td><strong>Quarterly Bonus</strong></td>
		<td>
		<%out.println(nsepAccountBean1.getQuarterlyBonus());%>
		</td>
	</tr>
	<tr>
		<td><strong>Annual Bonus</strong></td>
		<td>
		<%out.println(nsepAccountBean1.getAnnualBonus());%>
		</td>
	</tr>
	<tr>
		<td><strong>Account Balance</strong></td>
		<td>
		<%out.println(nsepAccountBean1.getAccountBalance());%>
		</td>
	</tr>
</table>
<%
	request.setAttribute("nsepAccountBean1", nsepAccountBean1);
%> <input type="hidden" name="studentId" value="<%=nsepAccountBean1.getStudentId()%>" />
<center><input type="submit" value="Delete" /> &nbsp;&nbsp;<input
	type="button" onclick="javascript:window.location=
	'jsp/DeleteNsepAccount.jsp'" value="Cancel" /></center>
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