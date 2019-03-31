<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>
    <link rel="stylesheet" href="/templates/css/login.css">

</@h.head>

<body class="body">
<@navFoot.navbarFooter>
    <#--<h1><#if errorMessge??>${errorMessge}</#if></h1>-->
    <#if Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger" role="alert">
            <#--${Session.SPRING_SECURITY_LAST_EXCEPTION.message}-->
            Bad credentials or Email hasn't been confirmed
        </div>
    </#if>
    <#if message??>
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </#if>

    <h1 id="loginInfo" style="display: none"></h1>
    <div class="login">
        <form id="loginFormName" action="/login" method="post" >
            <#--  <p> <input type="text" name="text" placeholder="Name" maxlength="10" autocomplete="off"></p>
               <p><input type="password" name="password" placeholder="Password" autofocus></p>-->

            <div>
                <div class="invalid-feedback" id="userNameLabel" style="display: none">
                    Message
                </div>
                <input id="username" class="form-control"  type="text" name="username" placeholder="Name" required/>
            </div>

            <input id="password" type="password" class="form-control" name="password" placeholder="Password" required/>
            <div class="invalid-feedback">
                Please enter a message in the textarea.
            </div>


            <input id="token" type="hidden" name="_csrf" value="${_csrf.token}">
            <div><input type="submit" class="btn-login" <#--id="BtnLoginRequest"-->  value="Submit"></div>
            <div class="forgot-password-registration">
                <a href="" style="padding-right: 14px">Forget password?</a>
               <a  href="/registration" style="float: right;padding-top: 16px;">Registration</a>
            </div>
        </form>
    </div>
</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/main.js" ></script>

</body>



<script>
    $(document).ready(function(){
        $("#username").val("");
    });

</script>