package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public final class view_005frestaurant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>VIEW RESTAURANT</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background-color: powderblue;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                background-size: cover;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function go(m_item_id)\n");
      out.write("            {\n");
      out.write("                var query = \"addtocart?m_item_id=\" + m_item_id;\n");
      out.write("                var xmlhttp = new XMLHttpRequest();\n");
      out.write("                xmlhttp.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                    {\n");
      out.write("                        document.getElementById(\"div_cart\").innerHTML = xmlhttp.responseText;\n");
      out.write("                        document.getElementById(\"div_cart\").style.display = \"block\";\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                xmlhttp.open(\"GET\", \"addtocart?m_item_id=\" + m_item_id, true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function removeitem(id)\n");
      out.write("            {\n");
      out.write("                alert(id);\n");
      out.write("                var ans = confirm(\"Sure To Remove Item?\");\n");
      out.write("                if (ans == true)\n");
      out.write("                {\n");
      out.write("                    var xmlhttp = new XMLHttpRequest();\n");
      out.write("                    xmlhttp.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                        {\n");
      out.write("                            document.getElementById(\"div_cart\").innerHTML = xmlhttp.responseText;\n");
      out.write("                            document.getElementById(\"div_cart\").style.display = \"block\";\n");
      out.write("                            if (xmlhttp.responseText.length == 0)\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"cart\").style.display = \"none\";\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                    xmlhttp.open(\"GET\", \"removetocart?m_item_id=\" + id, true);\n");
      out.write("                    xmlhttp.send();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function go1()\n");
      out.write("            {\n");
      out.write("                window.location.href = \"user_signin.jsp\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function checkout()\n");
      out.write("            {\n");
      out.write("                var choice = confirm(\"Proceed With Checkout???\");\n");
      out.write("                if (choice)\n");
      out.write("                {\n");
      out.write("                    window.location.href = \"apply_coupon.jsp\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div id=\"div_cart\" style=\"\n");
      out.write("             width: 270px;\n");
      out.write("             max-height: 400px;\n");
      out.write("             /*overflow: auto;*/\n");
      out.write("             position: fixed;\n");
      out.write("             margin-left: 70%;\n");
      out.write("             margin-top: 5%;\n");
      out.write("             background: #ffffff;\n");
      out.write("             z-index: 200\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            String restid = request.getParameter("id");
            String restname = "";
            if (session.getAttribute("rest_id") == null)
            {
                session.setAttribute("rest_id", restid);
            } else if (session.getAttribute("rest_id") != restid)
            {
                if (session.getAttribute("cart_list") != null)
                {
                    ArrayList<cart.Cart> al = (ArrayList<cart.Cart>) session.getAttribute("cart_list");
                    al.clear();
                    session.setAttribute("cart_list", al);
                }
            }
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from restaurant where restaurant_id='" + restid + "'");

                while (rs.next())
                {
                    restname = rs.getString("name");
                    String image = rs.getString("image");
                    System.out.println(image);
        
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <img src=\"");
      out.print( image);
      out.write("\" width=\"1200\" height=\"300\"/>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <a><strong>");
      out.print( restname);
      out.write("</strong></a>\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");

                    }
                } catch (Exception ex)
                {

                    ex.printStackTrace();
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div>\n");
      out.write("            <marquee>\n");
      out.write("                ");

                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs1 = stmt1.executeQuery("select * from gallery where restaurant_id='" + restid + "'");
                        while (rs1.next())
                        {
                            String path = rs1.getString("image_path");
                            String caption = rs1.getString("caption");
                
      out.write("\n");
      out.write("                <img style=\"float: right; margin-right: 20px\" src=\"");
      out.print(path);
      out.write("\" alt=\"");
      out.print(path);
      out.write("\"  height=\"150\"/>\n");
      out.write("                ");

                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                
      out.write("\n");
      out.write("            </marquee>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    ");

                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs = stmt.executeQuery("select * from menu where r_id='" + restid + "'");
                            while (rs.next())
                            {
                                String name = rs.getString("menu_name");
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <label>");
      out.print(name);
      out.write("</label>\n");
      out.write("                    </div>\n");
      out.write("                    ");

                            }
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-9\">\n");
      out.write("                    ");

                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs1 = stmt.executeQuery("select * from menu where  r_id='" + restid + "'");
                            while (rs1.next())
                            {
                                String name = rs1.getString("menu_name");
                                String image = rs1.getString("menu_image");
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("\n");
      out.write("                        <img src=\"");
      out.print(image);
      out.write("\" style=\"z-index: 50;\" width=\"700\" height=\"200\"> \n");
      out.write("                        <br>\n");
      out.write("                        <h1 style=\"text-align:center\"> ");
      out.print(name);
      out.write("</h1>\n");
      out.write("                    </div>\n");
      out.write("                    <br     \n");
      out.write("                        ");

                            try
                            {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Tasty_Khana", "root", "system");
                                Statement stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs2 = stmt1.executeQuery("select * from menu_item where  menu_name='" + name + "' and restaurant_name='" + restname + "'");
                                System.out.println("select * from menu_item where menu_name='" + name + "' and restaurant_name='" + restname + "'");
                                while (rs2.next())
                                {
                                    String m_item_id = rs2.getString("m_item_id");
                                    String mitemname = rs2.getString("item_name");
                                    String mitemvegornonveg = rs2.getString("veg_or_nonveg");
                                    String mitemdisplayprice = rs2.getString("display_price");
                                    String mitemofferprice = rs2.getString("offer_price");
                        
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-4\">\n");
      out.write("                           \n");
      out.write("                            <label>");
      out.print(mitemname);
      out.write("</label>\n");
      out.write("                            <br>\n");
      out.write("                            <label>\n");
      out.write("                                ");
      out.print(mitemvegornonveg);
      out.write("\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-sm-5\"> \n");
      out.write("                            <label id=\"dp\">\n");
      out.write("                                display_price:");
      out.print(mitemdisplayprice);
      out.write("\n");
      out.write("                            </label>\n");
      out.write("                            <br>\n");
      out.write("                            <label id=\"of\">\n");
      out.write("                                offer_price:");
      out.print(mitemofferprice);
      out.write("\n");
      out.write("                            </label>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                        </div> \n");
      out.write("\n");
      out.write("                        ");

                            if (session.getAttribute("email") != null)
                            {
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            <button type=\"button\" id=\"");
      out.print( m_item_id);
      out.write("\"  class=\"btn btn-primary\" onclick=\"go(this.id)\">Add to cart</button> \n");
      out.write("                        </div>\n");
      out.write("                        ");

                        } else
                        {
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-2\">\n");
      out.write("                            <button type=\"button\" data-toggle=\"modal\" data-target=\"#myModal\" class=\"btn btn-primary btn-lg\" >Sign In First</button> \n");
      out.write("                        </div>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                ");

                        }

                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");

                    }
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\n");
      out.write("            <div class=\"modal-dialog\">\n");
      out.write("\n");
      out.write("                <!-- Modal content-->\n");
      out.write("                <div class=\"modal-content\">\n");
      out.write("                    <div class=\"modal-header\">\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("                        <h4 class=\"modal-title\">Sign In</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-body\">\n");
      out.write("                        <form action=\"user_signin2.jsp\" method=\"post\" class=\"form-horizontal\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <br>\n");
      out.write("                                <div class=\"col-sm-2\">\n");
      out.write("                                    <label>Enter Your Email</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-10\">\n");
      out.write("\n");
      out.write("                                    <input type=\"text\" required name=\"email\" placeholder=\"email\" class=\"form-control\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"col-sm-2\">\n");
      out.write("                                    <label>Enter Your Password</label>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-sm-10\">\n");
      out.write("                                    <input type=\"password\" required name=\"password\" placeholder=\"password\" class=\"form-control\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <div class=\"col-sm-offset-5\">\n");
      out.write("                                    <button class=\"btn btn-primary btn-lg\" type=\"submit\">Signin</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"modal-footer\">\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
