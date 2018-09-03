package org.apache.jsp.Operator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Beans.Candidate;
import DataLayer.DALCandidate;

public final class Candidates_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                    String EName="";
                    String EDOB="";
                    String EFatherName="";
                    String EHigherQualification="";
                    String EAddress="";
                    String EContactNo="";
                    String EEmailId="";

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
                
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Operator/Header.html");
    _jspx_dependants.add("/Operator/Options.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WebXam Candidates</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateData()\n");
      out.write("            {\n");
      out.write("                var ret=true;\n");
      out.write("                var t1= document.forms[\"frmCandidates\"].elements[\"txtName\"];\n");
      out.write("                var t2= document.forms[\"frmCandidates\"].elements[\"txtDOB\"];\n");
      out.write("                var t3= document.forms[\"frmCandidates\"].elements[\"txtFatherName\"];\n");
      out.write("                var t4= document.forms[\"frmCandidates\"].elements[\"txtHigherQualification\"];\n");
      out.write("                var t5= document.forms[\"frmCandidates\"].elements[\"txtAddress\"];\n");
      out.write("                var t6= document.forms[\"frmCandidates\"].elements[\"txtContactNo\"];\n");
      out.write("                var t7= document.forms[\"frmCandidates\"].elements[\"txtEmailId\"];\n");
      out.write("                \n");
      out.write("                if(t1.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spName\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spName\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                if(t2.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spDOB\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spDOB\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                if(t3.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spFatherName\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spFatherName\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                if(t4.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spHigherQualification\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spHigherQualification\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                if(t5.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spAddress\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spAddress\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                if(t6.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spContactNo\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spContactNo\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                if(t7.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spEmailId\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spEmailId\").innerHTML= \"\";\n");
      out.write("                }\n");
      out.write("                return ret;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" >\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body\r\n");
      out.write("{\r\n");
      out.write("        background-color:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("*\r\n");
      out.write("{\r\n");
      out.write("        margin:0px;\r\n");
      out.write("        padding:0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#TopStrip\r\n");
      out.write("{\r\n");
      out.write("        height:10px;\r\n");
      out.write("        background-color:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#TitleDiv\r\n");
      out.write("{\r\n");
      out.write("        height:100px;\r\n");
      out.write("        width:1050px;\r\n");
      out.write("        background-color:#005387;\r\n");
      out.write("        margin:0 auto;\r\n");
      out.write("        margin-top:20px;\r\n");
      out.write("\r\n");
      out.write("        border-radius:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".Title\r\n");
      out.write("{\r\n");
      out.write("        font-size:32pt;\r\n");
      out.write("        color:white;\r\n");
      out.write("        font-weight:bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#ContentWrapper\r\n");
      out.write("{\r\n");
      out.write("        background-color:white;\r\n");
      out.write("        width:1050px;\r\n");
      out.write("        border:1px black solid;\r\n");
      out.write("        min-height:400px;\r\n");
      out.write("        margin:0 auto;\r\n");
      out.write("        margin-top:10px;\r\n");
      out.write("        border-radius:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#LeftDiv\r\n");
      out.write("{\r\n");
      out.write("        width:200px;\r\n");
      out.write("        height:250px;\r\n");
      out.write("\r\n");
      out.write("        position:absolute;\t\t\t\r\n");
      out.write("        margin-left:10px;\r\n");
      out.write("        margin-top:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#RightDiv\r\n");
      out.write("{\r\n");
      out.write("        width:850px;\r\n");
      out.write("        height:250px;\r\n");
      out.write("        float:right;\r\n");
      out.write("        margin-left:10px;\r\n");
      out.write("        margin-top: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#accordion \r\n");
      out.write("{\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    padding: 0 0 0 0;\r\n");
      out.write("    width: 185px;\r\n");
      out.write("    color:white;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#accordion div {\r\n");
      out.write("    display: block;\r\n");
      out.write("    background-color: #001E77;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    margin: 1px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    padding: 5px 5px 5px 7px;\r\n");
      out.write("    list-style: circle;\r\n");
      out.write("    -moz-border-radius: 10px;\r\n");
      out.write("    -webkit-border-radius: 10px;\r\n");
      out.write("    border-radius: 10px;\r\n");
      out.write("}\r\n");
      out.write("#accordion ul {\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    padding: 0 0 0 0;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("#accordion ul{\r\n");
      out.write("    display: none;\r\n");
      out.write("    width:175px;    \r\n");
      out.write("    padding-left:5px;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("#accordion ul li {\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    cursor: auto;\r\n");
      out.write("    background-color: #005387;\r\n");
      out.write("    padding: 0 0 0 7px;\r\n");
      out.write("    \r\n");
      out.write("    -moz-border-radius: 10px;\r\n");
      out.write("    -webkit-border-radius: 10px;\r\n");
      out.write("    border-radius: 10px;\r\n");
      out.write("    border-bottom:1px solid white;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("#accordion a {\r\n");
      out.write("\tcolor:white;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("#accordion a:hover {\r\n");
      out.write("    text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"LatestJQuery.js\">\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\t$(document).ready\r\n");
      out.write("\t\t(\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t$(\"#accordion > li > div\").click\r\n");
      out.write("\t\t\t\t(\r\n");
      out.write("\t\t\t\t\tfunction()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t    if(false == $(this).next().is(':visible')) \r\n");
      out.write("\t\t\t\t\t\t    {\r\n");
      out.write("\t\t\t\t\t\t        $('#accordion ul').slideUp(300);\r\n");
      out.write("    \t\t\t\t\t\t    }\r\n");
      out.write("\t\t\t\t\t\t    $(this).next().slideToggle(300);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t)\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t)\r\n");
      out.write("\r\n");
      out.write("\t</script>\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"TopStrip\">\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"TitleDiv\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <table>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                    <td> <img src=\"Bell.png\" height=\"50\" width=\"50\"> </td>\r\n");
      out.write("                                    <td> <span class=\"Title\"> WebXam </span> </td>\r\n");
      out.write("\r\n");
      out.write("                            </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("\n");
      out.write("        <div id=\"ContentWrapper\"> \n");
      out.write("            <div id=\"LeftDiv\"> \n");
      out.write("                ");
      out.write("<ul id=\"accordion\">\r\n");
      out.write("    <li><div><a href=\"Tests.jsp\">Tests</a></div></li>\r\n");
      out.write("    <li><div><a href=\"ChangePassword.jsp\">Change Password</a></div></li>\r\n");
      out.write("    <li><div><a href=\"Logout.jsp\">Logout</a></div></li>\r\n");
      out.write("</ul>\r\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"RightDiv\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

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

                
      out.write("\n");
      out.write("                <form action=\"Candidates.jsp\" name=\"frmCandidates\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Name</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtName\" maxlength=\"25\" value=\"");
      out.print(EName);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spName\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SName);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Gender</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"rdbGender\" value=\"Male\" ");
      out.print(MaleSel);
      out.write(" > Male\n");
      out.write("                                <input type=\"radio\" name=\"rdbGender\" value=\"Female\" ");
      out.print(FemaleSel);
      out.write("> Female\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Date of Birth</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtDOB\" maxlength=\"10\" value=\"");
      out.print(EDOB);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spDOB\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SDOB);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Father's Name</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtFatherName\" maxlength=\"25\" value=\"");
      out.print(EFatherName);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spFatherName\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SFatherName);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Higher Qualification</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtHigherQualification\" maxlength=\"15\" value=\"");
      out.print(EHigherQualification);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spHigherQualification\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SHigherQualification);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Address</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtAddress\" maxlength=\"50\" value=\"");
      out.print(EAddress);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spAddress\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SAddress);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Contact No.</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtContactNo\" maxlength=\"25\" value=\"");
      out.print(EContactNo);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spContactNo\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SContactNo);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Email Id</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtEmailId\" maxlength=\"30\" value=\"");
      out.print(EEmailId);
      out.write("\"></td>\n");
      out.write("                            <td><span id=\"spEmailId\"> </span></td>\n");
      out.write("                            <td>");
      out.print(SEmailId);
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\">\n");
      out.write("                                <input type=\"submit\" name=\"btnAdd\" value=\"Add\" onclick=\"return validateData();\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                    <table border=\"2\"> \n");
      out.write("                             <tr>\n");
      out.write("                                 <th class=\"THeading\">Name</th>\n");
      out.write("                                 <th class=\"THeading\">Gender</th>\n");
      out.write("                                 <th class=\"THeading\">D.O.B.</th>\n");
      out.write("                                 <th class=\"THeading\">Father's Name</th>\n");
      out.write("                                 <th class=\"THeading\">Higher Qualification</th>\n");
      out.write("                                 <th class=\"THeading\">Address</th>\n");
      out.write("                                 <th class=\"THeading\">Contact No.</th>\n");
      out.write("                                 <th class=\"THeading\">Email Id</th>\n");
      out.write("                             </tr>\n");
      out.write("\n");
      out.write("                             ");


                                 for(Beans.Candidate C : AC)
                                 {
                             
      out.write("\n");
      out.write("\n");
      out.write("                             <tr>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getName());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getGender());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getDOB());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getFatherName());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getHigherQualification());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getAddress());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getContactNo());
      out.write(" </td>\n");
      out.write("                                 <td class=\"TData\">");
      out.print(C.getEmailId());
      out.write(" </td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                 <td class=\"TData\"> \n");
      out.write("                                     <a href=\"Candidates.jsp?CIDE=");
      out.print(C.getCandidateId());
      out.write("\">Edit</a> \n");
      out.write("                                 </td>\n");
      out.write("                                 <td class=\"TData\"> \n");
      out.write("                                     <a href=\"Candidates.jsp?CIDD=");
      out.print(C.getCandidateId());
      out.write("\">Delete</a> \n");
      out.write("                                 </td>\n");
      out.write("                             </tr>\n");
      out.write("                             ");
}
      out.write("\n");
      out.write("                     </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\t\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
