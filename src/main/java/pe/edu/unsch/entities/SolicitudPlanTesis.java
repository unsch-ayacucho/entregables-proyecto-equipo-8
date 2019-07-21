package pe.edu.unsch.entities;
// Generated 20/07/2019 08:17:53 PM by Hibernate Tools 5.3.0.Beta2

import java.util.HashSet;
import java.util.Set;

/**
 * SolicitudPlanTesis generated by hbm2java
 */
public class SolicitudPlanTesis implements java.io.Serializable {

	private Integer idsolicitudPlanTesis;
	private SolicitudAprobacion solicitudAprobacion;
	private String urlPlanTesis;
	private String pagoTramite;
	private String detalle;
	private String estado;
	private Set comisions = new HashSet(0);

	public SolicitudPlanTesis() {
	}

	public SolicitudPlanTesis(SolicitudAprobacion solicitudAprobacion) {
		this.solicitudAprobacion = solicitudAprobacion;
	}

	public SolicitudPlanTesis(SolicitudAprobacion solicitudAprobacion, String urlPlanTesis, String pagoTramite,
			String detalle, String estado, Set comisions) {
		this.solicitudAprobacion = solicitudAprobacion;
		this.urlPlanTesis = urlPlanTesis;
		this.pagoTramite = pagoTramite;
		this.detalle = detalle;
		this.estado = estado;
		this.comisions = comisions;
	}

	public Integer getIdsolicitudPlanTesis() {
		return this.idsolicitudPlanTesis;
	}

	public void setIdsolicitudPlanTesis(Integer idsolicitudPlanTesis) {
		this.idsolicitudPlanTesis = idsolicitudPlanTesis;
	}

	public SolicitudAprobacion getSolicitudAprobacion() {
		return this.solicitudAprobacion;
	}

	public void setSolicitudAprobacion(SolicitudAprobacion solicitudAprobacion) {
		this.solicitudAprobacion = solicitudAprobacion;
	}

	public String getUrlPlanTesis() {
		return this.urlPlanTesis;
	}

	public void setUrlPlanTesis(String urlPlanTesis) {
		this.urlPlanTesis = urlPlanTesis;
	}

	public String getPagoTramite() {
		return this.pagoTramite;
	}

	public void setPagoTramite(String pagoTramite) {
		this.pagoTramite = pagoTramite;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set getComisions() {
		return this.comisions;
	}

	public void setComisions(Set comisions) {
		this.comisions = comisions;
	}

}
