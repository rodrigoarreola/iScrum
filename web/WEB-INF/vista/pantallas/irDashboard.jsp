<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Dashboard</title>
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    </head>
    <body>
        <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
        <h1>Dashboard</h1>

        <div class="list-container">
            <div class="list list-dimension">
                <h1 class="list-header" contenteditable>Product Backlog</h1>
                <ul class="list-inner-scroll">
                    <li class="list-item" contenteditable>Hacer modluos</li>
                    <li class="list-item" contenteditable>Implementar login</li>
                </ul>
                <button class="add-card-button">Añadir tarjeta</button>
            </div>
            <button class="add-list-button list-dimension">Crear lista</button>
        </div>

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/dashboard.js"></script>

    </body>
</html>
