
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>admin_login1</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
                      body{
                background-image: url("food_img/Meatballs-ridotto_1253459840.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    
    
    </head>
    <body>
    <div class="container">
        
        
            <h1   class="bg-info" style="text-align: center ">Admin_login1</h1>
            
               
            <br>
            <br>
            <form action="admin_login2.jsp" method="post" class="form-horizontal">
               
          <div class="form-group">
                    <label class="col-sm-3">
                        Enter Your Email
                    </label>
                    <div class="col-sm-9">
                        
                        <input type="text" required name="email" placeholder="email" class="form-control" >
                    </div>
          </div>
                                 <div class="form-group">
                    <label class="col-sm-3">Enter Your Password</label>
                    <div class="col-sm-9">
                        <input type="password" required name="password" placeholder="password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn btn-primary btn-lg" type="submit">Login</button>
                        <button class="btn btn-primary btn-lg" type="button" onclick="window.location.href='admin_forgot_password1.jsp'">Forgot Password</button>    
                    </div>
                
            </form>
        </div>
        

    </body>
   
    
</html>
