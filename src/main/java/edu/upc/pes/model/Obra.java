package edu.upc.pes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Obra {

	@Id
	@GeneratedValue
	private Long id;
	
	private String titulo;
	@OneToOne
	private Beacon beacon;
	
	private String autor;
	private String estilo;
	
	@JsonIgnore
	@ManyToOne
	private Museo museo;
	
	@JsonIgnore
	@ManyToOne
	private Coleccion coleccion;

	@ManyToOne
	private Exposicion exposicion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "obra",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<MultimediaItem> multimediaItems;
	
	
	public Obra(){
		
	}
	
	public Obra(String titulo, String autor, String estilo,  Museo museo){
		this.titulo = titulo;
		this.autor = autor;
		this.estilo = estilo;
		this.museo = museo;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public Museo getMuseo() {
		return museo;
	}

	public void setMuseo(Museo museo) {
		this.museo = museo;
	}

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
		Exposicion e = coleccion.getExposicion();
		if(e != null){
			exposicion = e;
		}
		
	}

	public Exposicion getExposicion() {
		return exposicion;
	}

	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}

	public List<MultimediaItem> getMultimediaItems() {
		return multimediaItems;
	}

	public void setMultimediaItems(List<MultimediaItem> multimediaItems) {
		this.multimediaItems = multimediaItems;
	}

	public void editar(String titulo, String autor, String estilo, Coleccion coleccion, Museo museo){
		this.titulo = titulo;
		this.autor = autor;
		this.estilo = estilo;
		this.coleccion = coleccion;
		this.museo = museo;
	
	}
	public void addMultimedia(MultimediaItem multimedia){
		multimediaItems.add(multimedia);
	}
	@Override
	public boolean equals(Object u){
		Obra obra = (Obra) u;
		if (obra.getId() == null) return true;
		return (obra.id == this.getId());
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
}
