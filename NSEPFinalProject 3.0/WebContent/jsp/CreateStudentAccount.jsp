<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/Validatestudentid.js">

</script>

<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>

<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION --> <!-- END DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>
<div class="rightAbout"><br></br>
<br></br>
<center><strong>
<p style="font-size: 25px; letter-spacing: -1px;">Bank Account
Creation</p>
</strong></center>
<br></br>


<form name="student" onsubmit="return validate()"
	action="<%=request.getContextPath()%>/StudentAccountController?pageid=1"
	method="post">


<table border="0" bordercolor="black" cellpadding="5" cellspacing="10"
	align="center">

	<tr>
		<td><STRONG>StudentId:</STRONG></td>
		<td><input type="text" name="studentid" maxlength="5"></input></td>
	</tr>
</table>
<br>
<center><input type="submit" value="Validate"></input></center>


</form>
<br></br>

</div>

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>






<jsp:include page="Footer.jsp"></jsp:include>