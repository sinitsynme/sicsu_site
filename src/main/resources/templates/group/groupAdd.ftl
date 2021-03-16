<#import "../parts/common.ftl" as c>

<@c.head pageName="Add new group | SICSU ADMIN">

  <div style="color: lightcyan">
    <h1>ADD NEW GROUP</h1>
  </div>

  <#if message??>
    <div style="color: deeppink">
      ${message}
    </div>
  </#if>

    <div class="justify-content-center" style="color: lightcyan">
      <form action="/groups/new" method="post">
        <div class="form-group row">
          <label class="col-sm-2 col-form-label" for="groupFullId">Group Id</label>
          <div class="col-sm-4">
            <input class="form-control" id="groupFullId" name="groupFullId" type="text" placeholder="Group Id">
          </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <div class="form-group">
          <button type="submit" class="btn btn-primary">Add group</button>
        </div>

      </form>
    </div>

</@c.head>