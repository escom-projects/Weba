var p1 = document.getElementById("p1");
var t1 = document.getElementById("inputTitle");
var b1 = document.getElementById("insert_mul");
var b2 = document.getElementById("insert_check");
var datos = [];
var counter = 0;
var limit = 3;
var counterCheckBox = 0;
var newButt = document.createElement('div');
var newTit = document.createElement('div');

function b1_Click(event){
    var counterRadioButton = 1;
    var titulo = t1.value || '';
    if (!titulo || !titulo.trim().length) {
        alert('debe ingresar un titulo');
        return;
    } else {
        if(counter === 0){
            newButt.innerHTML = "<br><button type='button' class=\"btn btn-success\" id='btG'style='color: white; background-color:#0489B1; border-color:white; border-top-right-radius:5px; border-top-left-radius:5px;'>Guardar Examen</button>";
            document.getElementById("p2").appendChild(newButt);
            newTit.innerHTML = "<br><h1>"+t1.value+"</h1>";
            document.getElementById("p1").appendChild(newTit);
        }
        var newdiv = document.createElement('div');
        var newRE = document.createElement('div');
        var newRE1 = document.createElement('div');
        var newRE2 = document.createElement('div');
        var newRE3 = document.createElement('div');
        newdiv.innerHTML = "<br><b><h3>Pregunta " + (counter + 1) + "</h3></b> <input type=\"text\" class=\"form-control\" name=\"myInputs[]\" placeholder=\"Escribe la pregunta\" required>";
        document.getElementById("p1").appendChild(newdiv);
        newRE.innerHTML = "<br>" + (counterRadioButton ++) +".- <div class=\"col-xs-2 col-lg-6\"> <div class=\"input-group\"><span class=\"input-group-addon\" aria-label=\"...\" disabled><input type=\"radio\" name=\"myRadioButtons[]\"></span><input type=\"text\" name=\"myInputs[]\" class=\"form-control\" placeholder=\"Escribe la respuesta\" required></div></div>";
        document.getElementById("p1").appendChild(newRE);
        newRE1.innerHTML = "<br>"+ (counterRadioButton ++) +".- <div class=\"col-xs-2 col-lg-6\"> <div class=\"input-group\"><span class=\"input-group-addon\" aria-label=\"...\" disabled><input type=\"radio\" name=\"myRadioButtons[]\"></span><input type=\"text\" name=\"myInputs[]\" class=\"form-control\" placeholder=\"Escribe la respuesta\" required></div></div>";
        document.getElementById("p1").appendChild(newRE1);
        newRE2.innerHTML = "<br>"+ (counterRadioButton ++) +".- <div class=\"col-xs-2 col-lg-6\"> <div class=\"input-group\"><span class=\"input-group-addon\" aria-label=\"...\" disabled><input type=\"radio\" name=\"myRadioButtons[]\"></span><input type=\"text\" name=\"myInputs[]\" class=\"form-control\" placeholder=\"Escribe la respuesta\" required></div></div>";
        document.getElementById("p1").appendChild(newRE2);
        newRE3.innerHTML = "<br>"+ (counterRadioButton ++) +".- <div class=\"col-xs-2 col-lg-6\"> <div class=\"input-group\"><span class=\"input-group-addon\" aria-label=\"...\" disabled><input type=\"radio\" name=\"myRadioButtons[]\"></span><input type=\"text\" name=\"myInputs[]\" class=\"form-control\" placeholder=\"Escribe la respuesta\" required></div></div>";
        document.getElementById("p1").appendChild(newRE3);
        counter++;
    }
};
function b2_Click(event){
    var titulo = t1.value || '';

    if (!titulo || !titulo.trim().length) {
        alert('debe ingresar un titulo');
        return;
    } else{
        if(counter === 0) {
            newButt.innerHTML = "<br><button type='button' id=\"btG\" style='color: white; background-color:#0489B1; border-color:white; border-top-right-radius:5px; border-top-left-radius:5px;'>Guardar Examen</button>";
            document.getElementById("p2").appendChild(newButt);
            newTit.innerHTML = "<br><h1>"+t1.value+"</h1>";
            document.getElementById("p1").appendChild(newTit);
        }
        var newD = document.createElement('div');
        var newVE = document.createElement('div');
        var newVE1 = document.createElement('div');
        newD.innerHTML = "<br><b><h3>Pregunta " + (counter + 1) + "</h3></b> <input type=\"text\" class=\"form-control\" name=\"myInputs[]\" placeholder=\"Escribe la pregunta\" required>";
        document.getElementById("p1").appendChild(newD);
        newVE.innerHTML = "<br><input type='radio' name='myRadioButtons[]'> Verdadero";
        document.getElementById("p1").appendChild(newVE);
        newVE1.innerHTML = "<br><input type='radio' name='myRadioButtons[]'> Falso";
        document.getElementById("p1").appendChild(newVE1);
        counter ++;
    }
};
b1.addEventListener('click', b1_Click);
b2.addEventListener('click', b2_Click);