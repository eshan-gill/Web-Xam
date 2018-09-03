<%-- 
    Document   : TestCategories
    Created on : Apr 6, 2015, 11:05:04 PM
    Author     : eshangill
--%>

<%@page import="Beans.TestCategory"%>
<%@page import="DataLayer.DALTestCategory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Test Categories</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["frmTestCategories"].elements["txtNOQ"];
               
                if(t1.value=="")
                {
                    document.getElementById("spNOQ").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    if(isNaN(t1.value)==true)
                    {
                        document.getElementById("spNOQ").innerHTML= "Only numeric digits allowed";
                        ret= false;
                    }
                    else
                        document.getElementById("spNOQ").innerHTML= " ";
                }
                return ret;
            }
        </script>
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
                    String msg="";
                    String SNOQ="";
                        //Combo Box Category
                        DataLayer.DALCategory objDALCategory = new DALCategory();
                        ArrayList<Beans.Category> AC = objDALCategory.getCategories();
                        int x=0;

                        if(request.getParameter("TIDC")!=null)
                        {
                            session.setAttribute("TestId",Integer.parseInt(request.getParameter("TIDC")));
                        }       

                        if(request.getParameter("btnAdd")!=null)
                        {
                            if(request.getParameter("txtNOQ").length()>0) //Server Side Validation
                            {
                                DataLayer.DALTestCategory objDALTestCategory= new DALTestCategory();
                                
                                if(objDALTestCategory.isNumeric(request.getParameter("txtNOQ"))==true)
                                {
                                    Beans.TestCategory obj= new TestCategory();

                                    obj.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));
                                    obj.setCategoryId(Integer.parseInt(request.getParameter("ddlCategory")));
                                    obj.setNOQ(Integer.parseInt(request.getParameter("txtNOQ")));

                                    objDALTestCategory.saveTestCategory(obj);

                                    SNOQ="";
                                    msg="Record Saved!";
                                }
                                else
                                {
                                    SNOQ="Only numeric digits allowed";
                                }
                            }
                            else
                            {
                                SNOQ="Value is empty";
                                msg="";
                            }
                        }
                        else
                            msg="";
                    //To show empty list
                    int ti=0;//TestId
                    DataLayer.DALTestCategory objDALTestCategory = new DALTestCategory();
                    ArrayList<Beans.TestCategory> ATC= objDALTestCategory.getTestCategories(ti);

                    if(session.getAttribute("TestId")!=null)
                    {
                        if(request.getParameter("TCIDD")!=null)
                        {
                            int y = Integer.parseInt(request.getParameter("TCIDD"));
                            objDALTestCategory.deleteTestCategory(y);

                        }
                        //TO show relevant Test Category of particular Test
                        ti = Integer.parseInt(session.getAttribute("TestId").toString());
                        ATC = objDALTestCategory.getTestCategories(ti);
                    }
                %>
                <form action="TestCategories.jsp" name="frmTestCategories">
                    <table>
                        <tr>
                            <td>Category</td>
                            <td>
                                <select style="width:175px" name="ddlCategory">

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
                            </td>
                        </tr>

                        <tr>
                            <td>No. of Questions</td>
                            <td><input type="text" name="txtNOQ" maxlength="3"></td>
                            <td><span id="spNOQ"></span></td>
                            <td><%=SNOQ%></td>
                        </tr>
                        <tr>
                            <td colspan="4"><input type="submit" name="btnAdd" value="Add" onclick="return validateData()"></td>
                        </tr>
                        <tr>
                            <td><font color="red"><%=msg%></font></td>
                        </tr>
                    </table>
                        <br>
                    <br>
                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Category</th>
                                 <th class="THeading">NOQ</th>

                             </tr>

                             <%

                                 for(Beans.TestCategory TC : ATC)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=TC.getCategoryName()%> </td>
                                 <td class="TData"><%=TC.getNOQ()%> </td>

                                 <td class="TData"> 
                                     <a href="TestCategories.jsp?TCIDD=<%=TC.getSerialNo()%>">Delete</a> 
                                 </td>
                             </tr>
                             <%}%>
                     </table>
                </form>
            </div>
        </div>
    </body>	
</html>