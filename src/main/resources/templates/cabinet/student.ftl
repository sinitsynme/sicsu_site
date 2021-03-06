<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">

<@c.head pageName="Student's cabinet | SICSU">

    <#if isAdmin>
        <#assign path="/cabinet/changepsw/${userData.getUser().id}">
    <#else>
        <#assign path="/cabinet/changepsw">
    </#if>

    <div style="color: lightcyan">
        <h1>STUDENT'S PAGE</h1>
    </div>

    <div class="card block" style="width: 25rem">
        <div class="card-header">
            <i>Student's profile</i>
        </div>
        <ul class="list-group list-group-flush" style="color: black">
            <li class="list-group-item">First name: <b>${userData.getFirstName()!}</b></li>
            <li class="list-group-item">Last name: <b>${userData.getLastName()!}</b></li>
            <li class="list-group-item">Birth date: <b>${userData.getBirthDate()!}</b></li>
            <li class="list-group-item">E-mail: <b>${userData.getEmail()!}</b></li>
            <li class="list-group-item">Course: <b>${userData.getCourseNumber()!}</b></li>
            <li class="list-group-item">Group ID: <b>${userData.getGroupId()!}</b></li>

            <#if user.id == userData.getUser().id || isAdmin>
                <li class="list-group-item block">
                    <form action="${path}" method="get">
                        <button type="submit" class="btn btn-primary">Change password</button>
                    </form>
                </li>
            </#if>
            <#if isAdmin>
                <li class="list-group-item block">
                    <form action="/students/${userData.id}/groupSet" method="get">
                        <button type="submit" class="btn btn-primary">Set or change group</button>
                    </form>
                </li>
            </#if>


        </ul>
    </div>

</@c.head>
