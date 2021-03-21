<#import "../parts/common.ftl" as c>

<@c.head pageName="Teacher Registration | SICSU Admin">

    <div style="color: lightcyan">
      <h1>TEACHER REGISTRATION</h1>
    </div>

    <div class="justify-content-center" style="color: lightcyan">

      <form action="/teachers/new" method="post">

        <div class="form-group row col-sm-5">
          <label class="form-label" for="firstName">First name</label>
          <input class="form-control" id="firstName" name="firstName" placeholder="First Name">
        </div>

        <div class="form-group row col-sm-5">
          <label class="form-label" for="lastName">Last name</label>
          <input class="form-control" id="lastName" name="lastName" placeholder="Last name">
        </div>

        <div>
          <button type="submit" class="btn btn-primary">Register</button>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="hidden" name="userId" value="${userRegistering.id}">

      </form>


    </div>


</@c.head>
