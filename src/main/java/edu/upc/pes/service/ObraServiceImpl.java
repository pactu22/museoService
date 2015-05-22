package edu.upc.pes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Coleccion;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;


@Service
public class ObraServiceImpl implements ObraService {

	@Autowired
	private ObraRepository obraRepository;
	
	@Autowired
	private MuseoRepository museoRepository;
	
	

	@Override
	public List<Obra> allObras() {
		return obraRepository.findAll();
		
	}



	@Override
	public Obra newObra(Obra obra, Museo museo) {
		
		obra.setMuseo(museo);
		return obraRepository.save(obra);
		
	}
	
	@Override
	public Obra getObra(Long idObra) {

		return obraRepository.findOne(idObra);
	}



	@Override
	public void borrarObra(Long idObra) {
		obraRepository.delete(idObra);
		
	}


	@Override
	public Obra getObraByTitulo(String titulo) {
		return obraRepository.findByTitulo(titulo);
	}



	@Override
	public Obra editarObra(Obra o, String titulo, String autor,
			String estilo,  Museo museo) {
		o.setAutor(autor);
		o.setTitulo(titulo);
		o.setEstilo(estilo);
		o.setMuseo(museo);
		return obraRepository.save(o);
	}



	@Override
	public List<Obra> findByMuseoAndColeccion(Museo museo, Coleccion coleccion) {

		return obraRepository.findByMuseoAndColeccion(museo, coleccion);
	}
}
