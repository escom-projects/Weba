$(document).ready(function () {
    $( "#error" ).hide();
    $( "#signin-form" ).validate( {
        rules: {
            inputNick: {
                required: true,
                minlength: 3
            },
            inputPassword: {
                required: true,
                minlength: 3
            }
        },
        messages: {
            inputNick: {
                required: "Ingese su nombre de usuario<br/>",
                minlength: "tu nombre de usuario debe consistir cuando menos de 3 caracteres<br/>"
            },
            inputPassword: {
                required: "Ingrese su contrase&ntilde;a<br/>",
                minlength: "Tu contrase&ntilde;a debe ser de cuando menos 3 carcateres<br/>"
            }
        },
        errorElement: "em",
        /*errorPlacement: function ( error, element ) {
            // Add the `help-block` class to the error element
            error.addClass( "help-block" );

            error.insertAfter( element.parent( ".input-group" ) );
        },*/
        errorLabelContainer: $("#signin-form div.alert"),
        highlight: function ( element, errorClass, validClass ) {
            $( element ).parents( "#form-input" ).addClass( "has-error" ).removeClass( "has-success" );
        },
        unhighlight: function (element, errorClass, validClass) {
            $( element ).parents( "#form-input" ).addClass( "has-success" ).removeClass( "has-error" );
        }
    } );
});