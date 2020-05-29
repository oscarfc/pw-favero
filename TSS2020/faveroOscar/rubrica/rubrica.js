/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
struttura = {};
url = "rubrica.json";

//programmazione asincrona (eventi)
//promise
fetch(url).then(function (response) {

    //promise
    return response.json();

}).then(function (json) {
    console.log("struttura letta da " + url, json);

    //struttura (contenuto del file esterno trasformato in oggetto js (JSON.parse))
    struttura = json;
    inizio();

}).catch(function (error) {
    console.error('Error:', error);
});

var indice = -1;

document.querySelector("#indietro").onclick = function () {
    if (indice > 0)
        indice--;
    else
        indice = struttura.length - 1;
    stampa(indice);
};

document.querySelector("#avanti").onclick = function () {
    console.log("indice: " + indice + "struttura " + struttura.length);
    if (indice < struttura.length - 1)
        indice++;
    else
        indice = 0;
    stampa(indice);
};

//document.querySelector("#nome").onchange = function () {
//    console.log(document.querySelector("#nome").value);
//};
//
//document.querySelector("#cognome").onchange = function () {
//    console.log(document.querySelector("#cognome").value);
//};

document.querySelectorAll("input[type=text]").forEach(function (elm, i, arr) {
    elm.onchange = function () {
        let id = elm.id;
        let valore = elm.value;
        let indice = parseInt(document.querySelector("label#indice").innerHTML) - 1;
        console.log("evento change", id, valore, indice);
        struttura[struttura.length][id] = valore;
        console.log(struttura.length);
    };
});

//document.querySelector("#modifica").onclick = function () {
//   var modificati = document.querySelectorAll("input[type=text]").onchange;
//   console.log(modificati.length);
//        modificati.forEach(function(e) { 
//                console.log(e);
//            });
//};

document.querySelector("#inserisci").onclick = function () {
    document.querySelector("#indice").innerHTML = struttura.length;
    document.querySelectorAll("input[type=text]").forEach(function (elm) {
        elm.value = "";
    });
    struttura[struttura.length] = {};
};

function stampa(n) {
    document.querySelector("#nome").value = struttura[n]["nome"];
    document.querySelector("#cognome").value = struttura[n]["cognome"];
    document.querySelector("#indirizzo").value = struttura[n]["indirizzo"];
    document.querySelector("#citta").value = struttura[n]["citta"];
    document.querySelector("#telefono").value = struttura[n]["telefono"];
    document.querySelector("#indice").innerHTML = n + 1;
}

function inizio() {
    stampa(++indice);
}

