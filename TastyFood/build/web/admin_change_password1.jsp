
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
                <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script>
            function checkPassword()
            {
                var newPassword = document.getElementById("newpw").value;
                var oldPassword = document.getElementById("confpw").value;
                if(newPassword == oldPassword)
                {
                    return true;
                }
                else
                {
                    alert("Passwords Do Not Match");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
        <%
            String email = (String) session.getAttribute("admin_email");
            if (email == null) {
                response.sendRedirect("admin_login2.jsp?msg=login first");
            } else {
        %>
        <h1 class="bg-info" style="text-align: center">Admin_Change_Password</h1>
        
        <br>
        <br>
        <form action="admin_change_password2.jsp" onsubmit="return checkPassword()" method="post"  class="form-horizontal">
        <div class="form-group">
         <label class="col-sm-3"> Email</label>
          <div class="col-sm-9">
            <input type="text"  class="form-control" value="<%=email%>" readonly name="email" />
                 </div>
            </div>
        <div class="form-group">
              <label class="col-sm-3">Old Password</label>
                        <div class="col-sm-9">
                     <input type="password" id="oldpw" name="oldpassword" required placeholder="old password" class="form-control" >
                
                 </div>
                 </div>
           <div class="form-group">
                <label class="col-sm-3">New Password</label>
               
                     <div class="col-sm-9">
                     <input type="password" id="newpw" name="newpassword" required placeholder="new password" class="form-control">
                     </div>
                     </div>
                     <div class="form-group">
                           <label class="col-sm-3">Confirm Password</label>
                           <div class="col-sm-9">
                        <input type="password" id="confpw" name="confpassword" required placeholder="confirm password" class="form-control">
                      </div>
                     </div>
                    
                 
               <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn btn-primary btn-lg" type="submit">Change Password</button>
                
       
               
                 </div>
                 </div>
                
               
        </form>
        </div>
        <%
            }
        %>
    </body>
</html>
