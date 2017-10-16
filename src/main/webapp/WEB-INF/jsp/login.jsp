<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
   	 <p>${failedLoginMessage}</p>
      <h2>Login</h2>
      <form:form modelAttribute="user" method = "POST" action = "/reading-monitor/login">
         <table>
            <tr>
               <td><form:label path = "email">Email</form:label></td>
               <td><form:input path = "email" /></td>
               <td><form:errors path = "email"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "password">Password</form:label></td>
               <td><form:input path = "password" /></td>
               <td><form:errors path = "password"></form:errors>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <a href="/reading-monitor/register">New User? Register Here</a>
   </body>
   
</html>