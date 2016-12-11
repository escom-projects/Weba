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
                        <li><a href="Redirect?pagina=menu-profesor.jsp">Home</a></li>
                        <li><a href="#">Materias</a></li>
                        <li class="active dropdown">
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
                        <li><a href="Redirect?pagina=profesor/menu-profesor.jsp"><span class="glyphicon glyphicon-user"></span> Profesor</a></li>
                        <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="menu">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="btn-group">
                                   <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span></span>
                                        <div id="form-input">
                                            <input type="text" name="inputTitle" id="inputTitle" class="form-control" placeholder="Inserta el título" required>
                                        </div>
                                    </div>
                                    <a class="btn dropdown-toggle"  data-toggle="dropdown"  id="insert_question" title="Insertar pregunta" aria-expanded="false">
                                        <img alt="Plus" src="imagenes/Add.png">     
                                            Insertar Pregunta
                                        <span class="caret"></span>
                                    </a>
                                    <ul class="dropdown-menu insert_picker_dropdown close_on_ click"> 
                                        <a class="btn action" id="insert_mul">
                                            <div class="btn-text">
                                                <img alt="Application-task" src="imagenes/task.png">
                                                Opci&oacute;n M&uacute;ltiple
                                            </div>
                                        <a class="btn action" id="insert_check">
                                            <div class="btn-text">
                                                <img alt="Cross-tick-small" src="imagenes/cross-tick.png">
                                                Verdadero o Falso
                                             </div>
                                        </a>
                                    </ul><br><br>
                                </div>
                                <div id="p1"></div>
                                <div id="p2"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/scripts_profesor/script_DoExamen.js"></script>
    </body>
</html>