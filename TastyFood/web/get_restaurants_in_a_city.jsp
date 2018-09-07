<%@page import="java.sql.*"%>
<%
    String city = request.getParameter("city");
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from Restaurant where city = '" + city + "'");
        while (rs.next())
        {
            String restName = rs.getString("name");
%>
<option value="<%= restName %>"><%= restName %></option>
<%
        }
    } catch (Exception e)
    {
        e.printStackTrace();
    }
%>