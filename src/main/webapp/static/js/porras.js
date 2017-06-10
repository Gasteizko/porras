function logout (){
    $.ajax({
        url: '/logout',
        type: 'post',
        data: {
            _csrf: $("input[name*='_csrf']").val()
        },
        success: function (data) {
            location.reload(true)
        }
    });

}

$(".clickedit").click(function(){
    var type= $(this).attr("xtype");

    function resetButtonColors(){
        $('.btn-porra-type').removeClass('btn-success');
        $('.btn-porra-type').addClass('btn-primary');
    }

    $(".admin").hide();
    switch(type){
        case "abierta":
            resetButtonColors();
            $("#panelAbierta").show();
            $('#tipoPorra').attr('value', "OPEN");
            $('#btn-porra-type-open').addClass('btn-success');
            break;
        case "partido":
            resetButtonColors();
            $("#panelPartido").show();
            $('#tipoPorra').attr('value', "MATCH");
            $('#btn-porra-type-match').addClass('btn-success');
            break;
        case "posibles":
            resetButtonColors();
            $("#panelPosibles").show();
            $('#tipoPorra').attr('value', "POSSIBLES");
            $('#btn-porra-type-possibles').addClass('btn-success');
            break;

    }
    $("#panelTodos").show();
});

function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function(){
    readURL(this);
});

function loadListaPorras(element) {
  var id = $(element).attr('id');
  if (id === 'btn-listaporras-latest')
    window.location = '/listaporras?latest=true';
  else if (id === 'btn-listaporras-mine')
    window.location = '/listaporras?mine=true';
  else if (id === 'btn-listaporras-winned')
    window.location = '/listaporras?winned=true';
  else if (id === 'btn-listaporras-losses')
    window.location = '/listaporras?losses=true';
  else
    window.location = '/listaporras'
}

function loadPorra(id) {
  window.location = '/porra/' + id
}
