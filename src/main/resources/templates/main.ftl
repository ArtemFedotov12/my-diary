<#--to add Freemarker add to application.pro-->
<#--spring.freemarker.expose-request-attributes=true
<input type="hidden" name="_csrf" value="${_csrf.token}">
-->
<#import "part/page.ftl" as p>
<@p.page>

<#--<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Sign Out"/>
</form>-->
<div>
<h1>Welcome <#if name??>${name}!</#if></h1>
    <h1>Kek</h1>

</div>

</@p.page>
