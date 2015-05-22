package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

public interface ObraService {

	public Obra newObra(Obra obra,  Museo museo);
	public List<Obra> allObras();
	public Obra getObraByTitulo(String titulo);
	public Obra getObra(Long idObra);
	public void borrarObra(Long idObra);
	public Obra editarObra(Obra idObra, String titulo, String autor, String estilo, Museo museo);
	
	public List<Obra> findByMuseoAndColeccion( Museo museo,Coleccion coleccion);
	
}
