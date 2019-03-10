function submitForm(form) {
    var token = $("meta[name='_csrf']").attr("content");
   /* $.ajaxSetup({
        beforeSend: function(xhr) {
            xhr.setRequestHeader('Csrf-Token', token);
        }
    });*/
// HERE
    //var formData = $(form).serializeArray();
    var formData = {
        name : $("#name").val(),
        email : $("#email").val(),
        country : $("#country").val(),
        town : $("#town").val(),
        schoolnumber : $("#schoolnumber").val(),
        passwordConfirm : $("#passwordConfirm").val()
    }
 /*   var psw={
        psw : $("#psw").val()
    }*/
    console.log("ppc");
    console.log(JSON.stringify(formData)+"!!");
    var token = $("meta[name='_csrf']").attr("content");
   // var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        url: "/test",
        method: "POST",
        data:JSON.stringify(formData),  //$("#registerSubmit").serialize(),JSON.stringify(formData),
        headers: {"X-CSRF-TOKEN": token},
        contentType : 'application/json',//;charset=utf-8
        dataType: "json",
        success: function (result) {
            console.log(result);
        },
        error: function(xhr, resp, text) {
            console.log(xhr, resp, text);
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

/*
$(document).ready(function(){
    // click on button submit
    $("#registerSubmit").on('click', function(){
        // send ajax
        $.ajax({
            url: '/test', // url where to submit the request
            type : "POST", // type of action POST || GET
            dataType : 'json', // data type
            data : $("#form").serialize(), // post data || get data
            success : function(result) {
                // you can see the result from the console
                // tab of the developer tools
                console.log("ok");
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        })
    });
});*/
