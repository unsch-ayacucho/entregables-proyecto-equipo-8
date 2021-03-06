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
 * Escuela generated by hbm2java
 */
@Entity
@Table(name = "escuela", catalog = "titulaciondb")
public class Escuela implements java.io.Serializable {

	private Integer idescuela;
	private Facultad facultad;
	private String nombre;
	private String codigo;
	private Set<Docente> docentes = new HashSet<Docente>(0);
	private Set<Bachiller> bachillers = new HashSet<Bachiller>(0);
	private Set<Secretario> secretarios = new HashSet<Secretario>(0);

	public Escuela() {
	}

	public Escuela(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public Escuela(Facultad facultad, String nombre, String codigo, Set<Docente> docentes, Set<Bachiller> bachillers,
			Set<Secretario> secretarios) {
		this.facultad = facultad;
		this.nombre = nombre;
		this.codigo = codigo;
		this.docentes = docentes;
		this.bachillers = bachillers;
		this.secretarios = secretarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idescuela", unique = true, nullable = false)
	public Integer getIdescuela() {
		return this.idescuela;
	}

	public void setIdescuela(Integer idescuela) {
		this.idescuela = idescuela;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idfacultad")
	public Facultad getFacultad() {
		return this.facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "codigo", nullable = false, length = 27)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "escuela")
	public Set<Docente> getDocentes() {
		return this.docentes;
	}

	public void setDocentes(Set<Docente> docentes) {
		this.docentes = docentes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "escuela")
	public Set<Bachiller> getBachillers() {
		return this.bachillers;
	}

	public void setBachillers(Set<Bachiller> bachillers) {
		this.bachillers = bachillers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "escuela")
	public Set<Secretario> getSecretarios() {
		return this.secretarios;
	}

	public void setSecretarios(Set<Secretario> secretarios) {
		this.secretarios = secretarios;
	}

}
