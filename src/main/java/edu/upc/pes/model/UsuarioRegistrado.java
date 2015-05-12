package edu.upc.pes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UsuarioRegistrado {
	
	@Id
	private String email;
	private String nombre;
	private String apellidos;
	private String contraseña;
	
	public UsuarioRegistrado(){
		
	}
	public UsuarioRegistrado(String email, String contraseña){
		this.email = email;
		this.contraseña = contraseña;
	}
	
	public UsuarioRegistrado(String email, String contraseña, String nombre, String apellidos){
		this.email = email;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
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
}
