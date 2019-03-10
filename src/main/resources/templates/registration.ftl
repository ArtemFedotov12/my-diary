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

    <#--<div class="registration" name="registrationform" id="registrationId"></div>-->
    <div class="registration" name="registrationform" id="registrationId">
        <form id="#registerSubmit" <#--enctype="multipart/form-data" action="/test" method="post" enctype="multipart/form-data"-->>


            <div class="invalid-feedback"><#if nameError??>${nameError} </#if></div>
    <input type="text" class="${(nameError??)?string('is-invalid','')} form-control is-valid" name="name" id="name" placeholder="Name" autocomplete="off" value="BWW"/>


    <div class="invalid-feedback"><#if emailError??>${emailError} </#if></div>
    <input type="email" class="${(emailError??)?string('is-invalid','')} form-control is-valid" name="email" id="email" placeholder="vasdsdsya@gmail.com" autocomplete="off" value="vasya@gmail.com"/>

    <div><#if passwordError??>${passwordError} </#if></div>
    <input type="password" class="${(passwordError??)?string('is-invalid','')}" name="password" id="password" placeholder="Password" autocomplete="off" value="1">

    <div><#if password2Error??>${password2Error} </#if></div>
    <input type="password" class="${(password2Error??)?string('is-invalid','')}" name="passwordConfirm" id="passwordConfirm" placeholder="Confirm" autocomplete="off" value="1">


    <select  name="country" id="country" style="margin: 8px 0px">
        <option value="au">Ukraine</option>
        <option value="ca">Russia</option>
        <option value="usa">USA</option>
    </select>

    <div><#if townError??>${townError} </#if></div>
    <input type="text" class="${(townError??)?string('is-invalid','')}" name="town" id="town" placeholder="Town" value="b"/>

    <div><#if schoolnumberError??>${schoolnumberError} </#if></div>
    <input type="text" class="${(townError??)?string('is-invalid','')}" name="schoolnumber" id="schoolnumber" placeholder="Schoolnumber" value="b"/>

    <#--<input type="file" name="file">-->

    <input type="reset" >

  <#--  <div>
        <#if captchaError??> ${captchaError}</#if>
        <div class="g-recaptcha" data-sitekey="6Lc7jIcUAAAAAJDybby4pHe_06m8kACP-jdY5CGG"></div>
    </div>-->

    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="button" value="Submit" onclick="submitForm(this.form)"></div>

    </form>
    </div>
</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" ></script>
<script src="/templates/css/js/footer.js" ></script>
<script src="/templates/css/js/regisration.js" ></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
</body>
