<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/Validatestudentname.js">

</script>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>




<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
</div>

<div class="rightAbout">
<br></br>
<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account View</p></strong></center>		
				<br></br>
<form  name="nsep" action="<%=request.getContextPath()%>/StudentAccountController?pageid=9" onsubmit="return validate1()" method="post" align="center">
<table border=0 cellpadding="20" cellspacing="10" align="center">
<tr >
<td ><strong>Student Name:</strong></td>
<td><input  type="text" name="name"></input></td>
</tr>
<tr><td><strong>Date Of Birth:</strong></td>
<td><input  type="text" name="dob"></input>&nbsp;&nbsp;(Eg:18-MAR-89)</td>
</tr>
</table> 
<center>
 <input  type="submit" value="Submit" ></input> &nbsp;&nbsp;
<input type="reset" value="Reset"></input>
</center>
</form>

</div>
<!-- END DESCRIPTION --> 

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> <br>
<jsp:include page="Footer.jsp"></jsp:include>
