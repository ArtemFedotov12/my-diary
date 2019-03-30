
    GET: $(document).ready(
        function() {

            // GET REQUEST
            $("#BtnLoginRequest").click(function (event) {
                event.preventDefault();
                ajaxGet();
            });


            function ajaxGet() {
                var username = $("#username").val();
                var sendParams = "/lo?username=" + username;
                $.ajax({
                    type: "GET",
                    url: sendParams,
                    contentType : "application/json",
                    success: function (result) {
                        console.log("result:"+result);
                        if (result.status == "success") {
                            console.log("Data:"+ result.data);
                            console.log(result.data["email"]+" er");
                            if(result.data["isUserExist"]=="false")
                            {
                                $("#username").addClass("form-control is-invalid");
                                $("#userLabel").css("display", "block").text("User doesn't exist");
                            }

                            else if((result.data["email"]=="inactive" && result.data["isUserExist"]=="true")){
                                $("#username").addClass("form-control is-invalid");
                                $("#userLabel").css("display", "block").text("Confirm email please");
                            }
                            else {
                                $("#submitBtn").click();
                                //var data = 'username=' + $('#username').val() + '&password=' + $('#password').val()+'&_csrf='+ $('#token').val();
                          /*      var request = $.ajax({
                                    url: "/login",
                                    method: "POST",
                                    data: $("#loginFormName").serialize(),
                                    dataType: 'json',
                                    contentType: 'json'
                                });
                                request.done(function( msg ) {
                                    console.log("id");
                                });

                                request.fail(function( jqXHR, textStatus ) {
                                    console.log("idi naxyu");
                                });*/
                            }


                        }}});
            }
        });





