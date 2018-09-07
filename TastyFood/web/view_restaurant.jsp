<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>VIEW RESTAURANT</title>
        <style>
            body{
                background-color: powderblue;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <script>
            function go(m_item_id)
            {
                var query = "addtocart?m_item_id=" + m_item_id;
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        document.getElementById("div_cart").innerHTML = xmlhttp.responseText;
                        document.getElementById("div_cart").style.display = "block";
                    }
                };
                xmlhttp.open("GET", "addtocart?m_item_id=" + m_item_id, true);
                xmlhttp.send();
            }

            function removeitem(id)
            {
                alert(id);
                var ans = confirm("Sure To Remove Item?");
                if (ans == true)
                {
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function ()
                    {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                        {
                            document.getElementById("div_cart").innerHTML = xmlhttp.responseText;
                            document.getElementById("div_cart").style.display = "block";
                            if (xmlhttp.responseText.length == 0)
                            {
                                document.getElementById("cart").style.display = "none";
                            }
                        }
                    };
                    xmlhttp.open("GET", "removetocart?m_item_id=" + id, true);
                    xmlhttp.send();
                }
            }

            function go1()
            {
                window.location.href = "user_signin.jsp";
            }

            function checkout()
            {
                var choice = confirm("Proceed With Checkout???");
                if (choice)
                {
                    window.location.href = "apply_coupon.jsp";
                }
            }

            function darkDiv(div)
            {
                div.style.backgroundColor = "lightgrey";
            }

            function revertDiv(div)
            {
                div.style.backgroundColor = "#f5f5f5";
            }
        </script>
    </head>

    <div class="container">
        <div id="div_cart" style="
             width: 270px;
             max-height: 400px;
             /*overflow: auto;*/
             position: fixed;
             margin-left: 70%;
             margin-top: 5%;
             background: #ffffff;
             z-index: 200">
        </div>

        <%
            String restid = request.getParameter("id");
            String restname = "";
            if (session.getAttribute("rest_id") == null)
            {
                session.setAttribute("rest_id", restid);
            } else if (session.getAttribute("rest_id") != restid)
            {
                if (session.getAttribute("cart_list") != null)
                {
                    ArrayList<cart.Cart> al = (ArrayList<cart.Cart>) session.getAttribute("cart_list");
                    al.clear();
                    session.setAttribute("cart_list", al);
                }
            }

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from restaurant where restaurant_id='" + restid + "'");

                while (rs.next())
                {
                    restname = rs.getString("name");
                    String image = rs.getString("image");
                    System.out.println(image);
        %>

        <div class="container-fluid">
            <br>
            <br>
            <div class="row">
                <img src="<%= image%>" style="width: 100%; height: 350px"/>
                <br>
                <!--<a><strong><%= restname%></strong></a>-->
                <br>
            </div>
            <%
                    }
                } catch (Exception ex)
                {

                    ex.printStackTrace();
                }
            %>
        </div>
        <br>
        <div>
            <marquee>
                <%
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs1 = stmt1.executeQuery("select * from gallery where restaurant_id='" + restid + "'");
                        while (rs1.next())
                        {
                            String path = rs1.getString("image_path");
                            String caption = rs1.getString("caption");
                %>
                <img style="float: right; margin-right: 20px; border-radius: 10px" src="<%=path%>" alt="<%=path%>"  height="150"/>
                <%
                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                %>
            </marquee>
            <marquee onmouseover="this.stop()" onmouseout="this.start()">
                <%
                    try
                    {
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from coupon where rest_id = '" + restid + "' and exp_date > '" + new Date(System.currentTimeMillis()) + "'");
                        while (rs.next())
                        {
                            String couponName = rs.getString("name");
                            String couponExpiryDate = "Expires on " + new SimpleDateFormat("dd MMM, yyyy").format(rs.getDate("exp_Date"));
                            String couponDiscountValue = "";
                            if (rs.getString("type").equals("price"))
                            {
                                couponDiscountValue = "Discount by Rs. " + rs.getString("value");
                            } else
                            {
                                couponDiscountValue = "Discount by " + rs.getString("value") + "%";
                            }
                            String couponMinPrice = "Minimum Applicable on Rs. " + rs.getString("min_price");
                %>
                <div style="background-color: #ff6600; width: 200px; padding: 25px; border-radius: 10px">
                    <center>
                        <label style="font-size: 25px"><u><b><%= couponName%></b></u></label>
                    </center>
                    <label><%= couponMinPrice%></label><br>
                    <label><%= couponDiscountValue%></label><br>
                    <label><%= couponExpiryDate%></label>
                </div>
                <%
                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                %>
            </marquee>
        </div>
        <br>
        <div class="container">
            <div class="col-sm-3 well" style="padding-top: 25px; border-radius: 10px">
                <a style="font-size: 20px; padding-bottom: 10px"><center><label><u>Jump To Category</u></label></center></a>
                <%
                    try
                    {
                        int menu_id = 1;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from menu where r_id='" + restid + "'");
                        while (rs.next())
                        {
                            String name = rs.getString("menu_name");
                %>
                <a href="#div_<%= menu_id%>">
                    <div 
                        style="padding: 15px;"
                        onmouseover="darkDiv(this)"
                        onmouseout="revertDiv(this)">
                        <label style="font-size: 20px"><%=name%></label>
                    </div>
                </a>
                <%
                            menu_id++;
                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                %>
            </div>
            <div class="col-sm-9 well" style="border-radius: 10px">
                <%
                    try
                    {
                        int div_id = 1;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs1 = stmt.executeQuery("select * from menu where r_id='" + restid + "'");
                        while (rs1.next())
                        {
                            String name = rs1.getString("menu_name");
                            String image = rs1.getString("menu_image");
                %>
                <div id="div_<%= div_id%>" style="margin-top: 10px" class="col-sm-12">
                    <img src="<%=image%>" style="border-radius: 10px; z-index: 50; width: 100%; height: 250px"/>
                    <br>
                    <h1 style="text-align:center"><u><%=name%></u></h1>
                    <%
                        div_id++;
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection conn1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                            Statement stmt1 = conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet rs2 = stmt1.executeQuery("select * from menu_item where  menu_name='" + name + "' and restaurant_name='" + restname + "'");
                            System.out.println("select * from menu_item where menu_name='" + name + "' and restaurant_name='" + restname + "'");
                            while (rs2.next())
                            {
                                String m_item_id = rs2.getString("m_item_id");
                                String mitemname = rs2.getString("item_name");
                                String mitemvegornonveg = rs2.getString("veg_or_nonveg");
                                if (mitemvegornonveg.equals("veg"))
                                {
                                    mitemvegornonveg = "Vegetarian Item";
                                } else
                                {
                                    mitemvegornonveg = "Non - Veg Item";
                                }
                                String mitemdisplayprice = rs2.getString("display_price");
                                String mitemofferprice = rs2.getString("offer_price");
                    %>
                    <div class="col-sm-4" style="height: 75px; padding: 15px;">
                        <label>Item Name : <%=mitemname%><br>(<%= mitemvegornonveg%>)</label>
                    </div>
                    <div class="col-sm-4" style="height: 75px; padding: 15px">
                        <label id="dp">MRP : <strike>Rs. <%=mitemdisplayprice%></strike></label><br>
                        <label id="of">Offer Price : Rs. <%=mitemofferprice%></label>
                    </div>
                    <div class="col-sm-4" style="height: 75px; padding: 15px">
                        <%
                            if (session.getAttribute("email") != null)
                            {
                        %>
                        <button type="button" id="<%= m_item_id%>"  class="btn btn-primary" style="width: 100%" onclick="go(this.id)">Add to cart</button> 
                        <%
                        } else
                        {
                        %>
                        <button type="button" data-toggle="modal" data-target="#myModal" style="width: 100%" class="btn btn-primary btn-lg" >Sign In First</button> 
                        <%
                            }
                        %>
                    </div>
                    <hr style="border: 1px solid lightgray; height: 2px">
                    <%
                        }
                    %>
                </div>
                <%
                            } catch (Exception ex)
                            {
                                ex.printStackTrace();
                            }
                        }
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                %>
            </div>
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Sign In</h4>
                        </div>
                        <div class="modal-body">
                            <form action="user_signin2.jsp" method="post" class="form-horizontal">
                                <div class="form-group">
                                    <br>
                                    <div class="col-sm-5">
                                        <label>Enter Your Email</label>
                                    </div>
                                    <div class="col-sm-12">
                                        <input type="text" required name="email" placeholder="email" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-5">
                                        <label>Enter Your Password</label>
                                    </div>
                                    <div class="col-sm-12">
                                        <input type="password" required name="password" placeholder="password" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div style="text-align: right; margin-right: 15px">
                                        <button class="btn btn-primary btn-lg" style="width: 250px" type="submit">Signin</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>