

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
        $("#"+idUser).css("display", "none");
    },
    error: function (e) {
        console.log(e);
    }
});

}

    function putActivationCode(idUser){
        $.ajax({
            type : "PUT",
            url : "/generateCode/" + idUser,
            headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            success: function (result) {
                console.log("sscccFirst");
                console.log(result);
                console.log("sscccSecond");


            },
            error: function (e) {
                console.log("bad all bad");
            }
        });

    }