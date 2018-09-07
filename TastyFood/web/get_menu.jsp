<%@page import="java.sql.*"%>
<%
    String restaurantName = request.getParameter("rest_name");
    String id = "";

    try
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from restaurant where name = '" + restaurantName + "'");
        if (rs.next())
        {
            id = rs.getString("restaurant_id");
        }
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
%>
<select name="menu_name">
    <%
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from menu where r_id = '" + id + "' order by menu_name asc");
            while (rs.next())
            {
                String menuName = rs.getString("menu_name");
    %>
    <option value="<%= menuName%>"><%= menuName%></option>   
    <%
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    %>
</select>