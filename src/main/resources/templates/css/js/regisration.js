
function userRegistration(formRegistrationId,role) {
    var form = $('#'+formRegistrationId)[0];
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
                $("#login"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#loginLabel"+role).css("display", "block").text(data["loginError"]);
            }else if (data["loginUniqueError"]==null) {
                $("#login"+role).removeClass("is-invalid").addClass("is-valid");
                $("#loginLabel"+role).css("display", "none");
            }

            if(data["loginUniqueError"]!=null){
                $("#login"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#loginLabel"+role).css("display", "block").text(data["loginUniqueError"]);
            }else if(data["loginError"]==null){
                $("#login"+role).removeClass("is-invalid").addClass("is-valid");
                $("#loginLabel"+role).css("display", "none");
            }

            if(data["emailError"]!=null){
                $("#email"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#emailLabel"+role).css("display", "block").text(data["emailError"]);
            }else if(data["emailUniqueError"]==null){
                $("#email"+role).removeClass("is-invalid").addClass("is-valid");
                $("#emailLabel"+role).css("display", "none");
            }
            if(data["emailUniqueError"]!=null){
                $("#email"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#emailLabel"+role).css("display", "block").text(data["emailUniqueError"]);
            }else if(data["emailError"]==null) {
                $("#email"+role).removeClass("is-invalid").addClass("is-valid");
                $("#emailLabel"+role).css("display", "none");
            }


            if(data["passwordError"]!=null){
                $("#password"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#passwordLabel"+role).css("display", "block").text(data["passwordError"]);
            }else {
                $("#password"+role).removeClass("is-invalid").addClass("is-valid");
                $("#passwordLabel"+role).css("display", "none");
            }

            if(data["passwordConfirmError"]!=null){
                $("#passwordConfirm"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#passwordConfirmLabel"+role).css("display", "block").text(data["passwordConfirmError"]);
            }else {
                $("#passwordConfirm"+role).removeClass("is-invalid").addClass("is-valid");
                $("#passwordConfirmLabel"+role).css("display", "none");
            }

            //Only if fields as: password and ConfirmPassword aren't empty, the we add manually error "passwordConfirmEqualError"
            if(data["passwordError"]==null && data["passwordConfirmError"]==null ){
                if(data["passwordConfirmEqualError"]!=null){
                    $("#passwordConfirm"+role).removeClass("is-valid").addClass("form-control is-invalid");
                    $("#passwordConfirmLabel"+role).css("display", "block").text(data["passwordConfirmEqualError"]);
                }else {
                    $("#passwordConfirm"+role).removeClass("is-invalid").addClass("is-valid");
                    $("#passwordConfirmLabel"+role).css("display", "none");
                }
            }

            if(data["firstNameError"]!=null){
                $("#firstName"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#firstNameLabel"+role).css("display", "block").text(data["firstNameError"]);
            }else {
                $("#firstName"+role).removeClass("is-invalid").addClass("is-valid");
                $("#firstNameLabel"+role).css("display", "none");
            }


            if(data["lastNameError"]!=null){
                $("#lastName"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#lastNameLabel"+role).css("display", "block").text(data["lastNameError"]);
            }else {
                $("#lastName"+role).removeClass("is-invalid").addClass("is-valid");
                $("#lastNameLabel"+role).css("display", "none");
            }

            if(data["patronymicError"]!=null){
                $("#patronymic"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#patronymicLabel"+role).css("display", "block").text(data["patronymicError"]);
            }else {
                $("#patronymic"+role).removeClass("is-invalid").addClass("is-valid");
                $("#patronymicLabel"+role).css("display", "none");
            }


            if(data["countryError"]!=null){
                $("#country"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#countryLabel"+role).css("display", "block").text(data["countryError"]);
            }else {
                $("#country"+role).removeClass("is-invalid").addClass("is-valid");
                $("#countryLabel"+role).css("display", "none");
            }

            if(data["townError"]!=null){
                $("#town"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#townLabel"+role).css("display", "block").text(data["townError"]);
            }else {
                $("#town"+role).removeClass("is-invalid").addClass("is-valid");
                $("#townLabel"+role).css("display", "none");
            }

            if(data["schoolnumberError"]!=null){
                $("#schoolnumber"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#schoolnumberLabel"+role).css("display", "block").text(data["schoolnumberError"]);
            }else {
                $("#schoolnumber"+role).removeClass("is-invalid").addClass("is-valid");
                $("#schoolnumberLabel"+role).css("display", "none");
            }


            if(data["captchaError"]!=null){
                // $("#reCaptcha").removeClass("is-valid").addClass("form-control is-invalid");
                $("#reCaptchaLabel"+role).css("display", "block");
            }else {
                // $("#reCaptcha").removeClass("is-invalid").addClass("is-valid");
                $("#reCaptchaLabel"+role).css("display", "none");
            }

            if(data["activationCodeForProductError"]!=null){
                $("#activationCodeForProduct"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#activationCodeForProductLabel"+role).css("display", "block").text(data["activationCodeForProductError"]);
            }else {
                $("#activationCodeForProduct"+role).removeClass("is-invalid").addClass("is-valid");
                $("#activationCodeForProductLabel"+role).css("display", "none");
            }

            if(data["accessKeyForTeacherError"]!=null){
                $("#accessKeyForTeacher"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#accessKeyForTeacherLabel"+role).css("display", "block").text(data["accessKeyForTeacherError"]);
            }else {
                $("#accessKeyForTeacher"+role).removeClass("is-invalid").addClass("is-valid");
                $("#accessKeyForTeacherLabel"+role).css("display", "none");
            }

            if(data["accessKeyForSchoolKidError"]!=null){
                $("#accessKeyForSchoolKid"+role).removeClass("is-valid").addClass("form-control is-invalid");
                $("#accessKeyForSchoolKidLabel"+role).css("display", "block").text(data["accessKeyForSchoolKidError"]);
            }else {
                $("#accessKeyForSchoolKid"+role).removeClass("is-invalid").addClass("is-valid");
                $("#accessKeyForSchoolKidLabel"+role).css("display", "none");
            }

        }
    });

}
