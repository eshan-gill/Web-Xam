<%-- 
    Document   : UsersList
    Created on : May 23, 2015, 2:26:45 PM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Users List</title>
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
                    String x="Admin"; 

                    //To show empty list
                    DataLayer.DALUser objDAL = new DALUser();
                    ArrayList<Beans.User> AU= objDAL.getUsers(x);

                    if(request.getParameter("ddlUserType")!=null)
                    {
                        
                        //TO show relevant user of particular type
                        x = request.getParameter("ddlUserType");
                        AU = objDAL.getUsers(x);
                    }

                %>
                <form action="UsersList.jsp" name="frmUsersList">
                    <select style="width:175px" name="ddlUserType" onchange="this.form.submit();">

                            <%
                                String selA="";
                                String selO="";
                                
                                    if(x.equals("Admin"))
                                    {
                                        selA="selected";
                                        selO="";
                                    } 
                                    else if(x.equals("Operator"))
                                    {
                                        selO="selected";
                                        selA="";
                                    }
                                        
                            %>

                            <option <%=selA%> value="Admin"> Admin </option>
                            <option <%=selO%> value="Operator"> Operator </option>

                            
                    </select>

                    <br>
                    <br>

                    <table border="2"> 
                             <tr>
                                 <th class="THeading">User Id</th>
                                 <th class="THeading">Name</th>
                             </tr>

                             <%
                                {
                                 for(Beans.User U : AU)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=U.getUserId()%></td>
                                 <td class="TData"><%=U.getName()%> </td>
                                 <%
                                     if(session.getAttribute("UserId").toString().equals("master") && U.getUserId().equals("master")==false)
                                     {
                                 %>
                                 <td class="TData"> 
                                     <a href="UserDel.jsp?UIDD=<%=U.getSerialNo()%>">Delete</a> 
                                 </td>
                                 <%
                                     }
                                 %>
                             </tr>
                             <%}}%>
                             
                     </table>
                     
                </form>
            </div>
        </div>
    </body>
</html>
