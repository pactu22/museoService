package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;

public interface ColeccionService {
	public Coleccion nuevaColeccion(Coleccion col);
	
	public Coleccion getColeccion(String nombre);

	public List<Coleccion> allColecciones();
	public List<Coleccion> allColecciones(Museo museo);

}
