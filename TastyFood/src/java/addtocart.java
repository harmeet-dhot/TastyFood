
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addtocart extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException
    {
        PrintWriter out = response.getWriter();
        
        
        int m_item_id = Integer.parseInt(request.getParameter("m_item_id"));
        ArrayList<cart.Cart> alCart;

        if (request.getSession().getAttribute("cart_list") == null)
        {
            alCart = new ArrayList<cart.Cart>();
        } else
        {
            alCart = (ArrayList<cart.Cart>) request.getSession().getAttribute("cart_list");
        }

        int flag = 0;
        for (int i = 0; i < alCart.size(); i++)
        {
            if (alCart.get(i).m_item_id == m_item_id)
            {
                flag = 1;
                alCart.get(i).menuItemQuantity++;
                break;
            }
        }
        if (flag == 0)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from menu_item where m_item_id='" + m_item_id + "'");
                if (rs.next())
                {
                    String mitemname = rs.getString("item_name");
                    int mitemdisplayprice = Integer.parseInt(rs.getString("display_price"));
                    int mitemofferprice = Integer.parseInt(rs.getString("offer_price"));
                    alCart.add(new cart.Cart(m_item_id, mitemname, mitemdisplayprice, mitemofferprice, 1));
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        int totalPrice = 0;
        out.println("<div style=\"height: 320px; overflow: auto; padding-top: 10px\">");
        for (int i = 0; i < alCart.size(); i++)
        {
            totalPrice += alCart.get(i).menuItemQuantity * alCart.get(i).mitemofferprice;
            out.println("<div class=\"row\">");
            out.println("<label style=\"margin-left: 30px\">" + alCart.get(i).mitemname + "</label><br>");
            out.println("<label style=\"margin-left: 30px\">Quantity - " + alCart.get(i).menuItemQuantity + " items</label><br>");
            out.println("<label style=\"margin-left: 30px\"><strike>MRP - Rs. " + alCart.get(i).mitemdisplayprice + "/-</strike></label><br>");
            out.println("<label style=\"margin-left: 30px\">Offer Price - Rs. " + alCart.get(i).mitemofferprice + "/-</label>");
            out.println("<button class=\"btn btn-primary\" onclick=\"removeitem(this.id)\" style=\"margin-left: 30px; width: 230px\" id=\"" +alCart.get(i).m_item_id + "\">Remove Item</button>");
            out.println("<hr>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("<div class=\"row\">");
        out.println("<label style=\"margin-left: 30px\">Total Price: Rs. " + totalPrice + "/-</label><br>");
        out.println("<button class=\"btn btn-primary\" onclick=\"checkout()\" style=\"margin-left: 30px; margin-bottom: 20px; width: 240px\">Check Out</button>");
        out.println("</div>");
        request.getSession().setAttribute("cart_list", alCart);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        try
        {
            processRequest(req, resp);
        } catch (SQLException ex)
        {
            Logger.getLogger(addtocart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(addtocart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        try
        {
            processRequest(req, resp);
        } catch (SQLException ex)
        {
            Logger.getLogger(addtocart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(addtocart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
