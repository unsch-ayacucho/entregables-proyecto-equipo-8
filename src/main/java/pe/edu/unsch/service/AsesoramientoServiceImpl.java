package pe.edu.unsch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unsch.dao.AsesoramientoDao;
import pe.edu.unsch.entities.SolucitudAsesoramiento;

@Service("asesoramientoService")
@Transactional
public class AsesoramientoServiceImpl implements AsesoramientoService {
	@Autowired
	private AsesoramientoDao asesoramientoDao;
	
	@Override
	public List<SolucitudAsesoramiento> listarAsesorados(int usuario){
			return asesoramientoDao.listarAsesorados(usuario);
	}
	
	@Override
	public void aceptarSolicitud(SolucitudAsesoramiento solucitudAsesoramiento) {
		asesoramientoDao.aceptarSolicitud(solucitudAsesoramiento);
	}
	
	@Override
	public void revertirCambios(Integer id) {
		asesoramientoDao.revertirCambios(id);
	}
}
