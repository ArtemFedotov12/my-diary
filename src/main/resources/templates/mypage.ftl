<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">
<@h.head>
    <link rel="stylesheet" href="/templates/css/mypage.css">

</@h.head>
<body class="body">
<@navFoot.navbarFooter>

    <form>
        <div class="main clearfix">

            <div class="image column">
                <#if user.filename??><img src="/img/${user.filename}" style="width: 100%">
                <#else>
                    <input type="file" name="file">
                </#if>
                <span>Add photo</span>
                <input type="file">
            </div>

            <div class="information column">

                <label><b>Login</b></label>
                <input type="text" class="fields" name="login"
                       value="<#if user.login??>${user.login}</#if>" disabled/>

                <label><b>Email</b></label>
                <input type="email" class="fields" name="email"
                       value="<#if user.email??>${user.email}</#if>" disabled/>

                <#if user.firstName??>
                    <label><b>First Name</b></label>
                    <input type="text" class="fields" name="login"
                           value="${user.firstName}" disabled/>
                </#if>

                <#if user.lastName??>
                    <label><b>Last Name</b></label>
                    <input type="text" class="fields" name="login"
                           value="${user.lastName}" disabled/>
                </#if>

                <#if user.patronymic??>
                    <label><b>Patronymic</b></label>
                    <input type="text" class="fields" name="login"
                           value="${user.patronymic}" disabled/>
                </#if>

                  <#if isDirector==true>
                      <label><b>Access Key for Teacher</b></label>
                        <input type="text" class="fields" name="login"
                               value="<#if user.accessKeyForTeacher??>${user.accessKeyForTeacher}</#if>" disabled/>
                    </#if>


                <div id="sendBtn" style="display: none">
                    <button onclick="handleRequest()">Send</button>
                </div>
                <button onclick="changeEmail()" id="editBtn">Edit</button>
            </div>
        </div>
    </form>
</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js"></script>
<script src="/templates/css/js/footer.js"></script>
<script src="/templates/css/js/myPageAjax.js"></script>
</body>


