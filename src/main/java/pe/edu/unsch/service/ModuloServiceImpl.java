package pe.edu.unsch.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unsch.dao.ModuloDao;

import java.util.List;

import pe.edu.unsch.entities.Modulo;

@Service("moduloService")
@Transactional
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	private ModuloDao moduloDao;
	
	@Override
	public List<Modulo> listarPorPerfil(String usuario) {
		return moduloDao.listarPorPerfil(usuario);
	}

	@Override
	public List<Modulo> listarModulos() {
		
		return moduloDao.listarModulos();
	}
	
}
