<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
<%@ page import="com.tcs.ilp.bean.NsepAccountBean"%>
<%
	//HttpSession hs=request.getSession();
	NsepAccountBean nsepAccountBean1 = (NsepAccountBean) request.getAttribute("nsepAccountBean");
%>

<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout">
<jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<center>
<strong><p style="font-size:25px;letter-spacing:-1px;">View NSEP Account</p></strong></center>
<table align="center" cellspacing="20">
	<tr>
		<td><strong>StudentId</strong></td>
		<td><%out.println(nsepAccountBean1.getStudentId());%></td>
	</tr>
	<tr>	
		<td><strong>NsepAccount Number</strong></td>
		<td><%out.println(nsepAccountBean1.getNsepAccountNumber());%></td>
	</tr>
	<tr>
		<td><strong>Committed Amount</strong></td>
		<td><%out.println(nsepAccountBean1.getCommittedAmount());%></td>
	</tr>	
	<tr>
		<td><strong>Topup</strong></td>
		<td><%out.println(nsepAccountBean1.getTopup());%></td>
	</tr>
	<tr>
		<td><strong>Quarterly Bonus</strong></td>
		<td><%out.println(nsepAccountBean1.getQuarterlyBonus());%></td>
	</tr>
	<tr>	
		<td><strong>Annual Bonus</strong></td>
		<td><%out.println(nsepAccountBean1.getAnnualBonus());%></td>
	</tr>
	<tr>
		<td><strong>Account Balance</strong></td>
		<td><%out.println(nsepAccountBean1.getAccountBalance());%></td>
	</tr>
</table>

</div>
<!-- END DESCRIPTION -->




<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>




<jsp:include page="Footer.jsp"></jsp:include>