<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Index.jsp").forward(request,
				response);

	}
%>
<h3 style="font-size:25px;letter-spacing:-1px;"><center>
<b> Menu</b></center></h3><pre><h4>
  <a href="<%=request.getContextPath()%>/jsp/Uploadcsv.jsp">
       Read Transaction file</a> <br>
    <a href="<%=request.getContextPath()%>/jsp/GenerateReports.jsp">
        Report Generation</a>
</h4>
</pre>