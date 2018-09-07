<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1 class="bg-warning" style="text-align: center">Admin_Change_Password2</h1>
        <%
            String email = request.getParameter("email");
            String oldpassword = request.getParameter("oldpassword");
            String password=request.getParameter("newpassword");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "' and password='" + oldpassword +"'");
                
                if (rs.next())
                {  
                    rs.updateString("password", password);
                    rs.updateRow();
                
                    session.setAttribute("admin_email", email);
                       response.sendRedirect("admin_home.jsp?em=" + email);
                }
                else
                {
                    session.removeAttribute("admin_email");
                    response.sendRedirect("admin_ change_password1.jsp?msg=invalid password");
                }
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();

            }
       %>
  
    </body>
</html>
