%-- 
    Document   : Verification
    Created on : Apr 27, 2015, 4:44:35 PM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALConductedTest"%>
<%@page import="Beans.Candidate"%>
<%@page import="DataLayer.DALCandidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Verification</title>
        <script type="text/javascript">
            function validateData()
            {
                ret=true;
                var t=document.forms["frmVerification"].elements["txtCandidateId"];
               
                if(t.value=="")
                {
                    document.getElementById("spCandidateId").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    if(isNaN(t.value)==true)
                    {
                        document.getElementById("spCandidateId").innerHTML= "Only numeric digits allowed";
                        ret= false;
                    }
                    else
                        document.getElementById("spCandidateId").innerHTML= " ";
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
                    String SCandidateId="";
                    String Invalidity="";
                    String Conducted="";
                        if(request.getParameter("btnVerify")!=null)
                        {
                            if(request.getParameter("txtCandidateId").length()==0)
                            {
                                SCandidateId="Value empty!";
                            }
                            else
                            {
                                DataLayer.DALCandidate objDAL= new DALCandidate();
                                if(objDAL.isNumeric(request.getParameter("txtCandidateId"))==true)
                                {
                                    SCandidateId="";

                                    if(objDAL.verifyCandidate(Integer.parseInt(request.getParameter("txtCandidateId")))==true)
                                    {
                                        DataLayer.DALConductedTest objDALConductedTest= new DALConductedTest();
                                        if(objDALConductedTest.candidateTestConducted(Integer.parseInt(request.getParameter("txtCandidateId")))==false)
                                        {
                                            Conducted="";
                                            session.setAttribute("CandidateId",Integer.parseInt(request.getParameter("txtCandidateId")));
                                            response.sendRedirect("VerifiedCandidate.jsp");
                                        }
                                        else
                                            Conducted="Test has already been conducted";
                                    }
                                    else
                                        Invalidity="Invalid CandidateId";
                                }
                                else
                                {
                                    SCandidateId="Only numeric digits allowed";
                                }
                            }
                        }
                %>
                <form name="frmVerification" action="Verification.jsp">
                    <table>
                        <tr>
                            <td>Candidate Id </td>
                            <td><input type="text" name="txtCandidateId" maxlength="5"></td>
                            <td><font color="red"><span id="spCandidateId"></span></font></td>
                            <td><font color="red"> <%=SCandidateId%> </font></td>
                        </tr>
                        <tr>
                            <td colspan="4"><input type="submit" name="btnVerify" value="Verify" onclick="return validateData();"></td>
                        </tr>
                        <tr>
                            <td><font color="red"><%=Invalidity%></font></td>
                            <td><font color="red"><%=Conducted%></font></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>	
</html>