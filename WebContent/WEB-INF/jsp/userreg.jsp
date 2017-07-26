<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	var name=document.registeruser.name.value;  
	var uname = document.registeruser.username.value;
	var password=document.registeruser.password.value;  
	var email = document.registeruser.email.value;
	var atposition=email.indexOf("@");  
	var dotposition=email.lastIndexOf(".");  
	
	if (uname==null || uname==""){  
	  alert("Username Empty");  
	  return false;  
}else if(name == null || name == "")
	{
	alert("Name can't be blank");
	return false;
    }else if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	}else if(atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length)
		{
		alert("Valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);
		}
	} 
</script>

<body>
<br>
<a href="main.html">Home</a>
<br>
<h1>Register Here</h1>  <br>
       <form:form name="registeruser" method="post" action="save.html" onsubmit = "return validateform()">
      <%--  Enter username : <form:input path="username"  /><br>
       Enter password : <form:input path="password" />    
       <button type="submit">Save</button> --%>
       <table cellpadding="3pt">
            <tr>
                <td>User Name :</td>
                <td><form:input type="text" path="username" size="30" /></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><form:input type="password" path="password" size="30" /></td>
            </tr>
 
            <tr>
                <td>Name :</td>
                <td><form:input type="text" path="name" size="30" /></td>
            </tr>
            <tr>
                <td>E-mail :</td>
                <td><form:input type="text" path="email" size="30" /></td>
            </tr>
           
        </table>
        <p />
        <input type="submit" value="Register" />
       </form:form>
       <p style="color:red">${message}</p>
</body>
</html>