package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DataLayer.DALUser;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WebXam Login</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateData()\n");
      out.write("            {\n");
      out.write("                var ret=true;\n");
      out.write("                \n");
      out.write("                var t1=document.forms[\"fLogin\"].elements[\"txtUserId\"];\n");
      out.write("                var t2=document.forms[\"fLogin\"].elements[\"txtPwd\"];\n");
      out.write("                \n");
      out.write("                if(t1.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spUserId\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spUserId\").innerHTML= \" \";\n");
      out.write("                }\n");
      out.write("                if(t2.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spPwd\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spPwd\").innerHTML= \" \";\n");
      out.write("                }\n");
      out.write("                return ret;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

                    Cookie[] cookies = request.getCookies();
                    String s="";
                    if(cookies!=null)
                    {
                        for(Cookie c : cookies)
                        {
                            if(c.getName().equals("UID"))
                            {
                                s=c.getValue();
                            }
                        }//For
                    }//IF
        
      out.write("\n");
      out.write("        ");

            String msg="";
            if(request.getParameter("btnSignIn")!=null)
            {
                DataLayer.DALUser objDAL = new DALUser();
                Beans.User obj= objDAL.authenticateUser(request.getParameter("txtUserId"), request.getParameter("txtPwd"),request.getParameter("rdbUserType"));

                if(obj.getSerialNo()>0)
                {
                    session.setAttribute("LoggedRegId", obj.getSerialNo());
                    session.setAttribute("Name", obj.getName());
                    session.setAttribute("PWD", obj.getPassword());

                    if(request.getParameter("chkRememberMe")!=null)
                    {
                        Cookie ck = new Cookie("UID", request.getParameter("txtUserId") );
                        ck.setMaxAge(60*60*60*24*30*12);
                        response.addCookie(ck);

                    }
                    response.sendRedirect("Admin/Department.jsp");
                }
                else
                    msg="User Id or password incorrect!";
            }
        
      out.write("\n");
      out.write("        <form action=\"Login.jsp\" name=\"fLogin\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td> User Id </td>\n");
      out.write("                    <td> <input type=\"text\" name=\"txtUserId\" value=\"");
      out.print(s);
      out.write("\"> </td>\n");
      out.write("                    <td> <span id=\"spUserId\"> </span></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td> Password </td>\n");
      out.write("                    <td> <input type=\"password\" name=\"txtPwd\" > </td>\n");
      out.write("                     <td> <span id=\"spPwd\"> </span></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td> User Type </td>\n");
      out.write("                    <td> <input type=\"radio\" name=\"rdbUserType\" value=\"Admin\" > Admin </td>\n");
      out.write("                    <td> <input type=\"radio\" name=\"rdbUserType\" value=\"Operator\" > Operator</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"3\"> <input type=\"checkbox\" name=\"chkRememberMe\" > Remember Me</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"3\"> <input type=\"submit\" name=\"btnSignIn\" value=\"Sign In\" onclick=\"return validateData();\"> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"3\"> ");
      out.print(msg);
      out.write(" </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
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
