package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.Job;
import DataLayer.DALJob;

public final class Job_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WebXam Job Entry</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateData()\n");
      out.write("            {\n");
      out.write("                var ret=true;\n");
      out.write("                \n");
      out.write("                var t1=document.forms[\"fJob\"].elements[\"txtJobName\"];\n");
      out.write("               \n");
      out.write("                if(t1.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spJobName\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spJobName\").innerHTML= \" \";\n");
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
      out.write("                \n");
      out.write("                 ");

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
                        
                
      out.write("\n");
      out.write("                <form action=\"Job.jsp\" name=\"fJob\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> Job Name <font color=\"red\">*</font> </td>\n");
      out.write("                            <td> <input type=\"text\" name=\"txtJobName\" maxlength=\"20\" value=\"");
      out.print(EJobName);
      out.write("\"> </td>\n");
      out.write("                            <td> <font color=\"red\"><span id=\"spJobName\"> </span> </font> </td>\n");
      out.write("                            <td> <font color=\"red\">");
      out.print(avl);
      out.write(" </font></td>\n");
      out.write("                            <td> <font color=\"red\">");
      out.print(SJobName);
      out.write(" </font></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> Description </td>\n");
      out.write("                            <td> <input type=\"text\" name=\"txtDescription\" maxlength=\"100\" value=\"");
      out.print(EDescription);
      out.write("\"> </td>\n");
      out.write("                            <td> <font color=\"red\"><span id=\"spDescription\"> </span></font> </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"3\"> <input type=\"submit\" name=\"btnSave\" value=\"Save\" onclick=\"return validateData()\"> </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"3\"> <font color=\"red\">Fields marked * are mandatory </font> </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       \n");
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
