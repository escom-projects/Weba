<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrador</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
        
        <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
        
        
    </head>
    <body>
        <!--nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Practica 02</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Ayuda</a></li>
                        <li class="active"><a href="#">Cerrar Sesión<span class="sr-only">(current)</span></a></li>
                    </ul>
                </div>
            </div>
            <br><br><br><br><br><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
        </nav-->
        
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
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Materias</a></li>
                <li><a href="#">Profesores</a></li>
                <li><a href="#">Alumnos</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Administrador</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="container">
            <br><br>
            <div class="alert alert-info" role="alert">¡Bienvenido, <%=request.getSession().getAttribute("usuario")%>!</div>
            
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-hover" id="tab_logic">
                            <thead>
                                <tr >
                                    <th class="text-center">
                                        #
                                    </th>
                                    <th class="text-center">
                                        Materia
                                    </th>
                                   
                                </tr>
                            </thead>
                            <tbody>
                                <tr id='addr0'>
                                    <td>
                                    1
                                    </td>
                                    <td>
                                        <input type="text" name='name0'  placeholder='Nombre de materia' class="form-control"/>
                                    </td>
                                </tr>
                                <tr id='addr1'></tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <a class="btn btn-default pull-left btn-primary">Actualizar</a>
                <a id='delete_row' class="pull-right btn btn-default">Borrar materia</a><a id="add_row" class="btn btn-default pull-right">Agregar otra materia</a>
                <br><br><br>
            
                      
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th style="width: 36px;"></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>Mark</td>
          <td>Tompson</td>
          <td>the_mark7</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        <tr>
          <td>2</td>
          <td>Ashley</td>
          <td>Jacobs</td>
          <td>ash11927</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        <tr>
          <td>3</td>
          <td>Audrey</td>
          <td>Ann</td>
          <td>audann84</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        <tr>
          <td>4</td>
          <td>John</td>
          <td>Robinson</td>
          <td>jr5527</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        <tr>
          <td>5</td>
          <td>Aaron</td>
          <td>Butler</td>
          <td>aaron_butler</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
        <tr>
          <td>6</td>
          <td>Chris</td>
          <td>Albert</td>
          <td>cab79</td>
          <td>
              <a href="user.html"><i class="icon-pencil"></i></a>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
          </td>
        </tr>
      </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="#">Prev</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</div>
            
                        
        </div>
        
        
        <script src="js/ie10-viewport-bug-workaround.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
