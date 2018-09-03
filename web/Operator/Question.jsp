
<%@page import="Beans.Option"%>
<%@page import="DataLayer.DALOption"%>
<%@page import="Beans.Question"%>
<%@page import="DataLayer.DALQuestion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataLayer.DALCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebXam Question</title>
        <script type="text/javascript">
            function validateData()
            {
                var ret=true;
                
                var t1=document.forms["frmQuestion"].elements["txtQ"];
                var t2=document.forms["frmQuestion"].elements["txtA"];
                var t3=document.forms["frmQuestion"].elements["txtB"];
                var t4=document.forms["frmQuestion"].elements["txtC"];
                var t5=document.forms["frmQuestion"].elements["txtD"];
               
                if(t1.value=="")
                {
                    document.getElementById("spQuestion").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                    document.getElementById("spQuestion").innerHTML= " ";
                }
                if(t2.value=="")
                {
                    document.getElementById("spOptionA").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                        document.getElementById("spOptionA").innerHTML= " ";
                }
                if(t3.value=="")
                {
                    document.getElementById("spOptionB").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                        document.getElementById("spOptionB").innerHTML= " ";
                }
                if(t4.value=="")
                {
                    document.getElementById("spOptionC").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                        document.getElementById("spOptionC").innerHTML= " ";
                }
                if(t5.value=="")
                {
                    document.getElementById("spOptionD").innerHTML= "Value is empty!";
                    ret= false;
                }
                else
                {
                        document.getElementById("spOptionD").innerHTML= " ";
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
                <%!
                    String SQuestion="";
                    String SOptionA="";
                    String SOptionB="";
                    String SOptionC="";
                    String SOptionD="";

                    private boolean sValidateData(HttpServletRequest request)
                    {
                        boolean ret=true;
                        if(request.getParameter("txtQ").length()==0)
                        {
                            SQuestion="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SQuestion="";
                        }
                        if(request.getParameter("txtA").length()==0)
                        {
                            SOptionA="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SOptionA="";
                        }
                        if(request.getParameter("txtB").length()==0)
                        {
                            SOptionB="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SOptionB="";
                        }
                        if(request.getParameter("txtC").length()==0)
                        {
                            SOptionC="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SOptionC="";
                        }
                        if(request.getParameter("txtD").length()==0)
                        {
                            SOptionD="Value is empty";
                            ret=false;
                        }
                        else
                        {
                            SOptionD="";
                        }
                        
                        return ret;
                    }
                 %>

                 <%
                            //Combo Box Category
                            DataLayer.DALCategory objDALCategory = new DALCategory();
                            ArrayList<Beans.Category> AC = objDALCategory.getCategories();
                            int x=0;

                            if(request.getParameter("btnAdd")!=null)
                            {
                                
                                boolean sv= sValidateData(request);
                                if(sv==true)
                                {
                                    DataLayer.DALQuestion objDALQuestion= new DALQuestion();
                                    Beans.Question objQuestion= new Question();
                                    DataLayer.DALOption objDALOption= new DALOption();
                                    Beans.Option objOption= new Option();

                                    objQuestion.setCategoryId(Integer.parseInt(request.getParameter("ddlCategory")));
                                    x=Integer.parseInt(request.getParameter("ddlCategory"));
                                    objQuestion.setQuestionText(request.getParameter("txtQ"));
                                    objDALQuestion.saveQuestion(objQuestion);
                                    
                                    int pQID=objDALQuestion.getQuestion(request.getParameter("txtQ"), x).getQuestionId();
                                    objOption.setQuestionId(pQID);
                                    
                                    objOption.setOptionText(request.getParameter("txtA"));
                                    if(request.getParameter("ddlCO").equals("A"))
                                        objOption.setIsAnswer(Byte.parseByte("1"));
                                    else
                                        objOption.setIsAnswer(Byte.parseByte("0"));
                                    objDALOption.saveOption(objOption);
                                    
                                    objOption.setOptionText(request.getParameter("txtB"));
                                    if(request.getParameter("ddlCO").equals("B"))
                                        objOption.setIsAnswer(Byte.parseByte("1"));
                                    else
                                        objOption.setIsAnswer(Byte.parseByte("0"));
                                    objDALOption.saveOption(objOption);
                                    
                                    objOption.setOptionText(request.getParameter("txtC"));
                                    if(request.getParameter("ddlCO").equals("C"))
                                        objOption.setIsAnswer(Byte.parseByte("1"));
                                    else
                                        objOption.setIsAnswer(Byte.parseByte("0"));
                                    objDALOption.saveOption(objOption);
                                    
                                    objOption.setOptionText(request.getParameter("txtD"));
                                    if(request.getParameter("ddlCO").equals("D"))
                                        objOption.setIsAnswer(Byte.parseByte("1"));
                                    else
                                        objOption.setIsAnswer(Byte.parseByte("0"));
                                    objDALOption.saveOption(objOption);
                                    
                                    
                                    response.sendRedirect("QuestionsList.jsp");
                                }
                                
                            }
                %> 
                <form action="Question.jsp" name="frmQuestion">
                    <table>
                        <tr>
                            <td>Category </td>
                            <td>
                                <select style="width:175px" name="ddlCategory">

                                        <%
                                            String sel="";
                                            for(Beans.Category C : AC)
                                            {
                                                if(x==C.getCategoryId())
                                                    sel="selected";
                                                else
                                                    sel="";
                                        %>

                                        <option <%=sel%> value="<%=C.getCategoryId()%>"> <%=C.getCategoryName()%> </option>

                                        <%}%>
                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td>Question</td>
                            <td><input type="text" name="txtQ" maxlength="500" ></td>
                            <td><font color="red"><span id="spQuestion"> </span></font></td>
                            <td><font color="red"><%=SQuestion%></font></td>
                        </tr>
                        <tr>
                            <td>Option A</td>
                            <td><input type="text" name="txtA" maxlength="500" ></td>
                            <td><font color="red"><span id="spOptionA"> </span></font></td>
                            <td><font color="red"><%=SOptionA%></font></td>
                        </tr>
                        <tr>
                            <td>Option B</td>
                            <td><input type="text" name="txtB" maxlength="500" ></td>
                            <td><font color="red"><span id="spOptionB"> </span></font></td>
                            <td><font color="red"><%=SOptionB%></font></td>
                        </tr>
                        <tr>
                            <td>Option C</td>
                            <td><input type="text" name="txtC" maxlength="500" ></td>
                            <td><font color="red"><span id="spOptionC"> </span></font></td>
                            <td><font color="red"><%=SOptionC%></font></td>
                        </tr>
                        <tr>
                            <td>Option D</td>
                            <td><input type="text" name="txtD" maxlength="500" ></td>
                            <td><font color="red"><span id="spOptionD"> </span></font></td>
                            <td><font color="red"><%=SOptionD%></font></td>
                        </tr>
                        <tr>
                            <td>Correct Option</td>
                            <td>
                                <select style="width:175px" name="ddlCO">

                                        <option value="A"> A </option>
                                        <option value="B"> B </option>
                                        <option value="C"> C </option>
                                        <option value="D"> D </option>
                                </select>
                            </td>
                        </tr>
                        
                        <tr>
                            <td colspan="4"><input type="submit" name="btnAdd" value="Add" onclick="return validateData();"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
