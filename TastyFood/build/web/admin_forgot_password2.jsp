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
                background-image: url("food_img/544.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
 
    </head>
    <body>
         <div class="container">
             <h1 class="bg-info" style="text-align: center">Forgot_Password2</h1>
             <br>
             <br>
        <%
            String email = request.getParameter("email");
            String sec_question = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from admin where email='" + email + "'");
                if (rs.next()) 
                {
                    sec_question = rs.getString("sec_question");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        %>


        <form action="admin_forgot_password4.jsp"  onsubmit="alert('hello')" method="post" class="form-horizontal">
            
             <div class="form-group">
                    <label class="col-sm-3">Enter Your Email</label>
                    <div class="col-sm-9">
                        <input type="text"  class="form-control" required placeholder="email" name="email" readonly value="<%=email%>" />
                    </div>
             </div>
                     <div class="form-group">
                    <label class="col-sm-3">Enter Your Security_Question</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" readonly placeholder="sec_question" value="<%=sec_question%>" >
                    </div>
                     </div>
                  <div class="form-group">
                    <label class="col-sm-3">Enter Your Security_Answer</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" required  placeholder="sec_answer" >
                    </div>
                  </div>
                    
                   <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
 
                   <button class="btn btn-primary" type="submit">Proceed</button>
                    </div>
            </div>
                   
        </form>
         </div>
    </body>

</html>
