<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeadStudentAccount.jsp"></jsp:include>
<%if((request.getSession().getAttribute("Active"))==null){
	request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);
	
	
} %>
    <%@page import="com.tcs.ilp.bean.StudentAccountBean"%>
    <%@page import="java.util.*" %>
    



 		<!-- START CONTAINER ABOUT -->
			<div id="containerAbout">
			<div class="leftAbout"><jsp:include page="MenuStudentAccount.jsp"></jsp:include>
            </div>
			

				<!-- DESCRIPTION -->
				<div class="rightAbout">
				<br></br>
				<center><strong><p style="font-size:25px;letter-spacing:-1px;">Bank Account Deletion</p></strong></center>
<form name="deletefailure" method="post">
<center>
<%StudentAccountBean studentaccountbean=(StudentAccountBean)request.getAttribute("studentAccountBean2");
 
 
 String accountStatus=studentaccountbean.getAccountStatus();

 
 %>
<br></br>
<center><strong><p style="font-size:17px;color: #f0a108;letter-spacing:-1px;">Unable To Delete Account</p></strong></center>
<br></br>
<center><strong>Student Bank Account Status:</b><%= accountStatus%></strong></center>
<br></br>

</center>
</form>

					</div>
				<!-- END DESCRIPTION --> 

<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT --> 
<jsp:include page="Footer.jsp"></jsp:include>


				