
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

/**
 *
 * @author Prabhjot kaur
 */
public class removetocart extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        int m_item_id = Integer.parseInt(request.getParameter("m_item_id"));
        ArrayList<cart.Cart> alCart;

        if (request.getSession().getAttribute("cart_list") == null)
        {
            alCart = new ArrayList<>();
        } else
        {
            alCart = (ArrayList<cart.Cart>) request.getSession().getAttribute("cart_list");
        }

        for (int i = 0; i < alCart.size(); i++)
        {
            if (alCart.get(i).m_item_id == m_item_id)
            {
                if (alCart.get(i).menuItemQuantity == 1)
                {
                    alCart.remove(i);
                } else
                {
                    alCart.get(i).menuItemQuantity--;
                }
                break;
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
