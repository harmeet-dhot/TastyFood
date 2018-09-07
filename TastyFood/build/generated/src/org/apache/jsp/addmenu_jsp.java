package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class addmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

    String id = request.getParameter("id");
    int count = 1;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("          <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/large imgs/images (13).jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("  \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 class=\"bg-danger\" style=\"text-align: center\">Add Menu To Restaurant</h1>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"AddMenu\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Menu_Name</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" name=\"menu_name\" required placeholder=\"Menu name\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Menu_Image</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"hidden\" name=\"r_id\" value=\"");
      out.print( id);
      out.write("\" class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                 \n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\"></label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"file\" name=\"file\" required class=\"form-control\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                    <br>\n");
      out.write("                    <br>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Restaurant Name</label>\n");
      out.write("                  \n");
      out.write("                </div>\n");
      out.write("                ");

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from Restaurant where restaurant_id = '" + id + "'");
                        if (rs.next())
                        {
                            String name = rs.getString("name");
                
      out.write("\n");
      out.write("                ");
      out.print(name);
      out.write("\n");
      out.write("                ");

                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("                        <button class=\"btn btn-primary\" type=\"submit\">Add Menu</button>\n");
      out.write("                        <button class=\"btn btn-default\" type=\"button\" onclick=\"window.location.href = 'add_menu_item.jsp'\">Add Menu Items</button>    \n");
      out.write("                    </div>\n");
      out.write("                </div\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                   \n");
      out.write("                    <label class=\"col-sm-3\">Sr. no.</label>\n");
      out.write("                    <div class=\"col-sm-offset-3\">                       \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Name</label>\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Image</label>\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from menu where r_id = '" + id + "'");
                        while (rs.next())
                        {
                            String name = rs.getString("menu_name");
                            String image = rs.getString("menu_image");
                
      out.write("\n");
      out.write("                ");
      out.print( count);
      out.write("\n");
      out.write("                ");
      out.print( name);
      out.write("\n");
      out.write("                <a href=\"");
      out.print( image);
      out.write("\" target=\"_blank\">Click To See Image</a>\n");
      out.write("                ");

                            count++;
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                
      out.write("\n");
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
