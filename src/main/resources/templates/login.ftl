<#import "part/page.ftl" as p>
<@p.page>
    <h1><#if errorMessge??>${errorMessge}</#if></h1>
    <h1 id="loginInfo" style="display: none"></h1>
        <div class="login">
            <form action="/login" method="post">
             <#--  <p> <input type="text" name="text" placeholder="Name" maxlength="10" autocomplete="off"></p>
                <p><input type="password" name="password" placeholder="Password" autofocus></p>-->

                <input id="username" type="text" name="username" placeholder="Name"/>
                <input type="password" name="password" placeholder="Password"/>
                <input id="us" type="text" name="username" placeholder="Name" style="display:none;"/>


                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div><input type="button" value="Submit" onclick="loginRequest()"></div>
                <input id="submitBtn" type="submit" style="display: none">
            <div class="forgot-password-registration">
            <a href="" style="padding-right: 14px">Forget password?</a>
            <a href="/registration">Registration</a>
            </div>
            </form>
        </div>

</@p.page>
<script>
    $(document).ready(function(){
        $("#username").val("");
    });

</script>