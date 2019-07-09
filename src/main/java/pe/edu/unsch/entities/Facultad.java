package pe.edu.unsch.entities;
// Generated 08/07/2019 08:40:20 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Facultad generated by hbm2java
 */
@Entity
@Table(name = "facultad", catalog = "titulaciondb")
public class Facultad implements java.io.Serializable {

	private Integer idfacultad;
	private String nombre;
	private Set<Escuela> escuelas = new HashSet<Escuela>(0);
	private Set<Decano> decanos = new HashSet<Decano>(0);

	public Facultad() {
	}

	public Facultad(String nombre) {
		this.nombre = nombre;
	}

	public Facultad(String nombre, Set<Escuela> escuelas, Set<Decano> decanos) {
		this.nombre = nombre;
		this.escuelas = escuelas;
		this.decanos = decanos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idfacultad", unique = true, nullable = false)
	public Integer getIdfacultad() {
		return this.idfacultad;
	}

	public void setIdfacultad(Integer idfacultad) {
		this.idfacultad = idfacultad;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
	public Set<Escuela> getEscuelas() {
		return this.escuelas;
	}

	public void setEscuelas(Set<Escuela> escuelas) {
		this.escuelas = escuelas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad")
	public Set<Decano> getDecanos() {
		return this.decanos;
	}

	public void setDecanos(Set<Decano> decanos) {
		this.decanos = decanos;
	}

}
