function month()
{
document.getElementById("select1").innerHTML="<table><tr><td><label><strong>Month:</strong></label></td><td><select name='month' id='month'><option value='01'>Jan</option><option value='02'>Feb</option><option value='03'>Mar</option><option value='04'>Apr</option><option value='05'>May</option><option value='06'>June</option><option value='07'>July</option><option value='08'>Aug</option><option value='09'>Sept</option><option value='10'>Oct</option><option value='11'>Nov</option><option value='12'>Dec</option></select></td></tr></table>";

document.getElementById("select2").innerHTML="<table><tr><td><label><strong>Year:</strong></label></td><td><select name='year' id='year'><option value='2010'>2010</option><option value='2011'>2011</option><option value='2012'>2012</option></select></td></tr></table> ";

document.getElementById("hid").innerHTML="<input type='hidden' name='hidden_crit' value='date'>";
}

function amount()
{
document.getElementById("select1").innerHTML="<table><tr><td><strong>Deposited Amount:</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type='text' id='amount' name='amount' maxlength='4' value='''/></td></tr></table>";
document.getElementById("hid").innerHTML="<input type='hidden' name='hidden_crit' value='amount'>";
document.getElementById("select2").innerHTML="";
}
function stuid()
{
	document.getElementById("select1").innerHTML="<table><tr><td><label><strong>Student Id:</strong></label></td><td><input type='text' id='stuid' name='stuid' maxlength='5' value='''/></td></tr></table>";
	document.getElementById("hid").innerHTML="<input type='hidden' name='hidden_crit' value='stuid'>";
	document.getElementById("select2").innerHTML="";
}

function check()
{
	if(document.reportform.select[0].checked==false && document.reportform.select[1].checked==false && document.reportform.select[2].checked==false)
	{
		alert("Please select any one of the options.");
		return false;
	}
	if(document.getElementById("mon").checked==true)
	{
		if(document.getElementById("month").selectedIndex<0)
		{
			alert("Please select month");
			return false;
		}
		if(document.getElementById("year").selectedIndex<0)
		{
			alert("Please select year");
			return false;
		}
	}
	if(document.getElementById("amt").checked==true)
	{
		if(document.getElementById("amount").value=="")
		{
			alert("Please enter Deposited amount");
			return false;
		}
		if(document.getElementById("amount").value!="")
	    {   

			var reg=/^\d+$/;  
	     
			if(!reg.test(document.getElementById("amount").value))
			{
				alert("Please enter valid amount.");
				return false;
			}
			
			
	    }
	}
	if(document.getElementById("studid").checked==true)
	{
		if(document.getElementById("stuid").value=="")
		{
			alert("please enter student id");
			return false;
		}
		if(document.getElementById("stuid").value!="")
	    {   

			var reg=/^\d+$/;  
	     
			if(!reg.test(document.getElementById("stuid").value))
			{
				alert("Please enter valid studentid.");
				return false;
			}
			if(document.getElementById("stuid").value.length<5)
			{
				alert("Studentid  can not be less than 5 digits. Please enter valid studentid.");
				return false;
			}
			if(document.getElementById("stuid").value.length>5)
			{
				alert("Studentid can not be greater than 5 digits. Please enter valid studentid.");
				return false;
			}
			
	    }
	
		
	}
	return true;
}

function validateFile()
{
	if(document.uploadfile.file.value=="")
	{
		alert("Please upload file");
		return false;
	}	
	if(document.uploadfile.file.value!="")
	{
	
	var fileName =document.uploadfile.file.value;
	var ext = fileName.substring(fileName.lastIndexOf('.') + 1);
	if(ext != "csv")
	{
		alert("Upload .csv only");
		
		return false;
	} 
	
	}
	return true;
}

