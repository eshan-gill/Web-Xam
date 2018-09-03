<%-- 
    Document   : TestDel
    Created on : May 24, 2015, 1:41:16 PM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALTest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
        <%
            DataLayer.DALTest objDALTest = new DALTest();
            int y = Integer.parseInt(request.getParameter("TIDD"));
            objDALTest.deleteTest(y);
            response.sendRedirect("TestsList.jsp");
        %>
                        
    </body>
</html>
