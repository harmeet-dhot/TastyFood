<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String cuisine = request.getParameter("cuisine");
    String city = (String) session.getAttribute("city");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <style>
            body
            {
                background-image: url("food_img/biryani.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }

            label
            {
                font-size: 18px;
            }s
        </style>
        <script>
            function openRestaurant(id)
            {
                window.location.href = "view_restaurant.jsp?id=" + id;
            }
            function filter(name)
            {
                window.location.href = "filter_restaurant.jsp?cuisine=" + name;
            }
        </script>
    </head>
    <body class="container"> 

        <div style="margin-bottom: 20px">
            <jsp:include page="header1.jsp"/>
        </div>

        <div class="col-sm-3 well">
            <jsp:include page="sidebar1.jsp"/>
        </div>

        <div class="col-sm-9">
            <%
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from restaurant_menu where cuisine_name = '" + cuisine + "'");
                    System.out.println("select * from restaurant_menu where cuisine_name = '" + cuisine + "'");
                    while (rs.next())
                    {
                        int rest_id = rs.getInt("r_id");
                        try
                        {
                            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                            Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs1 = stmt1.executeQuery("select * from restaurant where restaurant_id = " + rest_id + " and city = '" + city + "'");
                            System.out.println("select * from restaurant where restaurant_id = " + rest_id + " and city = '" + city + "'");
                            while (rs1.next())
                            {
                                String name = rs1.getString("name");
                                String delivery_time = rs1.getString("delivery_time");
                                String opening_time = rs1.getString("opening_time");
                                String closing_time = rs1.getString("closing_time");
                                String image = rs1.getString("image");
                                String cuisines = "";
                                String phone_no = rs1.getString("phone_no");
            %>
            <div class="row well" style="text-transform: capitalize">
                <div id="<%=rest_id%>" onclick="openRestaurant(this.id)">
                    <div class="col-sm-2">
                        <img src="<%= image%>" style="border-radius: 10px" width="115" height="115"/>
                    </div>
                    <div class="col-sm-5" style="padding: 10px">
                        <label><%= name%></label><br>
                        <label>Delivery time - <%= delivery_time%> Minutes</label><br>
                    </div>
                    <div class="col-sm-5"  style="padding: 10px">
                        <label>Phone Number - <%= phone_no%></label><br>
                        <label>Opening time - <%= opening_time%></label><br>
                        <label>Closing time - <%= closing_time%></label>
                    </div>
                </div>
                <hr>
            </div>
            <%
                            }
                            rs1.close();
                            stmt1.close();
                            con1.close();
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
        </div>

    </body>
</html>
