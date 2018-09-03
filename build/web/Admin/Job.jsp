<%-- 
    Document   : Job
    Created on : Apr 5, 2015, 11:10:53 AM
    Author     : eshangill
--%>

<%@page import="Beans.Job"%>
<%@page import="DataLayer.DALJob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Job Entry</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["fJob"].elements["txtJobName"];
               
                if(t1.value=="")
                {
                    document.getElementById("spJobName").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spJobName").innerHTML= " ";
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
                    String avl="";
                    String SJobName="";
                    String EJobName="";
                    String EDescription="";
                        if(request.getParameter("btnSave")!=null)
                        {
                            boolean sv=true;
                            if(request.getParameter("txtJobName").length()<=0)
                            {
                                SJobName="Value empty!";
                                sv=false;
                            }

                            if(sv==true)
                            {
                                DataLayer.DALJob objDAL= new DALJob();
                                Beans.Job obj= new Job();
                                if(session.getAttribute("JobId")==null)//opened for saving
                                {
                                    if(objDAL.checkJobAvailability(request.getParameter("txtJobName"),0)==true)
                                    {
                                         obj.setJobName(request.getParameter("txtJobName"));
                                        if(request.getParameter("txtDescription").length()>0)
                                            obj.setDescription(request.getParameter("txtDescription"));
                                        else
                                            obj.setDescription(" ");
                                        objDAL.saveJob(obj);
                                        avl="";
                                        response.sendRedirect("JobsList.jsp");
                                    }
                                    else
                                    {
                                        avl="Job already exists";
                                    }
                                } 
                                else// opened for editing
                                {
                                    int pJobId= Integer.parseInt(session.getAttribute("JobId").toString());
                                    if(objDAL.checkJobAvailability(request.getParameter("txtJobName"),pJobId)==true)
                                    {
                                        obj.setJobName(request.getParameter("txtJobName"));
                                        if(request.getParameter("txtDescription").length()>0)
                                            obj.setDescription(request.getParameter("txtDescription"));
                                        else
                                            obj.setDescription(" ");

                                        obj.setJobId(Integer.parseInt(session.getAttribute("JobId").toString()));
                                        objDAL.updateJob(obj);
                                        avl="";
                                        session.removeAttribute("JobId");
                                        response.sendRedirect("JobsList.jsp");
                                    }
                                    else
                                    {
                                        avl="Job already exists";
                                    }
                                }
                            }
                        }
                        else if(request.getParameter("JIDE")!=null)
                        {
                            int EditJobId= Integer.parseInt(request.getParameter("JIDE"));

                            DataLayer.DALJob objDAL= new DALJob();
                            Beans.Job objE = objDAL.getJob(EditJobId);
                            EJobName=objE.getJobName();
                            EDescription=objE.getDescription();

                            session.setAttribute("JobId", EditJobId);
                        }
                        
                %>
                <form action="Job.jsp" name="fJob">
                    <table>
                        <tr>
                            <td> Job Name <font color="red">*</font> </td>
                            <td> <input type="text" name="txtJobName" maxlength="20" value="<%=EJobName%>"> </td>
                            <td> <font color="red"><span id="spJobName"> </span> </font> </td>
                            <td> <font color="red"><%=avl%> </font></td>
                            <td> <font color="red"><%=SJobName%> </font></td>
                        </tr>
                        <tr>
                            <td> Description </td>
                            <td> <input type="text" name="txtDescription" maxlength="100" value="<%=EDescription%>"> </td>
                            <td> <font color="red"><span id="spDescription"> </span></font> </td>
                        </tr>

                        <tr>
                            <td colspan="3"> <input type="submit" name="btnSave" value="Save" onclick="return validateData()"> </td>
                        </tr>
                        <tr>
                            <td colspan="3"> <font color="red">Fields marked * are mandatory </font> </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
       
    </body>	
</html>