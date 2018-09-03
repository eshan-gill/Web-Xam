<%-- 
    Document   : ReportCard
    Created on : May 8, 2015, 12:19:25 PM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.QOAttemptedQuestion"%>
<%@page import="DataLayer.DALAttemptedQuestion"%>
<%@page import="DataLayer.DALTest"%>
<%@page import="DataLayer.DALCandidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Report Card</title>
        <link href="style.css" rel="stylesheet" >
    </head>
    <body>
        <%@include  file="Header.html" %>
        <div id="ContentWrapper"> 
           <%
                int CandidateId=Integer.parseInt(session.getAttribute("CandidateId").toString());
                int TestId=Integer.parseInt(session.getAttribute("TestId").toString());

                DataLayer.DALCandidate objDALCandidate= new DALCandidate();
                Beans.Candidate objCandidate;
                objCandidate=objDALCandidate.getCandidate(CandidateId);

                DataLayer.DALTest objDALTest= new DALTest();
                Beans.Test objTest;
                objTest=objDALTest.getFullTestDetails(TestId);

            %>
            <table>
                    <tr>
                        <td>Candidate Id: </td>
                        <td><%=objCandidate.getCandidateId()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        
                        <td>Name: </td>
                        <td><%=objCandidate.getName()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        
                        <td>Father's Name: </td>
                        <td><%=objCandidate.getFatherName()%></td>
                        
                    </tr>
                    <tr>
                        <td>Gender: </td>
                        <td><%=objCandidate.getGender()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        
                        <td>Date of Birth: </td>
                        <td><%=objCandidate.getDOB().substring(0,11)%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        
                        <td>Contact No. :</td>
                        <td><%=objCandidate.getContactNo()%></td>
                    </tr>
                    <tr>
                        <td>Email Id: </td>
                        <td><%=objCandidate.getEmailId()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        
                        
                    </tr>
                </table>
                <br>
                <b><hr></b>
                <br>
                
                <%
                    DataLayer.DALAttemptedQuestion objDAL=new DALAttemptedQuestion();
                    ArrayList<Beans.QOAttemptedQuestion> AAQ;
                    AAQ=objDAL.getQOAttemptedQuestions(Integer.parseInt(request.getParameter("CTID")));
                %>
                <%
                    int i=1;
                    for(Beans.QOAttemptedQuestion obj:AAQ)
                    {
                        
                %>

                    <b> Q: </b> <%=obj.getQText()%> <br>
                    <b> Option Marked: </b> <%=obj.getOText()%><br>
                    <br>
                    <hr>
                    <br>
                    <%
                        i++;
                        }
                    %>
                    <%
                        if(session!=null)
                        {
                            session.invalidate(); 

                            request.removeAttribute("CandidateId");
                            request.removeAttribute("TestId");
                            
                        }
                    %>
        </div>
    </body>
</html>
