package pe.edu.unsch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unsch.entities.Modulo;
import pe.edu.unsch.entities.SolucitudAsesoramiento;
import pe.edu.unsch.entities.Usuario;
import pe.edu.unsch.service.AsesoramientoService;
import pe.edu.unsch.service.UsuarioService;
import pe.edu.unsch.util.JsonResponse;

@Controller
@RequestMapping("/asesoramiento")
public class AsesoramientoController {

	@Autowired
	private AsesoramientoService asesoramientoService;
	
	@GetMapping
	public String principal(Model model) {
		return "views/admin/asesoramiento/index";
	}
	
	@Autowired
	private UsuarioService usuarioService;
	
	private JsonResponse jsonResponse;
	
	@GetMapping("/listar")
	public String listar(Model model) {
//		String docente = "docente";
//		Usuario usuario = (Usuario) usuarioService.detalle(docente);
		List<SolucitudAsesoramiento> solicitudAsesoramiento = asesoramientoService.listarAsesorados(3);
		model.addAttribute("asesorados",solicitudAsesoramiento );
		return "views/admin/asesoramiento/index";
	}
	
	@PostMapping("/aceptar-solicitud")
    @ResponseBody
    public JsonResponse actualizarModulo(@RequestBody SolucitudAsesoramiento solucitudAsesoramiento) {
	    try {
	    	asesoramientoService.aceptarSolicitud(solucitudAsesoramiento);
	    	jsonResponse = new JsonResponse();
	    	jsonResponse.respuestaInsertar();
	    } catch (Exception e) {
	    	e.getMessage();
	    }
    	return jsonResponse;
    }
	
	@RequestMapping("/revertir-cambio/{idsolucitudAsesoramiento}")
	public String revertirCambios(@PathVariable("idsolucitudAsesoramiento") Integer idsolucitudAsesoramiento) {
		this.asesoramientoService.revertirCambios(idsolucitudAsesoramiento);
		return "redirect:/asesoramiento/listar";
	}
}
