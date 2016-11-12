$.validator.setDefaults( {
    submitHandler: function () {
        alert( "submitted!" );
    }
} );

$( function() {
    $( "#fechaNacimiento" ).datepicker();
    $( "#fechaNacimiento" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
    
    $( "#form-registro-clientes" ).validate( {
        rules: {
            matricula: {
                required: true,
                minlength: 3,
                maxlength: 15,
                number: true
            },
            nombre: "required",
            ap_paterno_usuario: "required",
            ap_materno_usuario: "required",
            correo_usuario: {
                required: true,
                email: true
            },
            sexo: {
                required: true
            },
            fechaNacimiento: {
                required: true,
                date: true
            },
            cp: {
                required: true,
                minlength: 5,
                number: true
            },
            calle: "required",
            numero: {
                required: true,
                number: true,
                minlength: 3
            },
            colonia: "required",
            nombre_usuario: {
                required: true,
                minlength: 5
            },
            clave_usuario: {
                required: true,
                minlength: 5
            },
            tipo_usuario: {
                required: true
            },
            agree: "required"
        },
        messages: {
            matricula: {
                required: "Campo obligatorio",
                minlength: "Error, m&iacute;nimo 3 digitos",
                maxlength: "Error, m&aacute;ximo 15 digitos",
                number: "Introducir un numero v&aacute;lido"
            },
            nombre: "Favor de introducir su nombre",
            ap_paterno_usuario: "Introduce tu apellido paterno",
            ap_materno_usuario: "Introduce tu apellido materno",
            correo_usuario: {
                required: "Correo inv&aacute;lido!"
            },
            sexo: {
                required: "Elegir opcion"
            },
            fechaNacimiento: {
                required: "Formato de fecha incorrecta"
            },
            cp: {
                required: "Codigo postal incorrecto",
                minlength: "Favor de introducir cuando menos 5 digitos"
            },
            calle: "Campo obligatorio",
            numero: {
                required: "Campo obligatorio",
                minlength: "Favor de introducir cuando menos 3 digitos"
            },
            colonia: "Campo obligatorio",
            nombre_usuario: {
                required: "Favor de introducir su nombre de usuario",
                minlength: "Debes proveer cuando menos 5 carcateres de longitud"
            },
            clave_usuario: {
                required: "Favor de introducir su contrase&ntilde;a",
                minlength: "Debes proveer cuando menos 5 carcateres de longitud"
            },
            tipo_usuario: {
                required: "Selecciona algun elemento"
            },
            agree: "Debes aceptar los t&eacute;rminos"
        },
        errorElement: "em",
        errorPlacement: function ( error, element ) {
            error.addClass( "help-block" );

            element.parents( "#campo" ).addClass( "has-feedback" );

            if ( element.prop( "type" ) === "checkbox" ) {
                error.insertAfter( element.parent( "div" ) );
            } else if( element.prop( "type" ) === "radio" ) {
                error.insertAfter( element.parent( "div" ) );
            } else {
                error.insertAfter( element );
            }

            // Add the span element, if doesn't exists, and apply the icon classes to it.
            if ( !element.next( "span" )[ 0 ] ) {
                $( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
            }
        },
        success: function ( label, element ) {
            if ( !$( element ).next( "span" )[ 0 ] ) {
                $( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
            }
        },
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( "#campo" ).addClass( "has-error" ).removeClass( "has-success" );
            $( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
        },
        unhighlight: function ( element, errorClass, validClass ) {
            $( element ).parents( "#campo" ).addClass( "has-success" ).removeClass( "has-error" );
            $( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
        }
    } );
} );