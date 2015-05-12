package edu.upc.pes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;


@Service
public class ObraServiceImpl implements ObraService {

	@Autowired
	private ObraRepository obraRepository;
	
	@Autowired
	private MuseoRepository museoRepository;
	
	@Override
	public void newObra(String titulo, String autor,String estilo, String coleccion, String museo) {
		
		Museo museoAux = museoRepository.findOne("museo"); 
		Obra obra = new Obra(titulo, autor,estilo, coleccion, museoAux);
		obraRepository.save(obra);
		
	}

	@Override
	public List<Obra> allObras() {
		return obraRepository.findAll();
		
	}
	

}
