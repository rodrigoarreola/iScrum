    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    
    <h5>Nuevo Rol</h5>


    <form id="forma" action="procesarRegistroRol.do" method="post"> 
        <!-- el action va MCURegistrar rol -->
        <table>
            <tr>
                <td colspan="2">
                   <html:errors />
                </td>
            </tr>
            <tr>
                <td align="right">
                    Nombre
                </td>
                <!-- el name es el valor que se pasa al MCURegistrarRol
                todo tiene que estar en forms -->
                <td align="left">
                    <input type="text" 
                           id="nombre"
                           name="nombre"
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevoRol.nombre}" />
                </td>
            </tr>
            <br>
            <tr>
                <td align="right">
                    Rol
                </td>
                <td align="left">
                    <input type="text"
                           name="descripcion" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevoRol.descripcion}" />
                </td>
            </tr>
            <br>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" 
                           name="submit"
                           value="Agregar"
                           onclick="forma.action='procesarRegistroRol.do?volver=si'"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarRegistroRol.do'" />
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="cancelar" 
                           onclick="bCancel=true;">   
                           

                </td>
            </tr>
        </table>
    </form>
    
