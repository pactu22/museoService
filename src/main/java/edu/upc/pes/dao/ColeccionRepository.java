package edu.upc.pes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;

public interface ColeccionRepository extends JpaRepository<Coleccion, String>{
	public List<Coleccion> findByMuseo(Museo museo);
}
