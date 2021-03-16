<#assign
known = Session.SPRING_SECURITY_CONTEXT??>

<#if known>
    <#assign user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    username = user.getUsername()
    isAdmin = user.isAdmin()
    isStudent = user.isStudent()
    isTeacher = user.isTeacher()
    >
<#else>
    <#assign isAdmin=false isStudent=false, isTeacher=false, user=false>
</#if>