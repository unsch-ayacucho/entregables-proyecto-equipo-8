package pe.edu.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.entities.Bachiller;

@Repository("bachillerDao")
public class BachillerDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Bachiller> listarPorPerfil (String usuario){
		return (List<Bachiller>) entityManager.createQuery("select new Bachiller(b.idbachiller  as idbachiller"
				+ "b.nombre as nombre, b.telefono as telefono) "
				+"from Bachiller b "
				+ "inner join b.UsuarioPerfil up "
				+ "where up.perfil = some("
				+ "select p.idperfil from Perfil as p "
				+ "inner join up.usuario u "
				+ "where u.nombre= :usuario) "
				+ "group by b.idbachiller", Bachiller.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}
	
	
}
