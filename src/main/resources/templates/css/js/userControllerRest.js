

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
                var data=result.data;
                console.log("sscccFirst");
                console.log(result);

                var content = "<table class=\"w3-table-all w3-hoverable\">";
                $.each(data, function(key, value){
                    content += '<tr> <td>' +key +'</td>';
                    content += '<td>' +value +'</td> </tr>';
                });
                content += "</table>";

                $('#here_table').append(content);


            },
            error: function (e) {
                console.log("bad all bad");
            }
        });

    }