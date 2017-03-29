<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<% String nombre = (String) request.getSession().getAttribute("user1");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        <h3>Usuario: </h3>
        <h3 id="current-user"> <%= nombre %></h3>
        <div class="input-group">
            <span class="input-group-addon">Usuario</span>
            <input type="text" class="form-control"  aria-label="<%= nombre %>">
        </div>

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

<<<<<<< HEAD
        <%--


        <form id="forma" action="procesarRegistroRol.do" method="post">
            el action va MCURegistrar rol
            el name es el valor que se pasa al MCURegistrarRol                todo tiene que estar en forms
            <input type="text" id="nombre" name="nombre" size="50" maxlength="100"
                    value="${formaNuevoRol.nombre}" />

            <input type="text" name="descripcion" size="50" maxlength="100"
                    value="${formaNuevoRol.descripcion}" />

            <input type="submit" name="submit" value="Agregar y terminar"/>

            <input type="submit" name="submit" value="Agregar y volver"
                onclick="forma.action='procesarRegistroRol.do?volver=si'"/>

        </form>

        <form id="formDashboard" action="procesarDashboard.do" method="post">

        </form>
        --%>
=======
>>>>>>> 143fcab03998107787080a41b8895e2a0e02247e
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/dashboard.js"></script>

    </body>
</html>
