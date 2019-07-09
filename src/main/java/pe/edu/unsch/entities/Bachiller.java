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
 * Bachiller generated by hbm2java
 */
@Entity
@Table(name = "bachiller", catalog = "titulaciondb")
public class Bachiller implements java.io.Serializable {

	private int idbachiller;
	private Escuela escuela;
	private UsuarioPerfil usuarioPerfil;
	private String nombre;
	private String apellido;
	private String codigo;
	private String dni;
	private String telefono;
	private Set<SolucitudAsesoramiento> solucitudAsesoramientos = new HashSet<SolucitudAsesoramiento>(0);

	public Bachiller() {
	}

	public Bachiller(int idbachiller, Escuela escuela, UsuarioPerfil usuarioPerfil) {
		this.idbachiller = idbachiller;
		this.escuela = escuela;
		this.usuarioPerfil = usuarioPerfil;
	}

	public Bachiller(int idbachiller, Escuela escuela, UsuarioPerfil usuarioPerfil, String nombre, String apellido,
			String codigo, String dni, String telefono, Set<SolucitudAsesoramiento> solucitudAsesoramientos) {
		this.idbachiller = idbachiller;
		this.escuela = escuela;
		this.usuarioPerfil = usuarioPerfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.codigo = codigo;
		this.dni = dni;
		this.telefono = telefono;
		this.solucitudAsesoramientos = solucitudAsesoramientos;
	}

	@Id

	@Column(name = "idbachiller", unique = true, nullable = false)
	public int getIdbachiller() {
		return this.idbachiller;
	}

	public void setIdbachiller(int idbachiller) {
		this.idbachiller = idbachiller;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idescuela", nullable = false)
	public Escuela getEscuela() {
		return this.escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario_perfil", nullable = false)
	public UsuarioPerfil getUsuarioPerfil() {
		return this.usuarioPerfil;
	}

	public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
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

	@Column(name = "codigo", length = 8)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "dni", length = 8)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "telefono", length = 8)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bachiller")
	public Set<SolucitudAsesoramiento> getSolucitudAsesoramientos() {
		return this.solucitudAsesoramientos;
	}

	public void setSolucitudAsesoramientos(Set<SolucitudAsesoramiento> solucitudAsesoramientos) {
		this.solucitudAsesoramientos = solucitudAsesoramientos;
	}

}
