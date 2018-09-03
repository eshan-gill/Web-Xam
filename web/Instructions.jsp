<%-- 
    Document   : Instructions
    Created on : Apr 27, 2015, 8:13:24 PM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALInstruction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Instructions</title>
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
                    String SAgree="";
                        DataLayer.DALInstruction objDAL = new DALInstruction();
                        int TestId=Integer.parseInt(session.getAttribute("TestId").toString());
                        ArrayList<Beans.Instruction> AI = objDAL.getInstructions(TestId);
                        if(request.getParameter("btnProceed")!=null)
                        {
                            if(request.getParameter("chkAgree")!=null)
                            {
                                response.sendRedirect("StartTest.jsp");
                                SAgree=" ";
                            }
                            else
                            {
                                SAgree="You need to agree to proceed further";
                            }
                        }
                %>
                <form action="Instructions.jsp" name="frmInstructions">
                    <table> 
                             <%
                                 for(Beans.Instruction I : AI)
                                 {
                             %>

                             <tr>
                                 <td><%=I.getInstructionText() %> </td>
                             </tr>
                             <%}%>
                             <tr>
                                 <td><input type="checkbox" name="chkAgree"> I Agree</td>
                             </tr>
                             <tr>
                                 <td colspan="2"><input type="submit" name="btnProceed" value="Proceed"></td>
                             </tr>
                             <tr>
                                <td colspan="2"><font color="red"><%=SAgree%></font></td>
                            </tr>
                     </table>
                </form>
            </div>
        </div>
    </body>	
</html>