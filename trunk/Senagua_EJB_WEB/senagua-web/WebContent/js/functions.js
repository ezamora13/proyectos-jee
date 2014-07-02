/*
 *
 * JS AND JQUERY FUNCTIONS
 * @autor Jorge Tenorio
 * @fecha 30-05-2012 
 */

function sendPage(form, destination, div) {
	// alert(div);
	var parametros;
	if (form != 'null') {
		var param = $("#" + form).serialize();

		// serializar a objeto
		var campos = param.split("&");
		var data = "{";
		for ( var i = 0; i < campos.length; i++) {
			temp = campos[i].split("=");
			data = data + temp[0] + ': "' + temp[1] + '"';
			if (i < campos.length - 1) {
				data = data + ",";
			}
		}
		data = data + "}";
		parametros = eval("(" + data + ")");
	} else {
		parametros = eval("({data: 0})");
	}

	if (destination == '#') {
		destination = '#';
	}

	$("#" + div).addClass('msgInfo');
	$("#" + div).html('<div  id="loading" style="margin:0 auto;"><img src="../../img/arbol/ajax-loader.gif"></div>');
	$("#" + div).removeClass('msgInfo');

	$("#" + div).load(destination, parametros, function() {
		//alert("bla blabla");
	});
}

function popUp(url, title, width, height) {
	newWindow = window.open(url, title,
			"location=1,status=1,scrollbars=0,width=" + width + ",height="
					+ height);
	newWindow.moveTo(0, 0);
}

