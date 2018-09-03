package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.TestCategory;
import DataLayer.DALTestCategory;
import java.util.ArrayList;
import DataLayer.DALCategory;

public final class TestCategories_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String msg="";
            String SNOQ="";
        
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WebXam Test Categories</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateData()\n");
      out.write("            {\n");
      out.write("                var ret=true;\n");
      out.write("                \n");
      out.write("                var t1=document.forms[\"frmTestCategories\"].elements[\"txtNOQ\"];\n");
      out.write("               \n");
      out.write("                if(t1.value==\"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spNOQ\").innerHTML= \"Value is empty!\";\n");
      out.write("                    ret= false;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"spNOQ\").innerHTML= \" \";\n");
      out.write("                }\n");
      out.write("                return ret;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

                //Combo Box Category
                DataLayer.DALCategory objDALCategory = new DALCategory();
                ArrayList<Beans.Category> AC = objDALCategory.getCategories();
                int x=0;
                
                if(request.getParameter("TIDC")!=null)
                {
                    session.setAttribute("TestId",Integer.parseInt(request.getParameter("TIDC")));
                }       
                
                if(request.getParameter("btnAdd")!=null)
                {
                    if(request.getParameter("txtNOQ").length()>0) //Server Side Validation
                    {
                        DataLayer.DALTestCategory objDALTestCategory= new DALTestCategory();
                        Beans.TestCategory obj= new TestCategory();
                        
                        obj.setTestId(Integer.parseInt(session.getAttribute("TestId").toString()));
                        obj.setCategoryId(Integer.parseInt(request.getParameter("ddlCategory")));
                        obj.setNOQ(Integer.parseInt(request.getParameter("txtNOQ")));
                        
                        objDALTestCategory.saveTestCategory(obj);
                        
                        SNOQ="";
                        msg="Record Saved!";
                    }
                    else
                    {
                        SNOQ="Value is empty";
                        msg="";
                    }
                }
                else
                    msg="";
            //To show empty list
            int ti=0;//TestId
            DataLayer.DALTestCategory objDALTestCategory = new DALTestCategory();
            ArrayList<Beans.TestCategory> ATC= objDALTestCategory.getTestCategories(ti);
            
            if(session.getAttribute("TestId")!=null)
            {
                if(request.getParameter("TCIDD")!=null)
                {
                    int y = Integer.parseInt(request.getParameter("TCIDD"));
                    objDALTestCategory.deleteTestCategory(y);
                     
                }
                //TO show relevant Test Category of particular Test
                ti = Integer.parseInt(session.getAttribute("TestId").toString());
                ATC = objDALTestCategory.getTestCategories(ti);
            }
        
      out.write("\n");
      out.write("        <form action=\"TestCategories.jsp\" name=\"frmTestCategories\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Category</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select style=\"width:175px\" name=\"ddlCategory\">\n");
      out.write("                               \n");
      out.write("                                ");

                                    String sel="";
                                    for(Beans.Category C : AC)
                                    {
                                        if(x==C.getCategoryId())
                                            sel="selected";
                                        else
                                            sel="";
                                
      out.write("\n");
      out.write("                                    \n");
      out.write("                                <option ");
      out.print(sel);
      out.write(" value=\"");
      out.print(C.getCategoryId());
      out.write("\"> ");
      out.print(C.getCategoryName());
      out.write(" </option>\n");
      out.write("                                \n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>No. of Questions</td>\n");
      out.write("                    <td><input type=\"text\" name=\"txtNOQ\" maxlength=\"3\"></td>\n");
      out.write("                    <td><span id=\"spNOQ\"></span></td>\n");
      out.write("                    <td>");
      out.print(SNOQ);
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"4\"><input type=\"submit\" name=\"btnAdd\" value=\"Add\" onclick=\"return validateData()\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><font color=\"red\">");
      out.print(msg);
      out.write("</font></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("                <br>\n");
      out.write("            <br>\n");
      out.write("            <table border=\"2\"> \n");
      out.write("                     <tr>\n");
      out.write("                         <th class=\"THeading\">Category</th>\n");
      out.write("                         <th class=\"THeading\">NOQ</th>\n");
      out.write("                         \n");
      out.write("                     </tr>\n");
      out.write("\n");
      out.write("                     ");

                        
                         for(Beans.TestCategory TC : ATC)
                         {
                     
      out.write("\n");
      out.write("\n");
      out.write("                     <tr>\n");
      out.write("                         <td class=\"TData\">");
      out.print(TC.getCategoryName());
      out.write(" </td>\n");
      out.write("                         <td class=\"TData\">");
      out.print(TC.getNOQ());
      out.write(" </td>\n");
      out.write("                        \n");
      out.write("                         <td class=\"TData\"> \n");
      out.write("                             <a href=\"TestCategories.jsp?TCIDD=");
      out.print(TC.getSerialNo());
      out.write("\">Delete</a> \n");
      out.write("                         </td>\n");
      out.write("                     </tr>\n");
      out.write("                     ");
}
      out.write("\n");
      out.write("             </table>\n");
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
