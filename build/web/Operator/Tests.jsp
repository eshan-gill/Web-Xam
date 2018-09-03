<%-- 
    Document   : Tests
    Created on : Apr 17, 2015, 10:42:23 AM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALTest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALDepartment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Tests</title>
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
                    //For Department ComboBox
                    DataLayer.DALDepartment objDALDepartment = new DALDepartment();
                    ArrayList<Beans.Department> AD = objDALDepartment.getDepartments();
                    int x=0;

                    //To show empty list
                    DataLayer.DALTest objDALTest = new DALTest();
                    ArrayList<Beans.Test> AT= objDALTest.getTests(x);

                    if(request.getParameter("ddlDepartment")!=null)
                    {
                        //TO show relevant test of particular department
                        x = Integer.parseInt( request.getParameter("ddlDepartment"));
                        AT = objDALTest.getTests(x);
                    }

                %>
                <form action="Tests.jsp" name="frmTests">
                    Department: <select style="width:175px" name="ddlDepartment" onchange="this.form.submit();">
                        <option> </option>
                            <%
                                String sel="";
                                for(Beans.Department D : AD)
                                {
                                    if(x==D.getDepartmentId())
                                        sel="selected";
                                    else
                                        sel="";
                            %>

                            <option <%=sel%> value="<%=D.getDepartmentId()%>"> <%=D.getDepartmentName()%> </option>

                            <%}%>
                    </select>

                    <br>
                    <br>

                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Test Date</th>
                                 <th class="THeading">Job</th>
                                 <th class="THeading">Passing Score</th>
                                 <th class="THeading">Duration</th>
                             </tr>

                             <%
                                {
                                 for(Beans.Test T : AT)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=T.getTestDate()%> </td>
                                 <td class="TData"><%=T.getJobName()%> </td>
                                 <td class="TData"><%=T.getPassingScore()%> </td>
                                 <td class="TData"><%=T.getDuration()%> </td>
                                 <td class="TData"> 
                                     <a href="Candidates.jsp?TIDC=<%=T.getTestId() %>">Candidates</a> 
                                 </td>
                             </tr>
                             <%}}%>
                     </table>
                </form>
            </div>
        </div>
    </body>	
</html>