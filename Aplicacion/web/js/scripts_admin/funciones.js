$(document).ready(function () {
    $( '#mensajes' ).hide();//AddMateria
    $( "#sendRequest" ).click( function () {
        $.ajax({
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
        errorPlacement: function ( error, element ) {
            error.addClass( "help-block" );
            element.parents( "#input" ).addClass( "has-feedback" );
            error.insertAfter( element.parent( "#input" ) );
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( "#form-input" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( "#form-input" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
        }
    });
});