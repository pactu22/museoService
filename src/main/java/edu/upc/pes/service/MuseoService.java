package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

public interface MuseoService {

	public void newMuseo(String nombre, String descripcion);
	public void agregarObra(String titulo, String autor,String estilo, String coleccion, String museo );
	public Museo findByNombre(String nombre);
	
	public List<Obra> getAllObrasByMuseo(String museo);
	
	public void borrarObra(String titulo);
	public void editarObra(String idObra, String titulo, String autor,
			String estilo, String coleccion, String museo);
	public Obra getObra(String id);
	
}
