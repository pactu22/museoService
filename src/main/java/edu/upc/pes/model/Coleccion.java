package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Coleccion {
	@Id
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "coleccion",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Obra> obras;

	@ManyToOne
	private Museo museo;
	
	
	public Coleccion(){
		obras = new ArrayList<Obra>();
	}
	public Coleccion(String nombre, Museo museo){
		this.nombre = nombre;
		this.museo = museo;
		obras = new ArrayList<Obra>();
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> obras) {
		this.obras = obras;
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
	public void borrarObra(Obra o){
		obras.remove(o);
	}
	public boolean tieneObra(Obra o){
		return obras.contains(o);
	}
	
	public void editarObra(int indice, Obra o){
		obras.remove(indice);
		obras.add(indice, o);
	}
	@Override
	public boolean equals(Object u){
		Coleccion col= (Coleccion) u;
		return (col.getNombre().equals(this.nombre));
	}
	
	@Override
	public int hashCode(){
		return nombre.hashCode();
	}
}
