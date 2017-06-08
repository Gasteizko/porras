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

    $(".admin").hide();
    switch(type){
        case "abierta":
            $("#panelAbierta").show();
            $('#tipoPorra').attr('value', "OPEN");
            break;
        case "partido":
            $("#panelPartido").show();
            $('#tipoPorra').attr('value', "MATCH");
            break;
        case "posibles":
            $("#panelPosibles").show();
            $('#tipoPorra').attr('value', "POSSIBLES");
            break;

    }
});