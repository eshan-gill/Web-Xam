<%-- 
    Document   : UsersDel
    Created on : May 24, 2015, 1:34:44 PM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <%
                DataLayer.DALUser objDAL = new DALUser();
                int y = Integer.parseInt(request.getParameter("UIDD"));
                objDAL.deleteUser(y);
                response.sendRedirect("UsersList.jsp");
                        
        %>
    </body>
</html>
