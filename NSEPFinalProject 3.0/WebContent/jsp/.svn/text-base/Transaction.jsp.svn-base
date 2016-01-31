
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHeaderTransaction.jsp"></jsp:include>


<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);

	}
%>
<!-- START CONTAINER ABOUT -->
<div id="containerAbout"><!-- DESCRIPTION -->
<div class="leftAbout"><jsp:include page="MenuTransaction.jsp"></jsp:include>

</div>

<div class="rightAbout"><pre>
<b>
<p style="font-size: 25px; letter-spacing: -1px;">               
			       Transactions</p></b>
</pre> 
<pre><strong>						
		The Bank sends a transaction file, this file is updated into transaction table and calculate the monthly 
	top-up and bonuses based on the transactions made by the student, then updates the student accounts(in NSEP)
	and NSEP accounts on a regular basis.The record of the transactions made by student are maintained based on 
	the criteria like deposited month,deposited amount and studentid.
	 
			</strong>	</pre></div>
<!-- END DESCRIPTION -->


<div class="clearer"></div>
</div>
<!-- END CONTAINER ABOUT -->
<br>


</div>



<jsp:include page="Footer.jsp"></jsp:include>

