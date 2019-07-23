package pe.edu.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.entities.Modulo;
import pe.edu.unsch.entities.SolucitudAsesoramiento;

@Repository("asesoramientoDao")
public class AsesoramientoDaoImpl implements AsesoramientoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SolucitudAsesoramiento> listarAsesorados(int usuario) {
		
		return (List<SolucitudAsesoramiento>) entityManager.
				createQuery("select sa FROM SolucitudAsesoramiento sa "
						+ "inner join sa.docente d "
						+ "where d.iddocente = :docente "
							, SolucitudAsesoramiento.class).setParameter("docente", 2)
				.getResultList();
		
	}
	
	@Override
	public void aceptarSolicitud(SolucitudAsesoramiento sa) {
		entityManager.createQuery(
			      "UPDATE SolucitudAsesoramiento SET estado=:estado, detalle=:detalle").
				setParameter("estado", sa.getEstado()).
				setParameter("detalle", sa.getDetalle()).
				executeUpdate();
	}
	
	@Override
	public void revertirCambios(Integer id) {
		entityManager.createQuery(
			      "UPDATE SolucitudAsesoramiento SET detalle = :detalle, estado =:estado where idsolucitudAsesoramiento=:id").
				setParameter("id",id).
				setParameter("detalle","").
				setParameter("estado", "pendiente").
				executeUpdate();
	}
	
}
