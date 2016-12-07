$(document).ready(function () {
    
});

function cargarMaestros() {
    $.ajax({
        'url': "cargarProfesores",
        'type': "get",
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