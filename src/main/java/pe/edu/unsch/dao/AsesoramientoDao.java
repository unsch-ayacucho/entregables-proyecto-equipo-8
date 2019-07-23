package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.entities.SolucitudAsesoramiento;

public interface AsesoramientoDao {

	public List<SolucitudAsesoramiento> listarAsesorados(int usuario);
	
	public void aceptarSolicitud(SolucitudAsesoramiento solucitudAsesoramiento);

	public void revertirCambios(Integer id);
	
}
