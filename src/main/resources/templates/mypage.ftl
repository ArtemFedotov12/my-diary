<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">
<@h.head>
    <link rel="stylesheet" href="/templates/css/mypage.css">

<#--Choose file Start-->
    <link rel="stylesheet" type="text/css" href="/templates/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/component.css"/>
<#--Choose file End-->
    <script>
        (function(e,t,n){
                var r=e.querySelectorAll("html")[0];
                r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")
            }
        )(document,window,0);
    </script>
</@h.head>
<body class="body">
<@navFoot.navbarFooter>
<#--user.filename==null || user.filename==""-->
    <form id="formMyPage">
        <div class="main clearfix">


            <div class="content">
                <div class="image column">

                    <#if user.filename?? && user.filename!="">
                        <img src="/img/${user.filename}" alt="photo" style="width: 100%">
                        <div id="uploadPhoto" style="display: none">
                            <input type="file" name="file" id="file-3" class="inputfile" data-multiple-caption="{count} files selected"/>
                            <label for="file-3" <#--style="color: #2b9fff; font-size: 14px"--> class="labelForPhoto">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                                    <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4
                                     2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2
                                      2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9
                                       1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                                </svg> <span>Upload Photo</span>
                            </label>
                        </div>


                    <#else>
                        <div class="box">
                            <input type="file" name="file" id="file-5" class="inputfile inputfile-4" data-multiple-caption="{count} files selected" multiple />
                            <label for="file-5">
                                <figure>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="30" viewBox="0 0 20 17">
                                        <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3
                                    11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2
                                    2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                                    </svg>
                                </figure> <span>Upload Photo</span></label>
                        </div>
                    </#if>


                </div>
            </div>




            <div class="information column">

                <label><b>Login</b></label>
                <input type="text" class="fields" name="login"
                       value="<#if user.login??>${user.login}</#if>" required disabled/>

                <label><b>Email</b></label>
                <input type="email" class="fields" name="email"
                       value="<#if user.email??>${user.email}</#if>" required disabled/>

                <#if user.firstName??>
                    <label><b>First Name</b></label>
                    <input type="text" class="fields" name="firstName"
                           value="${user.firstName}" required disabled/>
                </#if>

                <#if user.lastName??>
                    <label><b>Last Name</b></label>
                    <input type="text" class="fields" name="lastName"
                           value="${user.lastName}" required disabled/>
                </#if>

                <#if user.patronymic??>
                    <label><b>Patronymic</b></label>
                    <input type="text" class="fields" name="patronymic"
                           value="${user.patronymic}" required disabled/>
                </#if>

                <#if isDirector==true>
                    <label><b>Access Key for Teacher</b></label>
                    <input type="text" class="fields" name="accessKeyForTeacher"
                           value="<#if user.accessKeyForTeacher??>${user.accessKeyForTeacher}</#if>" required disabled/>
                </#if>



                <#--<button onclick="handleRequest()" id="sendBtnMyPage" style="display: none">Send</button>-->
                <#--<button onclick="changeEmail()" id="editBtnMyPage">Edit</button>-->

                <input type="button" onclick="changeEmail()" id="editBtnMyPage" value="Edit">
                <input type="button" onclick="handleRequest()" id="sendBtnMyPage" value="Send" style="display: none">
            </div>


        </div>

        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js"></script>
<script src="/templates/css/js/footer.js"></script>
<script src="/templates/css/js/myPageAjax.js"></script>
<#--Choose file-->
<script src="/templates/css/js/custom-file-input.js"></script>
</body>


