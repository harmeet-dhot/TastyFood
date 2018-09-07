<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
                      body{
                background-image: url("food_img/large imgs/download (8).jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
   
        <script>
            function getMenu()
            {
                var restaurantName = document.getElementById("restaurant_name").value;
                var xml = new XMLHttpRequest();
                var query = "get_menu.jsp?rest_name=" + restaurantName;
                xml.onreadystatechange = function ()
                {
                    if (xml.readyState == 4 && xml.status == 200)
                    {
                        document.getElementById("menu_td").innerHTML = xml.responseText;
                    }
                };
                xml.open("GET", query, true);
                xml.send();
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1 class="bg-success" style="text-align: center">Add_menu_item</h1>
            <br>
            <br>
            <form action="addmenuitem" enctype="multipart/form-data" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3">Item_Name</label>
                    <div class="col-sm-9">
                        <input type="text" name="item_name" class="form-control" required placeholder="Item name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Veg or Non veg</label>
                    <div class="col-sm-9">
                        <input type="radio" class="radio-inline"  name="vegornon" value="veg"/>Vegetarian
                        <input type="radio" class="radio-inline" name="vegornon" value="nonveg"/>Non Vegetarian
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3">Display_price</label>
                    <div class="col-sm-9">
                        <input type="text" name="display_price" 
                               class="form-control" required placeholder="display_price"/>
                    </div>
                </div>
                                <div class="form-group">
                                    <label class="col-sm-3">Offer_price</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="offer_price" class="form-control" required placeholder="offer_price"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3">Select_restaurant</label>
                                    <div class="col-sm-9">
                                        <select id="restaurant_name" name="restaurant" class="form-control"  onchange="getMenu()">
                                            <option value="null">Select Restaurant</option>
                <%
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from restaurant");
                        while (rs.next())
                        {
                            String restaurant_name = rs.getString("name");
                %>
                <option><%=restaurant_name%></option>
                <%
                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                %>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-3 col-sm-9" id="menu_td">

        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-3 col-sm-9">
            <button class="btn btn-primary btn-block" type="submit">Submit</button>
        </div>
    </div>
            </form>
        </div>
    </body>
</html>
