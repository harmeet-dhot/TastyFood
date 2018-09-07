<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin_login2</title>
    </head>
    <body>
        <h1>admin_login2</h1>
        <%
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "' and password='" + password + "'");
                if (rs.next())
                {
                    session.setAttribute("admin_email", email);
                    response.sendRedirect("admin_home.jsp?em=" + email);
                }
                else
                {
                    response.sendRedirect("admin_login1.jsp?msg=invalid email/password");
                }
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();

            }
        %>
    </body>
</html>
