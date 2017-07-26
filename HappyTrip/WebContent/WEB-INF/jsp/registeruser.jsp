<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registered User</title>
</head>

<body >
  <br>
<a href="main.html">Home</a>
<br>
<h1>Users List</h1>  

<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Username</th><th>Password</th><th>Email</th><th>Delete</th></tr>  

   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.getName()}</td>  
   <td>${user.getUsername()}</td>  
   <td>${user.getPassword()}</td>  
   <td>${user.getEmail()}</td>  
   <td><a href="deleteuser/${user.getUsername()}.html">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
  
</body>
</html>