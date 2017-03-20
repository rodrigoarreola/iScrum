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
    alert('Usuario agregado');
}