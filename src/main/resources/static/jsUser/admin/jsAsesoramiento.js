$(window).load(function() {
	listarModulo();
	 
});

function listarModulo() {


	
	$('.tablaEstablecimiento').DataTable({
          "lengthMenu": [
              [3, 50, 100, 200, -1],
              [3, 50, 100, 200, "All"]
          ],
          // "pageLength": 25,
          // "tablaEstablecimiento_length": 10,
      });
      // x = document.getElementById('dataTableProductoCantidadSalida_wrapper');
      // x.children[1].style.marginTop = '1em';

}

$('#btnAgregar').click(function(e) {
    e.preventDefault();
    
//     var path = $("#path").val();

    var modalModulo = $('#modalModulo');
//     modalModulo.find('form').attr('action', path + "/admin/modulo/registrar");
//     modalModulo.find('.modal-header .modal-title').html($(this).attr('title'));
    
//     $('#idmodulo').val('0');
//     $('#estado').val('0');
    
//    limpiarModal();
    modalModulo.modal('show');
});


function editarAsesoramiento(id){

    $('#idsolucitudAsesoramiento').val(id);
    var modalModulo = $('#modalModulo');
    modalModulo.modal('show');

}

$('#btnGuardar').click(function(e) {
	var frm = $('#modalModulo form');
	var enviarCategoria = {
		idsolucitudAsesoramiento : $('#idsolucitudAsesoramiento').val(),
		detalle : $('#detalle').val(),
		estado : $('#estado').val()
	};
	
	console.log(enviarCategoria);
	
	var dataResponse = validateForm('.modal-body input[type="text"][data-req]');
	if (dataResponse.estado === false) {
		jsonToDivError(dataResponse, '#modalModulo #divMessage');
		return;
	}
	console.log("entrando");
	
	$.ajax({
		url : "/asesoramiento/aceptar-solicitud",
		data : JSON.stringify(enviarCategoria),
		type : "POST",
		dataType : 'json',
		contentType : 'application/json',
		success : function(dataResponse) {
		$('#formModulo').trigger("reset");
			if (jsonToDivError(dataResponse, '#modalModulo #divMessage', path)) {
				recargarModulos();
			}
		}
	});
	alert("Estado modificado");
	
	
	console.log("saliendo");
// 		e.preventDefault();
	
	document.location.href = "/asesoramiento/listar";
});

function revertirAsesoramiento(id){
	
	if(confirm("Desea revertir los cambios echos en la solicitud?")){
		
		document.location.href="/asesoramiento/revertir-cambio/"+id;
	}
	
}