<header class="main__header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation"> 
            <!-- Brand and toggle get grouped for better mobile display --> 
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="navbar-header">
                <h1 class="navbar-brand"><a href="index.html">Order From Tasty khana in your City</a></h1>
                <a href="#" class="submenu">Menus</a> </div>
            <div class="menuBar">
                <ul class="menu">
                    <li class="active"><a href="search_city_restaurant.jsp">Home</a></li>
                    <!-- <li class="dropdown"><a href="#">Pages</a>
                         <ul>
                             <li><a href="index_fixed.html">Home / Fixed</a></li>
                             <li><a href="index_with_blog.html">Home + Blog</a></li>
                             <li><a href="portfolio.html">Portfolio</a></li>
                             <li><a href="typography.html">Typography</a></li>
                             <li><a href="shortcodes.html">Shortcodes</a></li>
                             <li><a href="store.html">Web Store</a></li>
                             <li><a href="blog.html">Blog & News</a></li>
                             <li><a href="tables.html">Tables</a></li>
                             <li><a href="faq.html">FAQ</a></li>
                         </ul>
                       </li>
                    -->
                    <!--
                       <li><a href="left_sidebar.html">left sidebar</a></li>
                       <li><a href="right_sidebar.html">right sidebar</a></li>
                       <li><a href="full_width.html">full page</a></li>
                       <li><a href="contact.html">contact us</a></li>
                   </ul>
                    -->
                    <li><a href="aboutus.jsp">About us</a></li>
                        <%
                            if (session.getAttribute("email") == null)
                            {
                        %>
                    <li><a href="user_signin.jsp">User Login</a></li>
                        <%
                        } else
                        {
                        %>
                    <li><a href="user_logout.jsp">User Logout</a></li>
                        <%
                            }
                        %>
            </div>
            <!-- /.navbar-collapse --> 
        </nav>
    </div>
</header>