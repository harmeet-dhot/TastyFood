package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header2_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<header class=\"main__header\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <nav class=\"navbar navbar-default\" role=\"navigation\"> \n");
      out.write("            <!-- Brand and toggle get grouped for better mobile display --> \n");
      out.write("            <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <h1 class=\"navbar-brand\"><a href=\"index.html\">Order From Tasty khana in your City</a></h1>\n");
      out.write("                <a href=\"#\" class=\"submenu\">Menus</a> </div>\n");
      out.write("            <div class=\"menuBar\">\n");
      out.write("                <ul class=\"menu\">\n");
      out.write("                    <li class=\"active\"><a href=\"search_city_restaurant.jsp\">Search</a></li>\n");
      out.write("                    <li class=\"dropdown\"><a href=\"#\">Pages</a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"index_fixed.html\">Home / Fixed</a></li>\n");
      out.write("                            <li><a href=\"index_with_blog.html\">Home + Blog</a></li>\n");
      out.write("                            <li><a href=\"portfolio.html\">Portfolio</a></li>\n");
      out.write("                            <li><a href=\"typography.html\">Typography</a></li>\n");
      out.write("                            <li><a href=\"shortcodes.html\">Shortcodes</a></li>\n");
      out.write("                            <li><a href=\"store.html\">Web Store</a></li>\n");
      out.write("                            <li><a href=\"blog.html\">Blog & News</a></li>\n");
      out.write("                            <li><a href=\"tables.html\">Tables</a></li>\n");
      out.write("                            <li><a href=\"faq.html\">FAQ</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"left_sidebar.html\">left sidebar</a></li>\n");
      out.write("                    <li><a href=\"right_sidebar.html\">right sidebar</a></li>\n");
      out.write("                    <li><a href=\"full_width.html\">full page</a></li>\n");
      out.write("                    <li><a href=\"contact.html\">contact us</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.navbar-collapse --> \n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("</header>");
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
