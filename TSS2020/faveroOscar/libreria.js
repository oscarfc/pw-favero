/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function loadScript(src) {
                var script = document.createElement('script');
                script.onload = function () {
                    console.log("loadscript", src);
                };
                if (src.indexOf("?") === -1) {
                    script.src = src + "?" + Math.random();
                } else {
                    script.src = src + "&" + Math.random();
                }
                document.body.appendChild(script);
            }
