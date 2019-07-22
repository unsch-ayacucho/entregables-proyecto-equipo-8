package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.entities.Modulo;

public interface ModuloDao {
	
	public List<Modulo> listarPorPerfil(String usuario);
	
	public List<Modulo> listarModulos();
	
	public void insertar(Modulo modulo);
	
	public void cambiarEstado(Integer id);
	
	public void eliminar(Integer id);

}
