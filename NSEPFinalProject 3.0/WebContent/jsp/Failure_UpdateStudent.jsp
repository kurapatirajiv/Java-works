<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>

<div class="rightAbout">

<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Updation</p></strong></center>
<br>
<br>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%> <%
 	String message = (String) request.getAttribute("report");
 %>
 <center><strong><p style="font-size:17px;color: #f0a108;letter-spacing:-1px;"><%=message%></p></strong></center>
</div>
<!-- END DESCRIPTION -->

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<jsp:include page="Footer.jsp"></jsp:include>