 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Info</title>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


<script>
	$(function() {
		$("#datepicker-13").datepicker();
		$("#datepicker-13").datepicker("show");
	});
</script>
</head>
<script></script>

<body>
<br>
<a href="main.html">Home</a>
<br>
<h1>Schedule Information</h1>
<br>
<a href="addnewschedule.html">+Add new</a>
<table border="2" width="100%" cellpadding="2">  
<tr>
<th>Departure From</th>
<th>Arrival To</th>
<th>Departure Time</th>
<th>Flight No</th>
<th>Airline</th>
<th>Arrival Time</th>
<th>Cost</th>
<th>Duration</th>
<th>Seat</th>
<th>Flight Date</th>
<th>Update</th>
<th>Delete</th>
</tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.getDep()}</td>  
   <td>${emp.getArr()}</td>  
   <td>${emp.getDeptime()}</td>
   <td>${emp.getFlightno()}</td>
   <td>${emp.getAirline()}</td>
   <td>${emp.getArrtime()}</td>
   <td>${emp.getCost()}</td>
   <td>${emp.getDuration()}</td>
   <td>${emp.getSeats()}</td>
   <td>${emp.getFlightdate()}</td> 
  <td><a href="<c:url value='scheduleupdate/${emp.getDep()},${emp.getArr()}.html' />">Update</a></td> 
   <td><a href="<c:url value='scheduledelete/${emp.getDep()},${emp.getArr()}.html'/>">Delete</a></td>
   </tr>  
   </c:forEach>  
   </table>  

</body>
</html>