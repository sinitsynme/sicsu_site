<#import "../parts/common.ftl" as c>
<#include "../parts/security.ftl">

<#if isAdmin>
    <#assign path="/users/admchangepass">
<#else>
    <#assign path="/users/changepass">
</#if>

<@c.head pageName="Change password | SICSU">

    <div style="color: lightcyan">
        <h1>CHANGE PASSWORD</h1>
    </div>


    <div class="justify-content-center" style="color: lightcyan">
        <form action=${path} method="post">

            <#if !isAdmin>

                <#if wrongPsw??>
                    <div style="color: deeppink">
                        ${wrongPsw}
                    </div>
                </#if>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="currPsw">Current password</label>
                    <input class="form-control col-sm-4" id="currPsw" name="currentPassword" type="password"
                           placeholder="Current password">
                </div>


                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="newPsw">New password</label>
                    <input class="form-control col-sm-4" id="newPsw" name="newPassword" type="password"
                           placeholder="New password">
                </div>


                <#if notEqualPsws??>
                    <div style="color: deeppink">
                        ${notEqualPsws}
                    </div>
                </#if>


                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="confirmPsw">Confirm password</label>
                    <input class="form-control col-sm-4" id="confirmPsw" name="confirmPassword" type="password"
                           placeholder="Confirm password">
                </div>

            <#else>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="newPsw">New password</label>
                    <input class="form-control col-sm-4" id="newPsw" name="newPassword" type="password"
                           placeholder="New password">
                </div>

            </#if>


            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="_method" value="PATCH">
            <input type="hidden" name="userId" value="${userId}">

            <div>
                <button class="btn btn-primary" type="submit">Change password</button>
            </div>

        </form>


    </div>



</@c.head>

