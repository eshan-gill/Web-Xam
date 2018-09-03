<%-- 
    Document   : ChangePassword
    Created on : May 13, 2015, 11:07:11 PM
    Author     : eshangill
--%>

<%@page import="org.omg.CORBA.PRIVATE_MEMBER"%>
<%@page import="DataLayer.DALUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Change Password</title>
        <link href="style.css" rel="stylesheet" >
        <script type="text/javascript">
            
            function validateData()
            {
                var x=true;
                
                var t1 = document.forms["fPwd"].elements["txtOldPwd"];
                var t2 = document.forms["fPwd"].elements["txtNewPwd"];
                var t3 = document.forms["fPwd"].elements["txtConfirmPwd"];
                
                if(t1.value == "")
                {
                    document.getElementById("spOldPwd").innerHTML="Value is empty!";
                    x=false;
                }
                else
                {
                    document.getElementById("spOldPwd").innerHTML="";
                }
                if(t2.value == "")
                {
                    document.getElementById("spNewPwd").innerHTML="Value is empty!";
                    x=false;
                }
                else
                {
                    document.getElementById("spNewPwd").innerHTML="";
                    
                }
                if(t3.value == "")
                {
                    document.getElementById("spConfirmPwd").innerHTML="Value is empty!";
                    x=false;
                }
                else
                {
                    document.getElementById("spConfirmPwd").innerHTML="";
                    
                }
                
                if(t2.value!=t3.value)
                {
                    document.getElementById("spConfirmPwd").innerHTML="Passwords do not match!";
                    x=false;
                } 
                return x;
            }
        </script>
    </head>
    <body>
        <%@include  file="Header.html" %>
        <div id="ContentWrapper"> 
            <div id="LeftDiv"> 
                <%@include  file="Options.html" %>
            </div>

            <div id="RightDiv">
                
                
                <%
                    String msg1="";
                    if(request.getParameter("btnChange")!=null)
                    {
                        
                            int x = Integer.parseInt(session.getAttribute("LoggedRegId").toString());
                            String realPwd = session.getAttribute("PWD").toString();

                            DataLayer.DALUser objDAL = new DALUser();

                            String oldp = request.getParameter("txtOldPwd");
                            String newp = request.getParameter("txtNewPwd");

                            if(oldp.equals(realPwd))
                            {
                               objDAL.UpdatePassword(x,newp);
                               response.sendRedirect("Tests.jsp");
                            }
                            else
                            {
                                msg1="Password Incorrect!";
                            }
                        
                            
                    }
                   
                    %>
                <form action="ChangePassword.jsp" name="fPwd">
                    <table>
                        <tr>
                            <td> Old Password </td>
                            <td> <input type ="password" name="txtOldPwd" maxlength="20"> </td>
                            <td> <font color="red"><span id="spOldPwd"> </span></font> </td>
                           
                            <td> <font color="red"><%=msg1%> </td>
                        </tr>
                        <tr>
                            <td> New Password </td>
                            <td> <input type ="password" name="txtNewPwd" maxlength="20"> </td>
                            <td> <font color="red"><span id="spNewPwd"> </span> </font></td>
                            
                        </tr>
                        <tr>
                            <td> Confirm Password </td>
                            <td> <input type ="password" name="txtConfirmPwd" maxlength="20"> </td>
                            <td> <font color="red"><span id="spConfirmPwd"> </span></font> </td>
                            
                        </tr>
                        <tr>
                            <td colspan="4"> <input type="submit" name="btnChange" value="Change" onclick="return validateData()" </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
