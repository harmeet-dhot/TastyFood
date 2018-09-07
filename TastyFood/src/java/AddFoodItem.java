
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
public class AddFoodItem extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("foodname");
        String desc = request.getParameter("desc");
        String category = request.getParameter("category");
        String folderPath = getServletContext().getRealPath("/food_img");

        Part img = request.getPart("file");
        InputStream is = img.getInputStream();
        OutputStream os = new FileOutputStream(folderPath + File.separator + name + ".jpg");
        byte[] buffer = new byte[1024 * 1024];
        int read = 0;

        while ((read = is.read(buffer, 0, buffer.length)) != -1)
        {
            os.write(buffer, 0, read);
        }

        os.close();

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from food_items");
            rs.moveToInsertRow();
            rs.updateString("food_name", name);
            rs.updateString("desc", desc);
            rs.updateString("food_image", "./food_img/" + name + ".jpg");
            rs.updateString("cuisine_name", category);
            rs.insertRow();
            response.sendRedirect("add_food_to_category.jsp?msg=" + name + " Added");
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
