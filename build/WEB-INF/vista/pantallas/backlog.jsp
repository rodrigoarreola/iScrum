<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <body class="container">

     <h3>Product Backlog</h3>
       <div class="row">
                   <div class="col s12">
                     <ul class=" tabs">
                       <li class="tab col s3 "><a href="#items">Items</a></li>
                       <li class="tab col s3"><a  href="#Listado">Listado</a></li>
                     </ul>
                   </div>
             <div id="items" class="col s12">
                 <br>
                 <form action="IngresarDatos.do" method="post">
                   <ul class="tabs">
                       <div class="input-field col s6">
                             <input name="nombre" id="first_name" type="text" maxlength="50"class="validate" placeholder="Requisito">
                       </div>
                     </ul>
               <br>
               <div class="input-field col s12">
                 <input name="descripcion"  type="text" class="validate" maxlength="200" placeholder="Descripcion">

               </div>
             <input type="submit" class="waves-effect waves-light btn"name="Agregar" value="Agregar">
             <button class="waves-effect waves-light btn" id="Listar">Listar</button >

             </form>
         </div>


 <div id="Listado" class="col s12">


 </div>


   </div>



    </body>
    <script>
    $( "#Agregar" ).click(function() {
  $( "#Listado" ).append( "<h1>Hello</h1>" );;
 });
  </script>
