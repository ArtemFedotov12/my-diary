<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>

    <link rel="stylesheet" href="/templates/css/registrationn.css">

  <#--  <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header login is X-CSRF-TOKEN &ndash;&gt;
    <meta name="_csrf_header" content="${_csrf.headerName}"/>-->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</@h.head>

<body class="body">
<@navFoot.navbarFooter>


    <h1  style="text-align: center">Registration</h1>


    <div class="w3-container">

        <div class="w3-bar" style="margin: auto;width: 350px;">
            <button class="w3-bar-item w3-button tablink w3-red btn-width" onclick="openCity(event,'London')">London</button>
            <button class="w3-bar-item w3-button tablink btn-width" onclick="openCity(event,'Paris')">Paris</button>
            <button class="w3-bar-item w3-button tablink btn-width" onclick="openCity(event,'Tokyo')">Tokyo</button>
        </div>

        <#--    <div id="London" class="w3-container w3-border city">
                <h2>London</h2>
                <p>London is the capital city of England.</p>
            </div>

            <div id="Paris" class="w3-container w3-border city" style="display:none">
                <h2>Paris</h2>
                <p>Paris is the capital of France.</p>
            </div>

            <div id="Tokyo" class="w3-container w3-border city" style="display:none">
                <h2>Tokyo</h2>
                <p>Tokyo is the capital of Japan.</p>
            </div>-->

        <div class="registration">
            <form  id="formRegistration" <#--enctype="multipart/form-data" autocomplete="off"-->>


                <div>
                    <div class="invalid-feedback" id="nameLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control"  name="login" id="name" placeholder="Name" autocomplete="off" value="BWW"/>
                </div>

                <div>
                    <div class="invalid-feedback" id="emailLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="email" class="form-control"  name="email" id="email" placeholder="vasdsdsya@gmail.com" autocomplete="off" value="vasya@gmail.com"/>
                </div>


                <div>
                    <div class="invalid-feedback" id="passwordLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="password" class="form-control"  name="password" id="password" placeholder="Password" value="1"/>
                </div>


                <div>
                    <div class="invalid-feedback" id="passwordConfirmLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Confirm" autocomplete="off" value="1">
                </div>







                <div>
                    <div class="invalid-feedback" id="firstNameLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control" name="firstName" id="firstName" placeholder="FirstName" autocomplete="off" value="Kolya">
                </div>

                <div>
                    <div class="invalid-feedback" id="lastNameLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="LastName" autocomplete="off" value="Derkach">
                </div>

                <div>
                    <div class="invalid-feedback" id="patronymicLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control" name="patronymic" id="patronymic" placeholder="Patronymic" autocomplete="off" value="Volodumirovuch">
                </div>

                <div>
                    <div class="invalid-feedback" id="activationCodeForProductLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control" name="activationCodeForProduct" id="activationCodeForProduct" placeholder="Activation Code" autocomplete="off" >
                </div>




                <div>
                    <div class="invalid-feedback" id="countryLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <div class="input-group mb-3">
                        <select class="form-control" name="country" id="country"  <#--id="inputGroupSelect02" -->style="border-radius: 20px; margin:8px 0px -8px 0px;">
                            <option  value="">Choose...</option>
                            <option selected value="au">Ukraine</option>
                            <option value="ca">Russia</option>
                            <option value="usa">USA</option>
                        </select>
                    </div>
                </div>

                <div>
                    <div class="invalid-feedback" id="townLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control"  name="town" id="town" placeholder="Town" value="b"/>
                </div>



                <div>
                    <div class="invalid-feedback" id="schoolnumberLabel" style="display: none">
                        <#--Error Message-->
                    </div>
                    <input type="text" class="form-control" name="schoolnumber" id="schoolnumber" placeholder="The number of school" value="b"/>
                </div>

                <#-- <div class="custom-file">
                     <input type="file" class="custom-file-input" id="file">
                     <label class="custom-file-label" for="file">Choose file</label>
                 </div>-->
                <input  name="file" type="file">


                <div>
                    <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
                    <#--Error Message-->
                    <div id="reCaptchaLabel" class="alert alert-danger" role="alert" style="display: none; margin: 0px">
                        Please fill reCaptcha
                    </div>
                </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <#--registration.js on click run the function-->
                <div><input id="registerSubmit" type="button" value="Submit"></div>

            </form>

        </div>


    </div>


</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" ></script>
<script src="/templates/css/js/footer.js" ></script>
<script src="/templates/css/js/regisration.js" ></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<script src="/templates/css/js/navbarFooter.js"></script>

<script>
    function openCity(evt, cityName) {
        var i, x, tablinks;
        x = document.getElementsByClassName("city");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablink");
        for (i = 0; i < x.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " w3-red";
    }
</script>
</body>






<#--
<form id="fileUploadForm" &lt;#&ndash;action="/test" method="post" enctype="multipart/form-data"&ndash;&gt;>
    <input type="text" login="login" placeholder="login">
    <input type="password" login="password" placeholder="Password">
    <input id="filename" login="filename" type="file">
    <input type="hidden" login="_csrf" value="${_csrf.token}">
    <input id="sbtm" type="button" value="Submit">
</form>

<script>
    $("#sbtm").click(function(event){
        console.log("ter");
        var form = $('#fileUploadForm')[0];
        var data = new FormData(form);
        console.log(data);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/test",
            data: data,
            //http://api.jquery.com/jQuery.ajax/
            //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

            },
            error: function (e) {


            }
        });
    });

</script>-->
