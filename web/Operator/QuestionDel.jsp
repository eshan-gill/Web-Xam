<%-- 
    Document   : QuestionDel
    Created on : May 25, 2015, 12:03:54 AM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALOption"%>
<%@page import="DataLayer.DALQuestion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%
                DataLayer.DALQuestion objDALQuestion = new DALQuestion();
                DataLayer.DALOption objDALOption = new DALOption();
                int y = Integer.parseInt(request.getParameter("QIDD"));
                objDALOption.deleteOption(y);
                objDALQuestion.deleteQuestion(y);
                response.sendRedirect("QuestionsList.jsp");
                        
        %>
    </body>
</html>
