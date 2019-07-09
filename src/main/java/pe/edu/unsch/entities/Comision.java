package pe.edu.unsch.entities;
// Generated 08/07/2019 08:40:20 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Comision generated by hbm2java
 */
@Entity
@Table(name = "comision", catalog = "titulaciondb")
public class Comision implements java.io.Serializable {

	private int idcomision;
	private SolicitudPlanTesis solicitudPlanTesis;
	private String detalle;
	private String estado;
	private Set<SolicitudBorradora> solicitudBorradoras = new HashSet<SolicitudBorradora>(0);
	private Set<ComisionDocente> comisionDocentes = new HashSet<ComisionDocente>(0);

	public Comision() {
	}

	public Comision(int idcomision, SolicitudPlanTesis solicitudPlanTesis) {
		this.idcomision = idcomision;
		this.solicitudPlanTesis = solicitudPlanTesis;
	}

	public Comision(int idcomision, SolicitudPlanTesis solicitudPlanTesis, String detalle, String estado,
			Set<SolicitudBorradora> solicitudBorradoras, Set<ComisionDocente> comisionDocentes) {
		this.idcomision = idcomision;
		this.solicitudPlanTesis = solicitudPlanTesis;
		this.detalle = detalle;
		this.estado = estado;
		this.solicitudBorradoras = solicitudBorradoras;
		this.comisionDocentes = comisionDocentes;
	}

	@Id

	@Column(name = "idcomision", unique = true, nullable = false)
	public int getIdcomision() {
		return this.idcomision;
	}

	public void setIdcomision(int idcomision) {
		this.idcomision = idcomision;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsolicitud_plan_tesis", nullable = false)
	public SolicitudPlanTesis getSolicitudPlanTesis() {
		return this.solicitudPlanTesis;
	}

	public void setSolicitudPlanTesis(SolicitudPlanTesis solicitudPlanTesis) {
		this.solicitudPlanTesis = solicitudPlanTesis;
	}

	@Column(name = "detalle", length = 100)
	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Column(name = "estado", length = 45)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comision")
	public Set<SolicitudBorradora> getSolicitudBorradoras() {
		return this.solicitudBorradoras;
	}

	public void setSolicitudBorradoras(Set<SolicitudBorradora> solicitudBorradoras) {
		this.solicitudBorradoras = solicitudBorradoras;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comision")
	public Set<ComisionDocente> getComisionDocentes() {
		return this.comisionDocentes;
	}

	public void setComisionDocentes(Set<ComisionDocente> comisionDocentes) {
		this.comisionDocentes = comisionDocentes;
	}

}
