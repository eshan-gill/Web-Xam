<%-- 
    Document   : User
    Created on : May 23, 2015, 1:41:03 PM
    Author     : eshangill
--%>

<%@page import="Beans.User"%>
<%@page import="DataLayer.DALUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam User</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["frmUser"].elements["txtUserId"];
                var t2=document.forms["frmUser"].elements["txtPassword"];
                var t3=document.forms["frmUser"].elements["txtName"];
               
                if(t1.value=="")
                {
                    document.getElementById("spUserId").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spUserId").innerHTML= " ";
                }
                if(t2.value=="")
                {
                    document.getElementById("spPassword").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spPassword").innerHTML= " ";
                }
                if(t3.value=="")
                {
                    document.getElementById("spName").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spName").innerHTML= " ";
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
                    String SUserId="";
                    String SPassword="";
                    String SName="";
                    String VUserId="";
                    String VPassword="";
                    String VName="";
                    String VUserTypeA="checked";
                    String VUserTypeO="";
                    String sel="";
                        if(request.getParameter("btnAdd")!=null)
                        {
                            VUserId=request.getParameter("txtUserId");
                            VName=request.getParameter("txtName");
                            VPassword=request.getParameter("txtPassword");
                            if(request.getParameter("rdbUserType").equals("Admin"))
                            {
                                VUserTypeA="checked";
                                VUserTypeO="";
                            }
                            else
                            {
                                VUserTypeO="checked";
                                VUserTypeA="";
                            }
                            
                            boolean sv=true;
                            if(request.getParameter("txtUserId").length()<=0)
                            {
                                SUserId="Value empty!";
                                sv=false;
                            }
                            if(request.getParameter("txtPassword").length()<=0)
                            {
                                SPassword="Value empty!";
                                sv=false;
                            }
                            if(request.getParameter("txtName").length()<=0)
                            {
                                SName="Value empty!";
                                sv=false;
                            }

                            if(sv==true)
                            {
                                DataLayer.DALUser objDAL= new DALUser();
                                Beans.User obj= new User();
                                
                                if(objDAL.checkUserAvailability(request.getParameter("txtUserId"))==true)
                                {
                                     obj.setUserId(request.getParameter("txtUserId"));
                                     obj.setPassword(request.getParameter("txtPassword"));
                                     obj.setName(request.getParameter("txtName"));
                                     obj.setUserType(request.getParameter("rdbUserType"));
                                    
                                    objDAL.saveUser(obj);
                                    avl="";
                                    response.sendRedirect("UsersList.jsp");
                                }
                                else
                                {
                                    avl="UserId already exists";
                                }
                            }
                        }
                       
                    %>
                    <form action="User.jsp" name="frmUser">
                    <table>
                        <tr>
                            <td> User Id </td>
                            <td> <input type="text" name="txtUserId" maxlength="10" value="<%=VUserId%>"> </td>
                            <td> <font color="red"><span id="spUserId"> </span> </font> </td>
                            <td> <font color="red"><%=avl%> </font></td>
                            <td> <font color="red"><%=SUserId%> </font></td>
                        </tr>
                        <tr>
                            <td> Password </td>
                            <td> <input type="password" name="txtPassword" maxlength="10" value="<%=VPassword%>"> </td>
                            <td> <font color="red"><span id="spPassword"> </span></font> </td>
                            <td> <font color="red"><%=SPassword%> </font></td>
                        </tr>
                        <tr>
                            <td> Name </td>
                            <td> <input type="text" name="txtName" maxlength="25" value="<%=VName%>"> </td>
                            <td> <font color="red"><span id="spName"> </span></font> </td>
                            <td> <font color="red"><%=SName%> </font></td>
                        </tr>
                        <tr>
                            <td> User Type </td>
                            <td> <input type="radio" name="rdbUserType" value="Admin" <%=VUserTypeA%>> Admin
                                 <input type="radio" name="rdbUserType" value="Operator" <%=VUserTypeO%>> Operator
                            </td>
                        </tr>
                        <tr>
                            <td colspan="3"> <input type="submit" name="btnAdd" value="Add" onclick="return validateData()"> </td>
                        </tr>
                        
                    </table>
                </form>
            </div>
        </div>
    </body>	
</html>
