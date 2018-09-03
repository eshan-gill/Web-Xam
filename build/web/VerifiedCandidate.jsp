<%-- 
    Document   : VerifiedCandidate
    Created on : Apr 27, 2015, 5:33:54 PM
    Author     : eshangill
--%>

<%@page import="Beans.Candidate"%>
<%@page import="DataLayer.DALCandidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verified Candidate Details</title>
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
                    int CandidateId=Integer.parseInt(session.getAttribute("CandidateId").toString());
                    DataLayer.DALCandidate objDAL= new DALCandidate();
                    Beans.Candidate obj= new Candidate();
                    obj=objDAL.getCandidate(CandidateId);
                    session.setAttribute("TestId",obj.getTestId());
                    if(request.getParameter("btnProceed")!=null)
                    {
                        if(request.getParameter("chkAgree")!=null)
                        {
                            SAgree=" ";
                            response.sendRedirect("Instructions.jsp");
                        }
                        else
                        {
                            SAgree="You need to agree to the terms and conditions to proceed further";
                        }
                    }
                %>
                <form name="frmVerifiedCandidate" action="VerifiedCandidate.jsp">
                    <table>
                        <tr>
                            <td>Candidate Id: </td>
                            <td><%=obj.getCandidateId()%></td>
                        </tr>
                        <tr>
                            <td>Name: </td>
                            <td><%=obj.getName()%></td>
                        </tr>
                        <tr>
                            <td>Gender: </td>
                            <td><%=obj.getGender()%></td>
                        </tr>
                        <tr>
                            <td>Date of Birth: </td>
                            <td><%=obj.getDOB().substring(0,11)%></td>
                        </tr>
                        <tr>
                            <td>Father's Name: </td>
                            <td><%=obj.getFatherName()%></td>
                        </tr>
                        <tr>
                            <td>Higher Qualification: </td>
                            <td><%=obj.getHigherQualification()%></td>
                        </tr>
                        <tr>
                            <td>Address: </td>
                            <td><%=obj.getAddress()%></td>
                        </tr>
                        <tr>
                            <td>Contact No. : </td>
                            <td><%=obj.getContactNo()%></td>
                        </tr>
                        <tr>
                            <td>Email Id: </td>
                            <td><%=obj.getEmailId()%></td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><b><u>Terms and Conditions</u></b></td>
                        </tr>
                        <tr>
                            <td colspan="2">I hereby verify that all the details given above are correct.</td> 
                        </tr>
                        <tr>
                            <td colspan="2">In case of any discrepancy my candidature might be canceled.</td> 
                        </tr>
                        <tr>
                            <td colspan="2"><input type="checkbox" name="chkAgree">I agree</td>
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