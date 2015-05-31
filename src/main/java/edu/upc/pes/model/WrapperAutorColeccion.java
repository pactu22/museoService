package edu.upc.pes.model;

import java.util.ArrayList;
import java.util.List;

public class WrapperAutorColeccion {
	
	private  List<Autor> autores = new ArrayList<Autor> ();
	private List<Coleccion> colecciones = new ArrayList<Coleccion> ();
	
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	public List<Coleccion> getColecciones() {
		return colecciones;
	}
	public void setColecciones(List<Coleccion> colecciones) {
		this.colecciones = colecciones;
	}
	
}
