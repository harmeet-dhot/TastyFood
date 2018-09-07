package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class admin_005fforgot_005fpassword2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("          <style>\n");
      out.write("                      body{\n");
      out.write("                background-image: url(\"food_img/544.jpg\");\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write(" \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <div class=\"container\">\n");
      out.write("             <h1 class=\"bg-info\" style=\"text-align: center\">Forgot_Password2</h1>\n");
      out.write("             <br>\n");
      out.write("             <br>\n");
      out.write("        ");

            String email = request.getParameter("email");
            String sec_question = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "'");
                if (rs.next()) 
                {
                    sec_question = rs.getString("sec_question");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"admin_forgot_password4.jsp\"  onsubmit=\"alert('hello')\" method=\"post\" class=\"form-horizontal\">\n");
      out.write("            \n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Enter Your Email</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\"  class=\"form-control\" required placeholder=\"email\" name=\"email\" readonly value=\"");
      out.print(email);
      out.write("\" />\n");
      out.write("                    </div>\n");
      out.write("             </div>\n");
      out.write("                     <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Enter Your Security_Question</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" readonly placeholder=\"sec_question\" value=\"");
      out.print(sec_question);
      out.write("\" >\n");
      out.write("                    </div>\n");
      out.write("                     </div>\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                    <label class=\"col-sm-3\">Enter Your Security_Answer</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" required  placeholder=\"sec_answer\" >\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                    \n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write(" \n");
      out.write("                   <button class=\"btn btn-primary\" type=\"submit\">Proceed</button>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("                   \n");
      out.write("        </form>\n");
      out.write("         </div>\n");
      out.write("    </body>\n");
      out.write("\n");
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
