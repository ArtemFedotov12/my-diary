$(document).ready(function(){
    //$("#registerSubmit").on('click', function(){
    $("#registerSubmit").click(function(){
console.log("click was")
    var formData = {
        name : $("#name").val(),
        email : $("#email").val(),
        country : $("#country").val(),
        town : $("#town").val(),
        schoolnumber : $("#schoolnumber").val(),
        passwordConfirm : $("#passwordConfirm").val()
    }

    console.log("ppc");
    console.log(JSON.stringify(formData)+"!!");
    var token = $("meta[name='_csrf']").attr("content");
   // var header = $("meta[name='_csrf_header']").attr("content");
    $.ajax({
        url: "/registration",
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

});
});
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
/* $.ajaxSetup({
     beforeSend: function(xhr) {
         xhr.setRequestHeader('Csrf-Token', token);
     }
 });*/
//var formData = $(form).serializeArray();