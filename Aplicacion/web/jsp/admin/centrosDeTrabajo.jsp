<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Centros de Trabajo</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="css/css_profesor/estilos.css" rel="stylesheet">
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
                        <li><a href="Redirect?pagina=materias.jsp">Materias</a></li>
                        <li><a href="Redirect?pagina=profesores.jsp">Profesores</a></li>
                        <li><a href="Redirect?pagina=alumnos.jsp">Alumnos</a></li>
                        <li class="active"><a href="Redirect?pagina=centrosDeTrabajo.jsp">Centros de Estudios</a></li>
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
            <div class="row">
                <div class="pagina">
                    <div class="col-md-5">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <h2>Registro de centros de trabajo</h2>
                            </div>
                            <div class="panel-body">
                                <form id="formulario-registro-centros-de-trabajo" name="formulario-registro-centros-de-trabajo" action="CentroDeTrabajoServlet" method="post">
                                    <div class="form-group">
                                        <label>Nombre centro de trabajo:</label>
                                        <input type="text" class="form-control" id="centro_trabajo" name="centro_trabajo" placeholder="Escribe el nombre del centro de trabajo.">
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary" name="btnGuardarCT" id="btnGuardarCT">Guardar</button>                                  
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-6">
                        <table class="table table-responsive table-hover">
                            <thead>
                                <th>No.</th>
                                <th>Nombre centro de trabajo</th>
                                <th>Carreras</th>
                            </thead>
                            <tbody id="rows">
                                <c:set var="numRow" value="0" scope="page" />
                                <c:choose>
                                    <c:when test="${fn:length(listaCES) > 0}">
                                        <for:each var="ce" items="${listaCES}">
                                            <tr>
                                                <td>
                                                    <c:set var="numRow" value="${numRow + 1}" scope="page"/>
                                                    <c:out value="${numRow}" />
                                                </td>
                                                <td>
                                                    <c:out value="${ce.nombreCentroDeTrabajo}" />
                                                </td>
                                                <td>
                                                    <button class="btn btn-danger" id="btnEliminar" name="btnEliminar" onclick="javascript: deleteCE(<c:out value="${ce.idcentrodetrabajo}" />)">
                                                        <span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;Eliminar
                                                    </button>
                                                </td>
                                            </tr>
                                        </for:each>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="3"><i>No has registrado centros de trabajo</i></td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/jsp/EditMyInformation.jsp" %>
        <script type="text/javascript" src="js/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/ie-emulation-modes-warning.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/ie10-viewport-bug-workaround.js"></script>
        <script type="text/javascript" src="js/scripts_admin/funcionesAlumno.js"></script>
    </body>
</html>
