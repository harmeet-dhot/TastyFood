<%@page import="java.sql.*"%>
<%
    String email = (String) session.getAttribute("email");
    String userName = "";
    int serial = 1;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from user where email = '" + email + "'");
        if (rs.next())
        {
            userName = rs.getString("name");
        }
        rs.close();
        stmt.close();
        conn.close();
    } catch (Exception e)
    {
        e.printStackTrace();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script>
            function postRating(id)
            {
                var reviewID = "ta" + id;
                var ratingID = "rating" + id;
                var review = document.getElementById(reviewID).value;
                var rating = document.getElementById(ratingID).value;
                if (review.trim().length == 0)
                {
                    alert("Review Cannot Be Empty");
                    return;
                }
                if (rating.trim().length == 0)
                {
                    alert("Rating Cannot Be Empty");
                    return;
                }
                if (/[a-zA-Z]/.test(rating) || (rating > 5 || rating < 0))
                {
                    alert("Invalid Rating Found");
                    return;
                }
                window.location.href = "putRating?id=" + id + "&rev=" + review + "&rat=" + rating;
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <center>
                <h1><%= userName%></h1>
            </center>
            <table class="table table-bordered table-hover table-striped">
                <tr>
                    <th style="width: 100px">
                        Serial No.
                    </th>
                    <th>
                        Ordered Items
                    </th>
                    <th style="width: 300px">
                        Review
                    </th>
                    <th style="width: 300px">
                        Rating
                    </th>
                </tr>
                <%
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from user_order where email = '" + email + "' and reviewed = 'no'");
                        while (rs.next())
                        {
                            String orderedItems = "";
                            String orderID = rs.getString("order_id");
                            try
                            {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                                Statement stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs1 = stmt1.executeQuery("select * from order_detail where order_id = '" + orderID + "'");
                                while (rs1.next())
                                {
                                    orderedItems += rs1.getString("menu_item") + " ";
                                }
                                rs1.close();
                                stmt1.close();
                                conn1.close();
                            } catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                %>
                <tr>
                    <td>
                        <%= serial%>
                    </td>
                    <td>
                        <%= orderedItems%>
                    </td>
                    <td>
                        <textarea placeholder="Write a Review..." id="ta<%= orderID%>"
                                  name="ta<%= orderID%>" class="form-control"></textarea>
                    </td>
                    <td>
                        <input type="text" placeholder="Write a Rating from 1 to 5..." 
                               id="rating<%= orderID%>" name="rating<%= orderID%>"
                               class="form-control"/>
                    </td>
                    <td>
                        <button class="btn btn-success" id="<%= orderID%>" 
                                onclick="postRating(this.id)">Post Review</button>
                    </td>
                </tr>
                <%
                            serial++;
                        }
                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                %>
            </table>
        </div>
    </body>
</html>
