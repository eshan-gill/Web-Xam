package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import DataLayer.DALUser;

public final class ChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                    String msg1="";
                    
                
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/Header.html");
    _jspx_dependants.add("/Options.html");
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
      out.write("        <title>WebXam Change Password</title>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" >\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function validateData()\n");
      out.write("            {\n");
      out.write("                var x=true;\n");
      out.write("                \n");
      out.write("                var t1 = document.forms[\"fPwd\"].elements[\"txtOldPwd\"];\n");
      out.write("                var t2 = document.forms[\"fPwd\"].elements[\"txtNewPwd\"];\n");
      out.write("                var t3 = document.forms[\"fPwd\"].elements[\"txtConfirmPwd\"];\n");
      out.write("                \n");
      out.write("                if(t1.value == \"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spOldPwd\").innerHTML=\"Value is empty!\";\n");
      out.write("                    x=false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spOldPwd\").innerHTML=\"\";\n");
      out.write("                }\n");
      out.write("                if(t2.value == \"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spNewPwd\").innerHTML=\"Value is empty!\";\n");
      out.write("                    x=false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spNewPwd\").innerHTML=\"\";\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                if(t3.value == \"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spConfirmPwd\").innerHTML=\"Value is empty!\";\n");
      out.write("                    x=false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spConfirmPwd\").innerHTML=\"\";\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(t2.value!=t3.value)\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spConfirmPwd\").innerHTML=\"Passwords do not match!\";\n");
      out.write("                    x=false;\n");
      out.write("                } \n");
      out.write("                return x;\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
      out.write("        padding-top:0px;\r\n");
      out.write("        padding-bottom:0px;\r\n");
      out.write("        padding-right:0px;\r\n");
      out.write("        padding-left: 5px;\r\n");
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
      out.write("            <li><div><a href=\"Home.jsp\">Home</a></div></li>\r\n");
      out.write("            <li><div><a href=\"Login.jsp\">Login</a></div></li>\r\n");
      out.write("            <li><div><a href=\"Verification.jsp\">Start Test</a></div></li>\r\n");
      out.write("            <li><div><a href=\"AboutDeveloper.jsp\">About Developer</a></div></li>\r\n");
      out.write("</ul>\r\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id=\"RightDiv\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                \n");
      out.write("                ");

                    
                    if(request.getParameter("btnChange")!=null)
                    {
                        
                            int x = Integer.parseInt(session.getAttribute("LoggedRegId").toString());
                            String realPwd = session.getAttribute("PWD").toString();

                            DataLayer.DALUser objDAL = new DALUser();

                            String oldp = request.getParameter("txtOldPwd");
                            String newp = request.getParameter("txtNewPwd");

                            if(oldp.equals(realPwd))
                            {
                               objDAL.UpdatePassword(x,newp);
                               response.sendRedirect("Home.jsp");
                            }
                            else
                            {
                                msg1="Password Incorrect!";
                            }
                        
                            
                    }
                   
                    
      out.write("\n");
      out.write("                <form action=\"ChangePassword.jsp\" name=\"fPwd\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> Old Password </td>\n");
      out.write("                            <td> <input type =\"password\" name=\"txtOldPwd\" maxlength=\"20\"> </td>\n");
      out.write("                            <td> <font color=\"red\"><span id=\"spOldPwd\"> </span></font> </td>\n");
      out.write("                           \n");
      out.write("                            <td> <font color=\"red\">");
      out.print(msg1);
      out.write(" </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> New Password </td>\n");
      out.write("                            <td> <input type =\"password\" name=\"txtNewPwd\" maxlength=\"20\"> </td>\n");
      out.write("                            <td> <font color=\"red\"><span id=\"spNewPwd\"> </span> </font></td>\n");
      out.write("                            \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td> Confirm Password </td>\n");
      out.write("                            <td> <input type =\"password\" name=\"txtConfirmPwd\" maxlength=\"20\"> </td>\n");
      out.write("                            <td> <font color=\"red\"><span id=\"spConfirmPwd\"> </span></font> </td>\n");
      out.write("                            \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"4\"> <input type=\"submit\" name=\"btnChange\" value=\"Change\" onclick=\"return validateData()\" </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
