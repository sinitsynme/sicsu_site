<#import "parts/login.ftl" as l>
<#import "parts/common.ftl" as c>

<@c.head pageName="Registration | SICSU">
  <div style="color: gold">
    <label>Registration</label>
  </div>
    <div style="color: deeppink">
      ${message!}
    </div>
  <@l.login isRegisterFrom=true path="/registration"/>
</@c.head>
