package pe.edu.unsch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unsch.entities.Modulo;
import pe.edu.unsch.service.ModuloService;
import pe.edu.unsch.service.ModuloServiceImpl;
import pe.edu.unsch.util.JsonResponse;

@Controller
@RequestMapping("/admin")
public class ModuloController {

	@GetMapping("/modulo")
	public String mainGet(Model model) {
		model.addAttribute("titulo", "Módulo | Evaluación 360°");
		return "views/admin/modulo/index";
	}
	
	@Autowired
	private ModuloService moduloService;
	
	private JsonResponse jsonResponse;
	
    @GetMapping("/modulo/listar")
    public String lista(Model model) {
    	
    	List<Modulo> modulos = moduloService.listarModulos();
        model.addAttribute("modulos", modulos);
    	
    	return "views/admin/modulo/index";
    }
    
    @PostMapping("/modulo/registrar")
    @ResponseBody
    public JsonResponse registrarModulo(@RequestBody Modulo modulo) {
	    try {
	    	moduloService.insertar(modulo);
	    	jsonResponse = new JsonResponse();
	    	jsonResponse.respuestaInsertar();
	    } catch (Exception e) {
	    	e.getMessage();
	    }
    	return jsonResponse;
    }
    
    @RequestMapping("/modulo/eliminar/{idmodulo}")
	public String eliminarModulo(@PathVariable("idmodulo") Integer idmodulo) {
		this.moduloService.eliminar(idmodulo);
		return "redirect:/admin/modulo/listar";
	}
 
    @RequestMapping("/modulo/estado/{idmodulo}")
	public String cambiarEstado(@PathVariable("idmodulo") Integer idmodulo) {
		this.moduloService.cambiarEstado(idmodulo);
		return "redirect:/admin/modulo/listar";
	}
  
    @PostMapping("/modulo/actualizar")
    @ResponseBody
    public JsonResponse actualizarModulo(@RequestBody Modulo modulo) {
	    try {
	    	moduloService.actualizar(modulo);
	    	jsonResponse = new JsonResponse();
	    	jsonResponse.respuestaInsertar();
	    } catch (Exception e) {
	    	e.getMessage();
	    }
    	return jsonResponse;
    }
    
}
