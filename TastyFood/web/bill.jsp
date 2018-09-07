<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int totalBill = 0;
            ArrayList<cart.Cart> alCart;
            alCart = (ArrayList<cart.Cart>) session.getAttribute("cart_list");
            for (int i = 0; i < alCart.size(); i++)
            {
                totalBill += alCart.get(i).mitemofferprice;
            }
            System.out.println(totalBill);
        %>
        <form name="customerData" method="POST" action="http://thepinkmotif.com/ccavRequestHandler.php">
            <input type="hidden" name="tid" value="<%=System.currentTimeMillis()%>"/>
            <input type="hidden" name="order_id" value="<%=System.currentTimeMillis()%>"/>
            <input type="hidden" name="merchant_id" value="65798"/>
            <input type="hidden" name="currency" value="INR"/>
            <input type="hidden" name="amount" value="<%= totalBill %>"/>
            <input type="hidden" name="redirect_url" value="http://www.google.com"/>
            <input type="hidden" name="cancel_url" value="http://localhost:8084/Tasty_Khana/get_restaurants.jsp?city=Amritsar"/>
            <input type="hidden" name="language" value="EN"/>
            <label>Total amount is Rs. <%= totalBill %></label>
            <button type="submit">Pay Bill</button>
        </form>
    </body>
</html>
