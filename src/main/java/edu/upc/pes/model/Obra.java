package edu.upc.pes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Obra {

	@Id
	@GeneratedValue
	private Long id;
	
	private String titulo;
	private Long beacon;
	private String autor;
	private String estilo;
	private String coleccion;
	
	@JsonIgnore
	@ManyToOne
	private Museo museo;
	
	public Obra(){
		
	}
	
	public Obra(String titulo, String autor, String estilo, String coleccion, Museo museo){
		this.titulo = titulo;
		this.autor = autor;
		this.estilo = estilo;
		this.coleccion = coleccion;
		this.museo = museo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBeacon() {
		return beacon;
	}
	public void setBeacon(Long beacon) {
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
	public String getColeccion() {
		return coleccion;
	}
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Museo getMuseo() {
		return museo;
	}

	public void setMuseo(Museo museox) {
		this.museo = museox;
	}
	
	public void editar(String titulo, String autor, String estilo, String coleccion, Museo museo){
		this.titulo = titulo;
		this.autor = autor;
		this.estilo = estilo;
		this.coleccion = coleccion;
		this.museo = museo;
	
	}
	
}
