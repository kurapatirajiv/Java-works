function studentAcctNum()
	{
	document.getElementById("select1").innerHTML="<table><tr><td><strong>Student Account Number:&nbsp;&nbsp;</strong></td><td><input type='text' id='studentAccountNumber' name='studentAccountNumber' maxlength='14' value='''/></td></tr></table>";
	document.getElementById("hid").innerHTML="<input type='hidden' name='hidden_crit' value='studentAccountNumber'>";
	//document.getElementById("select2").innerHTML="";
	}
	function studentId1()
	{
		document.getElementById("select1").innerHTML="<table><tr><td><label><strong>Student Id:<strong></label></td><td><input type='text' id='studentId' name='studentId' maxlength='5' value='''/></td></tr></table>";
		document.getElementById("hid").innerHTML="<input type='hidden' name='hidden_crit' value='studentId'>";	

		//document.getElementById("select2").innerHTML="";
	}
	function nsepAcctNum()
	{
	document.getElementById("select1").innerHTML="<table><tr><td><strong>NSEP Account Number:&nbsp;&nbsp;</strong></td><td><input type='text' id='nsepAccountNumber' name='nsepAccountNumber'  maxlength='14' value='''/></td></tr></table>";
	document.getElementById("hid").innerHTML="<input type='hidden' name='hidden_crit' value='nsepAccountNumber'>";
	//document.getElementById("select2").innerHTML="";
	}
	function check()
	{
		if(document.form1.select[0].checked==false && document.form1.select[1].checked==false )
		{
			alert("Please select any one");
			return false;
		}

		if(document.getElementById("studacctnum").checked==true)
		{
			if(document.getElementById("studentAccountNumber").value=="")
			{
				alert("Please enter Student Account Number.");
				return false;
			}
			if(document.getElementById("studentAccountNumber").value!="")
		    {   

				var reg=/^\d+$/;  
		     
				if(!reg.test(document.getElementById("studentAccountNumber").value))
				{
					alert("Please enter valid Student Account Number.");
					return false;
				}
				
				if(document.getElementById("studentAccountNumber").value.length!=14)
				{
					alert("Please enter 14 digits for StudentAccountNumber.");
					return false;
				}
		    }
		}
		if(document.getElementById("studid").checked==true)
		{
			if(document.getElementById("studentId").value=="")
			{
				alert("Please enter Student Id");
				return false;
			}
			if(document.getElementById("studentId").value!="")
		    {   

				var reg=/^\d+$/;  
		     
				if(!reg.test(document.getElementById("studentId").value))
				{
					alert("Please enter valid Student Id.");
					return false;
				}
				if(document.getElementById("studentId").value.length!=5)
				{
					alert("Please enter 5 digits for Student Id.");
					return false;
				}
				
				
		    }
		
			
		}
		return true;
	}
	
	
	
	function check1()
	{
		if(document.form1.select[0].checked==false && document.form1.select[1].checked==false )
		{
			alert("Please select any one");
			return false;
		}

		if(document.getElementById("nsepacctnum").checked==true)
		{
			if(document.getElementById("nsepAccountNumber").value=="")
			{
				alert("Please enter NSEP Account Number");
				return false;
			}
			if(document.getElementById("nsepAccountNumber").value!="")
		    {   

				var reg=/^\d+$/;  
		     
				if(!reg.test(document.getElementById("nsepAccountNumber").value))
				{
					alert("Please enter valid NSEP Account Number.");
					return false;
				}
				
				if(document.getElementById("nsepAccountNumber").value.length!=14)
				{
					alert("Please enter 14 digits for NSEP AccountNumber.");
					return false;
				}
		    }
		}
		if(document.getElementById("studid").checked==true)
		{
			if(document.getElementById("studentId").value=="")
			{
				alert("please enter student id");
				return false;
			}
			if(document.getElementById("studentId").value!="")
		    {   

				var reg=/^\d+$/;  
		     
				if(!reg.test(document.getElementById("studentId").value))
				{
					alert("Please enter valid studentid.");
					return false;
				}
				if(document.getElementById("studentId").value.length!=5)
				{
					alert("Please enter 5 digits for Student Id.");
					return false;
				}
				
				
		    }
		
			
		}
		return true;
	}
	
	function validate() {

		if (document.form1.studentId.value == "") {
			alert("Please enter Student Id");
			return false;
		}

		if (document.form1.studentId.value!= "") {

			var reg = /^\d+$/;

			if (!reg.test(document.form1.studentId.value)) {
				alert("Please enter valid Student Id");
				return false;
			}

			if (document.form1.studentId.value.length!= 5) {
				alert("Please enter 5 digits for Student Id..");
				return false;
			}
			

		}
		return true;
	}
	
	

