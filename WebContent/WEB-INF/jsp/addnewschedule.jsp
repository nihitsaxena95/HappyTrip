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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Add</title>
</head>
<script>
function validateform(){  
	var Departure_Time=document.s1.Departure_Time.value;  
	var Arrival_Time = document.s1.Arrival_Time.value;
	var Flightno = document.s1.Flightno.value;
	var Airline = document.s1.Airline.value;
	var Cost = document.s1.Cost.value;
	var Duration = document.s1.Duration.value;
	var Seat = document.s1.Seat.value;
	
	if(checkTime(Departure_time)){
	}else if(checkTime(arrivalTime)){
	}else if ((Flightno==null || Flightno=="") && Flightno.length <= 6){  
	  alert("Enter valid Flight Number");  
	  return false;  
}else if(airline == null || airline == "")
	{
	alert("Airline field can't be blank");
	return false;
    }else if(NumberChk(Cost) && Cost.length <= 6){  
	  alert("Invalid Cost Field");  
	  return false;  
	}else if(Duration == null || Duration == ""){
		alert("Invalid Duration Field");
		}else if((Seat == null || Seat == "") && Seat.length < 3)
			{
			alert("INvalid Seat Entry");
			}
	
	}
	 
function checkTime(time)
{
  

  // regular expression to match required time format
  re = /^\d{1,2}:\d{2}([ap]m)?$/;

  if(form.starttime.value != '' && !form.starttime.value.match(re)) {
    alert("Invalid time format: " + form.starttime.value);
    form.starttime.focus();
    return false;
  }

  return true;
}
function CheckDate(FlightDate)
{
	// regular expression to match required date format
	  re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;

	  if(form.startdate.value != '' && !form.startdate.value.match(re)) {
	    alert("Invalid date format: " + form.startdate.value);
	    form.startdate.focus();
	    return false;
	  }
	  
	  return true;
}
function NumberChk(Cost)  
{   
var numbers = /^[0-9]+$/;  
if(Cost.value.match(numbers))  
{  
return true; 
}
else  
{  
alert('Enter Number Only');  
Cost.focus();  
return false;  
}
}
</script>

<body >
<br>
<a href="main.html">Home</a>
<br>
 <h1>Add Schedule Information</h1>  
       <form:form method="get" action="savenewschedule.html">    
        <table >    
        <tr>  
        <td>Departure :</td>    
         <td>
         <form:select path="dep">
         <c:forEach var="emp" items="${ls}">
         <form:option value="${emp.getCode() }">${emp.getCode() }(${emp.getCity() })</form:option>  
         </c:forEach>
         </form:select>
         </td>  
         </tr>
         <tr>  
        <td>Arrival :</td>    
         <td>
          <form:select path="arr">
         <c:forEach var="emp" items="${ls}">
         <form:option value="${emp.getCode() }">${emp.getCode() }(${emp.getCity() })</form:option>  
         </c:forEach>
         </form:select>
         </td>  
         </tr>   
         <tr>    
          <td>Departure Time : </td>   
          <td><form:input path="deptime"  /></td>  
         </tr>    
         <tr>    
          <td>Arrival Time : </td>   
          <td><form:input path="arrtime"  /></td>  
         </tr>    
         <tr>    
          <td>Flightno :</td>    
          <td><form:input path="flightno" /></td>  
         </tr>  
           <tr>    
          <td>Airline :</td>    
          <td>
           <form:select path="airline">
         <c:forEach var="emp" items="${ls1}">
         <form:option value="${emp.getAirline_code() }">${emp.getAirline_code() }(${emp.getAirline_name() })</form:option>  
         </c:forEach>
         </form:select>
          </td>  
         </tr>  
           <tr>    
          <td>Cost :</td>    
          <td><form:input path="cost" /></td>  
         </tr>   
           <tr>    
          <td>Seat :</td>    
          <td><form:input path="seats" /></td>  
         </tr> 
         <tr>    
          <td>Date :</td>    
          <td><form:input type="text" path="flightdate" id="datepicker-13" /></td>  
         </tr>  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>