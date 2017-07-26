 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airport Info</title>
</head>
<body >
<br>
<a href="main.html">Home</a>
<br>
<h1>Airport Information</h1>
<br>
<a href="addnewairport.html">+Add new</a>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Code</th><th>Airport Name</th><th>City</th><th>Update</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.getAirport_code()}</td>  
   <td>${emp.getAirport_name()}</td>  
   <td>${emp.getCity()}</td> 
  <td><a href="<c:url value='airportupdate/${emp.getAirport_code()}.html' />">Update</a></td> 
   <td><a href="<c:url value='airportdelete/${emp.getAirport_code()}.html'/>">Delete</a></td>
   </tr>  
   </c:forEach>  
   </table>  

</body>
</html>