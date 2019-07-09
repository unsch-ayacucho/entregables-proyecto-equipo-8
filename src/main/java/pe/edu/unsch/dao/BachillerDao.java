package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.entities.Bachiller;

public interface BachillerDao {
	
	public List<Bachiller> listarPorPerfil(String usuario);
	
}
