<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css" />


<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body onload="noBack()" oncontextmenu="return false;">
<div class="container">

<div class="logo" id="top"><img
	src="<%=request.getContextPath()%>/images/logo.jpg" alt="NSEP logo"
	height="100" /></div>


<center><img
	src="<%=request.getContextPath()%>/images/shadow.gif" alt=""
	class="shadow" /></center>
	<marquee><Strong> Welcome to NSEP Portal</Strong></marquee>