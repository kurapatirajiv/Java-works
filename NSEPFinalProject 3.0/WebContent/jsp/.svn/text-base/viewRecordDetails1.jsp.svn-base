<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
<%@page import="java.util.ArrayList"  %>
   <%@ page import="com.tcs.ilp.bean.NsepAccountBean" %>
   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transaction Details</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"> </script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/demo_table.css">
<script type="text/javascript">
$(document).ready(function() {
    $('#mytable').dataTable({
    	
    	 "sPaginationType": "full_numbers"	
    });
} );

</script>
<script type="text/javascript" src="../../js/ValidateBankForm.js">
</script>
<script type="text/jscript" src="../../js/Disable_right_click.js">   
</script> 
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" media="screen" />

</head>
<%
ArrayList<NsepAccountBean> arl = (ArrayList<NsepAccountBean>) request.getAttribute("arl");
   	if(request.getAttribute("arl")!=null)
	{
		arl=(ArrayList<NsepAccountBean>) request.getAttribute("arl");
		
%>

<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout">
<jsp:include page="MenuNsep.jsp"></jsp:include>

</div>
<div class="rightAbout">

<h2>View</h2>
<br></br>
<table align="center" cellpadding="5" cellspacing="5" border=1 class="display" id="mytable">

<thead>
<tr>
<th>Student Account ID</th>
<th>NSEP Account ID</th>
<th>Committed  Amount</th>
<th>Total NSEP Balance </th>
</tr>
</thead>

<tbody>
<% 
	for(NsepAccountBean nsepAccountBean:arl)
	{
	%>

<tr>

<td><%= nsepAccountBean.getStudentId() %></td>
<td><%= nsepAccountBean.getNsepAccountNumber() %></td>
<td><%= nsepAccountBean.getCommittedAmount() %></td>
<td><%= nsepAccountBean.getAccountBalance() %></td>

</tr>
<%}} %>
</tbody>

</table>
</div>
		<!-- end #content -->
	
	</div>
	</div>
	</div>
	<!-- end #page -->
	<div class="clearer"></div>
</div>
</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	<!-- end #footer -->
