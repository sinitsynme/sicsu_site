<#import "../parts/common.ftl" as c>

<@c.head pageName="Add new group | SICSU ADMIN">

    <div style="color: lightcyan">
        <#if group??>
            <#assign path="/groups/${group.id}">
            <h1>EDIT GROUP</h1>
        <#else>
            <#assign path="/groups/new">
            <h1>ADD NEW GROUP</h1>
        </#if>

    </div>

    <#if message??>
        <div style="color: deeppink">
            ${message}
        </div>
    </#if>

    <div class="justify-content-center" style="color: lightcyan">
        <form action="${path}" method="post">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="groupFullId">Group Id</label>
                <div class="col-sm-4">
                    <input class="form-control" id="groupFullId" name="groupFullId" type="text"
                           placeholder="${(group.groupFullId)!"Group Id"}">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label" for="info">Description</label>
                <div class="col-sm-4">
                    <input class="form-control" id="info" name="info" type="text"
                           placeholder="Description">
                </div>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <#if group??>
                <input type="hidden" name="_method" value="PATCH">
            </#if>

            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add group</button>
            </div>

        </form>
    </div>

</@c.head>