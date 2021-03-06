package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Museo {
	
	@Id
	private String nombre;
	private String descripcion;
	private String direccion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("titulo")
	private List<Obra> obras;
	
	@JsonIgnore
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Visitante> visitantes;  
	
	@JsonIgnore
	@OneToMany(mappedBy = "museo",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("nombre ASC")
	private List<Coleccion> colecciones;  
	
	
	public Museo(){
		obras = new ArrayList<Obra>();
		visitantes = new ArrayList<Visitante>();
		colecciones = new ArrayList<Coleccion>();
	}
	public Museo(String nombre){
		this.nombre = nombre;
		obras = new ArrayList<Obra>();
		visitantes = new ArrayList<Visitante>();
		colecciones = new ArrayList<Coleccion>();
	}
	public Museo(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
		obras = new ArrayList<Obra>();
		visitantes = new ArrayList<Visitante>();
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
	public void borrarObra(Obra o){
		obras.remove(o);
	}
	public void addObra(Obra o){
		obras.add(o);
	}
	public void addColeccion(Coleccion c){
		colecciones.add(c);
	}
	public boolean tieneObra(Obra o){

		return obras.contains(o);
	}
	public boolean tieneColeccion(Coleccion c){

		return colecciones.contains(c);
	}
	public void editarObra(int idAntigua, Obra nueva) {
		obras.remove(idAntigua);
		obras.add(idAntigua, nueva);
		
	}
	public int getIndiceObra(Obra o){
		return obras.indexOf(o);
	}
	public Obra getObra(Long idObra) {
		
		for(Obra o: obras){
			if (o.getId() == idObra) return o;
		}
		return null;
	}
	public void editarObra(int indice, Autor autor, Long beacon, String estilo,
			String info, String titulo, Coleccion colWrapper) {
		Obra o = obras.get(indice);
		o.setAutor(autor);
		o.setBeacon(beacon);
		o.setEstilo(estilo);
		o.setInformacion(info);
		o.setTitulo(titulo);
		o.setColeccion(colWrapper);
		obras.set(indice, o);
	}
	
}
