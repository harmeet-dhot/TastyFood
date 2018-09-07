
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

public class CheckOut extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ArrayList<Cart> alCart = (ArrayList<Cart>) request.getSession().getAttribute("cart_list");

        int grandTotal = 0;
        int orderID = 0;
        String email = (String) request.getSession().getAttribute("email");
        for (int i = 0; i < alCart.size(); i++)
        {
            grandTotal += alCart.get(i).menuItemQuantity * alCart.get(i).mitemofferprice;
        }

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from user_order where email = '" + email + "' order by order_id desc");
            rs.moveToInsertRow();
            rs.updateString("email", email);
            rs.updateString("amount", grandTotal + "");
            rs.updateString("payable", grandTotal + "");
            rs.updateString("status", "pending");
            rs.insertRow();
            if (rs.next())
            {
                orderID = rs.getInt("order_id");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        for (int i = 0; i < alCart.size(); i++)
        {
            String itemName = alCart.get(i).mitemname;
            int itemQuantity = alCart.get(i).menuItemQuantity;
            int itemPrice = alCart.get(i).mitemofferprice;
            int subTotal = itemQuantity * itemPrice;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from order_detail");
                rs.moveToInsertRow();
                rs.updateInt("order_id", orderID);
                rs.updateString("menu_item", itemName);
                rs.updateInt("item_price", itemPrice);
                rs.updateInt("quantity", itemQuantity);
                rs.updateInt("subtotal", itemQuantity * itemPrice);
                rs.insertRow();
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
