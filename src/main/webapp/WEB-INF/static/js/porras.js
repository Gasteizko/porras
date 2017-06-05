function logout (csrf){
    $.ajax({
        url: '/logout',
        type: 'post',
        data: {
            _csrf: csrf
        },
        success: function (data) {
            location.reload(true)
        }
    });

}