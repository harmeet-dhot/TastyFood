
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class AddRestaurant extends HttpServlet
{

    String restaurantID = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String addr = request.getParameter("address");
        String num = request.getParameter("phone_no");
        String city = request.getParameter("city");
        String open = request.getParameter("open_time");
        String close = request.getParameter("close_time");
        String avg = request.getParameter("average_price");
        String delivery = request.getParameter("delivery_time");
        Part image = request.getPart("file");
        String imagePath = getServletContext().getRealPath("/restaurant_image");
        byte[] buffer = new byte[1024 * 1024];
        InputStream is = image.getInputStream();
        OutputStream os = new FileOutputStream(imagePath + File.separator + name + ".jpg");
        while (true)
        {
            int read = is.read(buffer, 0, buffer.length);
            if (read == -1)
            {
                os.close();
                break;
            }
            os.write(buffer, 0, read);
        }

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from restaurant where name = '" + name + "'");
            rs.moveToInsertRow();
            rs.updateString("name", name);
            rs.updateString("desc", desc);
            rs.updateString("image", "./restaurant_image/" + name + ".jpg");
            rs.updateString("address", addr);
            rs.updateString("phone_no", num);
            rs.updateString("city", city);
            rs.updateString("opening_time", open);
            rs.updateString("closing_time", close);
            rs.updateString("average_price", avg);
            rs.updateString("delivery_time", delivery);
            rs.insertRow();
            if (rs.next())
            {
                restaurantID = rs.getString("id");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        String[] cuisineName = request.getParameterValues("cuisine");
        for (int i = 0; i < cuisineName.length; i++)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from restaurant_menu");
                rs.moveToInsertRow();
                rs.updateString("cuisine_name", cuisineName[i]);
                rs.updateInt("r_id", Integer.parseInt(restaurantID));
                rs.insertRow();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        response.sendRedirect("addmenu.jsp?id=" + restaurantID);
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
