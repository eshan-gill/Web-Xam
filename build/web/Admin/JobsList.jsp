<%-- 
    Document   : JobsList
    Created on : Apr 5, 2015, 2:30:11 PM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALJob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Jobs List</title>
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
                        DataLayer.DALJob objDAL = new DALJob();
                        String ErrorMsg="";
                        if(request.getParameter("JIDD")!=null)
                        {
                            int y = Integer.parseInt(request.getParameter("JIDD"));
                            //objDAL.deleteJob(y);
                            int RValue = objDAL.deleteJob(y);
                            
                            if(RValue==-2)
                                ErrorMsg="Record cannot be deleted as it has related records!";
                            else
                                ErrorMsg="";
                        }

                        ArrayList<Beans.Job> AJ = objDAL.getJobs();
                %>
                <form action="JobsList.jsp" name="frmJobsList">
                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Job Name</th>
                             </tr>

                             <%
                                 for(Beans.Job J : AJ)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=J.getJobName() %> </td>
                                 <td class="TData"> 
                                     <a href="Job.jsp?JIDE=<%=J.getJobId() %>">Edit</a> 
                                 </td>
                                 <td class="TData"> 
                                     <a href="JobsList.jsp?JIDD=<%=J.getJobId() %>">Delete</a> 
                                 </td>
                             </tr>
                             <%}%>
                     </table>
                     <font color="red"><%=ErrorMsg%></font>
                </form>
            </div>
        </div>
    </body>	
</html>