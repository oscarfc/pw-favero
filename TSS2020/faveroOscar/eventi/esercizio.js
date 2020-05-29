/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.querySelector("#pulsante1").onclick = function () {
    alert("ciao da " + "oscar");
};

document.querySelector("#pulsante2").onclick = function () {
    document.queryselector("#lavagna").style().color = "green";
    document.queryselector("#lavagna").style().fontSize = "40pxl";
};


document.querySelector("#pulsante3").onclick = function () {
    var lettera = window.prompt("Inserisci lettera: ");
    alert("Hai digitato la lettera: " + lettera);
};

document.querySelector("#pulsante4").onclick = function () {
    document.querySelector("body").style.backgroundColor = "red";
};
