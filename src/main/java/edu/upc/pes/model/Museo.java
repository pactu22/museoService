package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Museo {
	
	@Id
	private String nombre;
	private String descripcion;
	private String direccion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Obra> obras;
	
	
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Visitante> visitantes;  
	
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Coleccion> colecciones;  
	
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Exposicion> exposiciones;  
	
	
	public Museo(){
		obras = new ArrayList<Obra>();
		visitantes = new ArrayList<Visitante>();
		exposiciones = new ArrayList<Exposicion>();
		colecciones = new ArrayList<Coleccion>();
	}
	public Museo(String nombre){
		this.nombre = nombre;
		obras = new ArrayList<Obra>();
		visitantes = new ArrayList<Visitante>();
		exposiciones = new ArrayList<Exposicion>();
		colecciones = new ArrayList<Coleccion>();
	}
	public Museo(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
		obras = new ArrayList<Obra>();
		visitantes = new ArrayList<Visitante>();
		exposiciones = new ArrayList<Exposicion>();
		colecciones = new ArrayList<Coleccion>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Obra> getObras() {
		return obras;
	}
	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}
	
	public List<Visitante> getVisitantes() {
		return visitantes;
	}
	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}

	
	public List<Coleccion> getColecciones() {
		return colecciones;
	}
	public void setColecciones(List<Coleccion> colecciones) {
		this.colecciones = colecciones;
	}
	public List<Exposicion> getExposiciones() {
		return exposiciones;
	}
	public void setExposiciones(List<Exposicion> exposiciones) {
		this.exposiciones = exposiciones;
	}
	
	public void addObra(Obra o){
		obras.add(o);
	}
	public void addExposicion(Exposicion e){
		exposiciones.add(e);
	}
	public void addColeccion(Coleccion c){
		colecciones.add(c);
	}
	public boolean tieneObra(Obra o){
		for(Obra ob : obras){
			if(ob.getTitulo().equals(o.getTitulo()))return true;
		}
		return false;
	}
}
