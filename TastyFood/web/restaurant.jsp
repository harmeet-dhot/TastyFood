<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
        <h1 class="bg-warning" style="text-align: center" >Restaurant</h1>
        <form action="AddRestaurant"  class="form-horizontal" enctype="multipart/form-data" method="post">
             <div class="form-group">
                  <label class="col-sm-3">Enter name of restaurant</label>
                    <div class="col-sm-9">
            <input type="text" name="name" class="form-control" required placeholder="name of restaurant">
                    </div>
             </div>
             <div class="form-group">
                  <label class="col-sm-3">Description</label>
                    <div class="col-sm-9">
            <textarea name="desc" class="form-control" required placeholder="Description"></textarea>
                    </div>
                  </div>
             <div class="form-group">
                  <label class="col-sm-3">Choose file name</label>
                    <div class="col-sm-9">
            <input type="file" class="form-control" name="file" required/>
                    </div>
             </div>
             <div class="form-group">
                  <label class="col-sm-3">Enter address of restaurant</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="address" required placeholder="address of restaurant"/>
                    </div>
             </div>
            <div   class="form-group">
                <label class="col-sm-3">Enter phone_no</label>
                <div class="col-sm-9">
                        <input type="text" class="form-control" name="phone_no" required placeholder= "phone_no"/>
                </div>
            </div>
              
            <div class="form-group">
               
                     <label class="col-sm-3">Select Cities</label>   
               <div class="col-sm-9">
           
                     
                     
            <select style="width: 100%" class="form-control dropdown" id="city" name="city">
                <option value="null">Select Cities</option>
                    <option  >Abohar</option>
                    <option  >Amritsar</option>
                    <option  >Batala</option>
                    <option  >Bombay</option>
                    <option  >Chandigarh</option>
                    <option  >Delhi</option>
                    <option  >Jalandhar</option>
                    <option  >Jandiala</option>
                    <option  >Kapurthala</option>
                    <option  >Kartarpur</option>
                    <option  >Ludhiana</option>
                    <option  >Majhitha</option>
                    <option  >Moga</option>
                    <option  >Nawa Shehar</option>
                    <option  >Patiala</option>
                    <option  >Tarn Taran</option>
                    <option  >Zira</option>
                           
            </select> 
                
        </div>
    </div>
           
                    <div class="form-group">
                    <label class="col-sm-3">Opening_time</label>
                    <div class="col-sm-9">
                   
            <input type="text" name="open_time" class="form-control" required placeholder="opening time"/>
                    </div>
                    </div>
            <div class="form-group">
                    <label class="col-sm-3">Closing_time</label>
                    <div class="col-sm-9">
           <input type="text"  class="form-control" name="close_time" required placeholder="closing time"/>       
                    </div>
            </div>
            <div class="form-group">
                    <label class="col-sm-3">Average_price</label>
                    <div class="col-sm-9">
                 
                        <input type="text" class="form-control" name="average_price" required placeholder="average price"/>
                    </div>
            </div>
            <div class="form-group">
                    <label class="col-sm-3">Delivery_time</label>
                    <div class="col-sm-9">
                 
                        <input type="text" class="form-control" name="delivery_time" required placeholder="Delivery Time"/>
                    </div>
            </div>
             <div class="form-group">
                    <div class="col-sm-3">
                    <label>Enter cuisine name</label>
                    </div>
                 <br>
                 <br>
                <%
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs = stmt.executeQuery("select * from cuisines order by name asc");
                        while (rs.next())
                        {
                            String name = rs.getString("name");
                %>
               <div class="row">
                    <div class="col-sm-offset-3">
                 
                   <input type="checkbox" name="cuisine" value="<%= name%>"/> <%= name%>
                    </div>
               </div>
                <%
                        }
                        conn.close();

                        rs.close();
                        stmt.close();
                    } catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                %>
              
               </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn-primary btn-lg" type="submit">Ok</button>
                    </div>
                </div>
        </form>
        </div>
    </body>
</html>
