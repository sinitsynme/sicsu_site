<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.head pageName="Login | SICSU Auth">
  <div class="text-center" style="font-family: 'Playfair Display', serif; color: whitesmoke">
    <h1>Login</h1>
  </div>
    <@l.login isRegisterFrom=false path="/login"/>
</@c.head>