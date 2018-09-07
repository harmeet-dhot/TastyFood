<%@page import="java.sql.*"%>
<%
    String id = request.getParameter("id");
    int count = 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
          <style>
                      body{
                background-image: url("food_img/large imgs/images (13).jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
  
    </head>
    <body>
        <div class="container">
            <h1 class="bg-danger" style="text-align: center">Add Menu To Restaurant</h1>
            <br>
            <br>
            <form action="AddMenu" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-sm-3">Menu_Name</label>
                    <div class="col-sm-9">
                        <input type="text" name="menu_name" required placeholder="Menu name" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Menu_Image</label>
                    <div class="col-sm-9">
                        <input type="hidden" name="r_id" value="<%= id%>" class="form-control"/>
                    </div>
                </div>
                 
                  <div class="form-group">
                    <label class="col-sm-3"></label>
                    <div class="col-sm-9">
                        <input type="file" name="file" required class="form-control"/>
                    </div>
                </div>
                    <br>
                    <br>
                <div class="form-group">
                    <label class="col-sm-3">Restaurant Name</label>
                  
                </div>
                <%
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from Restaurant where restaurant_id = '" + id + "'");
                        if (rs.next())
                        {
                            String name = rs.getString("name");
                %>
                <%=name%>
                <%
                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                %>
                

                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn btn-primary" type="submit">Add Menu</button>
                        <button class="btn btn-default" type="button" onclick="window.location.href = 'add_menu_item.jsp'">Add Menu Items</button>    
                    </div>
                </div
                <div class="form-group">
                   
                    <label class="col-sm-3">Sr. no.</label>
                    <div class="col-sm-offset-3">                       
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Name</label>
                    <div class="col-sm-offset-3 col-sm-9">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Image</label>
                    <div class="col-sm-offset-3 col-sm-9">
                    </div>
                </div>
                <%
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from menu where r_id = '" + id + "'");
                        while (rs.next())
                        {
                            String name = rs.getString("menu_name");
                            String image = rs.getString("menu_image");
                %>
                <%= count%>
                <%= name%>
                <a href="<%= image%>" target="_blank">Click To See Image</a>
                <%
                            count++;
                        }

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                %>
            </form>
        </div>
    </body>
</html>
