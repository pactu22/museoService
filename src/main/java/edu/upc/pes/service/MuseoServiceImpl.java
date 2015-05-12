package edu.upc.pes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.pes.dao.MuseoRepository;
import edu.upc.pes.dao.ObraRepository;
import edu.upc.pes.model.Museo;
import edu.upc.pes.model.Obra;

@Service
public class MuseoServiceImpl implements MuseoService {

	@Autowired
	MuseoRepository museoRepository;
	
	@Autowired
	ObraRepository obraRepository;

	@Override
	public void newMuseo(String nombre, String descripcion) {
		Museo museo = new Museo(nombre, descripcion);
		museoRepository.save(museo);
		
	}

	@Override
	public void agregarObra(String titulo, String autor,String estilo, String coleccion, String museo) {
		Museo mus = museoRepository.findOne(museo);
		Obra o = new Obra(titulo,autor,estilo, coleccion, mus);
		obraRepository.save(o);
		mus.addObra(o);
		
	}


	@Override
	public Museo findByNombre(String nombre) {
		return museoRepository.findOne(nombre);
		
	}

	@Override
	public List<Obra> getAllObrasByMuseo(String museo) {
		Museo mus = museoRepository.findOne(museo);
		return mus.getObras();
	}

	@Override
	public void borrarObra(String idObra) {
		Obra o = obraRepository.findOne(Long.parseLong(idObra));
		obraRepository.delete(o);
		//se borra de la coleccion??
		
	}

	@Override
	public void editarObra(String idObra, String titulo, String autor,
			String estilo, String coleccion, String museo) {
		Obra o = obraRepository.findOne(Long.parseLong(idObra));
		Museo mus = museoRepository.findOne(museo);
		o.editar(titulo, autor, estilo, coleccion, mus);
		obraRepository.save(o);
		
	}

	@Override
	public Obra getObra(String idObra) {

		return obraRepository.findOne(Long.parseLong(idObra));
	}
	
	
	
}
