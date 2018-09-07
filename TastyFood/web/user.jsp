

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>user</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script>
            function checkPassword()
            {
                var password = document.getElementById("password").value;
                var repeatpassword = document.getElementById("repeat_password").value;
                alert(password + " ---- " + repeatpassword);
                if (password == repeatpassword)
                {
                    return true;
                } else
                {
                    alert("password do not match");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <h1 class="bg-info" style="text-align: center">User signup...</h1>
            <br>
            <br>
            <%
                String email = request.getParameter("email");
            %>
            <form action="usersignup1" onsubmit="return checkPassword()" method="post" class="form-horizontal" >
                <div class="form-group">
                    <label class="col-sm-3">Enter your name</label>
                    <div class="col-sm-9">
                        <input type="text" required name="name" placeholder="name" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Enter Your Email</label>
                    <div class="col-sm-9">
                        <input type="text" required name="email" placeholder="email" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Enter Your password</label>
                    <div class="col-sm-9">
                        <input type="password" required name="password" id="password" placeholder="password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Repeat password</label>
                    <div class="col-sm-9">
                        <input type="password" required id="repeat_password" placeholder="repeat password" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3">Phone number</label>
                    <div class="col-sm-9">
                        <input type="text" required name="phone_number" placeholder="phone number" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn-primary btn-lg" type="submit">signup..</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
