
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Create.js">
</script>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout">
<jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<center>
<br></br>
<strong><p style="font-size:25px;letter-spacing:-1px;">Update NSEP Account</p></strong></center>
<br>
<form name="form1" onsubmit="return validate()"
	action="<%=request.getContextPath()%>/NsepAccountController?pageid=7" method="post">
<table cellspacing="5" align="center">
<tr>
<td><strong>Student Id:</strong></td>
<td><input type="text" name="studentId" maxlength="5"/></td>
</tr>
<tr>
<td><strong>Remarks:</strong></td>
<td>
<select name="remarks">
<option value="Defaulter">Defaulter</option>
<option value="NonDefaulter">NonDefaulter</option>
</select>
</td>
</tr>
</table>
<br></br>
<center>
<input type="submit" value="Submit" />
<br></br>
</center>
</form>
</div>
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
