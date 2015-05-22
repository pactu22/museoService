package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exposicion {

	@Id
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "exposicion",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Obra> obras;
	
	@JsonIgnore
	@OneToMany(mappedBy = "exposicion",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Coleccion> colecciones;
	
	@ManyToOne
	private Museo museo;

	public Exposicion(){
		obras = new ArrayList<Obra>();
		colecciones = new ArrayList<Coleccion>();
	}
	public Exposicion(String nombre, Date fechaInicio,  Museo museo){
		this.nombre = nombre;
		this.fechaInicio= fechaInicio;
		this.museo = museo;
		obras = new ArrayList<Obra>();
		colecciones = new ArrayList<Coleccion>();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}

	public List<Coleccion> getColecciones() {
		return colecciones;
	}

	public void setColecciones(List<Coleccion> colecciones) {
		this.colecciones = colecciones;
	}

	public Museo getMuseo() {
		return museo;
	}

	public void setMuseo(Museo museo) {
		this.museo = museo;
	}
	
	public void addObra(Obra o){
		obras.add(o);
	}
	public void addColeccion(Coleccion c){
		colecciones.add(c);
	}
	
	
}
