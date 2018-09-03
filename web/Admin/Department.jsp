<%-- 
    Document   : Department
    Created on : Mar 29, 2015, 4:59:54 PM
    Author     : eshangill
--%>

<%@page import="Beans.Department"%>
<%@page import="DataLayer.DALDepartment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" >
        <title>WebXam Department Entry</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["fDept"].elements["txtDepartmentName"];
                var t2=document.forms["fDept"].elements["txtAddress"];
                var t3=document.forms["fDept"].elements["txtContactNo"];
                var t4=document.forms["fDept"].elements["txtContactPerson"];
                
                if(t1.value=="")
                {
                    document.getElementById("spDepartmentName").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spDepartmentName").innerHTML= " ";
                }
                if(t2.value=="")
                {
                    document.getElementById("spAddress").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spAddress").innerHTML= " ";
                }
                if(t3.value=="")
                {
                    document.getElementById("spContactNo").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spContactNo").innerHTML= " ";
                }
                if(t4.value=="")
                {
                    document.getElementById("spContactPerson").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spContactPerson").innerHTML= " ";
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

                    String SDepartmentName="";
                    String SAddress="";
                    String SContactNo="";
                    String SContactPerson="";

                    String EDepartmentName="";
                    String EAddress="";
                    String ECity="";
                    String EContactNo="";
                    String EEmailId="";
                    String EContactPerson="";
                        if(request.getParameter("btnSave")!=null)
                        {
                            boolean sv=true;
                            if(request.getParameter("txtDepartmentName").length()<=0)
                            {
                                SDepartmentName="Value empty!";
                                sv=false;
                            }
                            if(request.getParameter("txtAddress").length()<=0)
                            {
                                SAddress="Value empty!";
                                sv=false;
                            }
                            if(request.getParameter("txtContactNo").length()<=0)
                            {
                                SContactNo="Value empty!";
                                sv=false;
                            }
                            if(request.getParameter("txtContactPerson").length()<=0)
                            {
                                SContactPerson="Value empty!";
                                sv=false;
                            }

                            if(sv==true)
                            {
                               DataLayer.DALDepartment objDAL= new DALDepartment();
                               Beans.Department obj= new Department();
                                if(session.getAttribute("DepartmentId")==null)//opened for saving
                                {
                                    if(objDAL.checkDeptAvailability(request.getParameter("txtDepartmentName"),0)==true)
                                    {
                                         obj.setDepartmentName(request.getParameter("txtDepartmentName"));
                                         obj.setAddress(request.getParameter("txtAddress"));
                                         if(request.getParameter("txtCity").length()>0)
                                            obj.setCity(request.getParameter("txtCity"));
                                         else
                                             obj.setCity(" ");
                                         obj.setContactNo(request.getParameter("txtContactNo"));
                                         if(request.getParameter("txtEmailId").length()>0)
                                            obj.setEmailId(request.getParameter("txtEmailId"));
                                         else
                                             obj.setEmailId(" ");
                                         obj.setContactPerson(request.getParameter("txtContactPerson"));
                                         objDAL.saveDepartment(obj);
                                         avl="";
                                         response.sendRedirect("DepartmentsList.jsp");
                                    }
                                    else
                                    {
                                        avl="Department already exists";
                                    }
                                }
                                else// opened for editing
                                {
                                    int pDepartmentId= Integer.parseInt(session.getAttribute("DepartmentId").toString());
                                    if(objDAL.checkDeptAvailability(request.getParameter("txtDepartmentName"),pDepartmentId)==true)
                                    {
                                        obj.setDepartmentName(request.getParameter("txtDepartmentName"));
                                        obj.setAddress(request.getParameter("txtAddress"));
                                        if(request.getParameter("txtCity").length()>0)
                                            obj.setCity(request.getParameter("txtCity"));
                                        else
                                            obj.setCity(" ");
                                        obj.setContactNo(request.getParameter("txtContactNo"));
                                        if(request.getParameter("txtEmailId").length()>0)
                                            obj.setEmailId(request.getParameter("txtEmailId"));
                                        else
                                            obj.setEmailId(" ");
                                        obj.setContactPerson(request.getParameter("txtContactPerson"));

                                        obj.setDepartmentId(Integer.parseInt(session.getAttribute("DepartmentId").toString()));
                                        objDAL.updateDepartment(obj);
                                        avl="";
                                        session.removeAttribute("DepartmentId");
                                        response.sendRedirect("DepartmentsList.jsp");
                                    }
                                    else
                                    {
                                        avl="Department already exists";
                                    }
                                }
                                
                                
                            }//if sv==true


                        }//if btnSave
                        else if(request.getParameter("DIDE")!=null)
                        {
                            int EditDepartmentId= Integer.parseInt(request.getParameter("DIDE"));

                            DataLayer.DALDepartment objDAL= new DALDepartment();
                            Beans.Department objE = objDAL.getDepartment(EditDepartmentId);
                            EDepartmentName=objE.getDepartmentName();
                            EAddress=objE.getAddress();
                            ECity=objE.getCity();
                            EContactNo=objE.getContactNo();
                            EEmailId=objE.getEmailId();
                            EContactPerson=objE.getContactPerson();

                            session.setAttribute("DepartmentId", EditDepartmentId);
                        }
                        
                %>
                <form action="Department.jsp" name="fDept">
                    <table>
                        <tr>
                            <td> Department Name<font color="red">*</font> </td>
                            <td> <input type="text" name="txtDepartmentName" maxlength="20" value="<%=EDepartmentName%>"> </td>
                            <td> <font color="red"><span id="spDepartmentName"> </span> </font></td>
                            <td> <font color="red"><%=avl%> </font></td>
                            <td> <font color="red"><%=SDepartmentName%> </font></td>
                        </tr>
                        <tr>
                            <td> Address<font color="red">*</font> </td>
                            <td> <input type="text" name="txtAddress" maxlength="50" value="<%=EAddress%>"> </td>
                            <td> <font color="red"><span id="spAddress"> </span></font> </td>
                            <td> <font color="red"><%=SAddress%> </font></td>
                        </tr>
                        <tr>
                            <td> City </td>
                            <td> <input type="text" name="txtCity" maxlength="20" value="<%=ECity%>"> </td>
                            <td> <font color="red"><span id="spCity"> </span></font> </td>
                        </tr>
                        <tr>
                            <td> Contact No.<font color="red">*</font> </td>
                            <td> <input type="text" name="txtContactNo" maxlength="25" value="<%=EContactNo%>"> </td>
                            <td> <font color="red"><span id="spContactNo"> </span> </font></td>
                            <td> <font color="red"><%=SContactNo%> </font></td>
                        </tr>
                        <tr>
                            <td> Email Id </td>
                            <td> <input type="text" name="txtEmailId" maxlength="30" value="<%=EEmailId%>"> </td>
                            <td> <font color="red"><span id="spEmailId"> </span> </font></td>
                        </tr>
                        <tr>
                            <td> Contact Person<font color="red">*</font></td>
                            <td> <input type="text" name="txtContactPerson" maxlength="20" value="<%=EContactPerson%>"> </td>
                            <td> <font color="red"><span id="spContactPerson"> </span> </font></td>
                            <td> <font color="red"><%=SContactPerson%> </font> </td>
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