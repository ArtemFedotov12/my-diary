<#import "part/navbarFooter.ftl" as navFoot>
<#import "part/head.ftl" as h>

<@h.head>
    <link rel="stylesheet" href="/templates/css/login.css">

</@h.head>

    <body class="body">
<@navFoot.navbarFooter>

User editor
<form method="post" action="/user">
    <input type="text" value="${teacher.login}" name="login">
    <#list roles as role>
    <div>
    <#-- it is cycle if for example will admin
     cycle check if role admin exist in
     list of priveligue or not
     if tru return checked
     false return ""
     checked it is atribute for tag <input>
     checked use for checkbox or radiobutton-->

    <#--it returns each time different amount of
     "checked"(with check mark) clause
     and it will write to variable !!!!!form!!!!
     if you put 2 check mark it will retrun 2-->
        <label><input type="checkbox" name="${role}" ${teacher.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
    </#list>
    <input type="hidden" value="${teacher.id}" name="id">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Save</button>
</form>
</@navFoot.navbarFooter>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/templates/css/js/topnav.js" type="text/javascript"></script>
<script src="/templates/css/js/footer.js" type="text/javascript"></script>

    </body>