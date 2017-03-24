
<html>
    <head>
        <meta charset="utf-8">
        <title>Dashboard</title>
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
        <link rel="stylesheet" type="text/css" href="css/flexboxgrid.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>

        <h1>Dashboard</h1>

        <div class="list-container">
            <div class="list list-dimension">
                <input type="text" class="element" value="Product Backlog">
                <ul class="list-inner-scroll">
                    <div class="input-group">
                        <input type="text" class="form-control"  aria-label="" placeholder="Hola">
                        <span class="input-group-addon glyphicon glyphicon-remove"></span>
                    </div>

                </ul>
                <button class="add-card-button btn btn-success">Agregar tarjeta</button>
                <button class="delete-card-button btn btn-danger">Borrar lista</button>
            </div>
            <button class="add-list-button list-dimension btn btn-success">Crear lista</button>
            <%-- <button type="button" class="btn btn-success">Crear lista</button> --%>
        </div>
        <div class="row center-xs">
            <button type="button" class="btn btn-primary btn-lg">Guardar cambios</button>
        </div>

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/dashboard.js"></script>

    </body>
</html>
