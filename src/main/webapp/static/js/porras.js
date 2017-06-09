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
});