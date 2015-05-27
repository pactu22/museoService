package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.Visitante;

public interface MuseoService {

	public Museo newMuseo(Museo museo);
	public void agregarObra(Obra obra, Museo museo );
	public Museo findByNombre(String nombre);
	public List<Obra> getAllObrasMuseo(Museo museo);
	public void borrarObra(Obra obra);
	public List<Visitante> getAllVisitantes(Museo museo);
	public Museo persist(Museo museo);
	public List<Museo> allMuseos();
	
	
}
