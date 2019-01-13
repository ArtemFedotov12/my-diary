<#assign
   <#-- esli etot object opredelen v kontexte mu mojem rabotat s sesueu polzovatela-->
    known=Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        teacher=Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name=teacher.getName()
        active=teacher.isActive()
        isAdmin=teacher.isAdmin()
        currentUserId=teacher.getId()
   <#--     filename=teacher.getFilename()-->
    >
<#else >
    <#assign
        name="unknown"
        isAdmin=false
        currentUserId=-1
        <#--filename="unknown"-->
    >
</#if>
