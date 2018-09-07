<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Podkova:400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>
        <link href="css/style.css" rel="stylesheet">
        <script>
            function go()
            {
                var selectedCity = document.getElementById("city").value;
                window.location.href = "get_restaurants.jsp?city=" + selectedCity;
            }
        </script>
    </head>
    <body>
        <jsp:include page="header2.jsp"/>
        
        <jsp:include page="slider.jsp"/>
        <section class="main__middle__container homepage">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-3">
                        <select style="width: 100%" class="form-control" id="city" name="city">
                            <option  >Abohar</option>
                            <option  >Amritsar</option>
                            <option  >Batala</option>
                            <option  >Bombay</option>
                            <option  >Chandigarh</option>
                            <option  >Delhi</option>
                            <option  >Jalandhar</option>
                            
                            <option  >Jandiala</option>
                            <option  >Kapurthala</option>
                            <option  >Kartarpur</option>
                            <option  >Ludhiana</option>
                            <option  >Majhitha</option>
                            <option  >Moga</option>
                            <option  >Nawa Shehar</option>
                            <option  >Patiala</option>
                            <option  >Tarn Taran</option>
                            <option  >Zira</option>
                        </select> 
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-success" onclick="go()" type="button" style="text-transform: capitalize">Find Restaurants</button>
                    </div>
                </div>
                <div id="result">
                </div>            
            </div>
        </section>

        <jsp:include page="footer1.jsp"/>
        <jsp:include page="slider2.jsp"/>
    </body>
</html>
