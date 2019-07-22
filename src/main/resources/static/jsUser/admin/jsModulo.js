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

    modalModulo.modal('show');
});

$('input:radio').change(function() {
	if ($("#activo").prop("checked")) {
		$('#estado').val('1');
		$('#activo').parent().addClass('btn-primary');
		$('#inactivo').parent().removeClass('btn-primary');
	} else {
		$('#estado').val('0');
		$('#inactivo').parent().addClass('btn-primary');
		$('#activo').parent().removeClass('btn-primary');
	}
});

$('#btnGuardar').click(function(e) {
	var frm = $('#modalModulo form');
	var enviarCategoria = {
		idcategoria : $('#idmodulo').val(),
		nombre : $('#nombre').val(),
		icono : $('#icono').val(),
		estado : $('#estado').val()
	};
	var dataResponse = validateForm('.modal-body input[type="text"][data-req]');
	if (dataResponse.estado === false) {
		jsonToDivError(dataResponse, '#modalModulo #divMessage');
		return;
	}
	console.log("entrando");
	$.ajax({
		url : "/admin/modulo/registrar",
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
	console.log("saliendo");
// 		e.preventDefault();
	alert("Modulo registrado");
	document.location.href = "/admin/modulo/listar";
});

function eliminarModulo(id){
	
	if(confirm("Desea eliminar el modulo?")){
		
		document.location.href="/admin/modulo/eliminar/"+id;
	}
	
}

function estadoModulo(id){
	
	if(confirm("Desea cambiar el estado del modulo?")){
		
		document.location.href="/admin/modulo/estado/"+id;
	}
	
}
