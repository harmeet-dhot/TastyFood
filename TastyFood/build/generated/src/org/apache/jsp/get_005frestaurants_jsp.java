package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class get_005frestaurants_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String city = request.getParameter("city");
    session.setAttribute("city", city);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("         <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/large imgs/Best-top-desktop-food-wallpapers-hd-food-wallpaper-food-pictures-image-photo-34.jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    \n");
      out.write("   \n");
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
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"col-sm-9\">\n");
      out.write("            ");

                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from restaurant where city = '" + city + "' order by name asc");
                    while (rs.next())
                    {
                        int rest_id = rs.getInt("restaurant_id");
                        String name = rs.getString("name");
                        String delivery_time = rs.getString("delivery_time");
                        String opening_time = rs.getString("opening_time");
                        String closing_time = rs.getString("closing_time");
                        String image = rs.getString("image");
                        String cuisines = "";
                        try
                        {
                            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                            Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs1 = stmt1.executeQuery("select * from restaurant_menu where r_id = " + rest_id);
                            while (rs1.next())
                            {
                                cuisines = cuisines + rs1.getString("cuisine_name") + " ";
                            }
                            rs1.close();
                            stmt1.close();
                            con1.close();
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
            
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div id=\"");
      out.print(rest_id);
      out.write("\" onclick=\"openRestaurant(this.id)\">\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <img src=\"");
      out.print( image);
      out.write("\" width=\"150\" height=\"150\"/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-8\">\n");
      out.write("                        <label>");
      out.print( name);
      out.write("</label><br>\n");
      out.write("                        <label>");
      out.print( cuisines);
      out.write("</label><br\n");
      out.write("                         <label>Delivery time-");
      out.print( delivery_time);
      out.write(" Minutes</label><br>\n");
      out.write("                    </div>\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                            <div class=\"col-sm-8\"></div>\n");
      out.write("                        <label>Opening time- ");
      out.print( opening_time);
      out.write(" </label><br>\n");
      out.write("                         <label>Closing time- ");
      out.print( closing_time);
      out.write(" </label><br>\n");
      out.write("                        </div>\n");
      out.write("                     \n");
      out.write("                    </div>\n");
      out.write("                    <hr>\n");
      out.write("                </div>\n");
      out.write("                    <br>\n");
      out.write("                    <br><br>\n");
      out.write("                    <br>\n");
      out.write("            </div>\n");
      out.write("            ");

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
