<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Menu Profesores</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/menu_admin.css" rel="stylesheet">
    </head>
    <body>
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
                        <li class="active">
                            <a href="Redirect?pagina=menu-profesor.jsp">Home</a>
                        </li>
                        <li>
                            <a href="Redirect?pagina=verMisMaterias.jsp">Materias</a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                Ex&aacute;menes
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="Redirect?pagina=calificarExamenes.jsp">Calificar Ex&aacute;men</a></li>
                                <li><a href="Redirect?pagina=realizarExamenes.jsp">Crear Ex&aacute;men</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Redirect?pagina=menu-profesor.jsp"><span class="glyphicon glyphicon-user"></span>&nbsp; Profesor</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp; Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="menu">
                    <div class="row">
                        <div class="alert alert-info" role="alert">¡Bienvenido profesor, <%=request.getSession().getAttribute("usuario")%>!</div>
                    </div>
                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="list-group">
                                        <a class="list-group-item active">Menu principal</a>
                                        <a href="Redirect?pagina=verMisMaterias.jsp" class="list-group-item">
                                            <div class="media">
                                                <div class="media-left">
                                                    <div class="col-xs-6 col-md-3">
                                                        <img src="imagenes/Libros.png" alt="Materias" height="30px" width="auto" />
                                                    </div>
                                                </div>
                                                <div class="media-body">Materias</div>
                                            </div>
                                        </a>
                                        <a href="" class="list-group-item">
                                            <div class="media">
                                                <div class="media-left">
                                                    <div class="col-xs-6 col-md-3">
                                                        <img src="imagenes/tests.png" alt="Examenes" height="30px" width="auto" />
                                                    </div>
                                                </div>
                                               <div class="media-body">Ex&aacute;menes
                                                    <ul class="nav nav-list">
                                                        <div class="btn-group">
                                                            <button style="color: white; background-color:#0489B1; border-color:white; border-top-right-radius:5px; border-top-left-radius:5px;" onClick="location.href='Redirect?pagina=realizarExamenes.jsp'"class="btn">Crear ex&aacute;men</button>
                                                            <button style="color: white; background-color:#0489B1; border-color:white; border-top-right-radius:5px; border-top-left-radius:5px;" onClick="location.href='Redirect?pagina=calificarExamenes.jsp'"class="btn">Calificar ex&aacute;men</button>                                                 
                                                        </div>
                                                    </ul>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2"></div>
                    <div class="row"></div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>