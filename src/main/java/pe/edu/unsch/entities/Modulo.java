package pe.edu.unsch.entities;
// Generated 08/07/2019 08:40:20 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modulo generated by hbm2java
 */
@Entity
@Table(name = "modulo", catalog = "titulaciondb")
public class Modulo implements java.io.Serializable {

	private int idmodulo;
	private String nombre;
	private String icono;
	private Byte estado;
	private Set<Submodulo> submodulos = new HashSet<Submodulo>(0);

	public Modulo() {
	}

	public Modulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}

	public Modulo(int idmodulo, String nombre, String icono, Byte estado, Set<Submodulo> submodulos) {
		this.idmodulo = idmodulo;
		this.nombre = nombre;
		this.icono = icono;
		this.estado = estado;
		this.submodulos = submodulos;
	}

	@Id

	@Column(name = "idmodulo", unique = true, nullable = false)
	public int getIdmodulo() {
		return this.idmodulo;
	}

	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "icono", length = 20)
	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	@Column(name = "estado")
	public Byte getEstado() {
		return this.estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
	public Set<Submodulo> getSubmodulos() {
		return this.submodulos;
	}

	public void setSubmodulos(Set<Submodulo> submodulos) {
		this.submodulos = submodulos;
	}

}
