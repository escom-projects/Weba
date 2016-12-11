<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Menu Administrador</title>
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
                        <li class="active"><a href="Redirect?pagina=menu-admin.jsp">Home</a></li>
                        <li><a href="Redirect?pagina=materias.jsp">Materias</a></li>
                        <li><a href="Redirect?pagina=profesores.jsp">Profesores</a></li>
                        <li><a href="Redirect?pagina=alumnos.jsp">Alumnos</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="Redirect?pagina=menu-admin.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-user"></span>&nbsp; Administrador
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#" data-toggle="modal" data-target="#editarPerfil">Editar mi informacion</a></li>
                            </ul>
                        </li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp; Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <br><br><br>
            <div class="alert alert-info" role="alert">¡Bienvenido, <%=request.getSession().getAttribute("usuario")%>!</div>
            <div class="row">
                <div class="menu">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="list-group">
                                    <a class="list-group-item active">Menu principal</a>
                                    <a href="Redirect?pagina=centrosDeTrabajo.jsp" class="list-group-item">
                                        <div class="media">
                                            <div class="media-left">
                                                <div class="col-xs-6 col-md-3">
                                                    <img src="imagenes/escuela.png" alt="Materias" height="30px" width="auto" />
                                                </div>
                                            </div>
                                            <div class="media-body">Centros de Estudio</div>
                                        </div>
                                    </a>
                                    <a href="Redirect?pagina=materias.jsp" class="list-group-item">
                                        <div class="media">
                                            <div class="media-left">
                                                <div class="col-xs-6 col-md-3">
                                                    <img src="imagenes/Libros.png" alt="Materias" height="30px" width="auto" />
                                                </div>
                                            </div>
                                            <div class="media-body">Materias</div>
                                        </div>
                                    </a>
                                    <a href="Redirect?pagina=profesores.jsp" class="list-group-item">
                                        <div class="media">
                                            <div class="media-left">
                                                <div class="col-xs-6 col-md-3">
                                                    <img src="imagenes/student_hat_1.png" alt="Profesores" height="30px" width="auto" />
                                                </div>
                                            </div>
                                            <div class="media-body">Profesores</div>
                                        </div>
                                    </a>
                                    <a href="Redirect?pagina=alumnos.jsp" class="list-group-item">
                                        <div class="media">
                                            <div class="media-left">
                                                <div class="col-xs-6 col-md-3">
                                                    <img src="imagenes/student_hat_1.png" alt="Alumnos" height="30px" width="auto" />
                                                </div>
                                            </div>
                                            <div class="media-body">Alumnos</div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                </div>
            </div>
        </div>
        <%@include file="/jsp/EditMyInformation.jsp" %>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>