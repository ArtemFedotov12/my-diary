$(document).ready(function(){
    //$("#registerSubmit").on('click', function(){
    $("#registerSubmit").click(function(event){
        //stop submit the form, we will post it manually.
        event.preventDefault();
        // Get form
        var form = $('#fileUploadForm')[0];

        // Create an FormData object
        var data = new FormData(form);
        console.log("000000");
        var formData = {
            name : $("#name").val(),
            email : $("#email").val(),
            country : $("#country").val(),
            town : $("#town").val(),
            schoolnumber : $("#schoolnumber").val(),
            password : $("#password").val(),
            passwordConfirm : $("#passwordConfirm").val(),
            filename:$("#filename").val()
        };
        console.log("FormData:");
        console.log(formData);

        var token = $("meta[name='_csrf']").attr("content");

        $.ajax({
            url: "/registration",
            method: "POST",
            enctype: 'multipart/form-data',
            data:JSON.stringify(formData),
            headers: {"X-CSRF-TOKEN": token},
            contentType : 'application/json',//;charset=utf-8
            dataType: "json",
            cache: false,
            processData: false,
            success: function (result) {
                console.log("1111111111111");
            },
            //Bad_Request 400 HTTP
            error: function(e) {
                console.log("2222222222");
                var data=e.responseJSON.data;
                if(data["nameError"]!=null){
                    $("#name").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#nameLabel").css("display", "block").text(data["nameError"]);
                }else {
                    $("#name").removeClass("is-invalid").addClass("is-valid");
                    $("#nameLabel").css("display", "none");
                }

                if(data["emailError"]!=null){
                    $("#email").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#emailLabel").css("display", "block").text(data["emailError"]);
                }else {
                    $("#email").removeClass("is-invalid").addClass("is-valid");
                    $("#emailLabel").css("display", "none");
                }

                if(data["passwordError"]!=null){
                    console.log("nnnnnnnnnnn");
                    $("#password").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#passwordLabel").css("display", "block").text(data["passwordError"]);
                }else {
                    console.log("kkkkkkkkk");
                    $("#password").removeClass("is-invalid").addClass("is-valid");
                    $("#passwordLabel").css("display", "none");
                }




            }
        });

    });
});
