
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCoupon extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String couponName = request.getParameter("c_name");
        String couponType = request.getParameter("c_type");
        String couponMinPrice = request.getParameter("c_min_price");
        String couponValue = request.getParameter("c_value");
        String couponExpDate = request.getParameter("c_exp_date");
        String couponRestID = request.getParameter("c_rest_id");
        
        StringTokenizer stDate = new StringTokenizer(couponExpDate, "/");
        int month = Integer.parseInt(stDate.nextToken());
        int day = Integer.parseInt(stDate.nextToken());
        int year = Integer.parseInt(stDate.nextToken());
        Date sqlDate = new Date(year - 1900, month - 1, day);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from coupon");
            rs.moveToInsertRow();
            rs.updateString("name", couponName);
            rs.updateString("type", couponType);
            rs.updateString("min_price", couponMinPrice);
            rs.updateString("rest_id", couponRestID);
            rs.updateString("value", couponValue);
            rs.updateDate("exp_date", sqlDate);
            rs.insertRow();
            response.sendRedirect("add_coupon.jsp");
        } catch (Exception e)
        {
            e.printStackTrace();
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
