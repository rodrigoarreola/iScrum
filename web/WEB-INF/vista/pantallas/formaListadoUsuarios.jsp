    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
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
                <th><h5>Nombre Usuario</h5></th>
                <th><h5>Nombre</h5></th>
                <th><h5>ID</h5></th>
            </tr>
	    </thead>

        <tbody>
        <c:forEach var="usuario" items="${formaListadoUsuarios.usuarios}">
            <tr>
                <td align="center" width="20%"><c:out value="${usuario.credencial.nombreUsuario}"/></td>
                <td align="center" width="20%"><c:out value="${usuario.nombre.nombre}"/></td>
                <td align="center" width="20%"><c:out value="${usuario.id}"/></td>
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
            <td colspan="4" align="left" style="padding-top:25px;"><b>Total:</b> ${formaListadoUsuarios.contador}</td>
        </tr>
        <tr>
            <td>
                <a href="solicitarRegistro.do" class="HipervinculoAdmon">Nuevo Usuario</a>
            </td>
        </tr>
    </table>
