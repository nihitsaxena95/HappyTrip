<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<a href="stmain.html">Home</a>
<br>
<h1>${list.getFromCity().getCity()}</h1>
<br>
<h3>${list.getToCity().getCity() }</h3>
<h3>${list.getAirline().getAirline_name() }</h3>
<h3></h3>
<table border="2" width="100%" cellpadding="2">  
<tr>
<th>Departure From</th>
<th>Arrival To</th>
<th>Flightno</th>
<th>Departure Time</th>
<th>Date of Travel</th>
<th>Airline</th>
<th>Arrival Time</th>
<th>Cost</th>
<th>Duration</th>
<th>Seat</th>
<th>Status</th>
<th>Book Now</th>
</tr>  
   <c:forEach var="pre" items="${list.getTs()}">   
   <tr>  
   <td>${list.getFromCity().getCode()}(${list.getFromCity().getCity()})</td>  
  <td>${list.getToCity().getCode()}(${list.getToCity().getCity()})</td>  
  <td>${pre.getFlightno()}</td> 
   <td>${pre.getDeptime()}</td>
   <td>${pre.getDate()}</td>
   <td>${list.getAirline().getAirline_code()}(${list.getAirline().getAirline_name()})</td>
   <td>${pre.getArrtime()}</td>
   <td>${pre.getCost()}</td>
   <td>${pre.getDuration()}</td>
   <td>${pre.getSeat()}</td>
   <td>${pre.getStatus()}</td> 
  <td><a href="bookflightseat/${pre.getFlightno()}.html">Book Seats</a></td>
   </tr>  
   </c:forEach>  
   </table>  

</body>
</html>