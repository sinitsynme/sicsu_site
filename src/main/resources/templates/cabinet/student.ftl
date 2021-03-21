<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">

<@c.head pageName="Student's cabinet | SICSU">


  <div style="color: lightcyan">
    <h1>STUDENT PAGE</h1>
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
      <li class="list-group-item">Group number: <b>${userData.getGroupId()!}</b></li>
    </ul>
  </div>




</@c.head>
