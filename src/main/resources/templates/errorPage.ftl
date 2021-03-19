<#import "parts/common.ftl" as c>

<@c.head pageName="Error 404">
  <div class="alert block alert-danger align-self-center col-sm-5 text-center" role="alert">
    <h1>ERROR 404</h1>
    <b>${error}</b>
    <p class="mt-2">Return to <a style="color: darkblue" href="/"
                                 class="alert-link">homepage</a></p>
  </div>
</@c.head>