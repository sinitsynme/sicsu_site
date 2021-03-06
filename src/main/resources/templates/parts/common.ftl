<#import "navbar.ftl" as nav>

<#macro head pageName>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>${pageName}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/static/css/style.css">
        <link rel="shortcut icon" href="/static/icons/favicon.png" type="image/png">

        <style>
            body {
                background-image: url(/static/images/homepage2.jpg);
                background-repeat: no-repeat;
                background-size: auto;
                background-position: center;
            }
        </style>

    </head>
    <body>

    <@nav.navbar/>

    <div class="container mt-3">
        <#nested>
    </div>

    <footer class="fixed-bottom bg-dark justify-content-center text-white"
            style="text-align: center; font-family: 'Comic Sans MS', serif; font-size: 14pt">
        <p>Developed by Maxim Sinitsyn, 2021</p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>

    </body>
    </html>
</#macro>

