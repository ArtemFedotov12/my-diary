$(document).ready(function(){
    //$("#registerSubmit").on('click', function(){
    $("#registerSubmit").click(function(event){

  /*      var formData = {
            name : $("#name").val(),
            email : $("#email").val(),
            country : $( "#country option:selected" ).val(),
            town : $("#town").val(),
            schoolnumber : $("#schoolnumber").val(),
            password : $("#password").val(),
            passwordConfirm : $("#passwordConfirm").val(),
            filename:$("#filename").val()
        };*/

        //console.log("Form Data:");
        //console.log(formData);
        //var token = $("meta[name='_csrf']").attr("content");
        var form = $('#formRegistration')[0];
        var data = new FormData(form);
        console.log(data);
        $.ajax({
           /* url: "/registration",
            method: "POST",
            //enctype: 'multipart/form-data',
            data:JSON.stringify(formData),
            headers: {"X-CSRF-TOKEN": token},
            contentType : 'multipart/form-data',//'application/json',//;charset=utf-8
            dataType: "json",
            cache: false,
            processData: false,*/

            type: "POST",
            enctype: 'multipart/form-data',
            url: "/registrationPost",
            data: data,
            //http://api.jquery.com/jQuery.ajax/
            //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (result) {
                //console.log(result["status"]);
                if(result["status"]=="success"){
                    console.log(result);
                    console.log("tyttttttttttttt");
                    $( ".form-control" ).each(function() {
                        $(this).removeClass("is-invalid").addClass("is-valid");
                    });
                    $( ".invalid-feedback" ).each(function() {
                        $(this).css("display", "none");
                    });
                }

            },
            //Bad_Request 400 HTTP
            error: function(e) {
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
                    $("#password").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#passwordLabel").css("display", "block").text(data["passwordError"]);
                }else {
                    $("#password").removeClass("is-invalid").addClass("is-valid");
                    $("#passwordLabel").css("display", "none");
                }

                if(data["passwordConfirmError"]!=null){
                    $("#passwordConfirm").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#passwordConfirmLabel").css("display", "block").text(data["passwordConfirmError"]);
                }else {
                    $("#passwordConfirm").removeClass("is-invalid").addClass("is-valid");
                    $("#passwordConfirmLabel").css("display", "none");
                }

                //Only if fields as: password and ConfirmPassword aren't empty, the we add manually error "passwordConfirmEqualError"
                if(data["passwordError"]==null && data["passwordConfirmError"]==null ){
                    if(data["passwordConfirmEqualError"]!=null){
                        $("#passwordConfirm").removeClass("is-valid").addClass("form-control is-invalid");
                        $("#passwordConfirmLabel").css("display", "block").text(data["passwordConfirmEqualError"]);
                    }else {
                        $("#passwordConfirm").removeClass("is-invalid").addClass("is-valid");
                        $("#passwordConfirmLabel").css("display", "none");
                    }
                }

                if(data["countryError"]!=null){
                    $("#country").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#countryLabel").css("display", "block").text(data["countryError"]);
                }else {
                    $("#country").removeClass("is-invalid").addClass("is-valid");
                    $("#countryLabel").css("display", "none");
                }

                if(data["townError"]!=null){
                    $("#town").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#townLabel").css("display", "block").text(data["townError"]);
                }else {
                    $("#town").removeClass("is-invalid").addClass("is-valid");
                    $("#townLabel").css("display", "none");
                }

                if(data["captchaError"]!=null){
                   // $("#reCaptcha").removeClass("is-valid").addClass("form-control is-invalid");
                    $("#reCaptchaLabel").css("display", "block");
                }else {
                   // $("#reCaptcha").removeClass("is-invalid").addClass("is-valid");
                    $("#reCaptchaLabel").css("display", "none");
                }



            }
        });

    });
});
