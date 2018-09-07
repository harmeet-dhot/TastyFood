
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user signin</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1  class="bg-danger" style="text-align: center">user signin</h1>
            <br>
            <br>
            <form action="user_signin2.jsp" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3">Enter Your Email</label>
                    <div class="col-sm-9">
                        <input type="text" required name="email" placeholder="Enter Your E-Mail" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Enter Your Password</label>
                    <div class="col-sm-9">
                        <input type="password" required name="password" placeholder="Enter Your Password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn btn-primary btn-lg" type="submit">Signin</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
