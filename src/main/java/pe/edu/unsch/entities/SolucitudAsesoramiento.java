package pe.edu.unsch.entities;
// Generated 21/07/2019 10:20:59 AM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SolucitudAsesoramiento generated by hbm2java
 */
@Entity
@Table(name = "solucitud_asesoramiento", catalog = "titulaciondb")
public class SolucitudAsesoramiento implements java.io.Serializable {

	private Integer idsolucitudAsesoramiento;
	private Bachiller bachiller;
	private Docente docente;
	private Solicitud solicitud;
	private String detalle;
	private String estado;
	private Set<SolicitudAprobacion> solicitudAprobacions = new HashSet<SolicitudAprobacion>(0);

	public SolucitudAsesoramiento() {
	}

	public SolucitudAsesoramiento(Bachiller bachiller, Docente docente, Solicitud solicitud) {
		this.bachiller = bachiller;
		this.docente = docente;
		this.solicitud = solicitud;
	}

	public SolucitudAsesoramiento(Bachiller bachiller, Docente docente, Solicitud solicitud, String detalle,
			String estado, Set<SolicitudAprobacion> solicitudAprobacions) {
		this.bachiller = bachiller;
		this.docente = docente;
		this.solicitud = solicitud;
		this.detalle = detalle;
		this.estado = estado;
		this.solicitudAprobacions = solicitudAprobacions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idsolucitud_asesoramiento", unique = true, nullable = false)
	public Integer getIdsolucitudAsesoramiento() {
		return this.idsolucitudAsesoramiento;
	}

	public void setIdsolucitudAsesoramiento(Integer idsolucitudAsesoramiento) {
		this.idsolucitudAsesoramiento = idsolucitudAsesoramiento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idbachiller", nullable = false)
	public Bachiller getBachiller() {
		return this.bachiller;
	}

	public void setBachiller(Bachiller bachiller) {
		this.bachiller = bachiller;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddocente", nullable = false)
	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsolicitud", nullable = false)
	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "solucitudAsesoramiento")
	public Set<SolicitudAprobacion> getSolicitudAprobacions() {
		return this.solicitudAprobacions;
	}

	public void setSolicitudAprobacions(Set<SolicitudAprobacion> solicitudAprobacions) {
		this.solicitudAprobacions = solicitudAprobacions;
	}

}
