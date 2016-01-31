
<jsp:include page="Header.jsp"></jsp:include>

<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>


</head>
<form method="post" action="Login" name="log">
<body onload="noBack();">

<!-- CONTAINER -->
<div class="container"><!-- LOGO + NAV  -->
<div class="logo" id="top"><img src="images/logo.jpg"
	alt="NSEP logo" height="250" /></div>

<marquee> Welcome to NSEP Official Website</marquee>
<center><img src="images/shadow.gif" alt="" class="shadow" /></center>
<!-- <div class="TopNavigation">
			<ul class="nav">
				   <li class="active">Home</a></li>
			       <li> <a href="about.html">Student Account</a></li>
			 	   <li><a href="portfolio.html">Nsep Account</a></li>
				   <li><a href="portfolio.html">Transaction</a></li>

		
		</ul>
		
		</div>
		<div class="social">
			
		
		</div>  -->


<div class="leftAbout">
<p>Employment is essential for lasting economic and social
empowerment. Unfortunately the employment for non vocational
under-graduate students can become an insurmountable barrier even if
they had academically performed better.</p>


Families from poorer backgrounds lack advance financial planning and
savings which puts such expenses beyond their means for self employment.

<p>Loans are not easily available for self employment for non
vocational graduates. To address the above mentioned problem, National
Self Employment Program for Undergraduate Students (NSEP) has come up
with a unique solution that will encourage the family and student to
fund as much as they can and NSEP program to contribute the balance
based on the predefined condition/rule.</p>

</div>
<div class="rightAbout"><br>
<br>

User Id &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="uid"><br>
<br>
Password &nbsp&nbsp<input type="password" name="pass"> <br>
<br>
<center><input type="submit" value="Submit"></center>
</div>




</div>
<br />
<jsp:include page="Footer.jsp"></jsp:include>