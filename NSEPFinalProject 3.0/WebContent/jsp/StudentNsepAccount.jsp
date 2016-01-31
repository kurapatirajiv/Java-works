<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadNsep.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>


<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->

<div class="leftAbout">
<jsp:include page="MenuNsep.jsp"></jsp:include>
</div>
<div class="rightAbout">
<br>
<center><strong><p style="font-size:23px;letter-spacing:-1px;">NSEP Account Operations</p></strong></center>
<br>
         <pre>  <strong>  
             Here Admin creates the NSEP Account, when the Student Account is created. NSEP will give a top up 
             contribution in proportion to the family's savings. This will be given monthly, along with quarterly 
             and annual bonuses based upon the committed amount.NSEP will contribute in all, a total of 75% over 
             their savings.NSEP contribution (Topups, Quarterly Bonus and Annual Bonus) are credited into NSEP 
             Account .When the end date is reached, the status of account is changed to closed. 
</strong>
</pre>

</div>
<!-- END DESCRIPTION -->
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>



<jsp:include page="Footer.jsp"></jsp:include>

