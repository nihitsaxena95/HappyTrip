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
	var airport_name=document.f1.airport_name.value;  
	var city = document.f1.city.value;
	
	if (airport_name==null || airport_name==""){  
	  alert("Enter Airport");  
	  return false;  
}else if(city == null || city == "")
	{
	alert("Enter City");
	return false;
    }
	} 
</script>
<body>
<h1>New Airport</h1>
<br>
<a href="main.html">Home</a>
<br>
 <form:form name= "f1" method="get" action="savenewairport.html" onsubmit = "return validateform()">    
        <table >    
        <tr>  
        <td>Code</td>    
         <td><form:input  path="Airport_code" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="Airport_name"  /></td>  
         </tr>    
         <tr>    
          <td>City :</td>    
          <td><form:input path="city" /></td>  
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