package pe.edu.unsch.entities;
// Generated 21/07/2019 10:20:59 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SolicitudSustentacion generated by hbm2java
 */
@Entity
@Table(name = "solicitud_sustentacion", catalog = "titulaciondb")
public class SolicitudSustentacion implements java.io.Serializable {

	private Integer idsolicitudSustentacion;
	private SolicitudBorradora solicitudBorradora;
	private Date solicitudSustentacioncol;
	private String fecha;
	private String lugar;

	public SolicitudSustentacion() {
	}

	public SolicitudSustentacion(SolicitudBorradora solicitudBorradora) {
		this.solicitudBorradora = solicitudBorradora;
	}

	public SolicitudSustentacion(SolicitudBorradora solicitudBorradora, Date solicitudSustentacioncol, String fecha,
			String lugar) {
		this.solicitudBorradora = solicitudBorradora;
		this.solicitudSustentacioncol = solicitudSustentacioncol;
		this.fecha = fecha;
		this.lugar = lugar;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idsolicitud_sustentacion", unique = true, nullable = false)
	public Integer getIdsolicitudSustentacion() {
		return this.idsolicitudSustentacion;
	}

	public void setIdsolicitudSustentacion(Integer idsolicitudSustentacion) {
		this.idsolicitudSustentacion = idsolicitudSustentacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsolicitud_borradora", nullable = false)
	public SolicitudBorradora getSolicitudBorradora() {
		return this.solicitudBorradora;
	}

	public void setSolicitudBorradora(SolicitudBorradora solicitudBorradora) {
		this.solicitudBorradora = solicitudBorradora;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "solicitud_sustentacioncol", length = 10)
	public Date getSolicitudSustentacioncol() {
		return this.solicitudSustentacioncol;
	}

	public void setSolicitudSustentacioncol(Date solicitudSustentacioncol) {
		this.solicitudSustentacioncol = solicitudSustentacioncol;
	}

	@Column(name = "fecha", length = 45)
	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Column(name = "lugar", length = 100)
	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
