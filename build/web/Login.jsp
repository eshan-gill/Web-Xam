<%-- 
    Document   : Login
    Created on : Mar 29, 2015, 7:12:06 PM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Login</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["fLogin"].elements["txtUserId"];
                var t2=document.forms["fLogin"].elements["txtPwd"];
                
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
                    document.getElementById("spPwd").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spPwd").innerHTML= " ";
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
                <%@include  file="Options.html" %>
            </div>

            <div id="RightDiv">
                <%
                    Cookie[] cookies = request.getCookies();
                    String s="";
                    if(cookies!=null)
                    {
                        for(Cookie c : cookies)
                        {
                            if(c.getName().equals("UID"))
                            {
                                s=c.getValue();
                            }
                        }//For
                    }//IF
                %>
                <%
                    String msg="";
                    if(request.getParameter("btnSignIn")!=null)
                    {
                        DataLayer.DALUser objDAL = new DALUser();
                        Beans.User obj= objDAL.authenticateUser(request.getParameter("txtUserId"), request.getParameter("txtPwd"),request.getParameter("rdbUserType"));

                        if(obj.getSerialNo()>0)
                        {
                            session.setAttribute("LoggedRegId", obj.getSerialNo());
                            session.setAttribute("UserId",obj.getUserId());
                            session.setAttribute("Name", obj.getName());
                            session.setAttribute("PWD", obj.getPassword());

                            if(request.getParameter("chkRememberMe")!=null)
                            {
                                Cookie ck = new Cookie("UID", request.getParameter("txtUserId") );
                                ck.setMaxAge(60*60*60*24*30*12);
                                response.addCookie(ck);

                            }
                            if(request.getParameter("rdbUserType").equals("Admin"))
                                response.sendRedirect("Admin/Department.jsp");
                            else if(request.getParameter("rdbUserType").equals("Operator"))
                                response.sendRedirect("Operator/Tests.jsp");
                        }
                        else
                            msg="User Id or password incorrect!";
                    }
                %>
                <form action="Login.jsp" name="fLogin">
                    <table>
                        <tr>
                            <td> User Id </td>
                            <td> <input type="text" name="txtUserId" value="<%=s%>" maxlength="10"> </td>
                            <td> <font color="red"><span id="spUserId"> </span></font></td>
                        </tr>
                        <tr>
                            <td> Password </td>
                            <td> <input type="password" name="txtPwd" maxlength="10" > </td>
                             <td> <font color="red"><span id="spPwd"> </span></font></td>
                        </tr>
                        <tr>
                            <td> User Type </td>
                            <td> <input type="radio" name="rdbUserType" value="Admin" checked> Admin 
                                 <input type="radio" name="rdbUserType" value="Operator" > Operator</td>
                        </tr>
                        <tr>
                            <td colspan="3"> <input type="checkbox" name="chkRememberMe" > Remember Me</td>
                        </tr>
                        <tr>
                            <td colspan="3"> <input type="submit" name="btnSignIn" value="Sign In" onclick="return validateData();"> </td>
                        </tr>
                        <tr>
                            <td colspan="3"><font color="red"> <%=msg%> </font> </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>	
</html>