<%-- 
    Document   : Category
    Created on : Apr 5, 2015, 11:10:41 AM
    Author     : eshangill
--%>

<%@page import="Beans.Category"%>
<%@page import="DataLayer.DALCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Category Entry</title>
        <link href="style.css" rel="stylesheet" >
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["fCategory"].elements["txtCategoryName"];
               
                if(t1.value=="")
                {
                    document.getElementById("spCategoryName").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spCategoryName").innerHTML= " ";
                }
                return ret;
            }
        </script>
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
                    String avl="";
                    String SCategoryName="";
                    String ECategoryName="";
                    String EDescription="";
                        if(request.getParameter("btnSave")!=null)
                        {
                            boolean sv=true;
                            if(request.getParameter("txtCategoryName").length()<=0)
                            {
                                SCategoryName="Value empty!";
                                sv=false;
                            }

                            if(sv==true)
                            {
                               DataLayer.DALCategory objDAL= new DALCategory();
                               Beans.Category obj= new Category();
                                if(session.getAttribute("CategoryId")==null)//opened for saving
                                {
                                    if(objDAL.checkCategoryAvailability(request.getParameter("txtCategoryName"),0)==true)
                                    {

                                        obj.setCategoryName(request.getParameter("txtCategoryName"));
                                        if(request.getParameter("txtDescription").length()>0)
                                            obj.setDescription(request.getParameter("txtDescription"));
                                        else
                                            obj.setDescription(" ");
                                        objDAL.saveCategory(obj);
                                        avl="";
                                        response.sendRedirect("CategoriesList.jsp");
                                    }
                                    else
                                    {
                                        avl="Category already exists";
                                    }

                                }
                                else// opened for editing
                                {
                                    int pCategoryId=Integer.parseInt(session.getAttribute("CategoryId").toString());
                                    if(objDAL.checkCategoryAvailability(request.getParameter("txtCategoryName"),pCategoryId)==true)
                                    {
                                        obj.setCategoryName(request.getParameter("txtCategoryName"));
                                        if(request.getParameter("txtDescription").length()>0)
                                            obj.setDescription(request.getParameter("txtDescription"));
                                        else
                                            obj.setDescription(" ");
                                        obj.setCategoryId(Integer.parseInt(session.getAttribute("CategoryId").toString()));
                                        objDAL.updateCategory(obj);
                                        avl="";
                                        session.removeAttribute("CategoryId");
                                        response.sendRedirect("CategoriesList.jsp");
                                    }
                                    else
                                    {
                                        avl="Category already exists";
                                    }
                                }
                                
                            }


                        }
                        else if(request.getParameter("CIDE")!=null)
                        {
                            int EditCategoryId= Integer.parseInt(request.getParameter("CIDE"));

                            DataLayer.DALCategory objDAL= new DALCategory();
                            Beans.Category objE = objDAL.getCategory(EditCategoryId);
                            ECategoryName=objE.getCategoryName();
                            EDescription=objE.getDescription();

                            session.setAttribute("CategoryId", EditCategoryId);
                        }
                %>
                <form action="Category.jsp" name="fCategory">
                    <table>
                        <tr>
                            <td> Category Name <font color="red">*</font> </td>
                            <td> <input type="text" name="txtCategoryName" maxlength="20" value="<%=ECategoryName%>"> </td>
                            <td> <font color="red"><span id="spCategoryName"> </span> </font></td>
                            <td> <font color="red"><%=avl%></font> </td>
                            <td> <font color="red"><%=SCategoryName%> </font> </td>
                        </tr>
                        <tr>
                            <td> Description </td>
                            <td> <input type="text" name="txtDescription" maxlength="100" value="<%=EDescription%>"> </td>
                            <td> <font color="red"><span id="spDescription"> </span> </font></td>
                        </tr>

                        <tr>
                            <td colspan="3"> <input type="submit" name="btnSave" value="Save" onclick="return validateData()"> </td>
                        </tr>
                        <tr>
                            <td colspan="3"> <font color="red">Fields marked * are mandatory </font> </td>
                        </tr>
                    </table>
                </form>
                            
            </div>
        </div>
    </body>	
</html>