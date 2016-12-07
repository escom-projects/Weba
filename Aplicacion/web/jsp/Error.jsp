<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="imagenes/logo-servicio.png">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/errorPage/errorPage.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <br>
            </div>
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <div class="alert alert-danger" role="alert">
                        <div>
                            <% if (request.getParameter("error").equals("UserNullFound")) {
                            %>
                            <div>Ha ocurrido un <strong>error</strong>. Usuario no registrado en el sistema. <a href="index.html" class="alert-link">Regresar</a></div>
                            <% } else if (request.getParameter("error").equals("UserNotRegister")) {
                            %>
                            <div>Ha ocurrido un <strong>error</strong>.Usuario no registrado previamente en el sistema. <a href="index.html" class="alert-link">Regresar</a></div>
                            <% } else if (request.getParameter("error").equals("emailError")) {
                            %>
                            <div>Ha ocurrido un <strong>error</strong> al enviarle correo de confirmacion. Hemos registrado sus datos en base de datos. <a href="index.html" class="alert-link">Regresar</a></div>
                            <%  }
                            %>
                        </div>
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
        </div>
        <script src="js/jquery/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>