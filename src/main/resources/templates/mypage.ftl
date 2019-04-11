<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">
<@h.head>
    <link rel="stylesheet" href="/templates/css/mypage.css">

</@h.head>
<body class="body">
<@navFoot.navbarFooter>

    <div class="main clearfix">

        <div class="image column">
            <#if user.filename??><img src="/img/${user.filename}" style="width: 100%">
            <#else>
                <input  name="file" type="file" value="Change image">
            </#if>

        </div>

        <div class="information column">

            <input type="text" class="fields" name="login"
                   value="<#if user.login??>${user.login}</#if>" disabled/>

            <input type="email" class="fields" name="email"
                   value="<#if user.email??>${user.email}</#if>" disabled/>

            <#if user.firstName??>
                <input type="text" class="fields" name="login"
                       value="${user.firstName}" disabled/>
            </#if>

            <#if user.lastName??>
                <input type="text" class="fields" name="login"
                       value="${user.lastName}" disabled/>
            </#if>

            <#if user.patronymic??>
                <input type="text" class="fields" name="login"
                       value="${user.patronymic}" disabled/>
            </#if>

            <#--    <#if isDirector??>
                    <input type="text" class="fields" name="login"
                           value="<#if user.accessKeyForTeacher??>${user.accessKeyForTeacher}</#if>" disabled/>
                </#if>-->




            <div id="sendBtn" style="display: none">
                <button onclick="handleRequest()">Send</button>
            </div>
            <button onclick="changeEmail()" id="editBtn">Edit</button>
        </div>



    </div>
</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/myPageAjax.js" type="text/javascript"></script>
</body>


