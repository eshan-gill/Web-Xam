<%-- 
    Document   : QuestionsList
    Created on : May 24, 2015, 11:28:09 PM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALOption"%>
<%@page import="DataLayer.DALQuestion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Questions List</title>
        <link href="style.css" rel="stylesheet" >
    </head>
    <body>
        <%@include  file="Header.html" %>
        <div id="ContentWrapper"> 
            <div id="LeftDiv"> 
                <%
                    if(session.getAttribute("Name")!=null)
                    {
                %>
                    <b>Welcome <%=session.getAttribute("Name")%>!</b>
                <%}%>
                <%@include  file="Options.html" %>
            </div>

            <div id="RightDiv">
                <%
                    //For Category ComboBox
                    DataLayer.DALCategory objDALCategory = new DALCategory();
                    ArrayList<Beans.Category> AC = objDALCategory.getCategories();
                    int x=0,y=0;

                    //To show empty list
                    DataLayer.DALQuestion objDALQuestion = new DALQuestion();
                    ArrayList<Beans.Question> AQ= objDALQuestion.getQuestionsWithCategoryId(x);
                    DataLayer.DALOption objDALOption = new DALOption();
                    ArrayList<Beans.Option> AO= objDALOption.getOptionsWithQuestionId(y);

                    if(request.getParameter("ddlCategory")!=null)
                    {
                        //TO show relevant questions of particular category
                        x = Integer.parseInt( request.getParameter("ddlCategory"));
                        AQ = objDALQuestion.getQuestionsWithCategoryId(x);
                    }

                %>
                <form action="QuestionsList.jsp" name="frmQuestionsList">
                    Category:&nbsp; 
                    <select style="width:175px" name="ddlCategory" onchange="this.form.submit();">
                            <option> </option>
                            <%
                                String sel="";
                                for(Beans.Category C : AC)
                                {
                                    if(x==C.getCategoryId())
                                        sel="selected";
                                    else
                                        sel="";
                            %>

                            <option <%=sel%> value="<%=C.getCategoryId()%>"> <%=C.getCategoryName()%> </option>

                            <%}%>
                    </select>

                    <br>
                    <br>
                    
                    <div id="ScrollDiv" style="height: 400px; width: 820px">
                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Question</th>
                                 <th class="THeading">Option A</th>
                                 <th class="THeading">Option B</th>
                                 <th class="THeading">Option C</th>
                                 <th class="THeading">Option D</th>
                                 <th class="THeading">Correct Option</th>
                             </tr>

                             <%
                                
                                 for(Beans.Question Q : AQ)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=Q.getQuestionText()%> </td>
                                 <%
                                        y = Q.getQuestionId();
                                        AO = objDALOption.getOptionsWithQuestionId(y);
                                        for(Beans.Option O : AO)
                                        {
                                 %>
                                 
                                 <td class="TData"><%=O.getOptionText()%> </td>
                                 <%
                                        }
                                        for(Beans.Option O : AO)
                                        {
                                            if(O.getIsAnswer()==1)
                                            {
                                 %>
                                 <td class="TData"><%=O.getOptionText()%> </td>
                                 <%
                                            }
                                        }
                                 %>
                                 <td class="TData"> 
                                     <a href="QuestionDel.jsp?QIDD=<%=Q.getQuestionId()%>">Delete</a> 
                                 </td>
                                
                             </tr>
                             <%}%>
                     </table>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
