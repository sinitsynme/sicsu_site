<#macro login isRegisterFrom path>

  <div class="justify-content-center" style="color: lightcyan">
    <form action=${path} method="post">
      <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="username">Username</label>
        <div class="col-sm-4">
          <input class="form-control" name="username" id="username" type="text" placeholder="Username">
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="password">Password</label>
        <div class="col-sm-4">
          <input class="form-control" name="password" type="password" id="password" placeholder="Password">
        </div>
      </div>

      <input type="hidden" name="_csrf" value="${_csrf.token}"/>


        <#if isRegisterFrom>

          <div class="form-group row">
            <label class="col-sm-2 col-form-label" for="conf_psw">Confirm password</label>
            <div class="col-sm-4">
              <input class="form-control" name="confirm_psw" type="password" id="conf_psw"
                     placeholder="Confirm password">
            </div>
          </div>

          <div class="form-group row">
            <label class="col-sm-5 col-form-label" style="color: gold">Choose 1 of the roles
              below</label>
          </div>

          <div>
            <label><input type="checkbox" name="isStudent">Student</label>
          </div>
          <div>
            <label><input type="checkbox" name="isTeacher">Teacher</label>
          </div>

        <#--          <div class="form-check">-->
        <#--            <input class="form-check-input" type="checkbox" value="isStudent" id="isStud">-->
        <#--            <label class="form-check-label" for="isStud">Student</label>-->
        <#--          </div>-->

        <#--          <div class="form-check mt-1">-->
        <#--            <input class="form-check-input" type="checkbox" value="isTeacher" id="isTeach">-->
        <#--            <label class="form-check-label" for="isTeach">Teacher</label>-->
        <#--          </div>-->

          <div class="form-group">
            <button class="btn btn-primary" type="submit">Registration</button>
          </div>
        <#else>
          <div class="form-group">
            <button class="btn btn-primary" type="submit">Login</button>
          </div>
        </#if>

    </form>
  </div>


</#macro>

<#macro logout>
  <form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit">Log out</button>
  </form>
</#macro>

<#macro loginbutton>
  <form action="/login" method="post">
    <button class="btn btn-primary" type="submit">Sign in</button>
  </form>
</#macro>