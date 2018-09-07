<%@page import="java.sql.*"%>
<%
    String restID = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-fluid">
            <%
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from review where rest_id = '" + restID + "'");
                    while (rs.next())
                    {
                        String rating = rs.getString("rating");
                        String review = rs.getString("review");
                        String email = rs.getString("email");
                        String datetime = rs.getString("datetime");
            %>
            <div class="row">
                <label>Review by - <%= email %></label><br>
                <label>Rating - <%= rating %></label><br>
                <label>Review - <%= review %></label><br>
                <label>Date & Time - <%= datetime %></label><br>
                <hr>
            </div>
            <%
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            %>
        </div>
    </body>
</html>
