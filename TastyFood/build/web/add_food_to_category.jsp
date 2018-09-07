

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
                background-image: url("food_img/large imgs/download (10).jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style> 
    
    </head>
    <body>
        <div class="container">
            <h1  class="bg-info" style="text-align: center">Add_food_items</h1>
            <br>
            <br>
            <form action="AddFoodItem" method="post" enctype="multipart/form-data" onsubmit="alert('hello')"  class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3">Enter Food Name</label>
                    <div class="col-sm-9">
                        <input type="text" name="foodname" class="form-control" required placeholder="Name of food item">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Description Of Food</label>
                    <div class="col-sm-9">
                        <textarea name="desc" class="form-control" required placeholder="Description"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Select Category</label>
                    <div class="col-sm-9">
                        <select name="category" class="form-control">
                            <%
                                try
                                {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    ResultSet rs = stmt.executeQuery("select * from cuisines");
                                    while (rs.next())
                                    {
                                        String cuisine_name = rs.getString("name");
                            %>
                            <option><%=cuisine_name%></option>
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
                    <label class="col-sm-3">Choose Food Item</label>
                    <div class="col-sm-9">

                        <input type="file" class=" form-control" name="file" required/>
                    </div>
                </div>
                <div class="form-group">

                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn btn-primary" type="submit">Add Food items</button>
                    </div>
                </div>



            </form>
        </div>
    </body>
</html>
