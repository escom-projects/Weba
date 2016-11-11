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
            <div class="panel panel-default">
                <div class="panel-heading">Lista de Materias</div>
                <table class="table">
                  <tr>
                    <th>#</th>
                    <th>Materia</th> 
                    <th>Eliminar materia</th> 
                  </tr>
                  <tr>
                    <td>1</td>
                    <td>Desarrollo de aplicaciones web</td> 
                    <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Eliminar</button></td>
                  </tr>
                  <tr>
                    <td>2</td>
                    <td>Compiladores</td> 
                    <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Eliminar</button></td>
                  </tr>
                </table>
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
        
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>