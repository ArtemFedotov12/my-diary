<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>

    <link rel="stylesheet" href="/templates/css/registrationn.css">
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</@h.head>

<body class="body">
<@navFoot.navbarFooter>


    <h1>Registration</h1>
    <div id="feedback">aaa</div>

<#--<div class="registration" name="registrationform" id="registrationId"></div>-->
    <div class="registration" name="registrationform" id="registrationId">
        <form  <#--enctype="multipart/form-data" action="/test" method="post" enctype="multipart/form-data"--> autocomplete="off" onautocomplete="false">


            <div>
                <div class="invalid-feedback" id="nameLabel" style="display: none">
                    <#--Error Message-->
                </div>
                <input type="text" class="form-control"  name="name" id="name" placeholder="Name" autocomplete="off" value="BWW"/>
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
                <input type="password" class="form-control"  name="password" id="password" placeholder="Password"/>
            </div>


            <div>
                <div class="invalid-feedback" id="passwordConfirmLabel" style="display: none">
                    <#--Error Message-->
                </div>
                <input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm" placeholder="Confirm" autocomplete="off" value="1">
            </div>


            <div class="input-group mb-3">
                <select class="form-control"  id="inputGroupSelect02" style="border-radius: 20px; margin:8px 0px -8px 0px;">
                    <option selected>Choose...</option>
                    <option value="au">Ukraine</option>
                    <option value="ca">Russia</option>
                    <option value="usa">USA</option>
                </select>
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
            <input id="file" type="file" value="File">

            <#-- <div>
                 <#if captchaError??> ${captchaError}</#if>
                 <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
             </div>-->

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <#--registration.js on click run the function-->
            <div><input id="registerSubmit" type="button" value="Submit"></div>

        </form>
    </div>
</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" ></script>
<script src="/templates/css/js/footer.js" ></script>
<script src="/templates/css/js/regisration.js" ></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
</body>
