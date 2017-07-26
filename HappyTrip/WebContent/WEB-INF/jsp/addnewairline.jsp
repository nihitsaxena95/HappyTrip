<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <a href="main.html">Home</a>
  <br>
        <h1>Add Airline</h1>  
       <form:form method="get" action="addairlineinfo.html">    
        <table >    
        <tr>  
        <td>Code : </td>    
         <td><form:input  path="airline_code" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="airline_name"  /></td>  
         </tr>    
         <tr>       
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
       <body>
       </body>
       <p style="color:red">${mess}</p>