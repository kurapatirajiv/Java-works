<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeaderTransaction.jsp"></jsp:include>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuTransaction.jsp"></jsp:include>

</div>
<div class="rightAbout">
<%
	ArrayList arrayList = new ArrayList();
	arrayList = (ArrayList) request.getAttribute("arrayList");
	String FileName = null;
	String path = null;
	int lineNumber = 0;
	Iterator ir = arrayList.iterator();
	if (ir.hasNext()) {

		lineNumber = (Integer) ir.next();
		FileName = (String) ir.next();
		path = (String) ir.next();
	}
%> <pre>		<b>
<p style="font-size: 25px; letter-spacing: -1px;">               
	     			 Reports</p></b></pre>
<form action="<%=request.getContextPath()%>/jsp/Uploadcsv.jsp">
<table cellspacing="10" cellpadding="8" align="center">
	<tr>
		<th>Number of Student Profiles Updated:</th>
		<td>"<%=lineNumber%>"</td>
	</tr>
	<tr>
		<th>File Location :</th>
		<td>"<%=FileName%>"</td>
	</tr>
	<tr>
		<th>File Name :</th>
		<td>"<%=path%>"</td>
	</tr>
</table>

</form>

<center><input type="button" value="Upload New File" onClick="javascript:window.location='jsp/Uploadcsv.jsp';"></center>
</p>




</div>
<!-- END DESCRIPTION --> <!-- END SHORT NEWS FROM TWITTER -->





<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>
<jsp:include page="Footer.jsp"></jsp:include>

