package edu.upc.pes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;
import edu.upc.pes.model.Visitante;

@Service
public class MuseoServiceImpl implements MuseoService {

	@Autowired
	MuseoRepository museoRepository;
	
	@Autowired
	ObraRepository obraRepository;

	@Override
	public Museo newMuseo(Museo museo) {
		if(museoRepository.exists(museo.getNombre())) return null;
		return museoRepository.save(museo);
		
	}

	@Override
	public void agregarObra(Obra obra, Museo museo) {
		museo.addObra(obra);
		museoRepository.save(museo);
		
	}


	@Override
	public Museo findByNombre(String nombre) {
		return museoRepository.findOne(nombre);
		
	}

	@Override
	public List<Obra> getAllObrasMuseo(Museo museo) {
		return museo.getObras();
	}

	@Override
	public void borrarObra(Obra obra) {
		obraRepository.delete(obra);
		//se borra de la coleccion??
		
	}

	@Override
	public List<Visitante> getAllVisitantes(Museo museo) {
		return museo.getVisitantes();
	}
	
	
	
	
}
