package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class filter_005frestaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String cuisine = request.getParameter("cuisine");
    String city = (String) session.getAttribute("city");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("         <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/biryani.jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("  \n");
      out.write("    \n");
      out.write("        <style>\n");
      out.write("            label\n");
      out.write("            {\n");
      out.write("                font-size: 25px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function openRestaurant(id)\n");
      out.write("            {\n");
      out.write("                window.location.href = \"view_restaurant.jsp?id=\" + id;\n");
      out.write("            }\n");
      out.write("            function filter(name)\n");
      out.write("            {\n");
      out.write("                window.location.href = \"filter_restaurant.jsp?cuisine=\" + name;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\"> \n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header1.jsp", out, false);
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar1.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"col-sm-9\">\n");
      out.write("            ");

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from restaurant_menu where cuisine_name = '" + cuisine + "'");
                    while (rs.next())
                    {
                        int rest_id = rs.getInt("r_id");
                        try
                        {
                            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                            Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs1 = stmt1.executeQuery("select * from restaurant where restaurant_id = " + rest_id + " and city = '" + city + "'");
                            while (rs1.next())
                            {
                                String name = rs1.getString("name");
                                String opening_time = rs1.getString("opening_time");
                                String closing_time = rs1.getString("closing_time");
                                String delivery_time = rs1.getString("delivery_time");
                                String image = rs1.getString("image");
            
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div id=\"");
      out.print(rest_id);
      out.write("\" onclick=\"openRestaurant(this.id)\">\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <img src=\"");
      out.print( image);
      out.write("\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-8\">\n");
      out.write("                        <label>");
      out.print( name);
      out.write("</label><br>\n");
      out.write("                        <label>");
      out.print( opening_time);
      out.write(" to ");
      out.print( closing_time);
      out.write("</label><br>\n");
      out.write("                        <label>");
      out.print( delivery_time);
      out.write(" Minutes</label><br>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                            }
                            rs1.close();
                            stmt1.close();
                            con1.close();
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            
      out.write("\n");
      out.write("        </div>\n");
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
