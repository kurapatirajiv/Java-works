<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="NavigationHead.jsp"></jsp:include>

<!-- START CONTAINER ABOUT -->
<br></br>
<strong><p style="font-size:25px;letter-spacing:-1px;">Home</p></strong>
<%
	if ((request.getSession().getAttribute("Active")) == null) {
		request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
				response);
	}
%>
<strong>
NSEP(National Self Employment Programme) is a Non-Profitable Organization 
that provides financial aid to underpriviledged and unemployed 
graduate students for self employment.
NSEP Contribution: NSEP will give a top up contribution in proportion
to the family's savings. This will be given monthly, along with
quarterly and annual bonuses provided the family meets their various
commitments. Assuming the family meets all their commitments (in terms
of amount saved each month and regularity of saving every month), NSEP
will contribute, in all, a total of 75% over their savings. <br></br>
The NSEP top up amount for each student will be held in a recurring
deposit account held in the name of NSEP and tagged to each individual
student. NSEP will only release these funds directly to a bank to pay
for the student's self employment scheme. This safeguards the interest
of the student and ensures that NSEPs contribution is not mis-used.</div>
</strong>

<br></br>
<br></br>
<jsp:include page="Footer.jsp"></jsp:include>
