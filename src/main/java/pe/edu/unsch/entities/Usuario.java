package pe.edu.unsch.entities;
// Generated 08/07/2019 12:10:03 AM by Hibernate Tools 5.1.7.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "titulaciondb")
public class Usuario implements java.io.Serializable {

	private Integer idusuario;
	private String nombre;
	private String usuario;
	private String password;
	private Byte estado;
	private String foto;
	private Date ultimoLogin;
	private Set<UsuarioPerfil> usuarioPerfils = new HashSet<UsuarioPerfil>(0);

	public Usuario() {
	}

	public Usuario(String nombre, String usuario, String password, Byte estado, String foto, Date ultimoLogin,
			Set<UsuarioPerfil> usuarioPerfils) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = password;
		this.estado = estado;
		this.foto = foto;
		this.ultimoLogin = ultimoLogin;
		this.usuarioPerfils = usuarioPerfils;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "usuario", length = 45)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "estado")
	public Byte getEstado() {
		return this.estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	@Column(name = "foto", length = 45)
	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ultimo_login", length = 19)
	public Date getUltimoLogin() {
		return this.ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<UsuarioPerfil> getUsuarioPerfils() {
		return this.usuarioPerfils;
	}

	public void setUsuarioPerfils(Set<UsuarioPerfil> usuarioPerfils) {
		this.usuarioPerfils = usuarioPerfils;
	}

}
