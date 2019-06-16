<#--to add Freemarker add to application.pro-->
<#--spring.freemarker.expose-request-attributes=true
<input type="hidden" login="_csrf" value="${_csrf.token}">
-->
<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">

<@h.head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="/templates/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="/templates/css/component.css"/>

<#--People for login button(Guy with tie)-->
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
          integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script>
        (function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>
</@h.head>

<body class="body" background="https://image.freepik.com/free-vector/back-school-poster-design-cartoon-pencils-board_1262-15493.jpg">
<@navFoot.navbarFooter>
<div>







</div>

</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>
<script src="/templates/css/js/main.js"></script>

    <#--Maybe you need to delete it-->
<script src="/templates/css/js/navbarFooter.js"></script>

<#--Choose file-->
<script src="/templates/css/js/custom-file-input.js"></script>
</body>
