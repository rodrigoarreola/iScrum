<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <h3>Product Backlog</h3>
      <div class="row">
                  <div class="grey darken-4">
                    <ul class="tabs">
                      <li class="tab col s3"><a href="#items">Items</a></li>
                      <li class="tab col s3"><a  href="#Listado">Listado</a></li>
                    </ul>
                  </div>
            <div id="items" class="col s12">
                <br>
                <form action="" >

                  <ul class="tabs">
                      <div class="input-field col s6">
                            <input name="Fist" id="first_name" type="text" class="validate">
                            <label for="first_name">Requisito</label>
                      </div>
                      <div class="row">


                      </div>
                    </ul>
                </form>
              <br>
              <div class="input-field col s12">
                      <textarea id="textarea1" class="materialize-textarea"></textarea>
                      <label for="textarea1">Descripcion</label>
              </div>
            <a class="waves-effect waves-light btn" id="Agregar">Agregar</a>
        </div>


    <div id="Listado" class="col s12">


    </div>


    </div>
