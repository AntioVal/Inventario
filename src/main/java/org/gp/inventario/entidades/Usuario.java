package org.gp.inventario.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "usuario")
public class Usuario {	

	public Usuario() {
		super();
//		this.idUsuario = 0;
//		this.nombreU = "";
//		this.contrasena = "";
//		this.nombreP = "";
//		this.apellidoPP = "";
//		this.apellidoMP = "";
//		this.privilegio = "";
//		this.fechaCreacion = new Date();
//		this.correo = "";
//		this.estado = "";
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idUsuario")	
	private Integer idUsuario;
	
	@Column(name = "nombreU")
	private String nombreU;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name = "nombreP")
	private String nombreP;
	
	@Column(name = "apellidoPP")
	private String apellidoPP;
	
	@Column(name = "apellidoMP")
	private String apellidoMP;
	
	@Column(name = "privilegio")
	private String privilegio;
	
	@Column(name = "fechaCreacion")
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaCreacion;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "estado")
	private String estado;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreU() {
		return nombreU;
	}
	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getApellidoPP() {
		return apellidoPP;
	}
	public void setApellidoPP(String apellidoPP) {
		this.apellidoPP = apellidoPP;
	}
	public String getApellidoMP() {
		return apellidoMP;
	}
	public void setApellidoMP(String apellidoMP) {
		this.apellidoMP = apellidoMP;
	}
	public String getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreU=" + nombreU
				+ ", contrasena=" + contrasena + ", nombreP=" + nombreP
				+ ", apellidoPP=" + apellidoPP + ", apellidoMP=" + apellidoMP
				+ ", privilegio=" + privilegio + ", fechaCreacion="
				+ fechaCreacion + ", correo=" + correo + ", estado=" + estado
				+ "]";
	}
	
	
	
}
