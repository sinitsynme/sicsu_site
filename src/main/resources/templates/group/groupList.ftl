<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<#assign count=1>

<@c.head pageName="Groups | SICSU">

  <div style="color: lightcyan">
    <h1>GROUP LIST</h1>
  </div>

  <table class="table" style="background-color: whitesmoke">
    <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Group ID</th>
      <#if isAdmin>
        <th scope="col"></th>
        <th scope="col"></th>
      </#if>
    </tr>
    </thead>

    <tbody>
    <#list groups as group>
      <tr>
        <th scope="row">${count}</th> <!--MAKE COUNT++-->
        <th scope="row">${group.groupFullId}</th>

        <#if isAdmin>
          <th scope="row">
            <form action="/groups/${group.id}/edit" method="post">
              <button type="submit" class="btn-primary btn">Edit</button>
            </form>
          </th>
          <th scope="row">
            <form action="/groups/${group.id}/delete" method="post">
              <button type="submit" class="btn-primary btn">Delete</button>
            </form>
          </th>

        </#if>

        <!--GET STUDENTS FROM A GROUP-->
      </tr>
    </#list>

    </tbody>

  </table>

  <#if isAdmin>
    <div class="block">
      <form action="/groups/new" method="get">
        <button class="btn btn-primary" type="submit">Add new group</button>
      </form>
    </div>
  </#if>



</@c.head>

