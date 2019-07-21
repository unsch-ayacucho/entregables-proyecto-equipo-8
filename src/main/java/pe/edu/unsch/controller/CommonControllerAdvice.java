package pe.edu.unsch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import pe.edu.unsch.service.ModuloService;
import pe.edu.unsch.service.SubmoduloService;

@ControllerAdvice
public class CommonControllerAdvice {
	
	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private SubmoduloService submoduloService;
	
	@ModelAttribute
	public void addAttributes(HttpServletRequest request, Model model) {
		//Recuperacion de session
	    HttpSession session = request.getSession();
	    String usuario = (String) session.getAttribute("usuario");
		
		// Modulos de usuario activo 
		model.addAttribute("modulosPorPerfil", moduloService.listarPorPerfil(usuario));    
					
		// Submodulos de usuario activo
		model.addAttribute("submodulosPorPerfil", submoduloService.listarPorPerfil(usuario));
	}

}
