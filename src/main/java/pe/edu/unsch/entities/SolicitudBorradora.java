package pe.edu.unsch.entities;
// Generated 08/07/2019 12:10:03 AM by Hibernate Tools 5.1.7.Final

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
 * SolicitudBorradora generated by hbm2java
 */
@Entity
@Table(name = "solicitud_borradora", catalog = "titulaciondb")
public class SolicitudBorradora implements java.io.Serializable {

	private int idsolicitudBorradora;
	private Comision comision;
	private Decano decano;
	private Secretario secretario;
	private String pagoTramite;
	private String urlBorradora;
	private Set<SolicitudSustentacion> solicitudSustentacions = new HashSet<SolicitudSustentacion>(0);

	public SolicitudBorradora() {
	}

	public SolicitudBorradora(int idsolicitudBorradora, Comision comision, Decano decano, Secretario secretario) {
		this.idsolicitudBorradora = idsolicitudBorradora;
		this.comision = comision;
		this.decano = decano;
		this.secretario = secretario;
	}

	public SolicitudBorradora(int idsolicitudBorradora, Comision comision, Decano decano, Secretario secretario,
			String pagoTramite, String urlBorradora, Set<SolicitudSustentacion> solicitudSustentacions) {
		this.idsolicitudBorradora = idsolicitudBorradora;
		this.comision = comision;
		this.decano = decano;
		this.secretario = secretario;
		this.pagoTramite = pagoTramite;
		this.urlBorradora = urlBorradora;
		this.solicitudSustentacions = solicitudSustentacions;
	}

	@Id

	@Column(name = "idsolicitud_borradora", unique = true, nullable = false)
	public int getIdsolicitudBorradora() {
		return this.idsolicitudBorradora;
	}

	public void setIdsolicitudBorradora(int idsolicitudBorradora) {
		this.idsolicitudBorradora = idsolicitudBorradora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcomision", nullable = false)
	public Comision getComision() {
		return this.comision;
	}

	public void setComision(Comision comision) {
		this.comision = comision;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddecano", nullable = false)
	public Decano getDecano() {
		return this.decano;
	}

	public void setDecano(Decano decano) {
		this.decano = decano;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idsecretario", nullable = false)
	public Secretario getSecretario() {
		return this.secretario;
	}

	public void setSecretario(Secretario secretario) {
		this.secretario = secretario;
	}

	@Column(name = "pago_tramite", length = 45)
	public String getPagoTramite() {
		return this.pagoTramite;
	}

	public void setPagoTramite(String pagoTramite) {
		this.pagoTramite = pagoTramite;
	}

	@Column(name = "url_borradora", length = 100)
	public String getUrlBorradora() {
		return this.urlBorradora;
	}

	public void setUrlBorradora(String urlBorradora) {
		this.urlBorradora = urlBorradora;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "solicitudBorradora")
	public Set<SolicitudSustentacion> getSolicitudSustentacions() {
		return this.solicitudSustentacions;
	}

	public void setSolicitudSustentacions(Set<SolicitudSustentacion> solicitudSustentacions) {
		this.solicitudSustentacions = solicitudSustentacions;
	}

}