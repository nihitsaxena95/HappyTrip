<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<br>
<a href="main.html">Home</a>
<br>
    <h1>Registration Form</h1>
    <form  method="get" action="/HappyTrip/routeupdate.html">
        <table cellpadding="3pt">
            <tr>
                <td>Departure:</td>
                <td><input type="number" name="dep" size="30" /></td>
            </tr>
            <tr>
                <td>Arrival :</td>
                <td><input type="number" name="arr" size="30" /></td>
            </tr>
 
            <tr>
                <td>Distance :</td>
                <td><input type="number" name="kms" size="30" /></td>
            </tr>
         
        </table>
        <p />
        <input type="submit" value="Add" />
    </form>
</body>
</html>