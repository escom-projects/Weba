$(document).ready(function () {
    
});

function cargarMaterasDisponibles() {
    $.ajax({
        'url': 'AlumnoServlet',
        'type': 'get',
        'data': { 'accion': 'verMisMaterias' },
        'contentType': "application/json",
        'dataType': "json" 
    }).done(function (data, textStatus, jqXHR) {
        if (textStatus === "success") {
            var txt = "";
            var objeto = eval(data);
            if (objeto.status === "emptyArray") {
                txt += "<tr><td colspan=\"3\"><i>Lo sentimos, el usuario no tiene inscrita la materia</i></td></tr>";
            } else if (objeto.status === "full") {
                var count = 1;
                var lista = objeto.listaMaterias;
                for (var i in lista)
                    txt += "<tr><td>" + (count++) + "</td><td>" + lista[i].nombre + "</td><td>" + lista[i].creditos + "</td></tr>";
            } else if (objeto.status === "nullArray") {
                txt += "<tr><td colspan=\"3\"><i>Lo sentimos, el usuario no tiene inscrita la materia</i></td></tr>";
            }
            $('#rows').html(txt);
        }        
    }).fail(function (status, errorThrown) {
        alert("Estatus del servidor: " + status + "\n" + 
            "Error:" + errorThrown + "\n");
    });
}