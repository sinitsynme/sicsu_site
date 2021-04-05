<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">

<@c.head pageName="All students | SICSU">

  <div style="color:whitesmoke;">
    <h1>STUDENT LIST</h1>
    <h2>${group.groupFullId}</h2>
    <h2>${group.info}</h2>
  </div>

    <#if message??>
      <div style="color:deeppink;">
        <h3>${message}</h3>
      </div>

      <div class="block mt-3">
        <form method="get" action="/groups">
          <button type="submit" class="btn btn-primary">Get back to groups</button>
        </form>
      </div>

    <#else>

      <table class="table mt-3" style="background-color: whitesmoke; width: auto;">
        <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">First name</th>
          <th scope="col">Last name</th>
        </tr>
        </thead>

        <tbody>
        <#list students as student>
          <tr>
            <th scope="row">${student_index + 1}</th>
            <th scope="row">
              <a href="/users/${student.user.id}">${student.firstName}</a>
            </th>
            <th scope="row">
              <a href="/users/${student.user.id}">${student.lastName}</a>
            </th>
          </tr>


        </#list>

        </tbody>
      </table>

    </#if>

</@c.head>