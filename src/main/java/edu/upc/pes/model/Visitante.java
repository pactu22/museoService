package edu.upc.pes.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Visitante extends UsuarioRegistrado{
	private Date fechaDeRegistro;

	
	public Visitante(){
		
	}
	
	public Visitante(String email, String contraseña){
		super(email, contraseña);
		fechaDeRegistro = new Date();
	}
	
	public Visitante(String email, String contraseña, String nombre, String apellidos){
		super(email, contraseña, nombre, apellidos);
	}
	
	public Date getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(Date fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}
}
