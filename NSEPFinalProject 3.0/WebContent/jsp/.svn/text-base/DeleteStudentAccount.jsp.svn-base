<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Validatestudentid.js">

</script>



<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br></br>
<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Deletion</p></strong></center>
</center>
<br></br>



<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%> 




<form name="student" action="<%=request.getContextPath()%>/StudentAccountController?pageid=2"
	onsubmit="return validate()" method="post">
<table border="0" bordercolor="black" bgcolor="" cellpadding="5" cellspacing="10" align="center">

<tr >
<td ><STRONG>StudentId:</STRONG></td>
<td><input  type="text" name="studentid" maxlength="5"></input></td>
</tr>
</table> 
<br>
<CENTER><input  type="submit" value="Submit"></input></CENTER>

</form>

</div>
<!-- END DESCRIPTION --> <!-- SHORT NEWS FROM TWITTER -->

<!-- END SHORT NEWS FROM TWITTER -->

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<jsp:include page="Footer.jsp"></jsp:include>
