package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fgallery_005fimages_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ad gallery images</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/th22ALGGPL.jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    \n");
      out.write("        <script>\n");
      out.write("            function go()\n");
      out.write("            {\n");
      out.write("                var cityName = document.getElementById(\"city\").value;\n");
      out.write("                var xml = new XMLHttpRequest();\n");
      out.write("                var query = \"get_restaurants_in_a_city.jsp?city=\" + cityName;\n");
      out.write("                xml.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xml.readyState == 4 && xml.status == 200)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"div_rest\").innerHTML = xml.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xml.open(\"GET\", query, true);\n");
      out.write("                xml.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function getImages()\n");
      out.write("            {\n");
      out.write("                var name = document.getElementById(\"div_rest\").value;\n");
      out.write("                var xml = new XMLHttpRequest();\n");
      out.write("                var query = \"get_images_of_rest.jsp?name=\" + name;\n");
      out.write("                xml.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xml.readyState == 4 && xml.status == 200)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"div_image\").innerHTML = xml.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xml.open(\"GET\", query, true);\n");
      out.write("                xml.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1  class=\"bg-warning\" style=\"text-align: center\">Add Galley Images</h1>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form action=\"Addimages\" class=\"form-horizontal\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-8\">\n");
      out.write("                        <select class=\"form-control\" id=\"city\" name=\"city\">\n");
      out.write("                            <option  >Select A City</option>\n");
      out.write("                               <option  >Abohar</option>\n");
      out.write("                    <option  >Amritsar</option>\n");
      out.write("                    <option  >Batala</option>\n");
      out.write("                    <option  >Bombay</option>\n");
      out.write("                    <option  >Chandigarh</option>\n");
      out.write("                    <option  >Delhi</option>\n");
      out.write("                    <option  >Jalandhar</option>\n");
      out.write("                    <option  >Jandiala</option>\n");
      out.write("                    <option  >Kapurthala</option>\n");
      out.write("                    <option  >Kartarpur</option>\n");
      out.write("                    <option  >Ludhiana</option>\n");
      out.write("                    <option  >Majhitha</option>\n");
      out.write("                    <option  >Moga</option>\n");
      out.write("                    <option  >Nawa Shehar</option>\n");
      out.write("                    <option  >Patiala</option>\n");
      out.write("                    <option  >Tarn Taran</option>\n");
      out.write("                    <option  >Zira</option>\n");
      out.write("                           \n");
      out.write("           \n");
      out.write("                            </select> \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <button style=\"width: 100%\" class=\"btn btn-primary\" type=\"button\" onclick=\"go()\">Find Restaurant</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-8\">\n");
      out.write("                        <select class=\"form-control\" id=\"div_rest\" name=\"rest_name\">\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <button style=\"width: 100%\" type=\"button\" onclick=\"getImages()\" class=\"btn btn-default\">Get Images</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <input type=\"text\" name=\"caption\" required class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <input type=\"file\" class=\"form-control\" name=\"file\" required/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <button style=\"width: 100%\" class=\"btn btn-default\" type=\"submit\">Upload Image</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"div_image\">\n");
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
