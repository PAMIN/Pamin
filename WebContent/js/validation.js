function mascara(o, f) {
	v_obj = o;
	v_fun = f;
	setTimeout("execmascara()", 1);

}

function execmascara() {
	v_obj.value = v_fun(v_obj.value);
}

function leech(v) {
	v = v.replace(/o/gi, "0");
	v = v.replace(/i/gi, "1");
	v = v.replace(/z/gi, "2");
	v = v.replace(/e/gi, "3");
	v = v.replace(/a/gi, "4");
	v = v.replace(/s/gi, "5");
	v = v.replace(/t/gi, "7");
	return v;
}

/* PARA AUTO COMPLETAR A DATA E SO PERMITIR QUE NUMEROS SEREM DIGITADOS */
function data(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/^(\d{2})(\d)/, "$1-$2"); // Coloca barra entre o 2° e o 3°
	// digito
	v = v.replace(/(\d{2})(\d)/, "$1-$2"); // Coloca barra entre o 4° e o 5°
	// dígito
	return v;
}

/* PARA AUTO COMPLETAR A HORA E SO PERMITIR QUE NUMEROS SEREM DIGITADOS */
function hora(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	/*
	 * v=v.replace(/^(\d{2})(\d)/,"$1:$2") //Coloca barra entre o 2° e o 3°
	 * digito
	 */
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1:$2"); // Coloca virgula entre o 3°
	// e o
	// 4° digito
	return v;
}

/* PARA AUTO COMPLETAR O VALOR E SO PERMITIR QUE NUMEROS SEREM DIGITADOS */
function valor(v) {
	v = v.replace(/\D/g, ""); // Remove tudo o que não é dígito
	v = v.replace(/(\d{1})(\d{1,2})$/, "$1,$2"); // Coloca virgula entre o 3°
	// e o
	// 4° digito
	return v;
}

/* PERMITIR QUE APENAS NUMEROS SEREM DIGITADOS */
function Numero(e) {
	navegador = /msie/i.test(navigator.userAgent);
	if (navegador)
		var tecla = event.keyCode;
	else
		var tecla = e.which;

	if (tecla > 47 && tecla < 58 || tecla == 44 || tecla == 46) // numeros de 0
		// e ponto(46)
		return true;
	else {
		if (tecla != 8) // backspace
			return false;
		else
			return true;
	}
}

function validaData() {
	var data_1 = document.getElementById("data1").value;
	var data_2 = document.getElementById("data2").value;
	var Compara01 = parseInt(data_1.split("/")[2].toString()
			+ data_1.split("/")[1].toString() + data_1.split("/")[0].toString());
	var Compara02 = parseInt(data_2.split("/")[2].toString()
			+ data_2.split("/")[1].toString() + data_2.split("/")[0].toString());

	alert(Compara01);
	if ((Compara01 < Compara02) || (Compara01 == Compara02)) {
		document.getElementById("msg").innerHTML = "OK";
	} else {
		document.getElementById("msg").innerHTML = "Data final deve ser maior que a inicial!";
		document.form1.data1.focus;
		return false;
	}

}

function confere() {
	document.getElementById('maisInfo').disabled = !document
			.getElementById('ck_permissao').checked;

}

function verifica() {
	if (document.getElementById('ck_permissao').checked != true) {
		document.getElementById('cadastro').disabled = false;
	}
	/*
	 * if(document.getElementById('ck_permissao').checked != true) {
	 * alert('precisa aceitar os termos antes'); return false; }else{
	 * document.getElementById('cadastro').disabled = false; return true }
	 */

}

var map;
var geocoder;

function initialize() {
	if (GBrowserIsCompatible()) {
		map = new GMap2(document.getElementById("map_canvas"));
		map.setCenter(new GLatLng(-7.111, -34.861), 15); // Centro de JP e
															// Zoom
		map.addControl(new GSmallZoomControl());
		geocoder = new GClientGeocoder();
		GEvent.addListener(map, "click", clicked);
	}
};

function clicked(overlay, latlng) {

	if (latlng) {
		geocoder.getLocations(latlng, function(addresses) {
			if (addresses.Status.code != 200) {
				alert("Endere�o n�o encontrado!" + latlng.toUrlValue());
			} else {

				address = addresses.Placemark[0];

				marker = new GMarker(latlng);
				map.clearOverlays();
				map.addOverlay(marker);

				var myHtml = address.address;

				var rua = myHtml.split(" - ");
				rua[1] = rua[1].split(", ");
				document.getElementById("form:logradouro").value = rua[0];
				document.getElementById("form:bairro").value = rua[1][0];
				document.getElementById("form:cidade").value = rua[1][1];

			}
		});
	}
};