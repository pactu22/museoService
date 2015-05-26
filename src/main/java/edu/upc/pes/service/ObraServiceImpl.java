package edu.upc.pes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Autor;
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
	public Obra newObra(Obra obra) {
		return obraRepository.save(obra);
		
	}
	
	@Override
	public Obra getObra(Long idObra) {

		return obraRepository.findOne(idObra);
	}



	@Override
	public void borrarObra(Obra obra) {
		obraRepository.delete(obra);
	}


	@Override
	public Obra getObraByTituloAndAutor(String titulo, Long idAutor) {
		
		return obraRepository.findByTituloAndAutor(titulo, idAutor);
	}




	@Override
	public List<Obra> findByMuseoAndColeccion(Museo museo, Coleccion coleccion) {

		return obraRepository.findByMuseoAndColeccion(museo, coleccion);
	}
	

	@Override
	public Obra updateObra(Long idObra, Autor autor, Long beacon,
			String estilo, String info, String titulo, Coleccion colWrapper) {
		Obra o = obraRepository.findOne(idObra);
		o.setAutor(autor);
		o.setBeacon(beacon);
		o.setEstilo(estilo);
		o.setInformacion(info);
		o.setTitulo(titulo);
		o.setColeccion(colWrapper);
		return obraRepository.save(o);
	}
}
