<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css\loginScrum.css" rel="stylesheet">
        
    </head>
    <body>
        <div class="login">
        <div class="login-triangle"></div>
        <h2 class="login-header">Login</h2>
            <form class="login-container" id="forma" action="procesarLogin.dd"  method="post"> 
                <p><input type="text" placeholder="User" id="user" value="${formaLogin.user}" name="user"></p>
                <p><input type="password" id="password" placeholder="Password" value="${formaLogin.password}" name="password"></p>
                <button type="submit" class="btnIn button" value="Login">Ingresar</button>         
                <br> <br>
            </form>
        </div>
    </body>
</html>