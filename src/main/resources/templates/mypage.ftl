<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#import "part/createGradebook.ftl" as createGradebook>
<#import "part/createClass.ftl" as createClass>
<#import "part/createSubject.ftl" as createSubject>
<#include "part/security.ftl">
<@h.head>
    <link rel="stylesheet" href="/templates/css/mypage.css">

<#--Choose file Start-->
    <link rel="stylesheet" type="text/css" href="/templates/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/component.css"/>


<#--People for login button(Guy with tie)-->
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
          integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<#--Choose file End-->

</@h.head>
<body class="body">
<@navFoot.navbarFooter>

    <div>
        <@createGradebook.createGradeBook></@createGradebook.createGradeBook>
        <@createClass.createClass></@createClass.createClass>
        <@createSubject.createSubject></@createSubject.createSubject>
    </div>

<#--user.filename==null || user.filename==""-->
    <form id="formMyPage">
        <div class="main clearfix">


            <div class="content">
                <div class="image column">

                    <#if userMyPage.filename?? && userMyPage.filename!="">
                        <div>Block1</div>
                        <img id="imgMyPage" src="/img/${userMyPage.filename}" alt="photo" style="width: 100%">
                        <div id="uploadPhoto" style="display: none">
                            <input type="file" name="file" id="fileMyPage" class="inputfile" data-multiple-caption="{count} files selected"/>
                            <label for="fileMyPage" <#--style="color: #2b9fff; font-size: 14px"--> class="labelForPhoto">
                                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                                    <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4
                                     2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2
                                      2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9
                                       1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                                </svg> <span id="spanMyPage">Upload Photo</span>
                            </label>
                        </div>


                    <#else>
                        <div class="box" id="photoNotExistMyPage">
                            <input type="file" name="file" id="fileMyPage2" class="inputfile inputfile-4 fields" data-multiple-caption="{count} files selected" disabled/>
                            <label for="fileMyPage2">
                                <figure>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="30" viewBox="0 0 20 17">
                                        <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3
                                    11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2
                                    2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                                    </svg>
                                </figure> <span >Upload Photo</span></label>
                        </div>



                        <div id="blockPhotoMyPage" style="display: none">
                            <#--Generate Photo with Js-->
                            <div id="imageMyPageAddedId"></div>


                            <div id="uploadPhoto" style="display: none">
                                <input type="file" name="file2" id="fileMyPage3" class="inputfile"/>
                                <label for="fileMyPage3" <#--style="color: #2b9fff; font-size: 14px"--> class="labelForPhoto">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                                        <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4
                                     2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2
                                      2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9
                                       1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                                    </svg> <span id="spanMyPage2">Upload Photo</span>
                                </label>
                            </div>
                        </div>

                    </#if>

                    <#if isTeacher==true>
                        <input class="btn-create" type="button" onclick="document.getElementById('createClassId').style.display='block';" value="Create class">
                        <input class="btn-create" type="button" onclick="openCreateGradeBookModel()" value="Create GradeBook">
                        <input class="btn-create" type="button" onclick="document.getElementById('createSubjectId').style.display='block';" value="Create Subject">
                    </#if>
                </div>
            </div>




            <div class="information column">

                <label><b>Login</b></label>
                <input type="text" class="fields" name="login"
                       value="<#if userMyPage.login??>${userMyPage.login}</#if>" required disabled/>

                <label><b>Email</b></label>
                <input type="email" class="fields" name="email"
                       value="<#if userMyPage.email??>${userMyPage.email}</#if>" required disabled/>

                <#if userMyPage.firstName??>
                    <label><b>First Name</b></label>
                    <input type="text" class="fields" name="firstName"
                           value="${userMyPage.firstName}" required disabled/>
                </#if>

                <#if user.lastName??>
                    <label><b>Last Name</b></label>
                    <input type="text" class="fields" name="lastName"
                           value="${userMyPage.lastName}" required disabled/>
                </#if>

                <#if userMyPage.patronymic??>
                    <label><b>Patronymic</b></label>
                    <input type="text" class="fields" name="patronymic"
                           value="${userMyPage.patronymic}" required disabled/>
                </#if>

                <#if isDirector==true>
                    <label><b>Access Key for Teacher</b></label>
                    <input type="text" class="fields" name="accessKeyForTeacher"
                           value="<#if userMyPage.accessKeyForTeacher??>${userMyPage.accessKeyForTeacher}</#if>" required disabled/>
                </#if>



                <#--<button onclick="handleRequest()" id="sendBtnMyPage" style="display: none">Send</button>-->
                <#--<button onclick="changeEmail()" id="editBtnMyPage">Edit</button>-->

                <input type="button" class="btn-myPage" onclick="changeEmail()" id="editBtnMyPage" value="Edit">
                <input type="button" class="btn-myPage" onclick="handleRequest()" id="sendBtnMyPage" value="Send" style="display: none">
            </div>


        </div>

        <input type="hidden" name="id" value="${userMyPage.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js"></script>
<script src="/templates/css/js/footer.js"></script>
<script src="/templates/css/js/mypageEditData.js"></script>
<script src="/templates/css/js/mypageCreate_GradeBook_Class_Subject.js"></script>
<script src="/templates/css/js/mypageCreateModel.js"></script>
<#--Choose file-->
<script src="/templates/css/js/custom-file-input.js"></script>
</body>


