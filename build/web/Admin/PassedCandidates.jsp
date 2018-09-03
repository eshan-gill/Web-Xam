<%-- 
    Document   : PassedCandidates
    Created on : May 12, 2015, 10:12:54 AM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALReport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passed Candidates</title>
        <link href="style.css" rel="stylesheet" >
        <style type="text/css">
            #ScrollDiv
            {
                height:350px;
                width:800px;
                overflow:auto;
            }
        </style>
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
                        DataLayer.DALReport objDAL = new DALReport();
                        ArrayList<Beans.Report> AR = objDAL.getPassedCandidates(Integer.parseInt(request.getParameter("TIDPC")));
                %>
                    <div id="ScrollDiv">
                    <table border="2"> 
                             <tr>
                                 
                                 <th class="THeading"> S. No. </th>
                                 <th class="THeading"> Candidate Id </th>
                                 <th class="THeading"> Name </th>
                                 <th class="THeading"> Father's Name </th>
                                 <th class="THeading"> Email Id </th>
                                 <th class="THeading"> Contact No. </th>
                                 <th class="THeading"> Attempted Questions </th>
                                 <th class="THeading"> Correct </th>
                                 <th class="THeading"> Incorrect </th>
                                 <th class="THeading"> Score </th>
                                 
                             </tr>

                             <%
                                 int i=1;
                                 for(Beans.Report R : AR)
                                 {
                             %>

                             <tr>
                                 
                                 <td class="TData"><%=i%>. </td>
                                 
                                 <td class="TData"><%=R.getCandidateId()%> </td>
                             
                                 <td class="TData"><%=R.getName() %> </td>
                             
                                 <td class="TData"><%=R.getFatherName()%> </td>
                             
                                 <td class="TData"><%=R.getEmailId()%> </td>
                             
                                 <td class="TData"><%=R.getContactNo()%> </td>
                             
                                 <td class="TData"><%=R.getAttempted()%> </td>
                             
                                 <td class="TData"><%=R.getCorrect()%> </td>
                             
                                 <td class="TData"><%=R.getIncorrect()%> </td>
                                 
                                 <td class="TData"><%=R.getScore()%> </td>
                             </tr>
                             <% i++; }%>
                     </table>
                    </div>
            </div>
                     
        </div>
    </body>
</html>
