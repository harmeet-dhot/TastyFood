

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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

public class Addimages extends HttpServlet
{
String g_id="";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String imagename = System.currentTimeMillis() + "";
        
        String restaurant_name = request.getParameter("rest_name");
        
        String caption = request.getParameter("caption");
        
        Part image = request.getPart("file");
        
        String imagePath = getServletContext().getRealPath("/restaurant_image");
        
        System.out.println("rest_name  " + restaurant_name);
        System.out.println("caption  " + caption);
        
        byte[] buffer = new byte[1024 * 1024];
        InputStream is = image.getInputStream();
        OutputStream os = new FileOutputStream(imagePath + File.separator + imagename + ".jpg");
        int read = 0;
        int r_id = 0;
        while ((read = is.read(buffer, 0, buffer.length)) != -1)
        {
            os.write(buffer, 0, read);
        }
        os.close();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from restaurant where name = '" + restaurant_name + "'");
            if(rs.next())
            {
                r_id = rs.getInt("restaurant_id");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from gallery");
            rs.moveToInsertRow();
            rs.updateInt("restaurant_id", r_id);
            rs.updateString("image_path", "./restaurant_image/" + imagename + ".jpg");
            rs.updateString("caption",caption);
            rs.insertRow();
            response.sendRedirect("add_gallery_images.jsp");
        }
        catch (Exception e)
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



