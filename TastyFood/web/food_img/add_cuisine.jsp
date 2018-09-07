<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1 class="bg-danger" style="text-align: center">Add Cuisines</h1>
            <br>
            <br>
            <form action="AddCuisine"  onsubmit="alert('hello')" method="post" class="form-horizontal" enctype="multipart/form-data">
                <div class="form-group">
                    <label class="col-sm-3">Enter Cuisine Name</label>
                    <div class="col-sm-9">

                        <input type="text" name="name" class="form-control" required placeholder="cuisine name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Description</label>
                    <div class="col-sm-9">


                        <textarea name="desc" class="form-control" required placeholder="desc"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Choose File </label>
                    <div class="col-sm-9">

                        <input type="file" class="form-control" name="file" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button class="btn btn-primary" type="submit">Upload</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
