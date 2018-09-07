/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class usersignup1 extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = "", email = "", password = "", phone_number = "";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from user");
            name = request.getParameter("name");
            password = request.getParameter("password");
            phone_number = request.getParameter("phone_number");
            email = request.getParameter("email");

            rs.moveToInsertRow();
            rs.updateString("name", name);
            rs.updateString("email", email);
            rs.updateString("password", password);
            rs.updateString("phone_number", phone_number);
            rs.insertRow();
            rs.close();
            stmt.close();
            con.close();
            response.sendRedirect("search_city_restaurant.jsp");
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
