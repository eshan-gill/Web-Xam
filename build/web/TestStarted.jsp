<%-- 
    Document   : TestStarted
    Created on : Apr 28, 2015, 10:57:43 PM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALQuestion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Test</title>
        <link href="style.css" rel="stylesheet" >
    </head>
    <body>
        <%@include  file="Header.html" %>
        <div id="ContentWrapper"> 
            <div id="LeftDiv"> 
                <%@include  file="Options.html" %>
            </div>

            <div id="RightDiv">
                <%  //Form not required as code has been transferred to StartTest.jsp
                    DataLayer.DALQuestion objDAL=new DALQuestion();
                    ArrayList<Beans.Question> All= objDAL.getQuestions(8);
                    int i=1;
                    for(Beans.Question Q:All)
                    {
                %>
                <%=Q.getQuestionText()%>
                <input type="hidden" name="Ques<%=i%>" value="<%=Q.getQuestionId()%>">
                <br><br>
                <%
                        for(Beans.Option O:Q.Options)
                        {
                %>
                <input type="radio" name="Opt<%=Q.getQuestionId()%>" value="<%=O.getOptionId()%>">
                <%=O.getOptionText()%>
                <br><br>
                <%
                        }
                        i++;
                    }
                %>
            </div>
        </div>
    </body>	
</html>