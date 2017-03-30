    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <link rel="stylesheet" type="text/css" href="css/materialize.css">
    <script href="js/materialize.js"></script>

    <style>
  .HipervinculoAdmon{
    color:#000000;
	text-decoration:none;
  }

  .HipervinculoAdmon:hover{
    color:#006666;
	text-decoration:underline;
  }
</style>
<script language="javascript" type="text/javascript">

  function EliminarRol(strRolName){
    return confirm("Se elmininara el usuario '" + strRolName + "' ")
  }

</script>



    <br>


    <table cellpadding="0" cellspacing="0" width="40%" border="0" class="highlight" id="myTable">
        <thead>
            <tr>
                <th><h5>Nombre</h5></th>
                <th><h5>Rol</h5></th>
                <th><h5>Id</h5></th>
                <th><h5>Eliminar</h5></th>
            </tr>
	    </thead>

        <tbody>
        <c:forEach var="rol" items="${formaListadoRoles.roles}">
            <tr>
                <td align="center" width="20%"><c:out value="${rol.nombre}"/></td>
                <td align="center" width="20%"><c:out value="${rol.descripcion}"/></td>
                <td align="center" width="20%"><c:out value="${rol.id}"/></td>
                <td align="center" width="20%">
                    <a href='procesarEliminarRol.do?id=<c:out value="${rol.id}"/>'
					   onClick="javascript: return EliminarRol('<c:out value="${rol.nombre}"/>')"
					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoRoles.etiqueta.eliminar" />
                    </a>
                </td>
            </tr>
        </c:forEach>
	    </tbody>
    </table>
            <script>
          $(document).ready(function()
            {
                $("#myTable").tablesorter();
            }
        );
        </script>

    <table cellpadding="0" cellspacing="0" width="60%" border="0" class="highlight">
        <tr>
            <td colspan="4" align="left" style="padding-top:25px;"><b>Total:</b> ${formaListadoRoles.contador}</td>
        </tr>

        <tr>
            <td colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroRol.do" class="HipervinculoAdmon">Nuevo Rol</a>
            </td>
        </tr>
        <tr>
            <td>
                <a href="solicitarRegistro.do" class="HipervinculoAdmon">Nuevo Usuario</a>
            </td>
        </tr>
    </table>
