<#assign
   <#-- esli etot object opredelen v kontexte mu mojem rabotat s sesueu polzovatela-->
    known=Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        user=Session.SPRING_SECURITY_CONTEXT.authentication.principal
        login=user.getLogin()
        active=user.isActiveEmail()
        isAdmin=user.isAdmin()
        currentUserId=user.getId()
   <#--     filename=user.getFilename()-->
    >
<#else >
    <#assign
        login="unknown"
        isAdmin=false
        currentUserId=-1
        <#--filename="unknown"-->
    >
</#if>
