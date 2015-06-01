package edu.upc.pes.model;

import java.util.List;

public class WrapperObra {

	
	private String titulo;
	private Long idBeacon;
	private String estilo;
	private Long idAutor;
	private String nombreColeccion;
	private String informacion;
	private List<MultimediaItem> items;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getIdBeacon() {
		return idBeacon;
	}
	public void setIdBeacon(Long idBeacon) {
		this.idBeacon = idBeacon;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public Long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombreColeccion() {
		return nombreColeccion;
	}
	public void setNombreColeccion(String nombreColeccion) {
		this.nombreColeccion = nombreColeccion;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public List<MultimediaItem> getIdsMultimedia() {
		return items;
	}
	public void setIdsMultimedia(List<MultimediaItem> items) {
		this.items = items;
	}
	
}
