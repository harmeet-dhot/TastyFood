package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class restaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <h1 class=\"bg-warning\" style=\"text-align: center\" >Restaurant</h1>\n");
      out.write("        <form action=\"AddRestaurant\"  class=\"form-horizontal\" enctype=\"multipart/form-data\" method=\"post\">\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                  <label class=\"col-sm-3\">Enter name of restaurant</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("            <input type=\"text\" name=\"name\" class=\"form-control\" required placeholder=\"name of restaurant\">\n");
      out.write("                    </div>\n");
      out.write("             </div>\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                  <label class=\"col-sm-3\">Description</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("            <textarea name=\"desc\" class=\"form-control\" required placeholder=\"Description\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                  <label class=\"col-sm-3\">Choose file name</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("            <input type=\"file\" class=\"form-control\" name=\"file\" required/>\n");
      out.write("                    </div>\n");
      out.write("             </div>\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                  <label class=\"col-sm-3\">Enter address of restaurant</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"address\" required placeholder=\"address of restaurant\"/>\n");
      out.write("                    </div>\n");
      out.write("             </div>\n");
      out.write("            <div   class=\"form-group\">\n");
      out.write("                <label class=\"col-lg-3\">Enter phone_no</label>\n");
      out.write("                <div class=\"col-lg-9\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"phone_no\" required placeholder= \"phone_no\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("            <div class=\"form-group\">\n");
      out.write("               \n");
      out.write("                     <label class=\"col-lg-3\">Select Cities</label>   \n");
      out.write("               <div class=\"col-lg-9\">\n");
      out.write("           \n");
      out.write("                     \n");
      out.write("                     \n");
      out.write("            <select style=\"width: 100%\" class=\"form-control dropdown\" id=\"city\" name=\"city\">\n");
      out.write("                <option value=\"null\">Select Cities</option>\n");
      out.write("                    <option  >Abohar</option>\n");
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
      out.write("            </select> \n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("           \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Opening_time</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                   \n");
      out.write("            <input type=\"text\" name=\"open_time\" class=\"form-control\" required placeholder=\"opening time\"/>\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Closing_time</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("           <input type=\"text\"  class=\"form-control\" name=\"close_time\" required placeholder=\"closing time\"/>       \n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Average_price</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                 \n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"average_price\" required placeholder=\"average price\"/>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Delivery_time</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                 \n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"delivery_time\" required placeholder=\"Delivery Time\"/>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                    <label>Enter cuisine name</label>\n");
      out.write("                    </div>\n");
      out.write("                 <br>\n");
      out.write("                 <br>\n");
      out.write("                ");

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from cuisines order by name asc");
                        while (rs.next())
                        {
                            String name = rs.getString("name");
                
      out.write("\n");
      out.write("               <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-offset-3\">\n");
      out.write("                 \n");
      out.write("                   <input type=\"checkbox\" name=\"cuisine\" value=\"");
      out.print( name);
      out.write("\"/> ");
      out.print( name);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("               </div>\n");
      out.write("                ");

                        }
                        conn.close();

                        rs.close();
                        stmt.close();
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                
      out.write("\n");
      out.write("              \n");
      out.write("               </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("                        <button class=\"btn-primary btn-lg\" type=\"submit\">Ok</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("        </form>\n");
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
