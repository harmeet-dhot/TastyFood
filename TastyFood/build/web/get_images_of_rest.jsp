<%@page import="java.sql.*"%>
<%
    String name = request.getParameter("name");
    int restID = 0;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select restaurant_id from Restaurant where name = '" + name + "'");
        if (rs.next())
        {
            restID = rs.getInt("restaurant_id");
        }
    } catch (Exception e)
    {
        e.printStackTrace();
    }
    System.out.println(restID);
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from gallery where restaurant_id = '" + restID + "'");
        while (rs.next())
        {
            String image = rs.getString("image_path");
            String caption = rs.getString("caption");
%>
<img src="<%= image%>" height="250" alt="Error"/>
<%
        }
    } catch (Exception e)
    {
        e.printStackTrace();
    }


%>