
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style1.css" type="text/css" />


<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body onload="noBack()">
<div class="container">

<div class="logo" id="top"><img
	src="<%=request.getContextPath()%>/images/logo.jpg" alt="NSEP logo"
	height="100" /></div>

<marquee><Strong> Welcome to NSEP Portal</Strong></marquee>
<center><img
	src="<%=request.getContextPath()%>/images/shadow.gif" alt=""
	class="shadow" /></center>
<div class="leftAbout"><strong> Employment is essential
for lasting economic and social empowerment. Unfortunately the
employment for non vocational under-graduate students can become an
insurmountable barrier even if they had academically performed better.<br></br>

There is a deep reduction in number of undergraduates who get employment
immediately after the graduation. <br></br>
Families from poorer backgrounds lack advance financial planning and
savings which puts such expenses beyond their means for self employment.
</strong> <br></br>
<br></br>
<br></br>
<br></br>
</div>
<div class="rightAbout"><script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ValidateLogin.js">
</script>



<center>
<h3>Login</h3>
</center>
<p align="center" style="color: red;">Invalid Login Details</p>
<form name="form1" onsubmit="return validateLogin()"
	action="<%=request.getContextPath()%>/LoginController"
	method="post">
<table align="center" cellspacing="10" cellpadding="6">
	<tr>
		<td><b>Username:*</b></td>
		<td><input type="text" name="userName" /></td>
	</tr>
	<tr>
		<td><b>Password:*</b></td>
		<td><input type="password" name="password" /></td>
	</tr>
</table>
<br>
<center><input type="submit" value="Submit" /></center>

</form>




</div>
<br />
<jsp:include page="Footer.jsp"></jsp:include>