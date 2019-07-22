package pe.edu.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.edu.unsch.entities.Modulo;

@Repository("moduloDao")
public class ModuloDaoImpl implements ModuloDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Modulo> listarPorPerfil(String usuario){
		return (List<Modulo>) entityManager
				.createQuery("select new Modulo(m.idmodulo as idmodulo, m.nombre as nombre, m.icono as icono) "
				+ "from PerfilOpcion po "
				+ "inner join po.opcion o "
				+ "inner join o.submodulo s "
				+ "inner join s.modulo m "
				+ "where po.perfil = some ("
				+ "select p.idperfil from Perfil as p "
				+ "inner join p.usuarioPerfils up "
				+ "inner join up.usuario u "
				+ "where u.nombre= :usuario) "
				+ "group by m.idmodulo", Modulo.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}
	
	@Override
	public List<Modulo> listarModulos() {
		
		return (List<Modulo>) entityManager
					.createQuery("from Modulo", Modulo.class)
					.getResultList();
	}
	
	@Override
	public void insertar(Modulo modulo) {
		entityManager.persist(modulo);
	}
	
	@Override
	public void cambiarEstado(Integer id) {
		entityManager.createQuery(
			      "UPDATE Modulo SET estado = 0 where idmodulo=:modulo").
				setParameter("modulo", id).
				executeUpdate();
	}
	
	@Override
	public void eliminar(Integer id) {
		Modulo modulo =  entityManager.find(Modulo.class, id);
	    if (modulo != null) {
	      entityManager.remove(modulo);
	    }
	}
}
