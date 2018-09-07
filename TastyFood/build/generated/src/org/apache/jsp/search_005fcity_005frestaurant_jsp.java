package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_005fcity_005frestaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Podkova:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <script>\n");
      out.write("            function go()\n");
      out.write("            {\n");
      out.write("                var selectedCity = document.getElementById(\"city\").value;\n");
      out.write("                window.location.href = \"get_restaurants.jsp?city=\" + selectedCity;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header2.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "slider.jsp", out, false);
      out.write("\n");
      out.write("        <section class=\"main__middle__container homepage\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-4 col-sm-offset-3\">\n");
      out.write("                        <select style=\"width: 100%\" class=\"form-control\" id=\"city\" name=\"city\">\n");
      out.write("                            <option  >Abohar</option>\n");
      out.write("                            <option  >Amritsar</option>\n");
      out.write("                            <option  >Batala</option>\n");
      out.write("                            <option  >Bombay</option>\n");
      out.write("                            <option  >Chandigarh</option>\n");
      out.write("                            <option  >Delhi</option>\n");
      out.write("                            <option  >Jalandhar</option>\n");
      out.write("                            \n");
      out.write("                            <option  >Jandiala</option>\n");
      out.write("                            <option  >Kapurthala</option>\n");
      out.write("                            <option  >Kartarpur</option>\n");
      out.write("                            <option  >Ludhiana</option>\n");
      out.write("                            <option  >Majhitha</option>\n");
      out.write("                            <option  >Moga</option>\n");
      out.write("                            <option  >Nawa Shehar</option>\n");
      out.write("                            <option  >Patiala</option>\n");
      out.write("                            <option  >Tarn Taran</option>\n");
      out.write("                            <option  >Zira</option>\n");
      out.write("                        </select> \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <button class=\"btn btn-success\" onclick=\"go()\" type=\"button\" style=\"text-transform: capitalize\">Find Restaurants</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"result\">\n");
      out.write("                </div>            \n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer1.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "slider2.jsp", out, false);
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
