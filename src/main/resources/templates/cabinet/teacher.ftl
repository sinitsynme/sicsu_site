<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">

<@c.head pageName="Teacher's cabinet | SICSU">

  <div style="color: lightcyan">
    <h1>TEACHER'S PAGE</h1>
  </div>

  <div class="card block" style="width: 25rem">
    <div class="card-header">
      <i>Teacher's profile</i>
    </div>
    <ul class="list-group list-group-flush" style="color: black">
      <li class="list-group-item">First name: <b>${userData.getFirstName()!}</b></li>
      <li class="list-group-item">Last name: <b>${userData.getLastName()!}</b></li>
      <li class="list-group-item">E-mail: <b>${userData.getEmail()!}</b></li>
      <#if user.id == userData.getUser().id || isAdmin>
        <div class="list-group-item block">
          <form action="/cabinet/changepsw" method="get">
            <button type="submit" class="btn btn-primary">Change password</button>
          </form>
        </div>
      </#if>
    </ul>
  </div>




</@c.head>
