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
    
    limpiarModal();
    modalModulo.modal('show');
});

function limpiarModal(){
	$('#btnGuardar').html('Guardar cambios');
    $('#btnGuardar').attr('class','btn btn-primary');
    $('#estado').val('');
    $('#nombre').val('');
    $('#icono').val('');
    $('#idmodulo').val('');
	$('#inactivo').parent().removeClass('btn-primary');
	$('#activo').parent().removeClass('btn-primary');
}

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
		idmodulo : $('#idmodulo').val(),
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
	if($('#btnGuardar').text() == 'Guardar cambios'){
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
		alert("Modulo registrado");
	}else{
		$.ajax({
			url : "/admin/modulo/actualizar",
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
		alert("Modulo actualizado");
	}
	
	console.log("saliendo");
// 		e.preventDefault();
	
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

function editarModulo(id){

    $('#'+id).children("td").each(function (index) {
        switch (index) {
            case 0:
                $('#nombre').val($(this).text());
                break;
            case 1:
            	$('#icono').val($(this).text());
                break;
            case 2:
            	estado = $(this).text();
            	if(estado==1){
            		$('#estado').val('1');
            		$('#activo').parent().addClass('btn-primary');
            		$('#inactivo').parent().removeClass('btn-primary');
            	}else{
            		$('#estado').val('0');
            		$('#inactivo').parent().addClass('btn-primary');
            		$('#activo').parent().removeClass('btn-primary');
            	}
                break;
        }

    });
    $('#idmodulo').val(id);
    var modalModulo = $('#modalModulo');
    $('#btnGuardar').html('Actualizar cambios');
    $('#btnGuardar').attr('class','btn btn-warning');
    modalModulo.modal('show');

}