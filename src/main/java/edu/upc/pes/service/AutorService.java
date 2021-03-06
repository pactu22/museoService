package edu.upc.pes.service;

import java.util.Date;
import java.util.List;

import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

public interface AutorService {
	public Autor getAtutor(Long id);
	public Autor getAtutor(String nombre, String apellidos,Date fechaNacimiento, String nacionalidad);
	public Autor newAutor(Autor autor);
	public boolean tiene(Autor autor);
	public List<Autor> getAll();
	public List<Obra> getObrasByAutorAndMuseo(String nombres, Museo museo);
	
}
