<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>
    <link rel="stylesheet" href="/templates/css/login.css">

</@h.head>

    <body class="body">
<@navFoot.navbarFooter>

<h1>sxsd</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
    <#list users as user>
    <tr>
        <td>${user.login}</td>
    <#--    <td> <#if user.activationCodeEmail??> ${user.activationCodeEmail} </#if> </td>-->
    <#-- #sep for use coma-->
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td> <#if user.filename??><img src="/img/${user.filename}" style="height: 128px"></#if></td>
        <td><a href="/user/${user.id}">edit</a></td>
    </tr>
    </#list>
        </tbody>
    </table>


</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>

    </body>