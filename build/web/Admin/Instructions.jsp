<%-- 
    Document   : Instructions
    Created on : Apr 13, 2015, 11:08:08 AM
    Author     : eshangill
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Instruction"%>
<%@page import="DataLayer.DALInstruction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Instructions</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                var t= document.forms["frmInstructions"].elements["txtInstruction"];
                if(t.value=="")
                {
                    document.getElementById("spInstruction").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spInstruction").innerHTML= "";
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
                    String SInstruction="";
                    if(request.getParameter("TIDI")!=null)
                    {
                        session.setAttribute("TestId",Integer.parseInt(request.getParameter("TIDI")));
                    }       


                    //To add
                    if(request.getParameter("btnAdd")!=null)
                    {
                        if(request.getParameter("txtInstruction").length()>0) //Server Side Validation
                        {
                            DataLayer.DALInstruction objDALInstruction = new DALInstruction();
                            Beans.Instruction obj= new Instruction();

                            obj.setInstructionText(request.getParameter("txtInstruction"));
                            obj.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));

                            objDALInstruction.saveInstruction(obj);

                            SInstruction="";
                        }
                        else
                        {
                            SInstruction="Value is empty";
                        }
                    }

                    //To show empty list
                    int x=0;//TestId
                    DataLayer.DALInstruction objDALInstruction = new DALInstruction();
                    ArrayList<Beans.Instruction> AI= objDALInstruction.getInstructions(x);

                    if(session.getAttribute("TestId")!=null)
                    {
                        if(request.getParameter("IIDD")!=null)
                        {
                            int y = Integer.parseInt(request.getParameter("IIDD"));
                            objDALInstruction.deleteInstruction(y);

                        }
                        //TO show relevant Instruction of particular Test
                        x = Integer.parseInt(session.getAttribute("TestId").toString());
                        AI = objDALInstruction.getInstructions(x);
                    }

                %>
                <form action="Instructions.jsp" name="frmInstructions">
                    <table>
                        <tr>
                            <td>Instruction</td>
                            <td><input type="text" name="txtInstruction" maxlength="500"></td>
                            <td><font color="red"><span id="spInstruction"> </span></font></td>
                            <td><font color="red"><%=SInstruction%></font></td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <input type="submit" name="btnAdd" value="Add" onclick="return validateData();">
                            </td>
                        </tr>
                    </table>
                    <br>
                    <br>
                    <table border="2"> 
                             <tr>
                                 <th class="THeading">Instruction Text</th>
                             </tr>

                             <%

                                 for(Beans.Instruction I : AI)
                                 {
                             %>

                             <tr>
                                 <td class="TData"><%=I.getInstructionText()%> </td>

                                 <td class="TData"> 
                                     <a href="Instructions.jsp?IIDD=<%=I.getInstructionId()%>">Delete</a> 
                                 </td>
                             </tr>
                             <%}%>
                     </table>
                </form>
            </div>
        </div>
    </body>	
</html>