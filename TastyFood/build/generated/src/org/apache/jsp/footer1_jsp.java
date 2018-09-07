package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<footer>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <h3>About</h3>\n");
      out.write("                <p>We strive to deliver a level of service that exceeds the expectations of our customers. <br />\n");
      out.write("                    <br />\n");
      out.write("                    If you have any questions about our products or services, please do not hesitate to contact us. We have friendly, knowledgeable representatives available seven days a week to assist you.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <h3>Tweets</h3>\n");
      out.write("                <p><span>Tweet</span> <a href=\"#\">@You</a><br />\n");
      out.write("                    Etiam egestas, ipsum posuere accumsan sollicitudin, nulla mauris volutpat sem, sit amet rutrum risus. </p>\n");
      out.write("                <p><span>Tweet</span> <a href=\"#\">@You</a><br />\n");
      out.write("                    Quisque porta tellus vitae adipiscing molestie. Mauris et lacus blandit, malesuada.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <h3>Mailing list</h3>\n");
      out.write("                <p>Subscribe to our mailing list for offers, news updates and more!</p>\n");
      out.write("                <br />\n");
      out.write("                <form action=\"#\" method=\"post\" class=\"form-inline\" role=\"form\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"sr-only\" for=\"exampleInputEmail2\">your email</label>\n");
      out.write("                        <input type=\"email\" class=\"form-control form-control-lg\" id=\"exampleInputEmail2\" placeholder=\"your email\">\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-info btn-md\">subscribe</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <h3>Social</h3>\n");
      out.write("                <p>123 Business Way<br />\n");
      out.write("                    San Francisco, CA 94108<br />\n");
      out.write("                    USA<br />\n");
      out.write("                    <br />\n");
      out.write("                    Phone: (888) 123-4567<br />\n");
      out.write("                    Fax: (887) 123-4567<br />\n");
      out.write("                    <br />\n");
      out.write("                </p>\n");
      out.write("                <div class=\"social__icons\"> <a href=\"#\" class=\"socialicon socialicon-twitter\"></a> <a href=\"#\" class=\"socialicon socialicon-facebook\"></a> <a href=\"#\" class=\"socialicon socialicon-google\"></a> <a href=\"#\" class=\"socialicon socialicon-mail\"></a> </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("<p class=\"text-center copyright\">&copy; Copyright ABC Company. All Rights Reserved.</p>");
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
