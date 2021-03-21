<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">
<#assign count=1>

<@c.head pageName="Groups | SICSU">

  <div style="color: lightcyan">
    <h1>GROUP LIST</h1>
  </div>

    <#if isAdmin>
      <div class="block">
        <form action="/groups/new" method="get">
          <button class="btn btn-primary" type="submit">Add new group</button>
        </form>
      </div>
    </#if>

  <table class="table mt-3" style="background-color: whitesmoke; width: auto">
    <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Group ID</th>
      <th scope="col">Description</th>
        <#if isAdmin>
          <th scope="col"></th>
          <th scope="col"></th>
        </#if>
    </tr>
    </thead>

    <tbody>
    <#list groups as group>
      <tr>
        <th scope="row">${group_index+1}</th>
        <th scope="row">${group.groupFullId}</th>
        <th scope="row">${group.info}</th>

          <#if isAdmin>
            <th scope="row">
              <form action="/groups/${group.id}/edit" method="get">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button type="submit" class="btn-primary btn">Edit</button>
              </form>
            </th>
            <th scope="row">
              <form action="/groups/${group.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="_method" value="DELETE">
                <button type="submit" class="btn-primary btn">Delete</button>
              </form>
            </th>

          </#if>

        <!--GET STUDENTS FROM A GROUP-->
      </tr>
    </#list>

    </tbody>

  </table>





</@c.head>

