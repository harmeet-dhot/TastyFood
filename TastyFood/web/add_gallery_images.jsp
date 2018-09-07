
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ad gallery images</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <style>
                      body{
                background-image: url("food_img/th22ALGGPL.jpg");
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
    
        <script>
            function go()
            {
                var cityName = document.getElementById("city").value;
                var xml = new XMLHttpRequest();
                var query = "get_restaurants_in_a_city.jsp?city=" + cityName;
                xml.onreadystatechange = function ()
                {
                    if (xml.readyState == 4 && xml.status == 200)
                    {
                        document.getElementById("div_rest").innerHTML = xml.responseText;
                    }
                };
                xml.open("GET", query, true);
                xml.send();
            }

            function getImages()
            {
                var name = document.getElementById("div_rest").value;
                var xml = new XMLHttpRequest();
                var query = "get_images_of_rest.jsp?name=" + name;
                xml.onreadystatechange = function ()
                {
                    if (xml.readyState == 4 && xml.status == 200)
                    {
                        document.getElementById("div_image").innerHTML = xml.responseText;
                    }
                };
                xml.open("GET", query, true);
                xml.send();
            }
        </script>

    </head>
    <body>
        <h1  class="bg-warning" style="text-align: center">Add Galley Images</h1>
        <div class="container">
            <form action="Addimages" class="form-horizontal" enctype="multipart/form-data" method="post">
                <div class="form-group">
                    <div class="col-sm-8">
                        <select class="form-control" id="city" name="city">
                            <option  >Select A City</option>
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
                    <div class="col-sm-4">
                        <button style="width: 100%" class="btn btn-primary" type="button" onclick="go()">Find Restaurant</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8">
                        <select class="form-control" id="div_rest" name="rest_name">
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <button style="width: 100%" type="button" onclick="getImages()" class="btn btn-default">Get Images</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-4">
                        <input type="text" name="caption" required class="form-control"/>
                    </div>
                    <div class="col-sm-4">
                        <input type="file" class="form-control" name="file" required/>
                    </div>
                    <div class="col-sm-4">
                        <button style="width: 100%" class="btn btn-default" type="submit">Upload Image</button>
                    </div>
                </div>
            </form>
        </div>
        <div id="div_image">
        </div>
    </body>
</html>
