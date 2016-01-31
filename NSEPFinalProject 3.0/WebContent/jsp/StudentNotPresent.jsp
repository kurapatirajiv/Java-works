<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>

 		<!-- START CONTAINER ABOUT -->
			<div id="containerAbout">
            <div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
            </div>
				<!-- DESCRIPTION -->
				<div class="rightAbout">
				
					<br></br>
<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Deletion</p></strong></center>
				

<form name="studentdetails"  method="post"> 
				 <center><strong><p style="font-size:15px;color: #f0a108;letter-spacing:-1px;">Student ID does not exist </p></strong></center>
				  
				 
		         <br/> 
		         
		         </center>
		         <br></br>


		       
		         </form>
</div>
<!-- END DESCRIPTION -->
<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> <br>
<jsp:include page="Footer.jsp"></jsp:include>


				