var ruolo = document.getElementById("ruolo").getAttribute("data-ruoli");
setTimeout(function(){
	document.getElementById("nome").innerHTML = '';
	document.getElementById("ruolo").innerHTML = ruolo;
},3500);