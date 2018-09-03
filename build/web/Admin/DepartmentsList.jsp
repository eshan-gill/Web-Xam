<%-- 
    Document   : DepartmentsList
    Created on : Apr 5, 2015, 2:29:35 PM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALDepartment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Departments List</title>
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
                        DataLayer.DALDepartment objDAL = new DALDepartment();
                        
                        String ErrorMsg="";
                        if(request.getParameter("DIDD")!=null)
                        {
                            int y = Integer.parseInt(request.getParameter("DIDD"));
                            int RValue = objDAL.deleteDepartment(y);
                            
                            if(RValue==-2)
                                ErrorMsg="Record cannot be deleted as it has related records!";
                            else
                                ErrorMsg="";
                        }

                        ArrayList<Beans.Department> AD = objDAL.getDepartments();
                %>
                <form action="DepartmentsList.jsp" name="frmDeptList">
                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Department Name</th>
                                 <th class="THeading">Address</th>
                                 <th class="THeading">Contact No.</th>
                                 <th class="THeading">Contact Person</th>
                             </tr>

                             <%
                                 for(Beans.Department D : AD)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=D.getDepartmentName() %> </td>
                                 <td class="TData"><%=D.getAddress() %> </td>
                                 <td class="TData"><%=D.getContactNo() %> </td>
                                 <td class="TData"><%=D.getContactPerson()%> </td>
                                 <td class="TData"> 
                                     <a href="Department.jsp?DIDE=<%=D.getDepartmentId() %>">Edit</a> 
                                 </td>
                                 <td class="TData"> 
                                     <a href="DepartmentsList.jsp?DIDD=<%=D.getDepartmentId() %>">Delete</a> 
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