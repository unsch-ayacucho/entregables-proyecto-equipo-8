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
 * Secretario generated by hbm2java
 */
@Entity
@Table(name = "secretario", catalog = "titulaciondb")
public class Secretario implements java.io.Serializable {

	private Integer idsecretario;
	private Escuela escuela;
	private String nombre;
	private String apellido;
	private String secretariocol;
	private String telefono;
	private Set<SolicitudAprobacion> solicitudAprobacions = new HashSet<SolicitudAprobacion>(0);
	private Set<SolicitudBorradora> solicitudBorradoras = new HashSet<SolicitudBorradora>(0);

	public Secretario() {
	}

	public Secretario(Escuela escuela) {
		this.escuela = escuela;
	}

	public Secretario(Escuela escuela, String nombre, String apellido, String secretariocol, String telefono,
			Set<SolicitudAprobacion> solicitudAprobacions, Set<SolicitudBorradora> solicitudBorradoras) {
		this.escuela = escuela;
		this.nombre = nombre;
		this.apellido = apellido;
		this.secretariocol = secretariocol;
		this.telefono = telefono;
		this.solicitudAprobacions = solicitudAprobacions;
		this.solicitudBorradoras = solicitudBorradoras;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idsecretario", unique = true, nullable = false)
	public Integer getIdsecretario() {
		return this.idsecretario;
	}

	public void setIdsecretario(Integer idsecretario) {
		this.idsecretario = idsecretario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idescuela", nullable = false)
	public Escuela getEscuela() {
		return this.escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellido", length = 45)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "secretariocol", length = 45)
	public String getSecretariocol() {
		return this.secretariocol;
	}

	public void setSecretariocol(String secretariocol) {
		this.secretariocol = secretariocol;
	}

	@Column(name = "telefono", length = 9)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secretario")
	public Set<SolicitudAprobacion> getSolicitudAprobacions() {
		return this.solicitudAprobacions;
	}

	public void setSolicitudAprobacions(Set<SolicitudAprobacion> solicitudAprobacions) {
		this.solicitudAprobacions = solicitudAprobacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "secretario")
	public Set<SolicitudBorradora> getSolicitudBorradoras() {
		return this.solicitudBorradoras;
	}

	public void setSolicitudBorradoras(Set<SolicitudBorradora> solicitudBorradoras) {
		this.solicitudBorradoras = solicitudBorradoras;
	}

}
