package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fchange_005fpassword1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title></title>\n");
      out.write("                <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function checkPassword()\n");
      out.write("            {\n");
      out.write("                var newPassword = document.getElementById(\"newpw\").value;\n");
      out.write("                var oldPassword = document.getElementById(\"confpw\").value;\n");
      out.write("                if(newPassword == oldPassword)\n");
      out.write("                {\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    alert(\"Passwords Do Not Match\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        ");

            String email = (String) session.getAttribute("admin_email");
            if (email == null) {
                response.sendRedirect("admin_login2.jsp?msg=login first");
            } else {
        
      out.write("\n");
      out.write("        <h1 class=\"bg-info\" style=\"text-align: center\">Admin_Change_Password</h1>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"admin_change_password2.jsp\" onsubmit=\"return checkPassword()\" method=\"post\"  class=\"form-horizontal\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("         <label class=\"col-sm-3\"> Email</label>\n");
      out.write("          <div class=\"col-sm-9\">\n");
      out.write("            <input type=\"text\"  class=\"form-control\" value=\"");
      out.print(email);
      out.write("\" readonly name=\"email\" />\n");
      out.write("                 </div>\n");
      out.write("            </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("              <label class=\"col-sm-3\">Old Password</label>\n");
      out.write("                        <div class=\"col-sm-9\">\n");
      out.write("                     <input type=\"password\" id=\"oldpw\" name=\"oldpassword\" required placeholder=\"old password\" class=\"form-control\" >\n");
      out.write("                \n");
      out.write("                 </div>\n");
      out.write("                 </div>\n");
      out.write("           <div class=\"form-group\">\n");
      out.write("                <label class=\"col-sm-3\">New Password</label>\n");
      out.write("               \n");
      out.write("                     <div class=\"col-sm-9\">\n");
      out.write("                     <input type=\"password\" id=\"newpw\" name=\"newpassword\" required placeholder=\"new password\" class=\"form-control\">\n");
      out.write("                     </div>\n");
      out.write("                     </div>\n");
      out.write("                     <div class=\"form-group\">\n");
      out.write("                           <label class=\"col-sm-3\">Confirm Password</label>\n");
      out.write("                           <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"password\" id=\"confpw\" name=\"confpassword\" required placeholder=\"confirm password\" class=\"form-control\">\n");
      out.write("                      </div>\n");
      out.write("                     </div>\n");
      out.write("                    \n");
      out.write("                 \n");
      out.write("               <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-3 col-sm-9\">\n");
      out.write("                        <button class=\"btn btn-primary btn-lg\" type=\"submit\">Change Password</button>\n");
      out.write("                \n");
      out.write("       \n");
      out.write("               \n");
      out.write("                 </div>\n");
      out.write("                 </div>\n");
      out.write("                \n");
      out.write("               \n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        
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
