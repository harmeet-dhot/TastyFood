<%@page import="java.sql.*"%>
<%
    String rest_id = request.getParameter("id");
    String restName = "";
    String restCuisines = "";
    String restDelveryTime = "";
    String restWorkingTime = "";
    String restDeliveryFee = "";
    String restTakeAwayTime = "";
    String restAddress = "";

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from restaurant where restaurant_id = '" + rest_id + "'");
        if (rs.next())
        {
            restName = rs.getString("name");
            restDelveryTime = rs.getString("delivery_time");
            restWorkingTime = rs.getString("opening_time") + " to " + rs.getString("closing_time");
            restDelveryTime = rs.getString("delivery_time");
            restDeliveryFee = "Rs. 70";
            restTakeAwayTime = restWorkingTime;
            restAddress = rs.getString("address");
            try
            {
                Connection conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from restaurant_menu where r_id = '" + rest_id + "'");
                while (rs1.next())
                {
                    restCuisines += rs1.getString("cuisine_name") + ", ";
                }
                restCuisines = restCuisines.substring(0, restCuisines.lastIndexOf(","));
                rs1.close();
                stmt1.close();
                conn1.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
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
    </head>
    <body>
        <div class="container-fluid">
            <center>
                <h1><%= restName%></h1>
            </center>

            <h1>Cuisines</h1>
            <label><%= restCuisines%></label>
            <h1>Working Hours</h1>
            <table class="table table-responsive">
                <tr>
                    <th>Days</th>
                    <th>Working Time</th>
                </tr>
                <tr>
                    <td>Sunday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Monday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Tuesday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Wednesday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Thursday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Friday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Saturday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
            </table>

            <h1>Takeaway Hours</h1>
            <table class="table table-responsive">
                <tr>
                    <th>Days</th>
                    <th>Takeaway Time</th>
                </tr>
                <tr>
                    <td>Sunday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Monday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Tuesday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Wednesday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Thursday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Friday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
                <tr>
                    <td>Saturday</td>
                    <td><%= restWorkingTime%></td>
                </tr>
            </table>

            <h1>Address</h1>
            <label><%= restAddress%></label>
            
            <h1>Delivery Price</h1>
            <label><%= restDeliveryFee %></label>
            
            <h1>Delivery Time</h1>
            <label><%= restDelveryTime %></label>
        </div>
    </body>
</html>
