<%-- 
    Document   : Candidates
    Created on : Apr 17, 2015, 10:43:10 AM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Candidate"%>
<%@page import="DataLayer.DALCandidate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Candidates</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                var t1= document.forms["frmCandidates"].elements["txtName"];
                var t2= document.forms["frmCandidates"].elements["txtDOB"];
                var t3= document.forms["frmCandidates"].elements["txtFatherName"];
                var t4= document.forms["frmCandidates"].elements["txtHigherQualification"];
                var t5= document.forms["frmCandidates"].elements["txtAddress"];
                var t6= document.forms["frmCandidates"].elements["txtContactNo"];
                var t7= document.forms["frmCandidates"].elements["txtEmailId"];
                
                if(t1.value=="")
                {
                    document.getElementById("spName").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spName").innerHTML= "";
                }
                if(t2.value=="")
                {
                    document.getElementById("spDOB").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spDOB").innerHTML= "";
                }
                if(t3.value=="")
                {
                    document.getElementById("spFatherName").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spFatherName").innerHTML= "";
                }
                if(t4.value=="")
                {
                    document.getElementById("spHigherQualification").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spHigherQualification").innerHTML= "";
                }
                if(t5.value=="")
                {
                    document.getElementById("spAddress").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spAddress").innerHTML= "";
                }
                if(t6.value=="")
                {
                    document.getElementById("spContactNo").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spContactNo").innerHTML= "";
                }
                if(t7.value=="")
                {
                    document.getElementById("spEmailId").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spEmailId").innerHTML= "";
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

                    String SName="";
                    String SDOB="";
                    String SFatherName="";
                    String SHigherQualification="";
                    String SAddress="";
                    String SContactNo="";
                    String SEmailId="";

                    private boolean sValidateData(HttpServletRequest request)
                    {
                        boolean ret=true;
                        if(request.getParameter("txtName").length()==0)
                        {
                            SName="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SName="";
                        }

                        if(request.getParameter("txtDOB").length()==0)
                        {
                            SDOB="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SDOB="";
                        }

                        if(request.getParameter("txtFatherName").length()==0)
                        {
                            SFatherName="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SFatherName="";
                        }
                        if(request.getParameter("txtHigherQualification").length()==0)
                        {
                            SHigherQualification="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SHigherQualification="";
                        }
                        if(request.getParameter("txtAddress").length()==0)
                        {
                            SAddress="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SAddress="";
                        }
                        if(request.getParameter("txtContactNo").length()==0)
                        {
                            SContactNo="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SContactNo="";
                        }
                        if(request.getParameter("txtEmailId").length()==0)
                        {
                            SEmailId="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SEmailId="";
                        }
                        return ret;
                    }
                %>
                <%
                    String EName="";
                    String EDOB="";
                    String EFatherName="";
                    String EHigherQualification="";
                    String EAddress="";
                    String EContactNo="";
                    String EEmailId="";
                    
                    if(request.getParameter("TIDC")!=null)
                    {
                        session.setAttribute("TestId",Integer.parseInt(request.getParameter("TIDC")));
                    }       
                    String MaleSel="Checked", FemaleSel="";

                    //To add
                    if(request.getParameter("btnAdd")!=null)
                    {
                        boolean sv= sValidateData(request);
                        if(sv==true) //Server Side Validation
                        {
                            DataLayer.DALCandidate objDALCandidate = new DALCandidate();
                            Beans.Candidate obj= new Candidate();

                            obj.setName(request.getParameter("txtName"));
                            obj.setGender(request.getParameter("rdbGender"));
                            obj.setDOB(request.getParameter("txtDOB"));
                            obj.setFatherName(request.getParameter("txtFatherName"));
                            obj.setHigherQualification(request.getParameter("txtHigherQualification"));
                            obj.setAddress(request.getParameter("txtAddress"));
                            obj.setContactNo(request.getParameter("txtContactNo"));
                            obj.setEmailId(request.getParameter("txtEmailId"));
                            obj.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));

                            if(session.getAttribute("CandidateId")==null)//opened for saving
                            {
                                objDALCandidate.saveCandidate(obj);
                            }
                            else //opened for editing
                            {
                                obj.setCandidateId(Integer.parseInt(session.getAttribute("CandidateId").toString()));
                                objDALCandidate.updateCandidate(obj);
                                EName="";
                                EDOB="";
                                EFatherName="";
                                EHigherQualification="";
                                EAddress="";
                                EContactNo="";
                                EEmailId="";
                            }
                        }
                    }
                    //To Edit
                    else if(request.getParameter("CIDE")!=null)
                    {
                        int EditCandidateId= Integer.parseInt(request.getParameter("CIDE"));

                        DataLayer.DALCandidate objDALCandidate= new DALCandidate();
                        Beans.Candidate objE = objDALCandidate.getCandidate(EditCandidateId);
                        EName=objE.getName();
                        if(objE.getGender().equals("Male"))
                        {
                            MaleSel="Checked";
                            FemaleSel="";
                        }
                        else
                        {
                            MaleSel="";
                            FemaleSel="Checked";
                        } 
                        EDOB=objE.getDOB();
                        EFatherName=objE.getFatherName();
                        EHigherQualification=objE.getHigherQualification();
                        EAddress=objE.getAddress();
                        EContactNo=objE.getContactNo();
                        EEmailId=objE.getEmailId();

                        session.setAttribute("CandidateId", EditCandidateId);
                    }

                    //To show empty list
                    int x=0;//TestId
                    DataLayer.DALCandidate objDALCandidate = new DALCandidate();
                    ArrayList<Beans.Candidate> AC= objDALCandidate.getCandidates(x);

                    if(session.getAttribute("TestId")!=null)
                    {
                        if(request.getParameter("CIDD")!=null)
                        {
                            int y = Integer.parseInt(request.getParameter("CIDD"));
                            objDALCandidate.deleteCandidate(y);

                        }
                        //To show relevant Candidate of particular Test
                        x = Integer.parseInt(session.getAttribute("TestId").toString());
                        AC = objDALCandidate.getCandidates(x);
                    }

                %>
                <form action="Candidates.jsp" name="frmCandidates">
                    <table>
                        <tr>
                            <td>Name</td>
                            <td><input type="text" name="txtName" maxlength="25" value="<%=EName%>"></td>
                            <td><font color="red"><span id="spName"> </span></font></td>
                            <td><font color="red"><%=SName%></font></td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td>
                                <input type="radio" name="rdbGender" value="Male" <%=MaleSel%> > Male
                                <input type="radio" name="rdbGender" value="Female" <%=FemaleSel%>> Female
                            </td>
                        </tr>
                        <tr>
                            <td>Date of Birth</td>
                            <td><input type="text" name="txtDOB" maxlength="10" value="<%=EDOB%>"></td>
                            <td><font color="red"><span id="spDOB"> </span></font></td>
                            <td><font color="red"><%=SDOB%></font></td>
                        </tr>
                        <tr>
                            <td>Father's Name</td>
                            <td><input type="text" name="txtFatherName" maxlength="25" value="<%=EFatherName%>"></td>
                            <td><font color="red"><span id="spFatherName"> </span></font></td>
                            <td><font color="red"><%=SFatherName%></font></td>
                        </tr>
                        <tr>
                            <td>Higher Qualification</td>
                            <td><input type="text" name="txtHigherQualification" maxlength="15" value="<%=EHigherQualification%>"></td>
                            <td><font color="red"><span id="spHigherQualification"> </span></font></td>
                            <td><font color="red"><%=SHigherQualification%></font></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td><input type="text" name="txtAddress" maxlength="50" value="<%=EAddress%>"></td>
                            <td><font color="red"><span id="spAddress"> </span></font></td>
                            <td><font color="red"><%=SAddress%></font></td>
                        </tr>
                        <tr>
                            <td>Contact No.</td>
                            <td><input type="text" name="txtContactNo" maxlength="25" value="<%=EContactNo%>"></td>
                            <td><font color="red"><span id="spContactNo"> </span></font></td>
                            <td><font color="red"><%=SContactNo%></font></td>
                        </tr>
                        <tr>
                            <td>Email Id</td>
                            <td><input type="text" name="txtEmailId" maxlength="30" value="<%=EEmailId%>"></td>
                            <td><font color="red"><span id="spEmailId"> </span></font></td>
                            <td><font color="red"><%=SEmailId%></font></td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <input type="submit" name="btnAdd" value="Add" onclick="return validateData();">
                            </td>
                        </tr>
                    </table>
                    <br>
                    
                    <div id="ScrollDiv" style="height:200px">
                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Candidate Id</th>
                                 <th class="THeading">Name</th>
                                 <th class="THeading">Gender</th>
                                 <th class="THeading">D.O.B.</th>
                                 <th class="THeading">Father's Name</th>
                                 <th class="THeading">Higher Qualification</th>
                                 <th class="THeading">Address</th>
                                 <th class="THeading">Contact No.</th>
                                 <th class="THeading">Email Id</th>
                             </tr>

                             <%

                                 for(Beans.Candidate C : AC)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=C.getCandidateId()%> </td>
                                 <td class="TData"><%=C.getName()%> </td>
                                 <td class="TData"><%=C.getGender()%> </td>
                                 <td class="TData"><%=C.getDOB()%> </td>
                                 <td class="TData"><%=C.getFatherName()%> </td>
                                 <td class="TData"><%=C.getHigherQualification()%> </td>
                                 <td class="TData"><%=C.getAddress()%> </td>
                                 <td class="TData"><%=C.getContactNo()%> </td>
                                 <td class="TData"><%=C.getEmailId()%> </td>


                                 <td class="TData"> 
                                     <a href="Candidates.jsp?CIDE=<%=C.getCandidateId()%>">Edit</a> 
                                 </td>
                                 <td class="TData"> 
                                     <a href="Candidates.jsp?CIDD=<%=C.getCandidateId()%>">Delete</a> 
                                 </td>
                             </tr>
                             <%}%>
                     </table>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </body>	
</html>