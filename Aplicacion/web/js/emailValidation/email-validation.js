$(document).ready(function () {
    $( "#error" ).hide();
    $("#enviarDatos").click(function () {
        $.ajax({
            'url': "AyudaServlet",
            'type': "get",
            'data': {
                'accion': "forgotAccesDatos",
                'email': $("#email").val()
            },
            'contentType': 'application/json',
            'dataType': "json"
        }).done(function (data, textStatus, jqXHR) {
            if (textStatus === "success") {
                var response = eval(data);
                $( '#error' ).removeClass("alert alert-danger alert-dismissible");
                $( '#error' ).removeClass("alert alert-info alert-dismissible");
                $( '#error' ).removeClass("alert alert-warning alert-dismissible");
                if (response.userNotRegistered) {
                    $( '#error' ).addClass("alert alert-danger alert-dismissible");
                    $( '#error' ).html("Ha ocurrido un <strong>error</strong>. Su correo no ha sido registrado o no se ha registrado en nuestro sistema.");
                } else if (response.emailNotSent) {
                    $( '#error' ).addClass("alert alert-warning alert-dismissible");
                    $( '#error' ).html("Hemos registrado sus datos, pero ocurrio un error al enviarle su correo.  " + textStatus);
                } else if (!response.emailNotSent) {
                    $( '#error' ).addClass("alert alert-info alert-dismissible");
                    $( '#error' ).html("Hemos registrado sus datos. Hemos enviado sus datos a su correo. ");
                } else if (response.nullPointerError) {
                    $( '#error' ).addClass("alert alert-danger alert-dismissible");
                    $( '#error' ).html("Ha ocurrido un <strong>error</strong>. Su correo no ha sido registrado o no se ha registrado en nuestro sistema.");
                }
                $( "#error" ).show();
                setTimeout(function() {
                    $( '#error' ).fadeOut(1500);
                }, 10000);
            }
        }).fail(function (jqXHR, textStatus, errorThrown) {
            $( '#error' ).addClass("alert alert-danger alert-dismissible");
            $( '#error' ).html("Ha ocurrido un <strong>error</strong> con el servidor: " + textStatus);
        });
    });
    $( "#form-actualizacion" ).validate( {
        rules: {
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            email: {
                required: "Ingrese su correo electr&oacute;nico.<br/>",
                email: "Introduzca un correo v&aacute;lido<br/>"
            }
        },
        errorElement: "em",
        errorPlacement: function ( error, element ) {
            error.addClass( "help-block" );
            element.parents( "#campo" ).addClass( "has-feedback" );
            error.insertAfter( element );
            if ( !element.next( "span" )[ 0 ] ) {
                $( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( "#campo" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( "#campo" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
        }
    } );
});