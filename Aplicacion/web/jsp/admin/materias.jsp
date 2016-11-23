<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/menu_admin.css" rel="stylesheet">
    </head>
    <body onload="javascript: cargar();">
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
                        <li class="active"><a href="Redirect?pagina=materias.jsp">Materias</a></li>
                        <li><a href="Redirect?pagina=profesores.jsp">Profesores</a></li>
                        <li><a href="Redirect?pagina=alumnos.jsp">Alumnos</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="Redirect?pagina=menu-admin.jsp"><span class="glyphicon glyphicon-user"></span> Administrador</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <br><br><br><br>
            <div class="row">
                <div id="mensajes" role="alert"></div>
            </div>
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="media">
                            <div class="media-left">
                                Lista de Materias
                            </div>
                            <div class="media-body">
                                <div class="col-md-8"></div>
                            </div>
                            <div class="media-right">
                                <button class="btn btn-success btn-block" data-toggle="modal" data-target="#agregarMateria"><span class="glyphicon glyphicon-plus"></span>&nbsp;Agregar</button>
                            </div>
                        </div>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <th>#</th>
                            <th>Materia</th>
                            <th>Cr&eacute;ditos</th>
                            <th>Acciones</th>
                        </thead>
                        <tbody id="rows"></tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Eliminar Materia</h4>
                    </div>
                    <div class="modal-body">
                        ¿Seguro que quieres eliminar _____?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary">Eliminar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal -->
        <div class="modal fade" id="agregarMateria" tabindex="-1" role="dialog" aria-labelledby="agregarModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="agregarModalLabel">Agregar nueva asignatura: </h4>
                    </div>
                    <div class="modal-body">
                        <form id="addAsignature" name="addAsignature">
                            <div class="form-group">
                                <label for="asignature_name" class="control-label">Nombre asignatura:</label>
                                <div id="input">
                                    <input type="text" class="form-control" id="asignature_name" name="asignature_name">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="creditos_text" class="control-label">Cr&eacute;ditos:</label>
                                <div id="input">
                                    <input type="number" class="form-control" id="creditos_text" name="creditos_text">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" class="btn btn-primary" name="sendRequest" id="sendRequest">Enviar solicitud</button>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/validator/jquery.validate.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts_admin/funciones.js"></script>
    </body>
</html>