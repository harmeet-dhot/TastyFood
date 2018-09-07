
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
public class addmenuitem extends HttpServlet
{

    String m_ID = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String item_name = request.getParameter("item_name");
        String veg_or_nonveg = request.getParameter("vegornon");
        String display_price = request.getParameter("display_price");
        String offer_price = request.getParameter("offer_price");
        String restaurant_name = request.getParameter("restaurant");
        String menu_name = request.getParameter("menu_name");

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from menu_item");
            rs.moveToInsertRow();
            rs.updateString("item_name", item_name);
            rs.updateString("veg_or_nonveg",veg_or_nonveg);
            rs.updateString("display_price",display_price);
            rs.updateString("offer_price",offer_price);
            rs.updateString("restaurant_name",restaurant_name );
            rs.updateString("menu_name", menu_name);
            rs.insertRow();

            if (rs.next())
            {
                m_ID = rs.getString("m_id");
            }
        } catch (Exception e)
            {
            e.printStackTrace();
        }
    }
        
}