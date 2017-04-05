
<% String nombre = (String) request.getSession().getAttribute("user1");%>

<body class="container">

    <div class="row">
        <div class="col s12 m6">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title center-align">Usuario: <%= nombre %></span>
            </div>
          </div>
        </div>
      </div>

    <div class="row">
        <div class="col s6 m6">
            <div class="card blue-grey darken-1">
                 <span class="card-title center-align">Product Backlog</span>
                <form action="IngresarDatos.do" method="post" class="col s12">
                  <div class="row">
                    <div class="input-field col s12">
                      <input name="nombre" id="first_name" type="text" maxlength="50" class="validate" placeholder="Requisito">
                      <label for="nombre">Requisito</label>
                    </div>
                    <div class="input-field col s12">
                      <input name="descripcion"  type="text" class="validate" maxlength="200" placeholder="Descripcion">
                      <label for="descripcion">Descripcion</label>
                    </div>
                  </div>
                  <input type="submit" class="waves-effect waves-light btn"name="Agregar" value="Agregar">
                </form>
            </div>
        </div>
        <div class="col s6 m6">
            <div class="card blue-grey darken-1">
                 <span class="card-title center-align">To Do</span>
                <form action="IngresarDatos.do" method="post" class="col s12">
                  <div class="row">
                    <div class="input-field col s12">
                      <input name="nombre" id="first_name" type="text" maxlength="50" class="validate" placeholder="Requisito">
                      <label for="nombre">Requisito</label>
                    </div>
                    <div class="input-field col s12">
                      <input name="descripcion"  type="text" class="validate" maxlength="200" placeholder="Descripcion">
                      <label for="descripcion">Descripcion</label>
                    </div>
                  </div>
                  <input type="submit" class="waves-effect waves-light btn"name="Agregar" value="Agregar">
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s6 m6">
            <div class="card blue-grey darken-1">
                 <span class="card-title center-align">In progress</span>
                <form action="IngresarDatos.do" method="post" class="col s12">
                  <div class="row">
                    <div class="input-field col s12">
                      <input name="nombre" id="first_name" type="text" maxlength="50" class="validate" placeholder="Requisito">
                      <label for="nombre">Requisito</label>
                    </div>
                    <div class="input-field col s12">
                      <input name="descripcion"  type="text" class="validate" maxlength="200" placeholder="Descripcion">
                      <label for="descripcion">Descripcion</label>
                    </div>
                  </div>
                  <input type="submit" class="waves-effect waves-light btn"name="Agregar" value="Agregar">
                </form>
            </div>
        </div>
        <div class="col s6 m6">
            <div class="card blue-grey darken-1">
                 <span class="card-title center-align">Done</span>
                <form action="IngresarDatos.do" method="post" class="col s12">
                  <div class="row">
                    <div class="input-field col s12">
                      <input name="nombre" id="first_name" type="text" maxlength="50" class="validate" placeholder="Requisito">
                      <label for="nombre">Requisito</label>
                    </div>
                    <div class="input-field col s12">
                      <input name="descripcion"  type="text" class="validate" maxlength="200" placeholder="Descripcion">
                      <label for="descripcion">Descripcion</label>
                    </div>
                  </div>
                  <input type="submit" class="waves-effect waves-light btn"name="Agregar" value="Agregar">
                </form>
            </div>
        </div>
    </div>

    <%-- <h3>Product Backlog</h3>
    <div class="row">
        <div class="col s12">
            <ul class=" tabs">
                <li class="tab col s3 "><a href="#items">Items</a></li>
                <li class="tab col s3"><a  href="#Listado">Listado</a></li>
            </ul>
        </div>

        <div id="items" class="col s12">
            <form action="IngresarDatos.do" method="post">
                <ul class="tabs">
                    <div class="input-field col s6">
                        <input name="nombre" id="first_name" type="text" maxlength="50"class="validate" placeholder="Requisito">
                    </div>
                </ul>

                <div class="input-field col s12">
                    <input name="descripcion"  type="text" class="validate" maxlength="200" placeholder="Descripcion">
                </div>
                <input type="submit" class="waves-effect waves-light btn"name="Agregar" value="Agregar">
                <button class="waves-effect waves-light btn" id="Listar">Listar</button >
            </form>
        </div>

        <div id="Listado" class="col s12">

        </div>

    </div> --%>
</body>

<script>
    $( "#Agregar" ).click(function() {
        $( "#Listado" ).append( "<h1>Hello</h1>" );;
    });
</script>
