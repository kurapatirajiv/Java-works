<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br></br>
<center>
<strong><p style="font-size:25px;letter-spacing:-1px;">View NSEP Account</p></strong>
<br>


<strong><p style="font-size:17px;color: #f0a108;letter-spacing:-1px;">Student Id Not Found</p></strong>
<br></br>
<br></br>
<br></br>
</center>
</div>
<!-- END DESCRIPTION --> <!-- SHORT NEWS FROM TWITTER -->






<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>




<jsp:include page="Footer.jsp"></jsp:include>



