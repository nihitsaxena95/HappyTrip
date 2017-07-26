<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Ticket</title>
</head>
<body >
<h1>${mess}</h1>
<br><hr>
<h1>Book Ticket</h1>
	<form:form action="getflightdata.html" method="post">
		<table cellpadding="3pt">
			<tr>
				<td>From City :</td>
				<td>
				<form:select path="fromCity">
				<c:forEach var="air" items="${airport}">
				<form:option value="${ air.getCode()}">${air.getCity()}(${air.getCode()})</form:option>
				</c:forEach>
				</form:select>
				</td>
			</tr>
			<tr>
				<td>To City :</td>
				<td>
				<form:select path="ToCity">
				<c:forEach var="air" items="${airport}">
				<form:option value="${ air.getCode()}">${air.getCity()}(${air.getCode()})</form:option>
				</c:forEach>
				</form:select>
				</td>
			</tr>
			<tr>
				<td>Date Of Travel:</td>

				<td><form:input type="text" path="Date" id="datepicker-13" /></td>
			</tr>
		</table>
		<p />
		<input type="submit" value="Submit" />
	</form:form>
	<p style="color:red">${message}</p>
</body>
</html>