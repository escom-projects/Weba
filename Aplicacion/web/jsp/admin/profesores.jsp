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
    <body onload="javascript: cargarProfesores();">
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
                        <li><a href="Redirect?pagina=menu-admin.jsp">Home</a></li>
                        <li><a href="Redirect?pagina=materias.jsp">Materias</a></li>
                        <li class="active"><a href="Redirect?pagina=profesores.jsp">Profesores</a></li>
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
            <br><br><br><br>
            <div class="panel panel-default">
                <div class="panel-heading">Lista de Profesores</div>
                <table class="table table-hover">
                    <thead>
                        <th>No.</th>
                        <th>Profesor</th>
                        <th>Correo</th>
                        <th>Claves de acceso</th>
                        <th>Acciones</th>
                    </thead>
                    <tbody id="rows"></tbody>
                </table>
            </div>
        </div>
        
        <!-- Modal Agregar Materia-->
        <div class="modal fade" id="myModalA" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                      <h4 class="modal-title" id="myModalLabel">Asignar materia</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Materia...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">Asignar</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal Eliminar Materia-->
        <div class="modal fade" id="myModalE" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Eliminar materia</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Materia...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="button">Eliminar</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/jsp/EditMyInformation.jsp" %>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts_admin/funcionesProfesor.js"></script>
    </body>
</html>