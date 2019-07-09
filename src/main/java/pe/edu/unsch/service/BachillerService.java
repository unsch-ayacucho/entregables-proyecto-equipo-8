package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.entities.Bachiller;

public interface BachillerService {
	
	public List<Bachiller> listarPorPerfil(String usuario);
	
}
