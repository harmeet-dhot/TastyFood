<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String city = request.getParameter("city");
    session.setAttribute("city", city);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                background-image: url("food_img/large imgs/Best-top-desktop-food-wallpapers-hd-food-wallpaper-food-pictures-image-photo-34.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
            
            label
            {
                font-size: 18px;
            }
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
                    ResultSet rs = stmt.executeQuery("select * from restaurant where city = '" + city + "' order by name asc");
                    while (rs.next())
                    {
                        int rest_id = rs.getInt("restaurant_id");
                        String name = rs.getString("name");
                        String delivery_time = rs.getString("delivery_time");
                        String opening_time = rs.getString("opening_time");
                        String closing_time = rs.getString("closing_time");
                        String image = rs.getString("image");
                        String cuisines = "";
                        String phone_no = rs.getString("phone_no");
                        try
                        {
                            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                            Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs1 = stmt1.executeQuery("select * from restaurant_menu where r_id = " + rest_id);
                            while (rs1.next())
                            {
                                cuisines = cuisines + rs1.getString("cuisine_name") + ", ";
                            }
                            cuisines = cuisines.substring(0, cuisines.lastIndexOf(","));
                            rs1.close();
                            stmt1.close();
                            con1.close();
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
            %>
            <div class="row well" style="text-transform: capitalize">
                <div id="<%=rest_id%>" onclick="openRestaurant(this.id)">
                    <div class="col-sm-2">
                        <img src="<%= image%>" style="border-radius: 10px" width="115" height="115"/>
                    </div>
                    <div class="col-sm-5" style="padding: 10px">
                        <label><%= name%></label><br>
                        <label><%= cuisines%></label><br>
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
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            %>
        </div>
    </body>
</html>
