package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.entities.Modulo;

public interface ModuloService {

	public List <Modulo> listarPorPerfil(String usuario);
	
	List<Modulo> listarModulos();
	
	public void insertar(Modulo modulo);
	
	public void cambiarEstado(Integer id);
	
	public void eliminar(Integer id);
	
	public void actualizar(Modulo modulo);
}
