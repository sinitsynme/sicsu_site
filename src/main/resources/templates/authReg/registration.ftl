<#import "../parts/login.ftl" as l>
<#import "../parts/common.ftl" as c>

<@c.head pageName="Registration | SICSU">
    <div style="color: gold">
        <label>Registration</label>
    </div>

    <#if message??>
        <div style="color: deeppink">
            ${message}
        </div>
    </#if>

    <@l.login isRegisterFrom=true path="/registration"/>
</@c.head>
