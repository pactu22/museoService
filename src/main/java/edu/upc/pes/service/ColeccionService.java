package edu.upc.pes.service;

import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;

public interface ColeccionService {
	public Coleccion nuevaColeccion(String nombre, Museo museo);
	
	public Coleccion getColeccion(String nombre);
}
