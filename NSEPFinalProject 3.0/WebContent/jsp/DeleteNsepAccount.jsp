<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/Create.js">
</script>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout">
<jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<center>
<br></br>
<strong><p style="font-size:25px;letter-spacing:-1px;">Delete NSEP Account</p></strong>
<br>
<form name="form1" onsubmit="return check1();"
	action="<%=request.getContextPath()%>/NsepAccountController?pageid=4"
	method="post">
<table cellspacing="15">
	<tr>
	
		<td><input type="radio" name="select" value="NsepAccount" id="nsepacctnum"
			onclick="nsepAcctNum();"><strong>By Nsep Account No</strong></td>

		<td><input type="radio" name="select" value="Studentid" id="studid"
			onclick="studentId1();"><strong>By Student Id</strong></td>
	</tr>
</table>
<div id="select1"></div>
<div id="hid"></div>
   <input type="submit" value="Submit" /> &nbsp;&nbsp;     
	<br></br>
<br></br>
</form>
</center>
</div>
<!-- END DESCRIPTION -->

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


<jsp:include page="Footer.jsp"></jsp:include>

