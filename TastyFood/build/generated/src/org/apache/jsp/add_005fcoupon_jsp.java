package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fcoupon_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\n");
      out.write("        <script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\n");
      out.write("        <script src=\"//code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"/resources/demos/style.css\">\n");
      out.write("        <script>\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#datepicker\").datepicker();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <center>\n");
      out.write("                <h1>Add Coupon</h1>\n");
      out.write("                <form action=\"AddCoupon\" method=\"post\">\n");
      out.write("                    <table style=\"width: 50%\" class=\"table table-bordered table-hover table-responsive table-striped\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Coupon Name</td>\n");
      out.write("                            <td><input type=\"text\" placeholder=\"Coupon Name\" name=\"c_name\" required class=\"form-control\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Coupon Type</td>\n");
      out.write("                            <td>\n");
      out.write("                                <select class=\"form-control\" name=\"c_type\">\n");
      out.write("                                    <option class=\"form-control\" value=\"price\">Discount by Price</option>\n");
      out.write("                                    <option class=\"form-control\" value=\"percentage\">Discount by Percentage</option>\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Minimum Applicable Price</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" placeholder=\"Minimum Applicable Price\" required name=\"c_min_price\" class=\"form-control\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Discount Value</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" placeholder=\"Discount Value\" required name=\"c_value\" class=\"form-control\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Expiry Date</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" required id=\"datepicker\" name=\"c_exp_date\" class=\"form-control\"/>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td>\n");
      out.write("                                <button style=\"width: 100%\" class=\"btn btn-primary\" type=\"submit\">Add Coupon</button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </center>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
