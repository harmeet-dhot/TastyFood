package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class slider_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<section class=\"slider\">\n");
      out.write("    \n");
      out.write("        <div class=\"carousel-inner\">\n");
      out.write("            <div class=\"item\"> <img data-src=\"images/slider/image_1920x1000.jpg\" \n");
      out.write("                                    alt=\"first slide\" src=\"one.jpg\">\n");
      out.write("<!--                <div class=\"container\">\n");
      out.write("                    <div class=\"carousel-caption\">\n");
      out.write("                        <h1>Vestibulum elementum vel ipsum sed.</h1>\n");
      out.write("                        <p>Fringilla placerat. Etiam a dolor sit amet arcu convallis congue. Praesent nec magna porta, sagittis tellus ut, rhoncus justo. Ut et porta turpis. Sed facilisis, justo quis.</p>\n");
      out.write("                        <p><a class=\"btn btn-default btn-lg\" href=\"#\" role=\"button\">get started</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>-->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"item\"> <img data-src=\"images/slider/image_1920x1000.jpg\"\n");
      out.write("                                    alt=\"second slide\" src=\"four.jpg\">\n");
      out.write("<!--                <div class=\"container\">\n");
      out.write("                    <div class=\"carousel-caption\">\n");
      out.write("                        <h1>Eleifend non neque sit amet mollis.</h1>\n");
      out.write("                        <p>Justo rutrum venenatis. Mauris accumsan posuere mauris non facilisis. Duis vestibulum sem lorem. Nulla ut blandit leo, in eleifend odio. Sed consequat dolor ut augue imperdiet adipiscing.</p>\n");
      out.write("                        <p><a class=\"btn btn-default btn-lg\" href=\"#\" role=\"button\">get started</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>-->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"item active\"> <img data-src=\"images/slider/image_1920x1000.jpg\" \n");
      out.write("                                           alt=\"third slide\" \n");
      out.write("                                           src=\"9.jpg\">\n");
      out.write("<!--                <div class=\"container\">\n");
      out.write("                    <div class=\"carousel-caption\">\n");
      out.write("                        <h1>Suspendisse pellentesque luctus tincidu.</h1>\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing ipsum dolor sit amet, consectetuer adipiscing elit. elit. Donec odio ipsum dolor sit amet, consectetuer adipiscing. Quisque volutpat mattis eros.</p>\n");
      out.write("                        <p><a class=\"btn btn-default btn-lg\" href=\"#\" role=\"button\">get started</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>-->\n");
      out.write("            </div>\n");
      out.write("            <div class=\"item active\"> <img data-src=\"images/slider/image_1920x1000.jpg\" \n");
      out.write("                                           alt=\"fourth slide\" \n");
      out.write("                                           src=\"112.jpg\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("    <div class=\"item active\"> <img data-src=\"images/slider/image_1920x1000.jpg\" \n");
      out.write("                                           alt=\"fifth slide\" \n");
      out.write("                                           src=\"10.jpg\">\n");
      out.write("        </div>\n");
      out.write("             <div class=\"item active\"> <img data-src=\"images/slider/image_1920x1000.jpg\" \n");
      out.write("                                           alt=\"sixth slide\" \n");
      out.write("                                           src=\"11.jpg\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"item active\"> <img data-src=\"images/slider/image_1920x1000.jpg\" \n");
      out.write("                                           alt=\"seventh slide\" \n");
      out.write("                                           src=\"12.jpg\">\n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("       </div>\n");
      out.write("        <a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\"><span class=\"glyphicon carousel-control-left\"></span></a> <a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\"><span class=\"glyphicon carousel-control-right\"></span></a> \n");
      out.write("\n");
      out.write("        \n");
      out.write("</section>\n");
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
