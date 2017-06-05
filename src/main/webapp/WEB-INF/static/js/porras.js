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