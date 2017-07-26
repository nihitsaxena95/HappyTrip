<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  <br>
<a href="main.html">Home</a>
<br>
        <h1>Update Airline</h1>  
       <form:form method="get" action="/HappyTrip/update.html">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="airline_code" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="airline_name"  /></td>  
         </tr>    
         <tr>       
          <td><input type="submit" value="Update" /></td>    
         </tr>    
        </table>  
        <body >
        </body>  
       </form:form>    