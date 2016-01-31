<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeaderTransaction.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
<%@page import="java.util.ArrayList"  %>
   <%@ page import="com.tcs.ilp.bean.Transaction_EntityBean" %>
   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transaction Details</title>
<script type="text/javascript" src="<%=request.getContextPath() %>
/js/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>
	/js/jquery.dataTables.min.js"> </script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>
	/css/demo_table.css">
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
<link href="<%=request.getContextPath() %>/css/style.css" 
rel="stylesheet" type="text/css" media="screen" />

</head>
<%
	ArrayList<Transaction_EntityBean> lists=
		new ArrayList<Transaction_EntityBean>();
   	if(request.getAttribute("transactionList")!=null)
	{
		lists=(ArrayList<Transaction_EntityBean>) 
		request.getAttribute("transactionList");
		
%>

<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout">
<jsp:include page="MenuTransaction.jsp"></jsp:include>

</div>
<div class="rightAbout">
<center>
<b><p style="font-size:25px;letter-spacing:-1px;">               
			      Transaction Report</p></b></center>
<br></br>
<table align="center" cellpadding="5" cellspacing="5" 
border=1 class="display" id="mytable">
<thead>
<tr>
<th>Student Id</th>
<th>Deposite Date</th>
<th>Monthly Topup</th>
<th>Quartely Bonus</th>
<th>Annual Bonus</th>
<th>Balance</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<% 
	for(Transaction_EntityBean transactionEntity:lists)
	{
	%>

<tr>
<td><%= transactionEntity.getStudent_id() %></td>
<td><%= transactionEntity.getTransaction_date() %></td>
	<td><%= transactionEntity.getMonthly_topup() %></td>
	<td><%= transactionEntity.getQuartely_bonus() %></td>
	<td><%= transactionEntity.getAnnual_bonus() %></td>
	<td><%= transactionEntity.getBalance() %></td>
	<td><%= transactionEntity.getStatus() %></td>
</tr>
<%} %>
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
</body>
<%
    }
    else
    {
    %>
    <jsp:forward page="/Jsp/Login.jsp"/>
    <%
     }
    %>
</html>