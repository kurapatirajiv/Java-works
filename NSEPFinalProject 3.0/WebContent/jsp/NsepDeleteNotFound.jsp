<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<center>
<br></br>
<strong><p style="font-size:25px;letter-spacing:-1px;">Delete Account</p></strong>
<br>
<strong><p style="font-size: 17px; color: #f0a108; letter-spacing: -1px;">NSEP Account Number Not Found</p></strong>
<br></br>
<br></br>
<br></br>
<br></br>
  
<br>
</center>
</div>
<!-- END DESCRIPTION -->
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>
<jsp:include page="Footer.jsp"></jsp:include>



