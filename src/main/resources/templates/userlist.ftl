<#import "parts/common.ftl" as c>
<@c.head pageName="Users | SICSU ADMIN">

  <h5>List of users</h5>
  <table>
    <thead>
    <tr>
      Name
    </tr>
    <tr>
      Role
    </tr>
    </thead>

    <tbody>
    <#list users as user>
      <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role} <#sep>, </#list></td>
      </tr>
    </#list>

    </tbody>
  </table>
</@c.head>