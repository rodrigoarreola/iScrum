function getItem(){

   var item = document.getElementById('myTextField').value;
   if( myNewTitle.length==0 ){
       alert('El campo no puede estar vacio.');
   return;
   }

   var title = document.getElementById('title');
   title.innerHTML = myNewTitle;

}

var idNumber = 0;

$('.add-list-button').click(function(e) {
    alert("Entra a add-list-button");
    var idNumber = 2;
    var $newList = $(newList);
    $('.list-container').find('.list').last().after($newList);
});

var newList = `
<div class="list list-dimension">
    <%-- <form id="formDashboard" action="procesarDashboard.do" method="post"> --%>
        <input type="text" name="nameList" class="element" value="Product Backlog">
        <ul class="list-inner-scroll">
            <div class="input-group">
                <input type="text" class="form-control"  aria-label="" name="itemList" placeholder="Hola">
                <%-- <span class="input-group-addon glyphicon glyphicon-remove"></span> --%>
            </div>
        </ul>
        <hr>
        <input id="" name="item" type="text" maxlength="50" class="validate form-control" placeholder="Escribe...">
        <button name="btn-send-item" class="add-card-button btn btn-success" onclick="getItem()">Agregar tarjeta</button>
    <%-- </form> --%>
</div>
`;

// var newCard = `<input type="text" class="element-item">`

    var newCard = `
    <div class="input-group">
        <input type="text" class="form-control" value="`+item+`">
        <span class="input-group-addon glyphicon glyphicon-remove"></span>
    </div>`;

function getItem(){
    console.log("entra a getItem");
    var item = document.getElementsByName('item');
    alert(item);
}





$('.list-container').on('click', '.add-card-button', function(e) {
  var $target = $(e.target);
  var $list = $target.parent('.list');
  addCardToList($list);
});

$('.list-container').on('click', '.delete-card-button', function(e) {
  this.fadeOut( "slow", function() {
    // Animation complete.
  });
});

$('.list-container').on('click', '.glyphicon-remove', function(e) {
    $(".input-group").fadeOut( "slow", function() {
        //do nothing
    });
});


function addCardToList($list) {
  var $newCard = $(newCard);
  $list.find('.list-inner-scroll').append($newCard);
  $newCard.focus();
}

// $( document ).ready(function() {
//     var user = getElementById('current-user');
//     alert("Document on ready");
//     alert(user);
//     console.log(user);
// });
