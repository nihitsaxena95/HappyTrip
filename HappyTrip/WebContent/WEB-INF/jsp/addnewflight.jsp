 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Airport</title>
</head>
<script>
function validateform(){  
	var flightno = document.f1.flightno.value;
	var name = document.f1.name.value;
	var capacity = document.f1.capacity;
	var airline = document.f1.airline.value;
	
	if ((flightno==null || flightno=="") && flightno.length <= 7){  
	  alert("Enter valid Flight Number");  
	  return false;  
}else if(name == null || name == "")
	{
	alert("Enter Name");
	return false;
    }else if (NumberChk(capacity)){
    	}else if(airline == null || airline == "")
    		{
    		alert("Enter correct code");
   			return false;
    		}
	} 
	function NumberChk(capacity)  
	{   
	var numbers = /^[0-9]+$/;  
	if(capacity.value.match(numbers))  
	{  
	return true;  
	}  
	else  
	{  
	alert('Enter Number Only');  
	capacity.focus();  
	return false;  
	}  
	}  
</script>
<body>
<br>
<a href="main.html">Home</a>
<br>
<h1>New Airport</h1>
<br>
 <form:form name = "f1" method="get" action="savenewflight.html" onsubmit="return validateform()">    
        <table >    
        <tr>  
        <td>Flight No.</td>    
         <td><form:input  path="Flightno" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Capacity : </td>    
          <td><form:input path="capacity" /><span id ="numloc"></span></td>  
         </tr>
          <tr>    
          <td>Airline :</td>    
          <td><form:input path="airline" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form> 
       <p style="color:red">${mess}</p>   
</body>
</html>