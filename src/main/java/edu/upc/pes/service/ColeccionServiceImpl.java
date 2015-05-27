package edu.upc.pes.service;

import java.util.List;

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
	public Coleccion nuevaColeccion(Coleccion col) {
		return coleccionRepo.save(col);
	}

	@Override
	public Coleccion getColeccion(String nombre) {
		
		return coleccionRepo.findOne(nombre);
	}
	@Override
	public List<Coleccion> allColecciones() {
		return coleccionRepo.findAll();
	}

	@Override
	public List<Coleccion> allColecciones(Museo museo) {
		// TODO Auto-generated method stub
		return coleccionRepo.findByMuseo(museo);
	}
	
}
