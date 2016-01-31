<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeaderTransaction.jsp"></jsp:include>
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
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuTransaction.jsp"></jsp:include>

</div>
<div class="rightAbout">

<center><br></br>
<b>
<p style="font-size: 25px; letter-spacing: -1px;">Upload Csv File</p>
</b>

<FORM name="uploadfile" ENCTYPE="multipart/form-data"
	ACTION="../TransactionController?id=readcsv" METHOD="POST"
	name="uploadfile" onsubmit="return validateFile();"><br>
<table border="2">

	<tr>
		<td><b>Choose the file To Upload: &nbsp;&nbsp;&nbsp;</b></td>
		<td><INPUT NAME="file" TYPE="file"></td>
	</tr>
	<tr>
		<td colspan="2"><br></br>
		<p><INPUT TYPE="submit" VALUE="Send File"></p>
		</td>
		<td></td>
	</tr>
</table>

</FORM>
<pre>
		
				
		</pre>
</div>
<!-- END DESCRIPTION --> <!-- SHORT NEWS FROM TWITTER --> <!-- END SHORT NEWS FROM TWITTER -->


</center>


<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>


<jsp:include page="Footer.jsp"></jsp:include>
