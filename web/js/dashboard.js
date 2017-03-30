var newList = `
<div class="list list-dimension">
    <form id="formDashboard" action="procesarDashboard.do" method="post">
        <input type="text" class="element" value="New List">
        <ul class="list-inner-scroll">
        </ul>
        <button class="add-card-button btn btn-success">Agregar tarjeta</button>
        <button class="delete-card-button btn btn-danger">Borrar lista</button>
    </form>
</div>
`;

// var newCard = `<input type="text" class="element-item">`
    var newCard = `
    <div class="input-group">
        <input type="text" class="form-control"  aria-label="" placeholder="Escribe...">
        <span class="input-group-addon glyphicon glyphicon-remove"></span>
    </div>`

$('.add-list-button').click(function(e) {
  var $newList = $(newList);
  $('.list-container').find('.list').last().after($newList);
});

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

$( document ).ready(function() {
    var user = getElementById('current-user');
    alert("Document on ready");
    alert(user);
    console.log(user);
});
