<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<% String nombre = (String) request.getSession().getAttribute("user1");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
    </head>

    <body>
        <h5 >Welcome <%= nombre %> </h5>
        <form class="login-container" id="forma" action="procesarLogin.dd"  method="post">
            <button type="submit" class="btnIn button" value="Login">Cerrar sesion</button>
        </form>
    </body>
</html>
