package edu.upc.pes.model;

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
public class Obra {

	@Id
	@GeneratedValue
	private Long id;
	
	private String titulo;
	private long idBeacon;
	@ManyToOne
	private Autor autor;
	private String estilo;
	
	@ManyToOne
	private Museo museo;
	
	@ManyToOne
	private Coleccion coleccion;

	@JsonIgnore
	@OneToMany(mappedBy = "obra",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
 	private List<MultimediaItem> multimediaItems;
	
	private String informacion;
	
	public Obra(){
		
	}
	
	public Obra(String titulo, Autor autor, String estilo,  Museo museo){
		this.titulo = titulo;
		this.autor = autor;
		this.estilo = estilo;
		this.museo = museo;
	}
	public Obra (String titulo, Autor autor, String estilo,  Museo museo, Coleccion col, long beacon){
		this(titulo,autor,estilo,museo);
		this.coleccion = col;
		this.idBeacon = beacon;

		
	}
	

	public Obra(String titulo, Autor autor, String estilo,  Museo museo,  long beacon) {
		this(titulo,autor,estilo,museo);
		this.idBeacon = beacon;
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

	public long getBeacon() {
		return idBeacon;
	}

	public void setBeacon(long beacon) {
		this.idBeacon = beacon;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
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
	}


	public List<MultimediaItem> getMultimediaItems() {
		return multimediaItems;
	}

	public void setMultimediaItems(List<MultimediaItem> multimediaItems) {
		this.multimediaItems = multimediaItems;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public void editar(String titulo, Autor autor, String estilo, Coleccion coleccion, Museo museo){
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
		return (obra.getTitulo().equals(this.getTitulo()) && 
				obra.getAutor().equals(this.getAutor()));
	}
	
	@Override
	public int hashCode(){
		return titulo.hashCode() + autor.hashCode();
	}
}
