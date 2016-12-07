$(document).ready(function () {
    $( '#mensajes' ).hide();//AddMateria
    $( "#sendRequest" ).click( function () {
        $.ajax({
//            'url': 'AddMateria',
            'url': 'AddMateria',
            'type': 'post',
            'data': $( '#addAsignature' ).serialize()
        }).done(function ( dataMsg ) {
            var estadoSolicitud = eval(dataMsg);
            var mensaje;
            $( '#mensajes' ).removeClass("alert alert-success alert-dismissible");
            $( '#mensajes' ).removeClass("alert alert-danger alert-dismissible");
            if (estadoSolicitud.Estado === "OK") {
                $( '#mensajes' ).addClass("alert alert-success alert-dismissible");
                mensaje = "<strong>Insercion exitosa</strong>. Se ha agregado una nueva asignatura!!!";
            } else if (estadoSolicitud.Estado === "Failed") {
                $( '#mensajes' ).addClass("alert alert-danger alert-dismissible");
                mensaje = "<strong>Insercion fallida</strong>. Se ha agregado una nueva asignatura!!!";
            }
            $( '#mensajes' ).html(mensaje);
            $( '#mensajes' ).show();
            setTimeout(function() {
                $( '#mensajes' ).fadeOut(1500);
            },5000);
            $('#agregarMateria').modal('hide');
        }).fail(function ( jqXHR, textStatus, errorThrown ) {
            $( '#mensajes' ).addClass("alert alert-danger alert-dismissible");
            $( '#mensajes' ).html("Ha ocurrido un <strong>error</strong> con el servidor: " + textStatus);
        });
    } );
    $( '#btnReload' ).click(function () {
        location.reload();
    });
    $('#addAsignature').validate({
        rules: {
            asignature_name: {
                required: true,
                minlength: 4
            },
            creditos_text: {
                required: true,
                minlength: 1,
                maxlength: 3,
                number: true
            }
        },
        messages: {
            asignature_name: {
                required: "*Campo obligatorio.",
                minlength: "Se requieren 4 caracteres como m&iacute;nimo."
            },
            creditos_text: {
                required: "*Campo obligatorio.",
                minlength: "Se necesita especificar un valor.",
                maxlength: "Se requieren como maximo 3 digitos.",
                number: "Especifica un numero v&aacute;lido."
            }
        },
        errorElement: "em",
        errorPlacement: function ( error, element ) {
            error.addClass( "help-block" );
            element.parents( "#input" ).addClass( "has-feedback" );
            error.insertAfter( element.parent( "div" ) );
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( "#input" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( "#input" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
        }
    });
});

function cargar() {
    $.ajax({
        'url': "cargarMaterias",
        'type': "get",
        'contentType': 'application/json',
        'dataType': "json"
    }).done(function (data) {
        var obj = eval(data);
        var row = "";
        var count = 1;
        for (var i in obj) {
            row += "<tr>";
            if (obj[i].status === "full") {
                row += "<td>" + (count++) + "</td>";
                row += "<td>" + obj[i].nombre + "</td>";
                row += "<td>" + obj[i].creditos + "</td>";
                row += "<td><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">Eliminar</button></td>";
            } else if (obj[i].status === "empty") {
                row += "<td colspan='3'>Lo sentimos, no hay materias registradas</td>";
            } else if (obj[i].status === "error") {
                row += "<td colspan='3'>Lo sentimos, ha ocurrido un error interno en el servidor</td>";
            }
            row += "</tr>";
        }
        $("#rows").html(row);
    }).fail(function (status, errorThrown) {
        alert("Estatus del servidor: " + status + "\n" + 
              "Error:" + errorThrown + "\n");
    });
}