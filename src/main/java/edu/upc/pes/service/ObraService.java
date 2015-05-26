package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Autor;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

public interface ObraService {

	public Obra newObra(Obra obra);
	public List<Obra> allObras();
	public Obra getObraByTituloAndAutor(String titulo, Long idAutor);
	public Obra getObra(Long idObra);
	public void borrarObra(Obra idObra);
	//public Obra editarObra(Obra idObra, String titulo, Autor autor, String estilo, Museo museo);
	
	public Obra updateObra(Long idObra, Autor autor, Long beacon,
			String estilo, String info, String titulo, Coleccion colWrapper);
	public List<Obra> findByMuseoAndTitulo(Museo mus, String titulo);
	public List<Obra> findByMuseoAndColeccion( Museo museo,Coleccion coleccion);
	public List<Obra> findByMuseoAndEstilo(Museo mus, String estilo);
	
	
	
}
