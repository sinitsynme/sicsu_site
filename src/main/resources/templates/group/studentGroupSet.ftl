<#import "../parts/common.ftl" as c>

<@c.head pageName="Set group | SICSU Admin">

  <div>
    <h1>SETTING A GROUP TO STUDENT</h1>
  </div>

  <!-- Make group search-->

    <#if message??>
      <div style="color: deeppink">
        ${message}
      </div>
    </#if>

  <form action="/students/${studentId}/groupSet" method="post">

    <table class="table mt-3" style="background-color: whitesmoke; width: auto">
      <thead class="thead-dark">
      <tr>
        <th scope="col">Choose a single group to set</th>
      </tr>
      </thead>

      <tbody>
      <#list groups as group>
        <tr>
          <th scope="row">
            <div class="form-check">
              <input class="form-check-input" type="radio" id="radio" name="groupName"
                     value="${group.groupFullId}">
              <label class="form-check-label" for="radio">${group.groupFullId}</label>
            </div>

          </th>
        </tr>
      </#list>

      </tbody>
    </table>

    <button class="btn btn-primary" type="submit" style="background-color: green">Set group</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}">

  </form>



</@c.head>