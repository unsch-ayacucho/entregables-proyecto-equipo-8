package pe.edu.unsch.entities;
// Generated 20/07/2019 08:17:53 PM by Hibernate Tools 5.3.0.Beta2

import java.util.HashSet;
import java.util.Set;

/**
 * Decano generated by hbm2java
 */
public class Decano implements java.io.Serializable {

	private Integer iddecano;
	private Facultad facultad;
	private UsuarioPerfil usuarioPerfil;
	private String nombre;
	private String apellido;
	private String telefono;
	private String dni;
	private Set solicitudBorradoras = new HashSet(0);

	public Decano() {
	}

	public Decano(Facultad facultad, UsuarioPerfil usuarioPerfil) {
		this.facultad = facultad;
		this.usuarioPerfil = usuarioPerfil;
	}

	public Decano(Facultad facultad, UsuarioPerfil usuarioPerfil, String nombre, String apellido, String telefono,
			String dni, Set solicitudBorradoras) {
		this.facultad = facultad;
		this.usuarioPerfil = usuarioPerfil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.dni = dni;
		this.solicitudBorradoras = solicitudBorradoras;
	}

	public Integer getIddecano() {
		return this.iddecano;
	}

	public void setIddecano(Integer iddecano) {
		this.iddecano = iddecano;
	}

	public Facultad getFacultad() {
		return this.facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public UsuarioPerfil getUsuarioPerfil() {
		return this.usuarioPerfil;
	}

	public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Set getSolicitudBorradoras() {
		return this.solicitudBorradoras;
	}

	public void setSolicitudBorradoras(Set solicitudBorradoras) {
		this.solicitudBorradoras = solicitudBorradoras;
	}

}
