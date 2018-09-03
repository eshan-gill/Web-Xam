<%-- 
    Document   : CategoryList
    Author     : eshangill
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" >
        <title>WebXam Categories List</title>
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
    `
                </div>

                <div id="RightDiv">

                    <%
                        DataLayer.DALCategory objDAL = new DALCategory();
                        String ErrorMsg="";

                        if(request.getParameter("CIDD")!=null)
                        {
                            int y = Integer.parseInt(request.getParameter("CIDD"));
                            //objDAL.deleteCategory(y);
                            int RValue = objDAL.deleteCategory(y);
                            
                            if(RValue==-2)
                                ErrorMsg="Record cannot be deleted as it has related records!";
                            else
                                ErrorMsg="";
                        }

                        ArrayList<Beans.Category> AC = objDAL.getCategories();
                    %>
                    <form action="CategoriesList.jsp" name="frmCategories">
                        <table border="2"> 
                                 <tr>
                                     <th class="THeading">Category Name</th>
                                 </tr>

                                 <%
                                     for(Beans.Category C : AC)
                                     {
                                 %>

                                 <tr>
                                     <td class="TData"><%=C.getCategoryName() %> </td>
                                     <td class="TData"> 
                                         <a href="Category.jsp?CIDE=<%=C.getCategoryId() %>">Edit</a> 
                                     </td>
                                     <td class="TData"> 
                                         <a href="CategoriesList.jsp?CIDD=<%=C.getCategoryId() %>">Delete</a> 
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