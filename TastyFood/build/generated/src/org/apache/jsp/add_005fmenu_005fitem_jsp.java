package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class add_005fmenu_005fitem_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head> \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/large imgs/download (8).jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("   \n");
      out.write("        <script>\n");
      out.write("            function getMenu()\n");
      out.write("            {\n");
      out.write("                var restaurantName = document.getElementById(\"restaurant_name\").value;\n");
      out.write("                var xml = new XMLHttpRequest();\n");
      out.write("                var query = \"get_menu.jsp?rest_name=\" + restaurantName;\n");
      out.write("                xml.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xml.readyState == 4 && xml.status == 200)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"menu_td\").innerHTML = xml.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xml.open(\"GET\", query, true);\n");
      out.write("                xml.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 class=\"bg-success\" style=\"text-align: center\">Add_menu_item</h1>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"addmenuitem\" enctype=\"multipart/form-data\" method=\"post\" class=\"form-horizontal\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Item_Name</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" name=\"item_name\" class=\"form-control\" required placeholder=\"Item name\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Veg or Non veg</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"radio\" class=\"radio-inline\"  name=\"vegornon\" value=\"veg\"/>Vegetarian\n");
      out.write("                        <input type=\"radio\" class=\"radio-inline\" name=\"vegornon\" value=\"nonveg\"/>Non Vegetarian\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Display_price</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" name=\"display_price\" \n");
      out.write("                               class=\"form-control\" required placeholder=\"display_price\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-sm-3\">Offer_price</label>\n");
      out.write("                                    <div class=\"col-sm-9\">\n");
      out.write("                                        <input type=\"text\" name=\"offer_price\" class=\"form-control\" required placeholder=\"offer_price\"/>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"col-sm-3\">Select_restaurant</label>\n");
      out.write("                                    <div class=\"col-sm-9\">\n");
      out.write("                                        <select id=\"restaurant_name\" name=\"restaurant\" class=\"form-control\"  onchange=\"getMenu()\">\n");
      out.write("                                            <option value=\"null\">Select Restaurant</option>\n");
      out.write("                ");

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from restaurant");
                        while (rs.next())
                        {
                            String restaurant_name = rs.getString("name");
                
      out.write("\n");
      out.write("                <option>");
      out.print(restaurant_name);
      out.write("</option>\n");
      out.write("                ");

                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <div class=\"col-sm-3 col-sm-9\" id=\"menu_td\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("        <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("            <button class=\"btn btn-primary btn-block\" type=\"submit\">Submit</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("            </form>\n");
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
