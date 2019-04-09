
function userRegistration(event) {
    var form = $('#formRegistrationDirector')[0];
    var data = new FormData(form);
    console.log(data);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/registration",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 60000000,
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
                $("#reCaptchaLabel").css("display", "none");
                location.href = "http://localhost:8080/login";
                $.ajax({
                    type: "POST",
                    enctype: 'multipart/form-data',
                    url: "/registration/email",
                    data: data,
                    //http://api.jquery.com/jQuery.ajax/
                    //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
                    processData: false, //prevent jQuery from automatically transforming the data into a query string
                    contentType: false,
                    cache: false,
                    timeout: 60000000,
                    success: function (result) {
                        console.log("suc22222");
                    },
                    errorr: function () {
                        console.log("error22222");
                    }
                });


            }
            //if(result === "no_errors")
        },
        //Bad_Request 400 HTTP
        error: function(e) {
            var data=e.responseJSON.data;
            console.log(data);
            console.log("FirstError");
            if(data["loginError"]!=null){
                $("#login").removeClass("is-valid").addClass("form-control is-invalid");
                $("#loginLabel").css("display", "block").text(data["loginError"]);
            }else if (data["loginUniqueError"]==null) {
                $("#login").removeClass("is-invalid").addClass("is-valid");
                $("#loginLabel").css("display", "none");
            }

            if(data["loginUniqueError"]!=null){
                $("#login").removeClass("is-valid").addClass("form-control is-invalid");
                $("#loginLabel").css("display", "block").text(data["loginUniqueError"]);
            }else if(data["loginError"]==null){
                $("#login").removeClass("is-invalid").addClass("is-valid");
                $("#loginLabel").css("display", "none");
            }

            if(data["emailError"]!=null){
                $("#email").removeClass("is-valid").addClass("form-control is-invalid");
                $("#emailLabel").css("display", "block").text(data["emailError"]);
            }else if(data["emailUniqueError"]==null){
                $("#email").removeClass("is-invalid").addClass("is-valid");
                $("#emailLabel").css("display", "none");
            }
            if(data["emailUniqueError"]!=null){
                $("#email").removeClass("is-valid").addClass("form-control is-invalid");
                $("#emailLabel").css("display", "block").text(data["emailUniqueError"]);
            }else if(data["emailError"]==null) {
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

            if(data["firstNameError"]!=null){
                $("#firstName").removeClass("is-valid").addClass("form-control is-invalid");
                $("#firstNameLabel").css("display", "block").text(data["firstNameError"]);
            }else {
                $("#firstName").removeClass("is-invalid").addClass("is-valid");
                $("#firstNameLabel").css("display", "none");
            }


            if(data["lastNameError"]!=null){
                $("#lastName").removeClass("is-valid").addClass("form-control is-invalid");
                $("#lastNameLabel").css("display", "block").text(data["lastNameError"]);
            }else {
                $("#lastName").removeClass("is-invalid").addClass("is-valid");
                $("#lastNameLabel").css("display", "none");
            }

            if(data["patronymicError"]!=null){
                $("#patronymic").removeClass("is-valid").addClass("form-control is-invalid");
                $("#patronymicLabel").css("display", "block").text(data["patronymicError"]);
            }else {
                $("#patronymic").removeClass("is-invalid").addClass("is-valid");
                $("#patronymicLabel").css("display", "none");
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

            if(data["schoolnumberError"]!=null){
                $("#schoolnumber").removeClass("is-valid").addClass("form-control is-invalid");
                $("#schoolnumberLabel").css("display", "block").text(data["schoolnumberError"]);
            }else {
                $("#schoolnumber").removeClass("is-invalid").addClass("is-valid");
                $("#schoolnumberLabel").css("display", "none");
            }


            if(data["captchaError"]!=null){
                // $("#reCaptcha").removeClass("is-valid").addClass("form-control is-invalid");
                $("#reCaptchaLabel").css("display", "block");
            }else {
                // $("#reCaptcha").removeClass("is-invalid").addClass("is-valid");
                $("#reCaptchaLabel").css("display", "none");
            }

            if(data["activationCodeForProductError"]!=null){
                $("#activationCodeForProduct").removeClass("is-valid").addClass("form-control is-invalid");
                $("#activationCodeForProductLabel").css("display", "block").text(data["activationCodeForProductError"]);
            }else {
                $("#activationCodeForProduct").removeClass("is-invalid").addClass("is-valid");
                $("#activationCodeForProductLabel").css("display", "none");
            }

        }
    });

}
