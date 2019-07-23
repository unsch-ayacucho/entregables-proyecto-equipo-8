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
		Modulo modulo =  entityManager.find(Modulo.class, id);
		byte estado = 0;
		if (modulo.getEstado() == 0) {
			estado=1;	
		}
		entityManager.createQuery(
			      "UPDATE Modulo SET estado =:estado where idmodulo=:modulo").
				setParameter("estado",estado).
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
	
	@Override
	public void actualizar(Modulo modulo) {
		entityManager.createQuery(
			      "UPDATE Modulo SET nombre=:nombre, icono=:icono, estado=:estado where idmodulo=:modulo").
				setParameter("modulo", modulo.getIdmodulo()).
				setParameter("nombre", modulo.getNombre()).
				setParameter("icono", modulo.getIcono()).
				setParameter("estado", modulo.getEstado()).
				executeUpdate();
	}
}
