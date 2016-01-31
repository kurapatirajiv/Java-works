<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeaderTransaction.jsp"></jsp:include>
<head>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ValidateTransaction.js">


</script>

<!-- START CONTAINER ABOUT -->

<div id="containerAbout">
<!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuTransaction.jsp"></jsp:include>
</div>
<div class="rightAbout">
<center><pre>




</pre> <b>
<p style="font-size: 25px; letter-spacing: -1px;">Transaction Report</p>
</b>

<div id="select">
<form name="reportform" method="post"
	action="<%=request.getContextPath()%>/TransactionController?id=readtable"
	onsubmit="return check();">
<table cellspacing="15">
	<tr>
		<th><input type="radio" name="select" value="month" id="mon"
			onclick=
	month();
>By Deposited Month</th>

		<th><input type="radio" name="select" value="amount" id="amt"
			onclick=
	amount();
>By Deposited Amount</th>
		<th><input type="radio" name="select" value="stuid" id="studid"
			onclick=
	stuid();
>By StudentId</th>
	</tr>
</table>
<div id="select1"></div>

<div id="hid"></div>

<div id="select2"></div>

 <pre>

<input type="submit" value="Submit">   
</pre></form>
</div>
</center>
</div>





<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


<jsp:include page="Footer.jsp"></jsp:include>