<#import "parts/common.ftl" as c>
<@c.head pageName="Users | SICSU ADMIN">

  <h5>List of users</h5>
  <table class="table" style="background-color: whitesmoke; width: auto">
    <thead class="thead-dark">
    <tr>
      <th scope="row">Name</th>
      <th scope="row">Role</th>
      <th scope="row"></th>
      <th scope="row"></th>
    </tr>
    </thead>

    <tbody>
    <#list users as user>
      <tr>
        <th scope="row">${user.username}</th>
        <th scope="row"><#list user.roles as role>${role} <#sep>, </#list></th>
        <th scope="row">
          <form action="/users/${user.id}" method="get">
            <button class="btn btn-primary" type="submit">View</button>
          </form>
        </th>

        <th scope="row">
          <form action="/users/delete/${user.id}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="_method" value="DELETE">

            <#if !(user.username=="admin")>
              <button class="btn btn-primary" type="submit">Delete</button>
            </#if>
          </form>
        </th>

      </tr>
    </#list>

    </tbody>
  </table>
</@c.head>