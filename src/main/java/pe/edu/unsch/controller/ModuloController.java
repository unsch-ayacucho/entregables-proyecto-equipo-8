package pe.edu.unsch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ModuloController {

	@GetMapping("/modulo")
	public String mainGet(Model model) {
		model.addAttribute("titulo", "Módulo | Evaluación 360°");
		return "views/admin/modulo/index";
	}
	
}
