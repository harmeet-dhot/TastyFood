<%@page import="java.sql.*"%>
<script>
    function darkDiv(div)
    {
        div.style.backgroundColor = "lightgrey";
    }

    function revertDiv(div)
    {
        div.style.backgroundColor = "#f5f5f5";
    }
</script>
<div>
    <%String tempCity = session.getAttribute("city").toString();%>
    <h3 onclick="window.location.href = 'get_restaurants.jsp?city=<%= tempCity%>'">All Cuisines</h3>
    <%
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from cuisines order by name asc");
            while (rs.next())
            {
                String name = rs.getString("name");
    %>
    <div style="padding: 5px; text-transform: capitalize"
         onmouseover="darkDiv(this)"
         onmouseout="revertDiv(this)">
        <h4 id="<%= name%>" onclick="filter(this.id)"> <%= name%></h4>
    </div>
    <%
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    %>
</div> 
</div>