package edu.upc.pes.service;

import java.util.List;

import edu.upc.pes.model.Obra;

public interface ObraService {

	void newObra(String titulo, String autor, String estilo, String coleccion, String museo);
	List<Obra> allObras();
}
