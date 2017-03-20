<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="StyleUser.css" rel="stylesheet">
        <script src="ScriptUsers.js"></script>
    </head>
    <body>
        <h1>Scrum Team</h1>

        <table id="tabla" class="container">
    <thead>
        <tr>
            <th><h1>User</h1></th>
            <th><h1>Rol</h1></th>
        </tr>
    </thead>
    <tbody>
    </tbody>
    </table>
    <br>
    
        Correo:<br>
             <input id= "email" type="email">
        <br>
        Rol:<br>
        <input type="radio" name="rol" value="ScrumMaster">ScrumMaster<br>
        <input type="radio" name="rol" value="ScrumTeam">ScrumTeam<br>
        <br>
        <input type="submit" class="button button2" onclick="addUser()" value="Agregar">
  
        
    </body>

    <script type="text/javascript">
    function addUser() {
    var table = document.getElementById("tabla");
    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var email=document.getElementById("email").value;
    var porNombre=document.getElementsByName("rol");
    var resultado="ninguno";
    for(var i=0;i<porNombre.length;i++)
        {
            if(porNombre[i].checked)
                resultado=porNombre[i].value;
        }



    cell1.innerHTML = email;
    cell2.innerHTML = resultado;
    
}
</script>

</html>
