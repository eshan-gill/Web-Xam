package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Beans.QOAttemptedQuestion;
import DataLayer.DALAttemptedQuestion;
import DataLayer.DALTest;
import DataLayer.DALCandidate;

public final class ReportCard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Header.html");
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
      out.write("        <title>WebXam Report Card</title>\n");
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
      out.write("                                    <td> <img src=\"Bell.png\" height=\"60\" width=\"80\"> </td>\r\n");
      out.write("                                    <td> <span class=\"Title\"> WebXam </span> </td>\r\n");
      out.write("\r\n");
      out.write("                            </tr>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("\n");
      out.write("        <div id=\"ContentWrapper\"> \n");
      out.write("           ");

                int CandidateId=Integer.parseInt(session.getAttribute("CandidateId").toString());
                int TestId=Integer.parseInt(session.getAttribute("TestId").toString());

                DataLayer.DALCandidate objDALCandidate= new DALCandidate();
                Beans.Candidate objCandidate;
                objCandidate=objDALCandidate.getCandidate(CandidateId);

                DataLayer.DALTest objDALTest= new DALTest();
                Beans.Test objTest;
                objTest=objDALTest.getFullTestDetails(TestId);

            
      out.write("\n");
      out.write("            <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Candidate Id: </td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getCandidateId());
      out.write("</td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                        <td>Name: </td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getName());
      out.write("</td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                        <td>Father's Name: </td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getFatherName());
      out.write("</td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Gender: </td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getGender());
      out.write("</td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                        <td>Date of Birth: </td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getDOB().substring(0,11));
      out.write("</td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                        <td>Contact No. :</td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getContactNo());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email Id: </td>\n");
      out.write("                        <td>");
      out.print(objCandidate.getEmailId());
      out.write("</td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                        <td>Department: </td>\n");
      out.write("                        <td>");
      out.print(objTest.getDepartmentName());
      out.write("</td>\n");
      out.write("                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                        \n");
      out.write("                        <td>Job: </td>\n");
      out.write("                        <td>");
      out.print(objTest.getJobName());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                <br>\n");
      out.write("                <b><hr></b>\n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("                ");

                    DataLayer.DALAttemptedQuestion objDAL=new DALAttemptedQuestion();
                    ArrayList<Beans.QOAttemptedQuestion> AAQ;
                    AAQ=objDAL.getQOAttemptedQuestions(Integer.parseInt(request.getParameter("CTID")));
                
      out.write("\n");
      out.write("                ");

                    int i=1;
                    for(Beans.QOAttemptedQuestion obj:AAQ)
                    {
                        
                
      out.write("\n");
      out.write("\n");
      out.write("                    <b> Q: </b> ");
      out.print(obj.getQText());
      out.write(" <br>\n");
      out.write("                    <b> Option Marked: </b> ");
      out.print(obj.getOText());
      out.write("<br>\n");
      out.write("                    <br>\n");
      out.write("                    <hr>\n");
      out.write("                    <br>\n");
      out.write("                    ");

                        i++;
                        }
                    
      out.write("\n");
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
