package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Coleccion {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "coleccion",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<Obra> obras;

	@ManyToOne
	private Museo museo;
	
	@ManyToOne
	private Exposicion exposicion;
	
	public Coleccion(){
		obras = new ArrayList<Obra>();
	}
	public Coleccion(String nombre, Museo museo){
		this.nombre = nombre;
		this.museo = museo;
		obras = new ArrayList<Obra>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Exposicion getExposicion() {
		return exposicion;
	}
	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}
	public void addObra(Obra o){
		obras.add(o);
	}
	
}
