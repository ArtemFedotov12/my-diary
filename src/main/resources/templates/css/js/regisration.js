function submitForm(form) {
    var token = $("meta[name='_csrf']").attr("content");
    $.ajaxSetup({
        beforeSend: function(xhr) {
            xhr.setRequestHeader('Csrf-Token', token);
        }
    });
// HERE
    var formData = $(form).serializeArray();
    console.log("ppc");
    console.log(JSON.stringify(formData)+"!!");
    var token = $("meta[name='_csrf']").attr("content");
   // var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        url: "/test",
        method: "POST",
        data:formData,  //$("#registerSubmit").serialize(),JSON.stringify(formData),
        headers: {"X-CSRF-TOKEN": token},
        contentType : 'application/json',
        dataType: "json",
        success: function (result) {
            console.log(result);
        }
    });



   // var formData = $(form).serializeArray();
   // console.log(formData);
    //formData[_csrf_param_name] = _csrf_token; // Adds the token
   /* var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    var request = $.ajax({
        url: "/registration2",
        method: "POST",
     //   data:formData, //JSON.stringify(formData),
       /!* headers: {
            "_csrf":token,
            "_csrf_header":header
        },*!/
        headers: {"X-CSRF-TOKEN": token},
        contentType : 'application/json',
       // dataType: "json"
    });*/


/*    request.done(function( result ) {
        console.log("kryto");
       // console.log(result.data["test"]);

    });

    request.fail(function( jqXHR, textStatus ) {
        console.log("ploxo");
    });*/
}