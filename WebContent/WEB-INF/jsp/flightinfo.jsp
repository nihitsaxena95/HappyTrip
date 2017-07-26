 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Info</title>
</head>
<body >
<br>
<a href="main.html">Home</a>
<br>
<h1>Flight Information</h1>
<br>
<a href="addnewflight.html">+Add new</a>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Flight Number</th><th>Name</th><th>Airline</th><th>Capacity</th><th>Update</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.getFlightno()}</td>  
   <td>${emp.getName()}</td>  
   <td>${emp.getAirline()}</td>
   <td>${emp.getCapacity()}</td> 
  <td><a href="<c:url value='flightupdate/${emp.getFlightno()}.html' />">Update</a></td> 
   <td><a href="<c:url value='flightdelete/${emp.getFlightno()}.html'/>">Delete</a></td>
   </tr>  
   </c:forEach>  
   </table>  

</body>
</html>