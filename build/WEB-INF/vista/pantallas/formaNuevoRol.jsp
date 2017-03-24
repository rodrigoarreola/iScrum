    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>

    <h5>Nuevo Rol</h5>

    <p>Registrate con Facebook</p>
                <div id="fb-root"></div>
                    <script>(function(d, s, id) {
                    var js, fjs = d.getElementsByTagName(s)[0];
                    if (d.getElementById(id)) return;
                    js = d.createElement(s); js.id = id;
                    js.src = "//connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v2.8&appId=382680545445284";
                    fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));
    </script>

     <button type="" class="btnReg button" onclick="logFB()">Registrarse</button>

     <div class="fb-login-button" data-max-rows="2" data-size="small" data-show-faces="true" data-auto-logout-link="true"></div>

         <script>
        function showReg() {
            document.getElementById("login").style.display = "block";
            logFB();
        }

        function logFB() {
            window.fbAsyncInit = function() {
                    FB.init({
                        appId      : '382680545445284',
                        cookie     : true,  // enable cookies to allow the server to access
                                            // the session
                        xfbml      : true,  // parse social plugins on this page
                        version    : 'v2.8' // use graph api version 2.8
                        });

                    };

                    (function(d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0];
                        if (d.getElementById(id)) return;
                        js = d.createElement(s); js.id = id;
                        js.src = "//connect.facebook.net/en_US/sdk.js";
                        fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));

                    testAPI();
        }


        function testAPI() {
                    console.log('Welcome!  Fetching your information.... ');
                    FB.api('/me', function(response) {
                    console.log('Successful login for: ' + response.name);
                    document.getElementById("nombre").value=response.name;
                });
        }

        function newAccount() {
            console.log('');
        }
    </script>

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
                           value="Agregar y terminar"/>
                    <input type="submit"
                           name="submit"
                           value="Agregar y volver"
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
