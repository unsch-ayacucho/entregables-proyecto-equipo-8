package pe.edu.unsch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.unsch.entities.Modulo;
import pe.edu.unsch.service.ModuloServiceImpl;

@Controller
@RequestMapping("/admin")
public class ModuloController {

	@GetMapping("/modulo")
	public String mainGet(Model model) {
		model.addAttribute("titulo", "Módulo | Evaluación 360°");
		return "views/admin/modulo/index";
	}
	
	@Autowired
	private ModuloServiceImpl moduloServiceImpl;
	
    @GetMapping("/lista-modulos")
    public String lista(Model model) {
    	
    	List<Modulo> modulos = moduloServiceImpl.listarModulos();
    	
    	/*Proveedor chinaPro = new Proveedor(1, "ChinChing Co.", "Beijing", "China");
    	Proveedor peruPro = new Proveedor(1, "El Chinito del Tractor S.R.L.", "Lima", "Perú");
    	
    	productos.add(new Producto(1, chinaPro, "Memoría RAM 8GB", 505.5f, 20));
    	productos.add(new Producto(2, peruPro, "Procesador AMD A4", 420.3f, 5));*/
    	
        model.addAttribute("modulos", modulos);
    	
    	return "views/admin/modulo/index";
    }
	
}
