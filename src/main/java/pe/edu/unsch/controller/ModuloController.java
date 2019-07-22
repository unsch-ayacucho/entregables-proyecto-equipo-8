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
    	
    	/*Proveedor chinaPro = new Proveedor(1, "ChinChing Co.", "Beijing", "China");
    	Proveedor peruPro = new Proveedor(1, "El Chinito del Tractor S.R.L.", "Lima", "Perú");
    	
    	productos.add(new Producto(1, chinaPro, "Memoría RAM 8GB", 505.5f, 20));
    	productos.add(new Producto(2, peruPro, "Procesador AMD A4", 420.3f, 5));*/
    	
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
    
//    @GetMapping("/modulo/{id}")
//	public String detalle(@PathVariable("id") Integer id, Model model) {
//		model.addAttribute("modulo", moduloService.buscar(id));
//		return "views/admin/modulo/index";
//	}
	
    
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
    
}
