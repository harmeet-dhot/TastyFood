<%@page import="java.sql.*"%>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("newpassword");
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from admin where email='"+ email +"'");
        if (rs.next()) 
        {
            rs.updateString("password", password);
            rs.updateRow();
            response.sendRedirect("admin_login1.jsp");
        }
    } catch (Exception ex) {
        ex.printStackTrace();

    }
%>