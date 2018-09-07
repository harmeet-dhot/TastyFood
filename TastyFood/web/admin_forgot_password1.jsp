
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
                      body{
                background-image: url("food_img/Grilled-Vegetable-Salad-on-TheShiksa_com-healthy-summer-recipe.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    </head>
    
    <body>
        <div class="container">
            <h1 class="bg-danger" style="text-align: center">Forgot_Password</h1>
            <br>
            <br>
            <form action="admin_forgot_password2.jsp" role="form" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3"> Email:-</label>
                    <div class="col-sm-9">
                        <input type ="text" name="email" class="form-control" required placeholder="enter your email">
                    </div>
                </div>
                <div class="form-group">
                    <div class=" col-sm-offset-3 col-sm-9">
                        <button class="btn-primary btn-group-justified" type="submit">Go</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
