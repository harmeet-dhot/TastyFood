<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function applyCoupon()
            {
                var couponName = document.getElementById("coupon_name").value;
                var totalBill = document.getElementById("totalBill").value;
                if (couponName.trim().length == 0)
                {
                    alert("Coupon Name Cannot Be Empty");
                    return;
                } else if (couponName.trim().length < 6)
                {
                    alert("Invalid Coupon Name");
                    return;
                }
                var xml = new XMLHttpRequest();
                xml.onreadystatechange = function ()
                {
                    if (xml.readyState == 4 && xml.status == 200)
                    {
                        document.getElementById("new_amount").innerHTML = xml.responseText;
                    }
                };
                xml.open("GET", "apply_coupon_to_final_amount.jsp?cn=" + couponName + "&tb=" + totalBill, true);
                xml.send();
            }
        </script>
    </head>
    <body>
        <h1>Bill</h1>
        <%
            ArrayList<cart.Cart> alCart = (ArrayList<cart.Cart>) session.getAttribute("cart_list");
            int totalBill = 0;
            for (int i = 0; i < alCart.size(); i++)
            {
                totalBill += alCart.get(i).menuItemQuantity * alCart.get(i).mitemofferprice;
            }
        %>
        <input type="hidden" name="totalBill" id="totalBill" value="<%= totalBill %>">
        <label>Current Payable Amount : Rs. <%= totalBill%></label><br>
        <label id="new_amount">New Payable Amount : Rs. <%= totalBill%></label><br>
        <label>Add Coupon : </label><input type="text" name="coupon_name" id="coupon_name"/>
        <input type="button" onclick="applyCoupon()" value="Apply Coupon"/>
        <input type="button" onclick="window.location.href = 'order'" value="Pay Bill"/>
    </body>
</html>