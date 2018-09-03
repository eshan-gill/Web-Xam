<%-- 
    Document   : Test
    Created on : Apr 6, 2015, 10:45:52 AM
    Author     : eshangill
--%>

<%@page import="Beans.Test"%>
<%@page import="DataLayer.DALTest"%>
<%@page import="DataLayer.DALJob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALDepartment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Test</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["frmTest"].elements["dtTestDate"];
                var t2=document.forms["frmTest"].elements["txtPassingScore"];
                var t3=document.forms["frmTest"].elements["txtDuration"];
               
                if(t1.value=="")
                {
                    document.getElementById("spTestDate").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spTestDate").innerHTML= " ";
                }
                if(t2.value=="")
                {
                    document.getElementById("spPassingScore").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    if(isNaN(t2.value)==true)
                    {
                        document.getElementById("spPassingScore").innerHTML= "Only numeric digits allowed";
                        ret= false;
                    }
                    else
                        document.getElementById("spPassingScore").innerHTML= " ";
                }
                if(t3.value=="")
                {
                    document.getElementById("spDuration").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    if(isNaN(t3.value)==true)
                    {
                        document.getElementById("spDuration").innerHTML= "Only numeric digits allowed";
                        ret= false;
                    }
                    else
                        document.getElementById("spDuration").innerHTML= " ";
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
                <%!
                    String STestDate="";
                    String SPassingScore="";
                    String SDuration="";

                    private boolean sValidateData(HttpServletRequest request)
                    {
                        DataLayer.DALTest objDALTest1= new DALTest();
                        boolean ret=true;
                        if(request.getParameter("dtTestDate").length()<=0)
                        {
                            STestDate="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            STestDate="";
                        }

                        if(request.getParameter("txtPassingScore").length()<=0)
                        {
                            SPassingScore="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            if(objDALTest1.isNumeric(request.getParameter("txtPassingScore"))==true)
                                SPassingScore="";
                            else
                            {
                                SPassingScore="Only numeric digits allowed"; 
                                ret=false;
                            }
                        }

                        if(request.getParameter("txtDuration").length()<=0)
                        {
                            SDuration="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            if(objDALTest1.isNumeric(request.getParameter("txtDuration"))==true)
                                SDuration="";
                            else
                            {
                                SDuration="Only numeric digits allowed"; 
                                ret=false;
                            }
                        }
                        return ret;
                    }
                 %>

                 <%
                    
                    String ETestDate="";
                    int EDepartmentId=0;
                    int EJobId=0;
                    String EPassingScore="";
                    String EDuration="";
                            //Combo Box Department
                            DataLayer.DALDepartment objDALDepartment = new DALDepartment();
                            ArrayList<Beans.Department> AD = objDALDepartment.getDepartments();

                            //Combo Box Job
                            DataLayer.DALJob objDALJob = new DALJob();
                            ArrayList<Beans.Job> AJ = objDALJob.getJobs();

                            if(request.getParameter("btnSchedule")!=null)
                            {
                                
                                boolean sv= sValidateData(request);
                                if(sv==true)
                                {
                                    DataLayer.DALTest objDALTest= new DALTest();
                                    Beans.Test obj= new Test();

                                    obj.setTestDate(request.getParameter("dtTestDate"));
                                    obj.setDepartmentId(Integer.parseInt(request.getParameter("ddlDepartment")));
                                    obj.setJobId(Integer.parseInt(request.getParameter("ddlJob")));
                                    obj.setPassingScore(Integer.parseInt(request.getParameter("txtPassingScore")));
                                    obj.setDuration(Integer.parseInt(request.getParameter("txtDuration")));

                                    if(session.getAttribute("TestId")==null) //Saving Data
                                    {
                                        objDALTest.saveTest(obj);
                                        response.sendRedirect("TestsList.jsp");
                                    }
                                    else //Updating Data
                                    {
                                        obj.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));
                                        objDALTest.updateTest(obj);
                                        response.sendRedirect("TestsList.jsp");
                                    }
                                }
                                
                            }
                            else if(request.getParameter("TIDE")!=null)
                            {
                                int EditTestId= Integer.parseInt(request.getParameter("TIDE"));

                                DataLayer.DALTest objDALTest= new DALTest();
                                Beans.Test objE = objDALTest.getTest(EditTestId);
                                ETestDate=objE.getTestDate();
                                EDepartmentId=objE.getDepartmentId();
                                EJobId=objE.getJobId();
                                EPassingScore= String.valueOf(objE.getPassingScore());
                                EDuration=String.valueOf(objE.getDuration());

                                session.setAttribute("TestId", EditTestId);
                            }
                            
                %> 
                <form action="Test.jsp" name="frmTest">
                    <table>
                        <tr>
                            <td>Test Date</td>
                            <td><input type="text" name="dtTestDate" maxlength="10" value="<%=ETestDate%>"></td>
                            <td><font color="red"><span id="spTestDate"> </span></font></td>
                            <td><font color="red"><%=STestDate%></font></td>
                        </tr>
                        <tr>
                            <td>Department</td>
                            <td>
                                <select style="width:175px" name="ddlDepartment">

                                        <%
                                            String selD="";
                                            for(Beans.Department D : AD)
                                            {
                                                if(EDepartmentId==D.getDepartmentId())
                                                    selD="selected";
                                                else
                                                    selD="";
                                        %>

                                        <option <%=selD%> value="<%=D.getDepartmentId()%>"> <%=D.getDepartmentName()%> </option>

                                        <%}%>
                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td>Job</td>
                            <td>
                                <select style="width:175px" name="ddlJob">

                                        <%
                                            String selJ="";
                                            for(Beans.Job J : AJ)
                                            {
                                                if(EJobId==J.getJobId())
                                                    selJ="selected";
                                                else
                                                    selJ="";
                                        %>

                                        <option <%=selJ%> value="<%=J.getJobId()%>"> <%=J.getJobName()%> </option>

                                        <%}%>
                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td>Passing Score</td>
                            <td><input type="text" name="txtPassingScore" maxlength="4" value="<%=EPassingScore%>"></td>
                            <td><font color="red"><span id="spPassingScore"> </span></font></td>
                            <td><font color="red"><%=SPassingScore%></font></td>
                        </tr>
                        <tr>
                            <td>Duration</td>
                            <td><input type="text" name="txtDuration" maxlength="3" value="<%=EDuration%>"></td>
                            <td><font color="red"><span id="spDuration"></span></font></td>
                            <td><font color="red"><%=SDuration%></font></td>
                        </tr>
                        <tr>
                            <td colspan="4"><input type="submit" name="btnSchedule" value="Schedule" onclick="return validateData();"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>	
</html>