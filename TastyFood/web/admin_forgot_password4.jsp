<%
    String email = request.getParameter("email");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
         <style>
                      body{
                background-image: url("food_img/88.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    
    </head>
    <body>
        <h1 class="bg-danger" style="text-align: center" >New_Password_Form</h1>
        <br>
        <br>
         <div class="container">
             <form action="update_password.jsp" method="post" onsubmit="alert('hello')" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3">Enter Your Password </label>
                    <div class="col-sm-9">
            
                        <input type="text"  name="newpassword" class="form-control" required placeholder="new password"/> 
                    </div>
                </div>
                 
                  <div class="form-group">
                    
                    <div class="col-sm-9">
                        <input type="hidden" value="<%=email%>" name="email"/> 
                    </div>
                  </div>
                    <div class="form-group">
                    <label class="col-sm-3">Confirm Your Password </label>
                    <div class="col-sm-9">
                        <input type="text" name="confirmpassword" class="form-control" required placeholder="confirm password">

                    </div>
                    </div>
                     <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                    <button class="btn btn-primary" type="submit">Update</button>
                    </div>
                     </div>
                   
                                        
                      
             </form>
         </div>
   
    </body>
</html>
