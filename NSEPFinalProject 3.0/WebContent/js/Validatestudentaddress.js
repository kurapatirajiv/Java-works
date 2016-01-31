function validate()
				{
					if(document.nsep.address.value=="")
						{
						alert("Address field can not be empty");
					    return false;
						}
					if(document.nsep.address.value.length>100)
					{
					alert("Address is too long. Please re-enter.");
					document.nsep.address.value="";
				    return false;
					}
					if(document.nsep.address.value.length<20)
					{
					alert("Address is too short. Please re-enter.");
					document.nsep.address.value="";
				    return false;
					}
					if(document.nsep.address.value.length>60)
					{
						alert("Address is too long. Please re-enter.");
						document.nsep.address.value="";
					    return false;
					}
					
					
					return true;
				}