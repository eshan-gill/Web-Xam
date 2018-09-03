package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import DataLayer.DALQuestion;

public final class TestStarted_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>WebXam Test</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            DataLayer.DALQuestion objDAL=new DALQuestion();
            ArrayList<Beans.Question> All= objDAL.getQuestions(8);
            int i=1;
            for(Beans.Question Q:All)
            {
        
      out.write("\n");
      out.write("        ");
      out.print(Q.getQuestionText());
      out.write("\n");
      out.write("        <input type=\"hidden\" name=\"Ques");
      out.print(i);
      out.write("\" value=\"");
      out.print(Q.getQuestionId());
      out.write("\">\n");
      out.write("        <br><br>\n");
      out.write("        ");

                for(Beans.Option O:Q.Options)
                {
        
      out.write("\n");
      out.write("        <input type=\"radio\" name=\"Opt");
      out.print(Q.getQuestionId());
      out.write("\" value=\"");
      out.print(O.getOptionId());
      out.write("\">\n");
      out.write("        ");
      out.print(O.getOptionText());
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        ");

                }
                i++;
            }
        
      out.write("\n");
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
