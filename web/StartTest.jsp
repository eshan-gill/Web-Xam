<%-- 
    Document   : StartTest
    Created on : Apr 27, 2015, 9:16:17 PM
    Author     : eshangill
--%>

<%@page import="DataLayer.DALTestCategory"%>
<%@page import="Beans.TestCategory"%>
<%@page import="DataLayer.DALAttemptedQuestion"%>
<%@page import="DataLayer.DALConductedTest"%>
<%@page import="Beans.AttemptedQuestion"%>
<%@page import="Beans.ConductedTest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALQuestion"%>
<%@page import="DataLayer.DALTest"%>
<%@page import="Beans.Candidate"%>
<%@page import="DataLayer.DALCandidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Start Test</title>
        <link href="style.css" rel="stylesheet" >
        <script src="LatestJQuery.js"></script>
        
    </head>
    <body onload="fn1()">
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
                 <%
                    DataLayer.DALQuestion objDAL=new DALQuestion();
                    //All Test Categories Code:
                    ArrayList<Beans.TestCategory> ATC = new ArrayList<TestCategory>();
                    DataLayer.DALTestCategory objDALTestCategory=new DALTestCategory();
                    ATC= objDALTestCategory.getTestCategories(Integer.parseInt(session.getAttribute("TestId").toString()));
                    ArrayList<Beans.Question> All=null;
                    
                    /*for(Beans.TestCategory objTC: ATC)
                    {
                        All= objDAL.getQuestions(objTC.getCategoryId(),objTC.getNOQ());
                    }*/
                    All=objDAL.getQuestions(ATC);
                    
                    if(request.getParameter("btnSubmit")!=null)
                    {
                        int n=Integer.parseInt(request.getParameter("NOQ"));

                        DataLayer.DALConductedTest objDALConductedTest= new DALConductedTest();
                        Beans.ConductedTest objConductedTest= new ConductedTest();
                        
                        objConductedTest.setCandidateId(Integer.parseInt(session.getAttribute("CandidateId").toString()));
                        objConductedTest.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));
                        
                        if(objDALConductedTest.candidateTestConducted(Integer.parseInt(session.getAttribute("CandidateId").toString()))==false)
                            objDALConductedTest.saveConductedTest(objConductedTest);

                        DataLayer.DALAttemptedQuestion objDALAttemptedQuestion= new DALAttemptedQuestion();
                        Beans.AttemptedQuestion objAQuestions;
                        
                        Beans.ConductedTest objConductedTestTemp=objDALConductedTest.getConductedTest(Integer.parseInt(session.getAttribute("CandidateId").toString()));
                        int aConductedTestId=objConductedTestTemp.getConductedTestId();
                                
                        for(int i=1;i<=n;i++)
                        {
                            if(request.getParameter("Opt"+i)!=null)
                            {
                                objAQuestions= new AttemptedQuestion();
                                objAQuestions.setQuestionId(Integer.parseInt(request.getParameter("Ques"+i)));
                                objAQuestions.setConductedTestId(aConductedTestId);
                                objAQuestions.setOptionId(Integer.parseInt(request.getParameter("Opt"+i)));

                                objDALAttemptedQuestion.saveAttemptedQuestion(objAQuestions);
                                objConductedTest.AllAQuestions.add(objAQuestions);
                            }
                        }
                        response.sendRedirect("ReportCard.jsp?CTID="+aConductedTestId);
                    }
                %>
                <form name="frmStartTest" action="StartTest.jsp">
                    <br>
                <table>
                    <tr>
                        <td>Candidate Id: </td>
                        <td><%=objCandidate.getCandidateId()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Department: </td>
                        <td><%=objTest.getDepartmentName()%></td>
                    </tr>
                    <tr>
                        <td>Name: </td>
                        <td><%=objCandidate.getName()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Job: </td>
                        <td><%=objTest.getJobName()%></td>
                    </tr>
                    <tr>
                        <td>Gender: </td>
                        <td><%=objCandidate.getGender()%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Passing Score : </td>
                        <td><%=objTest.getPassingScore()%></td>
                    </tr>
                    <tr>
                        <td>Date of Birth: </td>
                        <td><%=objCandidate.getDOB().substring(0,11)%></td>
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td>Duration: </td>
                        <td><%=objTest.getDuration()%></td>
                    </tr>
                    <tr>
                        <td>Time Remaining: <font color="red"><b><span id="spTimer"></span></b></font></td>
                        <td> <input type="hidden" name="txtDuration" id="txtDuration" value="<%=objTest.getDuration()%>"> </td>
                    </tr>
                </table>
                <br>
                <b><hr></b>
                <br>
               
                
                    <input type="hidden" name="NOQ" value="<%=All.size() %>"> 

                    <%

                    int i=1;
                    for(Beans.Question Q:All)
                    {
                    %>

                    <b> Q<%=i%>: </b> <%=Q.getQuestionText()%>
                    <input type="hidden" name="Ques<%=i%>" value="<%=Q.getQuestionId()%>">
                    <br><br>
                    <%
                            for(Beans.Option O:Q.Options)
                            {
                    %>
                                <input type="radio" name="Opt<%=i%>" value="<%=O.getOptionId()%>">
                                <%=O.getOptionText()%>
                                <br><br>
                    <%
                            }
                            i++;
                    %>
                    <hr>
                    <%
                        }
                    %>
                    <input type="submit" name="btnSubmit" id="btnSubmit" value="Submit">
                </form>
    </div>
        <script type="text/javascript">
            var min=parseInt(document.getElementById("txtDuration").value)-1;
            var sec=60;
            setInterval("fn1()",1000);
            function fn1()
            {
                if(min==0 && sec==0)
                {
                    document.getElementById("btnSubmit").click();
                }
                else
                {
                    if(sec==0)
                    {
                        min=min-1;
                        sec=59;
                    }
                    else
                        sec=sec-1;
                    document.getElementById("spTimer").innerHTML= min+":"+sec;
                }
            }
        </script>
    </body>	
</html>