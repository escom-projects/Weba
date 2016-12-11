$(document).ready(function () {
    
});

function cargarAlumnos() {
    $.ajax({
        'url': "AlumnosServlet",
        'type': "get",
        'data': { 'accion': 'readAll' },
        'contentType': 'application/json',
        'dataType': "json"
    }).done(function (data, textStatus, jqXHR) {
        if (textStatus === "success") {
            var obj = eval(data);
            var row = "";
            var count = 1;
            var list = obj.listaAlumnos;
            if (obj.status === "full") {
                for (var i in list) {
                    row += "<tr>";
                    row += "<td>" + (count++) + "</td>";
                    row += "<td>" + list[i].nombre + "</td>";
                    row += "<td>" + list[i].correo + "</td>";
                    row += "<td>" + list[i].nickUsuario + ", " + list[i].claveUsuario + "</td>";
                    row += "<td><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModalA\">Añadir</button></td>";
                    row += "<td><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModalE\">Eliminar</button></td>";
                    row += "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"javascript: bajaAlumno(" + 
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
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("Ha ocurrido un error de comunicacion con el servidor. Intentelo mas tarde.\n" +
              "Error: " + errorThrown + "\n" +
              "Estatus del servidor: " + textStatus);
    });
}

function bajaAlumno(id, nickUsuario, claveUsuario) {
    $.ajax({
        'url': "AlumnosServlet",
        'type': "get",
        'data': { 
            'accion': 'eliminar',
            'id': id,
            'nickUsuario': nickUsuario,
            'claveUsuario': claveUsuario
        },
        'contentType': 'application/json',
        'dataType': "json"
    }).done(function (data, txtstatus, jqXHR) {
        
    }).fail(function (jqXHR, textStatus, errorThrown) {
        alert("Ha ocurrido un error de comunicacion con el servidor. Intentelo mas tarde.\n" +
              "Error: " + errorThrown + "\n" +
              "Estatus del servidor: " + textStatus);
    });
}