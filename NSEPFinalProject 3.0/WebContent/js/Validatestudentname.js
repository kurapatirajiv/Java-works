function validate1()
{
	if(document.nsep.name.value =="" && document.nsep.dob.value=="")
	{
	alert("Please fill the given fields");
	return false;
	}
	
	if(document.nsep.name.value=="")
	{
		alert("Please enter student name");
		return false;
	}
	if(document.nsep.name.value!=="")
	{
		var reg=/[^A-Z a-z]/;
	      if(reg.test(document.nsep.name.value))
	       {
	        alert("Please enter only alphabets for student name");
           
           return false;
       }
	}
	if(document.nsep.dob.value=="")
	{
		alert("Please enter student date of birth");
		return false;
	}
	
	if(document.nsep.dob.value!=="")
	{
		var elementValue=document.nsep.dob.value;
		var urlregex = new RegExp(/^(\d{1,2})\-([A-z]{3})\-(\d{2})$/);
		if(!urlregex.test(elementValue))
		{
		alert('The string was not recognized as a valid Date of Birth.Please re-enter');
        return false;
		}

	}


	return true;
}