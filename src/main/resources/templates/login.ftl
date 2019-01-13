<#import "part/page.ftl" as p>
<@p.page>
        <div class="login">
            <form action="/login" method="post"">
               <#--<p> <input type="text" name="text" placeholder="Name" maxlength="10" autocomplete="off"></p>
                <p><input type="password" name="password" placeholder="Password" autofocus></p>-->
            <div><input type="text" name="username" placeholder="Name" maxlength="10" autocomplete="on"/></div>
            <div> <input type="password" name="password" placeholder="Password"/> </label></div>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div><input type="submit" value="Submit"sds></div>
            <div class="forgot-password-registration">
            <a href="" style="padding-right: 14px">Forget password?</a>
            <a href="/registration">Registration</a>
            </div>
            </form>
        </div>

</@p.page>