<#--to add Freemarker add to application.pro-->
<#--spring.freemarker.expose-request-attributes=true
<input type="hidden" name="_csrf" value="${_csrf.token}">
-->
<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">

<@h.head>
    <link rel="stylesheet" href="/templates/css/main.css">

</@h.head>

<body class="body">
<@navFoot.navbarFooter>
<div>
<#--<h1>Welcome <#if name??>${name}!</#if></h1>-->
    <h1>Kek</h1>

    <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>

    <div id="id01" class="modal">

        <form class="modal-content animate" action="/login" method="post">
            <div class="imgcontainer ">
                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="https://www.w3schools.com/howto/img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>
                <input  type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn-login">Login</button>
                <label>
                    <input type="checkbox" checked="checked" name="remember"> Remember me
                </label>
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="button" id="cancelBtn"  class="cancelbtn fa fa-close"> Cancel</button>
                <span class="psw"><a href="#">Registration</a></span>
            </div>
        </form>

    </div>
    <div class="k"> aaaa</div>





</div>

</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/main.js"></script>
</body>
