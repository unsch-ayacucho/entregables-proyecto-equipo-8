package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.entities.SolucitudAsesoramiento;

public interface AsesoramientoService {

	public List<SolucitudAsesoramiento> listarAsesorados(int usuario);
	
	public void aceptarSolicitud(SolucitudAsesoramiento solucitudAsesoramiento);
	
	public void revertirCambios(Integer id);
	
	
}
