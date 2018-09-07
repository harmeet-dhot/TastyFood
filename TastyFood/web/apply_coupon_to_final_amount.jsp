<%@page import="java.sql.*"%>
<%
    String couponName = request.getParameter("cn");
    int totalBill = Integer.parseInt(request.getParameter("tb"));
    Date expDate = new Date(System.currentTimeMillis());
    try
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tasty_khana", "root", "system");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from coupon where name = '" + couponName + "'");
        if (rs.next())
        {
            int minPrice = rs.getInt("min_price");
            int value = rs.getInt("value");
            if (rs.getDate("exp_date").getTime() < expDate.getTime())
            {
%>
Coupon Expired. Try Again With Other Coupon.
<%
} else if (minPrice > totalBill)
{
%>
Cannot Apply Coupon. Order Must be More Than Rs. <%= minPrice%>.
<%
} else
{
    totalBill = totalBill - value;
    session.setAttribute("discount_value", value);
    session.setAttribute("discount_coupon", couponName);
%>
New Payable Amount : Rs. <%= totalBill%>
<%
            }
        }
    } catch (Exception e)
    {
        e.printStackTrace();
    }
%>