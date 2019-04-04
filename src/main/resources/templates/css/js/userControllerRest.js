

    //$("#registerSubmit").on('click', function(){
    function deleteUser(idUser){
$.ajax({
    type : "DELETE",
    url : "/delete/" + idUser,
    headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
    processData: false, //prevent jQuery from automatically transforming the data into a query string
    contentType: false,
    cache: false,
    success: function (result) {
        console.log(result);
    },
    error: function (e) {
        console.log(e);
    }
});

}
