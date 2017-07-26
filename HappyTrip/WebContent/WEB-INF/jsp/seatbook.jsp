<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seat Required</title>
</head>
<body>
<a href="stmain.html">Home</a>
<br>
<h1>Enter Required Seats</h1>
<br><hr>
<form:form action="/HappyTrip/cnfmflightseat.html" method="get">
<table>
<tr>
				<td>Required Seat :</td>
				<td><form:input type="number" path="seat"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"/></td>
			</tr>
</table>
</form:form>
<p style="color:red">${message}</p>
</body>
</html>