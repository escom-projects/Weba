$(document).ready(function () {
    
});

function cargarProfesores() {
    $.ajax({
        'url': "ProfesoresServlet",
        'type': "get",
        'data': {'accion': "readAll"},
        'contentType': "application/json",
        'dataType': "json"        
    }).done(function (data, textStatus, jqXHR) {
        if (textStatus === "success") {
            var obj = eval(data);
            var row = "";
            var count = 1;
            var list = obj.listaProfesores;
            if (obj.status === "full") {
                for (var i in list) {
                    row += "<tr>";
                    row += "<td>" + (count++) + "</td>";
                    row += "<td>" + list[i].nombre + "</td>";
                    row += "<td>" + list[i].correo + "</td>";
                    row += "<td>" + list[i].nickUsuario + ", " + list[i].claveUsuario + "</td>";
                    row += "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"javascript: eliminarProfesor(" + 
                        list[i].ID + ", '" + list[i].nickUsuario + "', '" + list[i].claveUsuario + "');\">Eliminar</button></td>";
                    row += "</tr>";
                }
            } else if (obj.status === "emptyArray") {
                row += "<tr><td colspan='5'>Lo sentimos, no existen usuarios profesores registrados</td></tr>";
            } else if (obj.status === "error") {
                row += "<tr><td colspan='5'>Lo sentimos, ha ocurrido un error interno en el servidor</td></tr>";
            }
            $("#rows").html(row);
        }
    }).fail(function (status, errorThrown) {
        alert("Estatus del servidor: " + status + "\n" + 
            "Error:" + errorThrown + "\n");
    });
}

function modificarAcceso(id, nickUsuario, claveUsuario) {
    $.ajax({
        'url': "ProfesoresServlet",
        'type': "get",
        'data': {
            'accion': "eliminar",
            'id': id,
            'nickUsuario': nickUsuario,
            'claveUsuario': claveUsuario
        },
        'contentType': "application/json",
        'dataType': "json"        
    }).done(function (data, textStatus, jqXHR) {
        var obj = eval(data);
        if (textStatus === "success") {
            alert(obj.status);
        }
    }).fail(function (status, errorThrown) {
        alert("Estatus del servidor: " + status + "\n" + 
            "Error:" + errorThrown + "\n");
    });
}

function eliminarProfesor(id, nick, clave) {
    $.ajax({
        'url': "ProfesoresServlet",
        'type': "get",
        'data': {
            'accion': "eliminar",
            'id': id
        },
        'contentType': "application/json",
        'dataType': "json"        
    }).done(function (data, textStatus, jqXHR) {
        var obj = eval(data);
        if (textStatus === "success") {
            if (obj.Estado === "OK") {
                alert("¡Profesor eliminado!");
                window.location.href = "Redirect?pagina=profesores.jsp";
            } else {
                alert("¡Ocurrio un error al eliminar profesor!");
                window.location.href = "Redirect?pagina=menu-admin.jsp";
            }
        }
    }).fail(function (status, errorThrown) {
        alert("Estatus del servidor: " + status + "\n" + 
            "Error:" + errorThrown + "\n");
    });
}