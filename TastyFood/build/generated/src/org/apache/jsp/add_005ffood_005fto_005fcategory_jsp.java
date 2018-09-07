package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class add_005ffood_005fto_005fcategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("         <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/large imgs/download (10).jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style> \n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1  class=\"bg-info\" style=\"text-align: center\">Add_food_items</h1>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"AddFoodItem\" method=\"post\" enctype=\"multipart/form-data\" onsubmit=\"alert('hello')\"  class=\"form-horizontal\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Enter Food Name</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" name=\"foodname\" class=\"form-control\" required placeholder=\"Name of food item\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Description Of Food</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <textarea name=\"desc\" class=\"form-control\" required placeholder=\"Description\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Select Category</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <select name=\"category\" class=\"form-control\">\n");
      out.write("                            ");

                                try
                                {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    ResultSet rs = stmt.executeQuery("select * from cuisines");
                                    while (rs.next())
                                    {
                                        String cuisine_name = rs.getString("name");
                            
      out.write("\n");
      out.write("                            <option>");
      out.print(cuisine_name);
      out.write("</option>\n");
      out.write("                            ");

                                    }
                                } catch (Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Choose Food Item</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("\n");
      out.write("                        <input type=\"file\" class=\" form-control\" name=\"file\" required/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("                        <button class=\"btn btn-primary\" type=\"submit\">Add Food items</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
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
