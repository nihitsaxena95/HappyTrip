<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route</title>
</head>
<body>
<br>
<a href="main.html">Home</a>
<br>
<h1>Route Information</h1>
<br>
<a href="routeupdate.html">+ Add Route</a>
<br>
<table border="2" width="100%" cellpadding="2"> 
		<tr>
			<th>Departure From</th>
			<th>Arrival to</th>
			
			<th>Distance</th>
			<th>Duration(in mins)</th>
			<th>Cost</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="air" items="${list}">
			<tr>
				<td>${air.getDep()}</td>
				<td>${air.getArr()}</td>
				<td>${air.getDistance()}</td>
				<td>${air.getTime()}</td>
				<td>${air.getCost()}</td>
				<td><a href="deleteroute/${air}.html">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>