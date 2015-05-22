package edu.upc.pes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Visitante extends UsuarioRegistrado{
	private Date fechaDeRegistro;
	
	@ManyToOne
	private Museo museo;
	

	public Visitante(){
		
	}
	
	public Visitante(String email, String contraseña, Museo museo){
		super(email, contraseña, "visitante");
		this.museo = museo;
		fechaDeRegistro = new Date();
	}
	
	public Visitante(String email, String contraseña, String nombre, String apellidos, Museo museo){
		super(email, contraseña, nombre, apellidos,"visitante");
		this.museo = museo;
	}
	
	public Date getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(Date fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}
	

	public Museo getMuseo() {
		return museo;
	}

	public void setMuseo(Museo museo) {
		this.museo = museo;
	}
}
