<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="container">
    <center><h1>Review Order</h1></center>
    <form method="post" name="customerData" action="http://thepinkmotif.com/ccavRequestHandler.php">
        <table class="table table-bordered table-hover table-responsive table-striped">
            <tr>
                <td>Bill ID</td>
                <td>
                    <input type="text" readonly name="tid" value="<%= System.currentTimeMillis()%>"/>
                    <input type="hidden" readonly name="order_id" value="<%= System.currentTimeMillis()%>"/>
                    <input type="hidden" readonly name="merchant_id" value="65798"/>
                    <input type="hidden" readonly name="currency" value="INR"/>
                    <input type="hidden" readonly name="language" value="EN"/>
                    <input type="hidden" readonly name="redirect_url" value="http://localhost:8084/Tasty_Khana/PlaceOrder"/>
                    <input type="hidden" readonly name="cancel_url" value="http://localhost:8084/Tasty_Khana/search_city_restaurant.jsp"/>
                    <input type="hidden" readonly name="amount" value="<%= request.getSession().getAttribute("payable") %>"/>
                </td>
            </tr>
            <tr>
                <td>Total Amount</td>
                <td><input type="text" readonly value="<%= request.getSession().getAttribute("amount") %>"/></td>
            </tr>
            <tr>
                <td>Payable Amount</td>
                <td><input type="text" readonly value="<%= request.getSession().getAttribute("payable") %>"/></td>
            </tr>
            <tr>
                <td>Coupon Applied</td>
                <td><input type="text" readonly value="<%= request.getSession().getAttribute("coupon") %>"/></td>
            </tr>
            <tr>
                <td>Discount Value</td>
                <td><input type="text" readonly value="<%= request.getSession().getAttribute("discount") %>"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" class="btn btn-success" value="Pay Bill Online"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
