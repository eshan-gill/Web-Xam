<%-- 
    Document   : Logout
    Created on : May 13, 2015, 11:07:51 PM
    Author     : eshangill
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <%
            if(session!=null)
            {
                session.invalidate(); 
                           
                request.removeAttribute("LoggedRegId");
                request.removeAttribute("Name");
                request.removeAttribute("Pwd");

                response.sendRedirect("Login.jsp");
            }
            
          %>
    </body>
</html>
