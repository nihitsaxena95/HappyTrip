     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validateform(){  
	var name=document.loginview.username.value;  
	var password=document.loginview.password.value;  
	if (name==null || name==""){  
	  alert("Name can't be blank");  
	  return false;  
	}else if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	  }  
	} 
</script>

<body >
<h1>Login to HappyTrip</h1>
 <form:form name="loginview" method="post" action="check.html" onsubmit = "return validateform()">
        <table cellpadding="3pt">
            <tr>
                <td>User Name :</td>
                <td><form:input type="text" path="username" size="30" /></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><form:input type="password" path="password" size="30" /></td>
            </tr>
        </table>
        <p />
        <input type="submit" value="Login" />
       
       </form:form>
       <br>
       <a href="userform.html">Click here to Register</a>
       <p style="color:red">${message}</p>
</body>
</html>