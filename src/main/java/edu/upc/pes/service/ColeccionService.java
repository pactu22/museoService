package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Coleccion;

public interface ColeccionService {
	public Coleccion nuevaColeccion(Coleccion col);
	
	public Coleccion getColeccion(String nombre);

	public List<Coleccion> allColecciones();
}
