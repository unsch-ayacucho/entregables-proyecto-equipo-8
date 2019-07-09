package pe.edu.unsch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unsch.entities.Bachiller;
import pe.edu.unsch.dao.BachillerDao;

@Service("bachillerService")
@Transactional
public class BachillerServiceImpl {
	
	//@Autowired
	//private BachillerDao bachillerDao;
	
	//public List<Bachiller> listarPorPerfil(String usuario){
	//	return bachillerDao.listarPorPerfil(usuario);
	//}
	
}
