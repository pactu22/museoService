package edu.upc.pes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;

public interface ColeccionRepository extends JpaRepository<Coleccion, String>{
	public Coleccion findByNombre(String nombre);
	public Coleccion findByMuseo(Museo museo);
}
