import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class order extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int payable_amnt = 0;
        int orderid = 0;
        String couponName;
        if(request.getSession().getAttribute("discount_coupon") == null)
        {
            couponName = "No Coupon Applied";
        }
        else
        {
            couponName = request.getSession().getAttribute("discount_coupon").toString();
        }
        int discount;
        if(request.getSession().getAttribute("discount_value") == null)
        {
            discount = 0;
        }
        else
        {
            discount = Integer.parseInt(request.getSession().getAttribute("discount_value").toString());
        }
        
        ArrayList<cart.Cart> alCart = (ArrayList<cart.Cart>) request.getSession().getAttribute("cart_list");
        String email = (String) request.getSession().getAttribute("email");

        for (int i = 0; i < alCart.size(); i++)
        {
            payable_amnt += alCart.get(i).mitemofferprice * alCart.get(i).menuItemQuantity;
        }
        
        request.getSession().setAttribute("payable", (payable_amnt - discount));
        request.getSession().setAttribute("coupon", couponName);
        request.getSession().setAttribute("discount", discount);
        request.getSession().setAttribute("amount", payable_amnt);
        request.getSession().setAttribute("email", email);
        request.getSession().setAttribute("rest_id", request.getSession().getAttribute("rest_id").toString());
        
        response.sendRedirect("review_details.jsp");
        
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = stmt.executeQuery("select * from user_order where email='" + email + "'order by order_id desc");
//            rs.moveToInsertRow();
//            rs.updateString("rest_id", request.getSession().getAttribute("rest_id").toString());
//            rs.updateString("payable", (payable_amnt - discount) + "");
//            rs.updateString("coupen", couponName + "");
//            rs.updateString("discount", discount + "");
//            rs.updateString("amount", payable_amnt + "");
//            rs.updateString("email", email);
//            rs.insertRow();
//            if (rs.next())
//            {
//                orderid = rs.getInt("order_id");
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//            new mail.SimpleMailDemo(email, "Tasty Khana", "Your Order Has Been Placed. Happy Food ordering...");
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
//        
//        for (int i = 0; i < alCart.size(); i++)
//        {
//
//            String itemname = alCart.get(i).mitemname;
//            int itemprice = alCart.get(i).mitemofferprice;
//            int itemquantity = alCart.get(i).menuItemQuantity;
//            int subtotal = itemprice * itemquantity;
//            
//            try
//            {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
//                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                ResultSet rs = stmt.executeQuery("select * from order_detail");
//                rs.moveToInsertRow();
//                rs.updateInt("order_id", orderid);
//                rs.updateString("menu_item", itemname);
//                rs.updateString("item_price", itemprice + "");
//                rs.updateString("quantity", itemquantity + "");
//                rs.updateString("subtotal", subtotal + "");
//                rs.insertRow();
//                rs.close();
//                stmt.close();
//                conn.close();
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//        request.getSession().removeAttribute("cart_list");
//        response.sendRedirect("thanks.jsp");
    }
}