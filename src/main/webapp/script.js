function activar() {
    var tipoAnimal = document.getElementById("tipo").value;
    var campoPerro = document.getElementById("datos_perro");
    var campoGato = document.getElementById("datos_gato");
    if (tipoAnimal === "perro") {
        campoPerro.style.display = "block";
    } else {
        campoPerro.style.display = "none";
    }
    
    if(tipoAnimal === "gato"){
        campoGato.style.display = "block";
    } else {
        campoGato.style.display = "none";
    }
}

function mostrarValorRango(valor) {
    var elemento = document.getElementById("valor_e");
    document.getElementById("nivel_entrenamiento").value = valor;
    elemento.textContent = valor;
}