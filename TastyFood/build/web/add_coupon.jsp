<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <center>
                <h1>Add Coupon</h1>
                <form action="AddCoupon" method="post">
                    <table style="width: 50%" class="table table-bordered table-hover table-responsive table-striped">
                        <tr>
                            <td>Coupon Name</td>
                            <td><input type="text" placeholder="Coupon Name" name="c_name" required class="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Coupon Type</td>
                            <td>
                                <select class="form-control" name="c_type">
                                    <option class="form-control" value="price">Discount by Price</option>
                                    <option class="form-control" value="percentage">Discount by Percentage</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Minimum Applicable Price</td>
                            <td>
                                <input type="text" placeholder="Minimum Applicable Price" required name="c_min_price" class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Discount Value</td>
                            <td>
                                <input type="text" placeholder="Discount Value" required name="c_value" class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Expiry Date</td>
                            <td>
                                <input type="text" required id="datepicker" name="c_exp_date" class="form-control"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Select Restaurant For Coupon</td>
                            <td>
                                <select name="c_rest_id" class="form-control" required>
                                    <%
                                        try
                                        {
                                            Class.forName("com.mysql.jdbc.Driver");
                                            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                                            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                            ResultSet rs = stmt.executeQuery("select * from restaurant order by name asc");
                                            while (rs.next())
                                            {
                                                String restName = rs.getString("name");
                                                String restID = rs.getString("restaurant_id");
                                    %>
                                    <option value="<%= restID %>"><%= restName %></option>
                                    <%
                                            }
                                        } catch (Exception e)
                                        {
                                            e.printStackTrace();
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button style="width: 100%" class="btn btn-primary" type="submit">Add Coupon</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </center>
        </div>
    </body>
</html>

