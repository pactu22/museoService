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
	
	@JsonIgnore
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Obra> obras;
	
	public Museo(){
		obras = new ArrayList<Obra>();
	}
	public Museo(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
		obras = new ArrayList<Obra>();
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
	public List<Obra> getObras() {
		return obras;
	}
	public void setObras(List<Obra> obras) {
		this.obras = obras;
	}
	
	public void addObra(Obra o){
		obras.add(o);
	}
	
}
