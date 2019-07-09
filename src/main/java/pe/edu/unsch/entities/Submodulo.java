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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Submodulo generated by hbm2java
 */
@Entity
@Table(name = "submodulo", catalog = "titulaciondb")
public class Submodulo implements java.io.Serializable {

	private int idsubmodulo;
	private Modulo modulo;
	private String nombre;
	private Byte estado;
	private Set<Opcion> opcions = new HashSet<Opcion>(0);
	private int idmodulo;

	public Submodulo() {
	}
	
	public Submodulo(int idmodulo, String nombre) {
		this.idmodulo = idmodulo;
		this.nombre = nombre;
	}

	public Submodulo(int idsubmodulo, Modulo modulo, String nombre, Byte estado, Set<Opcion> opcions) {
		this.idsubmodulo = idsubmodulo;
		this.modulo = modulo;
		this.nombre = nombre;
		this.estado = estado;
		this.opcions = opcions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idsubmodulo", unique = true, nullable = false)
	public int getIdsubmodulo() {
		return this.idsubmodulo;
	}

	public void setIdsubmodulo(int idsubmodulo) {
		this.idsubmodulo = idsubmodulo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmodulo", nullable = false)
	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "estado")
	public Byte getEstado() {
		return this.estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "submodulo")
	public Set<Opcion> getOpcions() {
		return this.opcions;
	}

	public void setOpcions(Set<Opcion> opcions) {
		this.opcions = opcions;
	}

	@Transient
	public Integer getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}
	
}
