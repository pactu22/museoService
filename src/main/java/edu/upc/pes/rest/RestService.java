package edu.upc.pes.rest;

import java.util.List;

import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.UsuarioRegistrado;
import edu.upc.pes.model.WrapperObra;

public interface RestService {


	
	public Museo nuevoMuseo(Museo museo);
	
	public Autor nuevoAutor(Autor autor);

	public Coleccion nuevaColeccion(Coleccion col, String museo);
	
	public Obra nuevaObraMuseo(WrapperObra obra, String museo);

	public List<Obra> allObras();

	public List<Obra> obrasDeMuseo (String nombreMuseo);

	public List<Coleccion> coleccionesDeMuseo(String museo);

	public List<Coleccion> allColecciones();

	public Obra editarObraMuseo(WrapperObra obra, String museo, Long idObra);

	public List<Obra> borrarObraMuseo(Long idObra, String museo);

	public List<UsuarioRegistrado> allUsuarios();

	public List<Museo> allMuseos();

	public List<Autor> allAutores();

	public Obra getObraOfMuseo(String museo, Long idObra);

	public List<Obra> getObraOfMuseoByColeccion(String museo, String coleccion);

	public List<Obra> getObraOfMuseoByTitulo(String museo, String titulo);

	public List<Obra> getObraOfMuseoByEstilo(String museo, String estilo);

	public List<Obra> getObraOfMuseoByAutor(String museo, String autor);

	
}
