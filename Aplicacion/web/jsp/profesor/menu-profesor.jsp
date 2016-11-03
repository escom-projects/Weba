<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu de profesores</title>
    </head>
    <body>
        <h1>Hola soy el profesor <%=request.getSession().getAttribute("usuario")%></h1>
    </body>
</html>
