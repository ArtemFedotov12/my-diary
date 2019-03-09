<#--to add Freemarker add to application.pro-->
<#--spring.freemarker.expose-request-attributes=true
<input type="hidden" name="_csrf" value="${_csrf.token}">
-->
<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>
    <link rel="stylesheet" href="/templates/css/login.css">

</@h.head>

<body class="body">
<@navFoot.navbarFooter>
<div>
<h1>Welcome <#if name??>${name}!</#if></h1>
    <h1>Kek</h1>

</div>

</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>


</body>
