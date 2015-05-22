package edu.upc.pes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)  
public class UsuarioRegistrado {
	
	@Id
	private String email;
	private String nombre;
	private String apellidos;
	private String contraseña;
	
	private String tipo; //puede ser: admin, visitante o gestor


	public UsuarioRegistrado(){
		
	}
	public UsuarioRegistrado(String email, String contraseña, String tipo){
		this.email = email;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}
	
	public UsuarioRegistrado(String email, String contraseña, String nombre, String apellidos, String tipo){
		this.email = email;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
