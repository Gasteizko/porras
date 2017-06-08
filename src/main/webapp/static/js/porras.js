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
        case "wifi":
            $("#panelHackeador").show();
            break;
        case "desaut":
            $("#panelDesautentificador").show();
            break;
        case "hacked":
            $("#panelHacked").show();
            break;

    }
});