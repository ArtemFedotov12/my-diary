<#import "part/page.ftl" as p>
<@p.page>

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
        <td>${user.username}</td>
    <#-- #sep for use coma-->
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td> <#if user.filename??><img src="/img/${user.filename}" style="height: 128px"></#if></td>
        <td><a href="/user/${user.id}">edit</a></td>
    </tr>
    </#list>
        </tbody>
    </table>


</@p.page>