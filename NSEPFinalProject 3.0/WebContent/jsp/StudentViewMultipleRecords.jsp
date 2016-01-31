<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
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
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account View</p></strong></center>

<br>
<br>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>
<%@page import="java.util.ArrayList" %>
    <%@page import="java.util.Iterator" %>
   <%@page import="com.tcs.ilp.bean.StudentAccountBean" %> <%
 	String message = (String) request.getAttribute("report");
 	%>
   <%StudentAccountBean s1=new StudentAccountBean();
   ArrayList<StudentAccountBean> list1= new ArrayList<StudentAccountBean>();
   list1=(ArrayList<StudentAccountBean>)request.getAttribute("student");
   Iterator iterator1 = list1.iterator(); %>
   <%int size=list1.size();
  %>
   <center><strong><p style="font-size:17px;color: #f0a108;letter-spacing:-1px;"><%=message%></p></strong></center>
  
   <%int i=1;%>
   <table align="center" cellpadding="5" cellspacing="5" border=1 class="display" id="mytable">
   <thead>
   <tr>
   <th>Student Name</th>
   <th>Student ID</th>
   <th>Address</th>
   </tr>
   </thead>

   <tbody>
   <% 
   	for(StudentAccountBean s:list1)
   	{
   	%>

   <tr>

   <td><%=s.getStudentName() %></td>
   <td><%= s.getStudentId()%></td>
   <td><%= s.getAddress() %></td>
   
   </tr>
   <%} %>
   </tbody>

   </table>
  

</div>
<!-- END DESCRIPTION -->


<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<jsp:include page="Footer.jsp"></jsp:include>
