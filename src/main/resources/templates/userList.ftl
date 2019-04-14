<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>
<#include "part/security.ftl">

<@h.head>
    <#--Table style from W3.CSS for activationCodeForProductList-->
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</@h.head>

    <body class="body">
<@navFoot.navbarFooter>

<h1>sxsd</h1>
    <input id="currentUserId" type="hidden" value="${currentUserId}">

    <input id="btnCodeGeneration" type="button" onclick="putActivationCode(${currentUserId})" value="GenerateCode">

    <div id="here_table"></div>


    <table class="w3-table-all w3-hoverable">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Role</th>
            <th>Photo</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
    <#list users as user>
    <tr id="${user.id}">
        <td>${user.id}</td>
        <td>${user.login}</td>
    <#--    <td> <#if user.activationCodeEmail??> ${user.activationCodeEmail} </#if> </td>-->
    <#-- #sep for use coma-->
        <td> <#list user.roles as role>${role}<#sep>, </#list></td>
        <td> <#if user.filename??><img alt="img" src = "/img/${user.filename}" style = "height: 128px"></#if></td>
        <td> <a href = "/user/${user.id}"> edit </a></td>
        <td > <#--<a href = "/delete/${user.id}"> delete </a>-->
            <input type="button" onclick="deleteUser(${user.id})" value="DELETE">
        </td>
    </tr>
    </#list>
        </tbody>
    </table>


</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js"></script>
<script src="/templates/css/js/footer.js"></script>
<script src="/templates/css/js/userControllerRest.js"></script>

    </body>