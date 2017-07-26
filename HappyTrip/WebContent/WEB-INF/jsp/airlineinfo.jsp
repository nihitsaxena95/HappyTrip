<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Airline</title>
</head>
<body >
<br>
<a href="main.html">Home</a>
<br>
<h1>Airline Information</h1>
<br>
<a href="addairline.html">+ Add Airline</a>
<br>
	<table border="2" width="100%" cellpadding="2"> 
		<tr>
			<th>AIRPORT-NAME</th>
			<th>AIRPORT-CODE</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="air" items="${list}">
			<tr>
				<td>${air.getAirline_name()}</td>
				<td>${air.getAirline_code()}</td>
				<td><a href="updateairline/${air.getAirline_code()}.html">update</a></td>
				<td><a href="deleteairline/${air.getAirline_code()}.html">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>