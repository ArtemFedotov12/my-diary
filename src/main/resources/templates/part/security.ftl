<#assign
   <#-- esli etot object opredelen v kontexte mu mojem rabotat s sesueu polzovatela-->
    known=Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        teacher=Session.SPRING_SECURITY_CONTEXT.authentication.principal
        login=teacher.getLogin()
        active=teacher.isActiveEmail()
        isAdmin=teacher.isAdmin()
        currentUserId=teacher.getId()
   <#--     filename=teacher.getFilename()-->
    >
<#else >
    <#assign
        login="unknown"
        isAdmin=false
        currentUserId=-1
        <#--filename="unknown"-->
    >
</#if>
