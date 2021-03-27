<#import "../parts/common.ftl" as c>

<@c.head pageName="Student Registration | SICSU ADMIN">

  <div style="color: lightcyan">
    <h1>Registration of user ${userRegistering.username}</h1>
  </div>

  <div style="color: lightcyan">
    <form action="/students/new" method="post">
      <div class="form-group row">
        <label class="col-sm-3 form-label" for="fname">First name</label>
        <div class="col-sm-4">
          <input class="form-control" name="firstName" id="fname" type="text"
                 placeholder="${(userData.firstName)!"First name"}">
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-3 form-label" for="lname">Last name</label>
        <div class="col-sm-4">
          <input class="form-control" name="lastName" id="lname" type="text"
                 placeholder="${(userData.lastName)!"Last name"}">
        </div>
      </div>

      <div class="form-group row">
        <label class="col-sm-3 form-label" for="bdate">Birth date</label>
        <div class="col-sm-4">
          <input class="form-control" name="birthDate" id="bdate" type="text"
                 placeholder="${(userData.birthDate)!"Format: YYYY-MM-DD"}">
        </div>
      </div>

      <div class="form-group row">
        <label class="form-label col-sm-3" for="course">Course</label>
        <select name="course" id="course" class="form-select form-select-sm" aria-label=".form-select-sm example>">
          <option selected value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
        </select>
      </div>


      <input type="hidden" name="_csrf" value="${_csrf.token}">

      <input type="hidden" name="userId" value="${userRegistering.id}">

        <#if userData??>
          <input type="hidden" name="_method" value="PATCH">
            <#assign path="/students/${userData}">
        </#if>

      <div>
        <button type="submit" class="btn btn-primary">Register student</button>
      </div>

      <!--Course selector -->

        <#--        <select class="selectpicker" data-live-search="true">-->
        <#--          <option data-tokens="ketchup mustard">Hot Dog, Fries and a Soda</option>-->
        <#--          <option data-tokens="mustard">Burger, Shake and a Smile</option>-->
        <#--          <option data-tokens="frosting">Sugar, Spice and all things nice</option>-->
        <#--        </select>-->


    </form>
  </div>







</@c.head>