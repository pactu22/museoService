package edu.upc.pes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.ColeccionRepository;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
@Service
public class ColeccionServiceImpl implements ColeccionService{

	@Autowired
	ColeccionRepository coleccionRepo;
	
	@Override
	public Coleccion nuevaColeccion(String nombre, Museo museo) {
		Coleccion col = new Coleccion(nombre, museo);
		return coleccionRepo.save(col);
	}

	@Override
	public Coleccion getColeccion(String nombre) {
		
		return coleccionRepo.findByNombre(nombre);
	}

}
