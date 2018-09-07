<%@page import="java.sql.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="bg-danger" style="text-align: center">Forgot Password3</h1>
        <%
            String email = request.getParameter("email");
            String sec_answer = request.getParameter("sec_answer");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "' and sec_answer='" + sec_answer + "'");
                if (rs.next()) {
                    response.sendRedirect("admin_forgot_password4.jsp?email=" + email);
                } else {
                    response.sendRedirect("admin_login1.jsp?msg=invalid email/sec_answer");
                }
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        %>
    </body>
</html>
