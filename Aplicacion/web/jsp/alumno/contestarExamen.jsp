<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Examenes habilitados</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/css_alumno/menu_alumno.css" rel="stylesheet">
    </head>
    <body onload="javascript: cargarExamenesDisponibles();">
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">WebApp</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="Redirect?pagina=menu-alumno.jsp">Home</a></li>
                        <li><a href="Redirect?pagina=misMaterias.jsp">Materias</a></li>
                        <li class="active"><a href="Redirect?pagina=contestarExamen.jsp">Ex&aacute;menes</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp; Alumno</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp; Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <table class="table table-bordered table-hover table-responsive">
                    <thead>
                        <th>No.</th>
                        <th>Titulo</th>
                        <th>Fecha de actualizaci&oacute;n</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody id="rows"></tbody>
                </table>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/scripts_alumno/scripts.js"></script>
    </body>
</html>
