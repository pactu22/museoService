package edu.upc.pes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

public interface  ObraRepository extends JpaRepository<Obra, Long> {

	public Obra findByTitulo(String titulo);
	public Obra findByBeacon(Long beacon);
	public List<Obra> findByAutor(String autor);
	public List<Obra> findByMuseo(Museo museo);
	public List<Obra> findByColeccion(Coleccion coleccion);
	public List<Obra> findByMuseoAndColeccion(Museo museo, Coleccion coleccion);
}
