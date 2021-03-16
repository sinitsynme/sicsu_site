<#include "security.ftl">
<#import "login.ftl" as l>

<#macro navbar>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">SICSU</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li>
          <a class="nav-link" href="/info">Info</a>
        </li>

          <#if known>
            <li>
              <a class="nav-link" href="/groups">Groups</a>
            </li>
              <#if isAdmin>
                <li>
                  <a class="nav-link" href="/users" style="color:aqua;">Users</a>
                </li>

                <li>
                  <a class="nav-link" href="/registration">Registration</a>
                </li>

              <#else>
                <li>
                  <a class="nav-link" href="/cabinet" style="color:aqua">Personal cabinet</a>
                </li>

              </#if>
          </#if>


      </ul>
    </div>

      <#if known>
        <div class="navbar-text mr-3">
            ${username}
        </div>
          <@l.logout/>
      <#else>
          <@l.loginbutton/>
      </#if>


  </nav>


</#macro>