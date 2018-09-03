package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.Test;
import DataLayer.DALTest;
import DataLayer.DALJob;
import java.util.ArrayList;
import DataLayer.DALDepartment;

public final class Test_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                    String msg="";
                    String STestDate="";
                    String SPassingScore="";
                    String SDuration="";

                    String ETestDate="";
                    int EDepartmentId=0;
                    int EJobId=0;
                    String EPassingScore="";
                    String EDuration="";

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
                 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Admin/Header.html");
    _jspx_dependants.add("/Admin/Options.html");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WebXam Test</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateData()\n");
      out.write("            {\n");
      out.write("                var ret=true;\n");
      out.write("                \n");
      out.write("                var t1=document.forms[\"frmTest\"].elements[\"dtTestDate\"];\n");
      out.write("                var t2=document.forms[\"frmTest\"].elements[\"txtPassingScore\"];\n");
      out.write("                var t3=document.forms[\"frmTest\"].elements[\"txtDuration\"];\n");
      out.write("               \n");
      out.write("                if(t1.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spTestDate\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spTestDate\").innerHTML= \" \";\n");
      out.write("                }\n");
      out.write("                if(t2.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spPassingScore\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    if(isNaN(t2.value)==true)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"spPassingScore\").innerHTML= \"Only numeric digits allowed\";\n");
      out.write("                        ret= false;\n");
      out.write("                    }\n");
      out.write("                    else\n");
      out.write("                        document.getElementById(\"spPassingScore\").innerHTML= \" \";\n");
      out.write("                }\n");
      out.write("                if(t3.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spDuration\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    if(isNaN(t3.value)==true)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"spDuration\").innerHTML= \"Only numeric digits allowed\";\n");
      out.write("                        ret= false;\n");
      out.write("                    }\n");
      out.write("                    else\n");
      out.write("                        document.getElementById(\"spDuration\").innerHTML= \" \";\n");
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
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        position:absolute;\t\t\t\r\n");
      out.write("        margin-left:10px;\r\n");
      out.write("        margin-top:10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#RightDiv\r\n");
      out.write("{\r\n");
      out.write("        width:850px;\r\n");
      out.write("        \r\n");
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
      out.write("                                \r\n");
      out.write("                                    <td> &nbsp; &nbsp; &nbsp; <img src=\"Bell.png\" height=\"60\" width=\"80\"> </td>\r\n");
      out.write("                                    <td> &nbsp; <span class=\"Title\"> WebXam </span> </td>\r\n");
      out.write("\r\n");
      out.write("                            </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("\n");
      out.write("        <div id=\"ContentWrapper\"> \n");
      out.write("            <div id=\"LeftDiv\"> \n");
      out.write("                ");

                    if(session.getAttribute("Name")!=null)
                    {
                
      out.write("\n");
      out.write("                    <b>Welcome ");
      out.print(session.getAttribute("Name"));
      out.write("!</b>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
      out.write("<ul id=\"accordion\">\r\n");
      out.write("    <li><div>Department</div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"Department.jsp\">Add</a></li>\r\n");
      out.write("            <li><a href=\"DepartmentsList.jsp\">View</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("\r\n");
      out.write("    <li><div>Job</div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"Job.jsp\">Add</a></li>\r\n");
      out.write("            <li><a href=\"JobsList.jsp\">View</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    \r\n");
      out.write("    <li><div>User</div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"User.jsp\">Add</a></li>\r\n");
      out.write("            <li><a href=\"UsersList.jsp\">View</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </li>\r\n");
      out.write("    \r\n");
      out.write("    <li><div>Category</div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"Category.jsp\">Add</a></li>\r\n");
      out.write("            <li><a href=\"CategoriesList.jsp\">View</a></li>\r\n");
      out.write("        </ul>\t\t\r\n");
      out.write("    </li>\r\n");
      out.write("    <li><div>Test</div>\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a href=\"Test.jsp\">Add</a></li>\r\n");
      out.write("            <li><a href=\"TestsList.jsp\">View</a></li>\r\n");
      out.write("        </ul>\t\t\r\n");
      out.write("    </li>\r\n");
      out.write("    <li><div><a href=\"Reports.jsp\">Reports</a></div></li>\r\n");
      out.write("    <li><div><a href=\"ChangePassword.jsp\">Change Password</a></div></li>\r\n");
      out.write("    <li><div><a href=\"../Logout.jsp\">Logout</a></div></li>\r\n");
      out.write("</ul>\r\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"RightDiv\">\n");
      out.write("                ");
      out.write("\n");
      out.write("\n");
      out.write("                 ");

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
                                    }
                                    else //Updating Data
                                    {
                                        obj.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));
                                        objDALTest.updateTest(obj);
                                    }
                                    msg="Record saved!";
                                    response.sendRedirect("TestsList.jsp");
                                }
                                else
                                {
                                    msg="";
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
                            else
                            {
                                msg=" ";
                            }
                
      out.write(" \n");
      out.write("                <form action=\"Test.jsp\" name=\"frmTest\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Test Date</td>\n");
      out.write("                            <td><input type=\"datetime\" name=\"dtTestDate\" maxlength=\"10\" value=\"");
      out.print(ETestDate);
      out.write("\"></td>\n");
      out.write("                            <td><font color=\"red\"><span id=\"spTestDate\"> </span></font></td>\n");
      out.write("                            <td><font color=\"red\">");
      out.print(STestDate);
      out.write("</font></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Department</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select style=\"width:175px\" name=\"ddlDepartment\">\n");
      out.write("\n");
      out.write("                                        ");

                                            String selD="";
                                            for(Beans.Department D : AD)
                                            {
                                                if(EDepartmentId==D.getDepartmentId())
                                                    selD="selected";
                                                else
                                                    selD="";
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        <option ");
      out.print(selD);
      out.write(" value=\"");
      out.print(D.getDepartmentId());
      out.write("\"> ");
      out.print(D.getDepartmentName());
      out.write(" </option>\n");
      out.write("\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Job</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select style=\"width:175px\" name=\"ddlJob\">\n");
      out.write("\n");
      out.write("                                        ");

                                            String selJ="";
                                            for(Beans.Job J : AJ)
                                            {
                                                if(EJobId==J.getJobId())
                                                    selJ="selected";
                                                else
                                                    selJ="";
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        <option ");
      out.print(selJ);
      out.write(" value=\"");
      out.print(J.getJobId());
      out.write("\"> ");
      out.print(J.getJobName());
      out.write(" </option>\n");
      out.write("\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Passing Score</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtPassingScore\" maxlength=\"4\" value=\"");
      out.print(EPassingScore);
      out.write("\"></td>\n");
      out.write("                            <td><font color=\"red\"><span id=\"spPassingScore\"> </span></font></td>\n");
      out.write("                            <td><font color=\"red\">");
      out.print(SPassingScore);
      out.write("</font></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Duration</td>\n");
      out.write("                            <td><input type=\"text\" name=\"txtDuration\" maxlength=\"3\" value=\"");
      out.print(EDuration);
      out.write("\"></td>\n");
      out.write("                            <td><font color=\"red\"><span id=\"spDuration\"></span></font></td>\n");
      out.write("                            <td><font color=\"red\">");
      out.print(SDuration);
      out.write("</font></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\"><input type=\"submit\" name=\"btnSchedule\" value=\"Schedule\" onclick=\"return validateData();\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\"><font color=\"red\">");
      out.print(msg);
      out.write("</font></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
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
